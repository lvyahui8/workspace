#include <windows.h>
#include <tchar.h>
int WINAPI _tWinMain(
					 HINSTANCE hInstance,		// handle to current instance
					 HINSTANCE hPrevInstance,	// handle to previous instance
					 LPSTR lpCmdLine,			// pointer to command line
					 int nCmdShow				// show state of window
					 ){  
	UNREFERENCED_PARAMETER(hPrevInstance);
	UNREFERENCED_PARAMETER(lpCmdLine);
	UNREFERENCED_PARAMETER(hInstance);
	UNREFERENCED_PARAMETER(nCmdShow);
	
	HWND hWnd = GetDesktopWindow();

	::MessageBox(hWnd,_T("��һ��Ӧ�ó���"),_T("����"),MB_OK);
	
	return 0;
}