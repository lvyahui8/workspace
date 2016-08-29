#include <windows.h>
#include <stdio.h>
#define IDC_TIMER	101
#define SC_MCLOSE	102


LRESULT CALLBACK TimeProc(
						  HWND hwnd,      // handle to window
						  UINT uMsg,      // message identifier
						  WPARAM wParam,  // first message parameter
						  LPARAM lParam   // second message parameter
						  ){
	static int Hours = 0, Minutes = 0, Seconds = 0;
	static int s_ClientCX = 0, s_ClientCY = 0;
	switch(uMsg){
	case WM_CREATE:
		{
			SetTimer(hwnd,IDC_TIMER,1000,NULL);
			SendMessage(hwnd,WM_TIMER,1,0);
			RECT rect;
			HRGN hRgn;
			GetClientRect(hwnd,&rect);
			hRgn = CreateRoundRectRgn(rect.left,rect.top,rect.right,rect.bottom,20,20);
			SetWindowRgn(hwnd,hRgn,true);
			
		}
		break;
	case WM_SIZE:
		{
			int nScreenCX = GetSystemMetrics(SM_CXSCREEN);
			int nScreenCY = GetSystemMetrics(SM_CYSCREEN);
			s_ClientCX = LOWORD(lParam);//参数 lParam 中， lParam 的高字部分是客户区的高，低字部分是客户区的宽。
			s_ClientCY = HIWORD(lParam);
			SetWindowPos(
				hwnd,
				NULL,
				( nScreenCX - s_ClientCX ) / 2,
				( nScreenCY - s_ClientCY ) / 2,
				0,
				0,
				SWP_NOSIZE | SWP_NOZORDER | SWP_NOREDRAW
				);
		}
		break;
	case WM_PAINT:
		{
			HDC hdc;
			hdc = GetDC(hwnd);
			SetBkColor(hdc,RGB(0,0,0));
			SetTextColor(hdc,RGB(0,255,0));
			char szTime[25];
			sprintf(szTime,"%02d:%02d:%02d",Hours,Minutes,Seconds);
			TextOut(hdc,4,2,szTime,strlen(szTime));
			ReleaseDC(hwnd,hdc);
		}
		break;
	case WM_TIMER:
		{
			SYSTEMTIME stime;
			GetLocalTime(&stime);
			Hours = stime.wHour;
			Minutes = stime.wMinute;
			Seconds = stime.wSecond;
			SendMessage(hwnd,WM_PAINT,0,0);
		}
		break;
	case WM_DESTROY:
		PostQuitMessage(0);
		break;
	case WM_CLOSE:
		KillTimer(hwnd,IDC_TIMER);
		break;
#ifdef _MDEBUG
	case WM_LBUTTONDOWN:
		MessageBox(hwnd,"你好，这是一个时钟","提示",IDOK );
		break;
#endif // _MDEBUG	
	case WM_NCHITTEST:
		{
			/*伪造点击标题栏，使得可以点击任意位置移动窗口*/
			if ( HTCLIENT == DefWindowProc( hwnd, uMsg, wParam, lParam ) && GetAsyncKeyState(MK_LBUTTON) < 0 )
			{
				return HTCAPTION;
			}
		}
		break;
	case WM_CONTEXTMENU:
		{
			HMENU hMenu = CreatePopupMenu();
			AppendMenu(hMenu,MF_STRING,SC_MCLOSE,TEXT("关闭(&1)"));
			int nID = TrackPopupMenu( hMenu, TPM_LEFTALIGN | TPM_RETURNCMD, LOWORD(lParam), HIWORD(lParam), 0, hwnd, NULL );
			if (SC_MCLOSE  == nID )
			{
				SendMessage( hwnd, WM_DESTROY, nID, lParam );
			}
		}
		break;
	default:
		;
	}
	return DefWindowProc(hwnd,uMsg,wParam,lParam);
}


int WINAPI WinMain(
				   HINSTANCE hInstance,
				   HINSTANCE hPrevInstance,
				   LPSTR lpCmdLine,
				   int nCmdShow
				   ){
	char * szClassName = "ClockApp";
	WNDCLASSEX wclse;
	wclse.cbSize = sizeof(WNDCLASSEX);
	wclse.hCursor = LoadCursor(NULL,IDC_ARROW);
	wclse.hIcon = LoadIcon(NULL,IDI_APPLICATION);
	wclse.hIconSm = LoadIcon( NULL, IDI_QUESTION );
	wclse.hInstance = hInstance;
	wclse.lpfnWndProc = TimeProc;
	wclse.style = CS_VREDRAW | CS_HREDRAW;
	wclse.cbClsExtra = NULL;
	wclse.cbWndExtra = NULL;
	wclse.hbrBackground = (HBRUSH)GetStockObject(BLACK_BRUSH);
	wclse.lpszClassName = szClassName;
	wclse.lpszMenuName = NULL;

	RegisterClassEx(&wclse);

	HWND hWnd;
	hWnd = CreateWindow(
		szClassName,
		"Clock",
		WS_POPUPWINDOW,
		CW_USEDEFAULT,CW_USEDEFAULT,
		75,25,
		NULL,NULL,hInstance,NULL
		);

	ShowWindow(hWnd,nCmdShow);
	UpdateWindow(hWnd);
	MSG msg;
	while(GetMessage(&msg,NULL,0,0)){
		TranslateMessage(&msg);
		DispatchMessage(&msg);
	}
	return 1;
}
