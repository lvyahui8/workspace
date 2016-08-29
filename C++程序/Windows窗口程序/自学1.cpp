#include <windows.h>
#include <stdio.h>
#include <wingdi.h>
//     API
//		AngleArc(hdc,400,400,45,60,300);自学了AngleArc函数
LRESULT CALLBACK WinSunProc(
	HWND hwnd,      // handle to window
	UINT uMsg,      // message identifier
	WPARAM wParam,  // first message parameter
	LPARAM lParam   // second message parameter
);

int WINAPI WinMain(
	HINSTANCE hInstance,		// handle to current instance
	HINSTANCE hPrevInstance,	// handle to previous instance
	LPSTR lpCmdLine,			// pointer to command line
	int nCmdShow				// show state of window
){
	WNDCLASS wndcls;
	wndcls.cbClsExtra = 0;
	wndcls.cbWndExtra = 0;
	wndcls.hbrBackground = (HBRUSH)GetStockObject(WHITE_BRUSH);
	wndcls.hCursor = LoadCursor(NULL,IDC_CROSS);
	wndcls.hIcon = LoadIcon(NULL,IDI_ERROR);
	wndcls.hInstance = hInstance;
	wndcls.lpfnWndProc = WinSunProc;
	wndcls.lpszClassName = "Agrin2012";
	wndcls.lpszMenuName = NULL;
	wndcls.style = CS_HREDRAW | CS_VREDRAW;
	RegisterClass(&wndcls);

	HWND hwnd;
	hwnd = CreateWindow("Agrin2012","Agrin_DJ_2012",
		WS_OVERLAPPEDWINDOW,0,0,600,400,NULL,NULL,hInstance,NULL);

	ShowWindow(hwnd,SW_MAXIMIZE);
	UpdateWindow(hwnd);

	MSG msg;
	while(GetMessage(&msg,NULL,0,0)){
		TranslateMessage(&msg);
		DispatchMessage(&msg);
	}
	return 0;
}

LRESULT CALLBACK WinSunProc(
	HWND hwnd,      // handle to window
	UINT uMsg,      // message identifier
	WPARAM wParam,  // first message parameter
	LPARAM lParam   // second message parameter
){
	switch(uMsg){
	case WM_CHAR:
		char szChar[20];
		sprintf(szChar,"char is %d",wParam);
		MessageBox(hwnd,szChar,"Agrin",0);
		break;
	case WM_LBUTTONDOWN:
		MessageBox(hwnd,"mouse clicked","Agrin",0);
		HDC hdc;
		hdc = GetDC(hwnd);
		AngleArc(hdc,400,400,45,60,300);
		TextOut(hdc,650,390,"再也会不去的曾经",strlen("再也会不去的曾经"));
		ReleaseDC(hwnd,hdc);
		break;
	case WM_PAINT:
		HDC hDC;
		PAINTSTRUCT ps;
		hDC = BeginPaint(hwnd,&ps);
		TextOut(hDC,680,360,"2012年6月8日",strlen("2012年6月8日"));
		EndPaint(hwnd,&ps);
		break;
	case WM_CLOSE:
		if(IDYES == MessageBox(hwnd,"是否真的结束？","AgrinLV",MB_YESNO))
		{
			DestroyWindow(hwnd);
		}
		break;
	case WM_DESTROY:
		PostQuitMessage(0);
		break;
	default:
		return DefWindowProc(hwnd,uMsg,wParam,lParam);
	}
	return 0;
}
