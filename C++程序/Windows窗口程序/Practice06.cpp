#include <windows.h>
//	InitInstance(hInstance,int)

BOOL InitInstance(HINSTANCE hInstance,int nCmdShow){
	HWND		hWnd;
	HINSTANCE	hInst	= hInstance;

	hWnd	= CreateWindow(
		"��������",
		"���ڱ���",
		WS_OVERLAPPEDWINDOW,
		CW_USEDEFAULT,
		0,
		CW_USEDEFAULT,
		0,
		NULL,
		NULL,
		hInstance,
		NULL);
	if(!hWnd){
		return FALSE;
	}

	ShowWindow(hWnd,nCmdShow);
	UpdateWindow(hWnd);
	return TRUE;
}