// WinSDK.cpp : Defines the entry point for the application.
//

#include "stdafx.h"

#include <windows.h>

LRESULT CALLBACK WndProc (HWND, UINT, WPARAM, LPARAM) ;

int WINAPI WinMain (HINSTANCE hInstance, HINSTANCE hPrevInstance,					
                    PSTR szCmdLine, int iCmdShow)					
{	
	static TCHAR szAppName[] = TEXT ("HelloWin") ;
	HWND         hwnd ;
	MSG          msg ;
	WNDCLASS     wc ;
	wc.style         = CS_HREDRAW | CS_VREDRAW ;	
	wc.lpfnWndProc   = WndProc ;
	wc.cbClsExtra    = 0 ;
	wc.cbWndExtra    = 0 ;	
	wc.hInstance     = hInstance ;
	wc.hIcon         = LoadIcon (NULL, IDI_APPLICATION) ;	
	wc.hCursor       = LoadCursor (NULL, IDC_ARROW) ;	
	wc.hbrBackground = (HBRUSH) GetStockObject (WHITE_BRUSH) ;	
	wc.lpszMenuName  = NULL ;	
	wc.lpszClassName = szAppName ;		
	if (!RegisterClass (&wc))
	{
		MessageBox (NULL, TEXT ("This program requires Windows NT!"), 			
			szAppName, MB_ICONERROR) ;	
		return 0 ;		
	}	
	hwnd = CreateWindow (szAppName,                  // window class name
		
		TEXT ("欢迎你的到来!"), // window caption		
		WS_OVERLAPPEDWINDOW,        // window style		
		CW_USEDEFAULT,              // initial x position		
		CW_USEDEFAULT,              // initial y position		
		CW_USEDEFAULT,              // initial x size		
		CW_USEDEFAULT,              // initial y size		
		NULL,                       // parent window handle
		NULL,                       // window menu handle
		hInstance,                  // program instance handle		
		NULL) ;                     // creation parameters
	ShowWindow (hwnd, SW_SHOWMAXIMIZED) ;
	UpdateWindow (hwnd) ;
	while (GetMessage (&msg, NULL, 0, 0))	
	{	
		TranslateMessage (&msg) ;	
		DispatchMessage (&msg) ;		
	}	
	return msg.wParam ;	
}

LRESULT CALLBACK WndProc (HWND hwnd, UINT message, WPARAM wParam, LPARAM lParam)
{
	HDC         hdc ;
	PAINTSTRUCT ps ;
	RECT        rect ;
	switch (message)
	{
	case WM_PAINT:
		hdc = BeginPaint (hwnd, &ps) ;
		GetClientRect (hwnd, &rect) ;
		DrawText (hdc, TEXT ("你好,欢迎你来到VC之路!"), -1, &rect,
			DT_SINGLELINE | DT_CENTER | DT_VCENTER) ;		
		EndPaint (hwnd, &ps) ;		
		return 0 ;		
	case WM_DESTROY:	
		PostQuitMessage (0) ;	
		return 0 ;	
	}
	return DefWindowProc (hwnd, message, wParam, lParam) ;
}




