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
	MessageBox(NULL,"Hello,Windows 2013!","HelloMsg",MB_ICONEXCLAMATION | MB_OKCANCEL | MB_DEFBUTTON2 | MB_HELP );												//显示感叹号		确定与取消按钮  第二个按钮为默认按钮  显示帮助按钮
	wchar_t c='A';
	char p[12];
	sprintf(p,"nihao");
	MessageBox(NULL,p,p,MB_ICONEXCLAMATION | MB_OKCANCEL | MB_DEFBUTTON2 | MB_HELP );

	return 0;
}