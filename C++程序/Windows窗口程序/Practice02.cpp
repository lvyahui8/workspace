#include <windows.h>
#include <windows.h>
#include <tchar.h>
#include "resource.h"
int WINAPI _tWinMain(
					 HINSTANCE hInstance,		// handle to current instance
					 HINSTANCE hPrevInstance,	// handle to previous instance
					 LPSTR lpCmdLine,			// pointer to command line
					 int nCmdShow				// show state of window
					 ){  
	UNREFERENCED_PARAMETER(hPrevInstance);
	UNREFERENCED_PARAMETER(lpCmdLine);
	UNREFERENCED_PARAMETER(nCmdShow);

	const int MAXSIZE_APPBUF = 256;
	TCHAR wAppTitle[MAXSIZE_APPBUF];
	LoadString(hInstance,IDS_APP_TITLE,wAppTitle,MAXSIZE_APPBUF);

	HWND hWnd = GetDesktopWindow();
	// ��ʾ�����в���
	MessageBox(hWnd,lpCmdLine,wAppTitle,MB_OK);
	MessageBox(hWnd,_T("��һ��Ӧ�ó���"),wAppTitle,MB_OK);
	
	return 0;
}