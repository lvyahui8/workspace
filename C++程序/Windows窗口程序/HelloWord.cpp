#include <windows.h>
#include <stdio.h>
#include <wchar.h>
#include "r.h"
int WINAPI WinMain(
	HINSTANCE hInstance,		// handle to current instance
	HINSTANCE hPrevInstance,	// handle to previous instance
	LPSTR lpCmdLine,			// pointer to command line
	int nCmdShow				// show state of window
){
	MessageBox(NULL,"Hello,Windows 2013!","HelloMsg",MB_ICONEXCLAMATION | MB_OKCANCEL | MB_DEFBUTTON2 | MB_HELP );												//��ʾ��̾��		ȷ����ȡ����ť  �ڶ�����ťΪĬ�ϰ�ť  ��ʾ������ť
	wchar_t c='A';
	char p[12];
	sprintf(p,"nihao");
	MessageBox(NULL,p,p,MB_ICONEXCLAMATION | MB_OKCANCEL | MB_DEFBUTTON2 | MB_HELP );

	return 0;
}