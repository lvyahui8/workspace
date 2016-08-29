#include <windows.h>
#include <math.h>
#define _MDEBUG
//#define _DEBUG
#define	PI	3.14159265
/*�˵�ID*/
#define	IDM_TOPMOST 101
#define	IDM_HELP    102
/*Timer ID*/
#define IDC_TIMER   103
//ת��������
double DegreeToRad( double dDegrees )
{
	return ( PI / 180 ) * dDegrees;
}

int YSign( double d )
{
	if ( d >= 0 && d <= 90 ) return 1;
	if ( d > 90 && d <= 270 ) return -1;
	if ( d > 270 && d <= 360 ) return 1;
	return 1;
}

double Circel( double x, double r )
{
	return sqrt( pow( r, 2 ) - pow( x, 2 ) );
}

int CalcX( double degrees, double r )
{
	return (int)( sin( DegreeToRad(degrees) ) * r );
}

int CalcY( double degrees, double r )
{
	return YSign(degrees) * (int)Circel( CalcX( degrees, r ), r );
}

void SetCoordinate( HDC hDC, int l_cx, int l_cy, int d_cx, int d_cy, int nMode )
{
	SetMapMode( hDC, nMode );
	SetWindowExtEx( hDC, l_cx, l_cy, NULL );
	SetViewportExtEx( hDC, d_cx, -d_cy, NULL );
	SetViewportOrgEx( hDC, d_cx / 2, d_cy / 2, NULL );
}

void DrawClock( HDC hdc, double Hours, double Minutes, double Seconds, double r )
{
	HPEN hPen, hOldPen;

	/* ���� */
	hPen = CreatePen( PS_SOLID, 1, RGB( 250, 0, 0 ) );
	hOldPen = (HPEN)SelectObject( hdc, hPen );
	MoveToEx( hdc, 0, 0, NULL );
	LineTo( hdc, CalcX( Seconds, r - 10 ), CalcY( Seconds, r - 10 ) );
	SelectObject( hdc, hOldPen );
	DeleteObject(hPen);
	/* ���� */
	hPen = CreatePen( PS_SOLID, 5, RGB( 0, 192, 0 ) );
	hOldPen = (HPEN)SelectObject( hdc, hPen );
	MoveToEx( hdc, 0, 0, NULL );
	LineTo( hdc, CalcX( Minutes, r - 110 ), CalcY( Minutes, r - 110 ) );
	SelectObject( hdc, hOldPen );
	DeleteObject(hPen);
	/* ʱ�� */
	hPen = CreatePen( PS_SOLID, 9, RGB( 0, 0, 192 ) );
	hOldPen = (HPEN)SelectObject( hdc, hPen );
	MoveToEx( hdc, 0, 0, NULL );
	LineTo( hdc, CalcX( Hours, r - 210 ), CalcY( Hours, r - 210 ) );
	SelectObject( hdc, hOldPen );
	DeleteObject(hPen);
}

void DrawNullFrameCircel( HDC hdc, int ox, int oy, int r, COLORREF clr )
{
	HPEN hpen, holdpen;
	HBRUSH hbrush, holdbrush;
	hpen = CreatePen( PS_NULL, 1, 0 );
	hbrush = CreateSolidBrush(clr);
	holdpen = (HPEN)SelectObject( hdc, hpen );
	holdbrush = (HBRUSH)SelectObject( hdc, hbrush );
	Ellipse( hdc, ox - r, oy - r, ox + r, oy + r );

	/* �ָ�*/
	SelectObject( hdc, holdpen );
	SelectObject( hdc, holdbrush );
	DeleteObject(hpen);
	DeleteObject(hbrush);
}

void DrawClockFace( HDC hdc, int r )
{
	HPEN hpen, holdpen;
	int i;
	hpen = CreatePen( PS_SOLID, 10, RGB( 0x70, 0xee, 20 ) );
	holdpen = (HPEN)SelectObject( hdc, hpen );
	Ellipse( hdc, -r, r, r, -r );
	MoveToEx( hdc, -r, 0, NULL );
	LineTo( hdc, -r + 100, 0 );
	MoveToEx( hdc, r - 100, 0, NULL );
	LineTo( hdc, r, 0 );
	MoveToEx( hdc, 0, r, NULL );
	LineTo( hdc, 0, r - 100 );
	MoveToEx( hdc, 0, -r + 100, NULL );
	LineTo( hdc, 0, -r );
	SelectObject( hdc, holdpen );
	DeleteObject(hpen);
	for ( i = 6; i <= 360; i += 6 )
	{
		int x1 = CalcX( i, r - 20 ), y1 = CalcY( i, r - 20 );
		DrawNullFrameCircel( hdc, x1, y1, 10, RGB( 0x0, 0x80, 192 ) );
	}
}

