/*
[]=========================================================================[]

	Copyright(C)  Feitian Technologies Co., Ltd.
	All rights reserved.

FILE:
	DecryptFile.cpp

DESC:
	Test derive key from user key and use the Derivekey encrypt File.
[]=========================================================================[]
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

#include "generic.h"

bool DecryptFile(const string &strSource,
		const string &strDestination,
		const string &strPassword); 

void main(void)
{
	string strSrcFile;
	string strTgtFile;
	string strPassword;

	cout<< endl << "Decrypt a file." << endl << endl
		<< "Enter the name of the file to be decrypt:" << endl;
	cin >> strSrcFile;
	cout << "Enter the name of the output file:" << endl;
	cin >> strTgtFile;
	cout << "Enter the password to decrypt the file:" << endl;
	cin >> strPassword;

	if(DecryptFile(strSrcFile, strTgtFile, strPassword))
	{
		cout << "Decrypt file successfully." << endl;
	}
	else
	{
		cout << "Decrypt file failed." << endl;
	}
} // End of main

//--------------------------------------------------------------------
//    Define the function Decryptfile.

bool DecryptFile(const string &strSource,
		const string &strDestination,
		const string &strPassword)
{
	FILE *hSource = NULL; 
	FILE *hDestination = NULL;

	//--------------------------------------------------------------------
	// Open source file. 
	BeginAction("Open source file for read");
	if(NULL != (hSource = fopen(strSource.c_str(), "rb")))
	{
		ActionSuccess();
	}
	else
	{
		ActionFailed(GetLastError());
		return FALSE;
	}

	//--------------------------------------------------------------------
	// Open destination file. 
	BeginAction("Open target file for write");
	if(NULL != (hDestination = fopen(strDestination.c_str(), "wb")))
	{
		//HandleError("Error opening plaintext file!");
		ActionSuccess();
	}
	else
	{
		ActionFailed(GetLastError());
		return FALSE;
	}

	HCRYPTPROV hCryptProv = NULL;
	HCRYPTKEY hKey = NULL;
	HCRYPTHASH hHash = NULL;

	//--------------------------------------------------------------------
	// Get a handle to the provider. 
	BeginAction("CryptAcquireContext()");
	if(CryptAcquireContext(&hCryptProv,
			TEST_CONTAINER,
			TEST_CSP_NAME,   //epassNG CSP
			PROV_RSA_FULL,
			0))
	{
		ActionSuccess();
	}
	else
	{
		ActionFailed(GetLastError());
		return FALSE;
	}

	HCRYPTPROV_Holder holder(hCryptProv);

	//--------------------------------------------------------------------
	// Create a hash object. 
	BeginAction("CryptCreateHash()");
	if(CryptCreateHash(hCryptProv, CALG_MD5, 0, 0, &hHash))
	{
		ActionSuccess();
	}
	else
	{
		ActionFailed(GetLastError());
		return FALSE;
	}  
	//--------------------------------------------------------------------
	// Hash in the password data. 

	BeginAction("CryptHashData()");
	if(CryptHashData(hHash,
			(BYTE *) strPassword.c_str(),
			strPassword.length(),
			0))
	{
		ActionSuccess();
	}
	else
	{
		ActionFailed(GetLastError());
		return FALSE;
	}

	//--------------------------------------------------------------------
	// Derive a session key from the hash object. 
	BeginAction("CryptDeriveKey()");
	if(CryptDeriveKey(hCryptProv, ENCRYPT_ALGORITHM, hHash, KEYLENGTH, &hKey))
	{
		ActionSuccess();
	}
	else
	{
		ActionFailed(GetLastError());
		return FALSE;
	}

	//--------------------------------------------------------------------
	// Destroy the hash object. 
	BeginAction("CryptDestroyHash()");
	if(CryptDestroyHash(hHash))
	{
		hHash = NULL; 
		ActionSuccess();
	}
	else
	{
		ActionFailed(GetLastError());
		return FALSE;
	}

	//--------------------------------------------------------------------
	//   The decryption key is now available, either having been imported
	//   from a BLOB read in from the source file or having been created 
	//   using the password. This point in the program is not reached if 
	//   the decryption key is not available.

	//--------------------------------------------------------------------
	// Determine the number of bytes to decrypt at a time. 
	// This must be a multiple of ENCRYPT_BLOCK_SIZE. 

	DWORD dwBlockLen = 0;
	DWORD dwBufferLen = 0;
	DWORD dwCount = 0;

	dwBlockLen = 1000 - 1000 % ENCRYPT_BLOCK_SIZE; 
	dwBufferLen = dwBlockLen; 

	vector<BYTE> pbBuffer;
	pbBuffer.resize(dwBufferLen);

	//--------------------------------------------------------------------
	// Decrypt source file, and write to destination file. 

	do
	{
		//--------------------------------------------------------------------
		// Read up to dwBlockLen bytes from source file. 
		dwCount = fread(&pbBuffer[0], 1, dwBlockLen, hSource); 
		if(ferror(hSource))
		{
			ShowSysError("Read cipher text", GetLastError());
			return FALSE;
		}

		//--------------------------------------------------------------------
		// Decrypt data. 
		if(!CryptDecrypt(hKey, 0, feof(hSource), 0, &pbBuffer[0], &dwCount))
		{
			ShowSysError("CryptDecrypt()", GetLastError());
			return FALSE;
		}

		//--------------------------------------------------------------------
		// Write data to destination file. 
		fwrite(&pbBuffer[0], 1, dwCount, hDestination); 
		if(ferror(hDestination))
		{
			ShowSysError("Write plain text", GetLastError());
			return FALSE;
		}
	}
	while(!feof(hSource)); 

	//--------------------------------------------------------------------
	// Close files. 
	if(hSource)
	{
		fclose(hSource);
	} 
	if(hDestination)
	{
		fclose(hDestination);
	} 

	//--------------------------------------------------------------------
	// Destroy session key. 
	if(hKey)
	{
		CryptDestroyKey(hKey);
	} 

	return TRUE;
}
