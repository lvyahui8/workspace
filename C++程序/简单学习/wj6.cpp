#include <iostream>
#include <string>
#include<fstream>
using namespace std;
/*
int main(){
	string strTemp="lvyahi";
/ *
	ofstream ofstr("string.dat");
	if(!ofstr){
	return 0;
	}
	ofstr.write(strTemp.c_str(),strTemp.length());
	ofstr.close();
//* /
	ifstream ifstr("string.dat");
	if(!ifstr){
		return 0;
	}
	//string string2;

	char str2[50];
	ifstr.read(str2,strTemp.length());
	str2[strTemp.length()] = '\0';
	string string2(str2);
	cout<<string2<<endl;

	return 1;
}
*/


int main(){
	string strTemp="lvyahi";
/*	
	ofstream ofstr("string.dat");
	if(!ofstr){
	return 0;
	}
	ofstr.write(strTemp.c_str(),strTemp.length());
	ofstr.close();
*/	
	ifstream ifstr("string.dat");
	if(!ifstr){
		return 0;
	}
	//string string2;

	/*char str2[50];
	ifstr.read(str2,strTemp.length());
	str2[strTemp.length()] = '\0';
	string string2(str2);
	cout<<string2<<endl;*/
	string string2;
	while(getline(ifstr, string2))
	{
		cout << string2 << endl;
	}

	return 1;
}