LRESULT CALLBACK ClockWndProc( HWND hwnd, UINT uMsg, WPARAM wParam, LPARAM lParam )
{
#ifdef _MDEBUG
		static double Hours = 0, Minutes = 0, Seconds = 0;
		static int s_ClientCX = 0, s_ClientCY = 0;
	
		switch ( uMsg )
		{
		case WM_SIZE:
			{
				int nScreenCX = GetSystemMetrics(SM_CXSCREEN);
				int nScreenCY = GetSystemMetrics(SM_CYSCREEN);
				s_ClientCX = LOWORD(lParam);//���� lParam �У� lParam �ĸ��ֲ����ǿͻ����ĸߣ����ֲ����ǿͻ����Ŀ�
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
				PAINTSTRUCT ps;
				HDC hdc = BeginPaint( hwnd, &ps );
				SetCoordinate( hdc, 1000, 1000, s_ClientCX, s_ClientCY, MM_ISOTROPIC );
				DrawClockFace( hdc, 400 );
				DrawClock( hdc, Hours, Minutes, Seconds, 400 ); 
				DrawNullFrameCircel( hdc, 0, 0, 20, 0x0080ff );
				EndPaint( hwnd, &ps );
			}
			break;
		case WM_TIMER:
			{
				SYSTEMTIME st;
				GetLocalTime(&st);
				Seconds = st.wSecond * 6; /*��*/
				Minutes = st.wMinute * 6; /*��*/
				Hours = ( st.wHour % 12 ) * 30; /*ʱ*/
				InvalidateRect( hwnd, NULL, 1 );
			}
			break;
		case WM_CREATE:
			{
				HMENU hSysMenu;
				HRGN hRgn;
				RECT rc;
				SetTimer( hwnd, IDC_TIMER, 1000, NULL );
				SendMessage( hwnd, WM_TIMER, 1, 0 );
				hSysMenu = GetSystemMenu( hwnd, FALSE );
				AppendMenu( hSysMenu, MF_SEPARATOR, 0, NULL );
				AppendMenu( hSysMenu, MF_STRING, IDM_TOPMOST, "������ǰ(&T)" );
				AppendMenu( hSysMenu, MF_STRING, IDM_HELP, "����(&H)..." );
				GetClientRect( hwnd, &rc );
				hRgn = CreateRoundRectRgn( rc.left, rc.top, rc.right, rc.bottom, 20, 20 );
				SetWindowRgn( hwnd, hRgn, TRUE );
			}
			break;
		case WM_CLOSE:
			{
				KillTimer( hwnd, IDC_TIMER );
			}
			break;
		case WM_DESTROY:
			PostQuitMessage(0);
			break;
		case WM_NCHITTEST:
			{
				/*α������������ʹ�ÿ��Ե������λ���ƶ�����*/
				if ( HTCLIENT == DefWindowProc( hwnd, uMsg, wParam, lParam ) && GetAsyncKeyState(MK_LBUTTON) < 0 )
				{
					return HTCAPTION;
				}
			}
			break;
		case WM_CONTEXTMENU:
			{
				HMENU hSysMenu = GetSystemMenu( hwnd, FALSE );
				int nID = TrackPopupMenu( hSysMenu, TPM_LEFTALIGN | TPM_RETURNCMD, LOWORD(lParam), HIWORD(lParam), 0, hwnd, NULL );
				if ( nID > 0 )
				{
					SendMessage( hwnd, WM_SYSCOMMAND, nID, lParam );
				}
			}
			break;
		case WM_SYSCOMMAND:
			{
				HMENU hSysMenu = GetSystemMenu(hwnd,FALSE);
				switch ( wParam )
				{
				case IDM_TOPMOST:
					{
						static BOOL bChecked = FALSE;
						if ( bChecked = !bChecked )
						{
							CheckMenuItem( hSysMenu, wParam, MF_CHECKED );
							SetWindowPos( hwnd, HWND_TOPMOST, 0, 0, 0, 0, SWP_NOREDRAW | SWP_NOSIZE | SWP_NOMOVE );
						}
						else
						{
							CheckMenuItem( hSysMenu, wParam, MF_UNCHECKED );
							SetWindowPos( hwnd, HWND_NOTOPMOST, 0, 0, 0, 0, SWP_NOREDRAW | SWP_NOSIZE | SWP_NOMOVE );
						}
					}
					break;
				case IDM_HELP:
					{
						MessageBox( hwnd, "һ��ʱ�ӳ���.", "����", MB_ICONINFORMATION );
					}
					break;
				}
			}
			break;
		}
#endif // _DEBUG
	
	return DefWindowProc( hwnd, uMsg, wParam, lParam );
}

int WINAPI WinMain( HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow ) 
{
	char szClassName[] = "DrawClock";
	HWND hWnd;
	MSG msg;
	WNDCLASSEX wclsex;
	wclsex.cbClsExtra = 0;
	wclsex.cbSize = sizeof(wclsex);
	wclsex.cbWndExtra = 0;
	wclsex.hbrBackground = (HBRUSH)GetStockObject(BLACK_BRUSH);
	wclsex.hCursor = LoadCursor( NULL, IDC_ARROW );
	wclsex.hIcon = LoadIcon( NULL, IDI_QUESTION );
	wclsex.hIconSm = LoadIcon( NULL, IDI_QUESTION );
	wclsex.hInstance = hInstance;
	wclsex.lpfnWndProc = ClockWndProc;
	wclsex.lpszClassName = szClassName;
	wclsex.lpszMenuName = NULL;
	wclsex.style = CS_HREDRAW | CS_VREDRAW;

	RegisterClassEx(&wclsex);

	hWnd = CreateWindow(
		szClassName,
		"����ʱ�ӳ���",
		WS_POPUPWINDOW,
		CW_USEDEFAULT, CW_USEDEFAULT,
		300, 300,
		NULL, NULL, hInstance, NULL			//���һ������Ϊָ��һ��ֵ��ָ�룬��ֵ���ݸ�����WM_CREATE��Ϣ
	);
	
	ShowWindow( hWnd, nCmdShow );
	UpdateWindow(hWnd);
	while ( GetMessage( &msg, NULL, 0, 0 ) )
	{
		TranslateMessage(&msg);
		DispatchMessage(&msg);
	}
	return 0;
}
