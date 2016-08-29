//	RegisterClassEx	º¯Êý

#include <windows.h>
LRESULT CALLBACK WndProc( HWND hwnd, UINT uMsg, WPARAM wParam, LPARAM lParam );
#define IDI_TESTWIN	1
#define IDC_TESTWIN	2
#define IDI_SMALL	3
ATOM MyRegisterClass(HINSTANCE hInstance,LPSTR szWindowClass){
	WNDCLASSEX wcex;
	wcex.cbSize			=	sizeof(WNDCLASSEX);
	wcex.style			=	CS_HREDRAW | CS_VREDRAW;
	wcex.cbClsExtra		=	0;
	wcex.cbWndExtra		=	0;
	wcex.lpfnWndProc	=	WndProc;
	wcex.hInstance		=	hInstance;
	wcex.hIcon			=	LoadIcon(hInstance, MAKEINTRESOURCE(IDI_TESTWIN));
	wcex.hCursor		=	LoadCursor(NULL,IDC_ARROW);
	wcex.hbrBackground	=	(HBRUSH)(COLOR_WINDOW + 1);
	wcex.lpszMenuName	=	MAKEINTRESOURCE(IDC_TESTWIN);
	wcex.lpszClassName	=	szWindowClass;
	wcex.hIconSm		=	LoadIcon(wcex.hInstance,MAKEINTRESOURCE(IDI_SMALL));
	return RegisterClassEx(&wcex);
}