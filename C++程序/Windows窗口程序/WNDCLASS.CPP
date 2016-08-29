#include <windows.h> 
//包含应用程序中数据类型和数据结构的定义 
long CALLBACK WndProc(HWND,UINT,WPARAM,LPARAM); 
//窗口说明 
//WinMain函数是所有Windows应用程序的入口，类似c语言中的main函数 其功能是完成//一系列的定义和初始化，并产生消息循环
/* WinMain函数实现以下功能：注册窗口类，建立窗口及执行其他必要的初始化工作；进入消息循环，根据从应用程序消息队列接受的消息，调用相应的处理过程；当消息循环检
测到WM_QUIT消息时终止程序运行 

WinMain函数有三个基本部分组成：函数说明、初始化和消息循环*/ 
//函数说明 
int WINAPI WinMain( 
	HINSTANCE hInstance, // handle to current instance 
	HINSTANCE hPrevInstance, // handle to previous instance 
	LPSTR lpCmdLine, // command line 
	int nCmdShow // show state 
) 
//初始化 
//初始化包括窗口类的定义、注册、创建窗口实例和显示窗口四部分 
{ 
	HWND hwnd; 
	MSG Msg; 
	WNDCLASS wndclass; 
	char lpszClassName[]="窗口";//窗口类名 
	char lpszTitle[]="AgrinDJ"; //窗口标题名
	//窗口类定义 
	//窗口类定义了窗口的形式与功能 窗口类定义通过给窗口类数据结构WNDCLASS赋值完成 
	//该数据结构中包含窗口类的各种属性 
	wndclass.style =0;					// 窗口类型为缺省类型 
	wndclass.lpfnWndProc=WndProc;		//定义窗口处理函数 
	wndclass.cbClsExtra=0;				//窗口类无扩展 
	wndclass.cbWndExtra=0;				//窗口实例无扩展 
	wndclass.hInstance=hInstance;		//当前实例句柄 
	wndclass.hIcon=LoadIcon(NULL,IDI_APPLICATION);	//窗口的最小化图标为缺省图标 
	wndclass.hCursor=LoadCursor(NULL,IDC_ARROW);	// 窗口采用箭头光标
	wndclass.hbrBackground=(HBRUSH)(GetStockObject(WHITE_BRUSH));	//窗口背景为白色 
	wndclass.lpszMenuName=NULL;			//窗口无菜单 
	wndclass.lpszClassName=lpszClassName;			//窗口类名为“窗口” 

	//////////////// 以下是窗口类的注册 Windows系统本身提供部分预定义的窗口类，程序员也可以自定义窗口类// 窗口类必须先注册 后使用 
	if(!RegisterClass(&wndclass)) //如果注册失败 发出警告 
	{MessageBeep(0); return FALSE;} 

	///////////////创建窗口 创建一个窗口的实例由函数CreateWindow()实现 
	hwnd=CreateWindow( lpszClassName, //窗口类名 
		lpszTitle, //窗口标题名
		WS_OVERLAPPEDWINDOW, //窗口的风格 
		CW_USEDEFAULT, 
		CW_USEDEFAULT, //窗口左上角坐标值为缺省值
		CW_USEDEFAULT, CW_USEDEFAULT, //窗口的高和宽为缺省值
		NULL, //此窗口无父窗口 
		NULL, //此窗口无子菜单 
		hInstance, //创建此窗口的应用程序的当前句柄 
		NULL //不使用该值 
	); 

	/////////////显示窗口 
	ShowWindow(hwnd,nCmdShow); 

	//绘制用户区 
	UpdateWindow(hwnd); 

	/////////////消息循环
	while(GetMessage(&Msg,NULL,0,0)) 
	{ 
		TranslateMessage(&Msg); 
		DispatchMessage(&Msg);
	} 
	return Msg.wParam; //消息循环结束 即程序结束时 将信息返回系统 
} 


/////////////窗口函数
//窗口函数定义了应用程序对接收到的不同消息的响应，其中包含了应用程序对各种可能接受到的消息的 
//处理过程，时消息处理分支控制语句的集合 
long CALLBACK WndProc( 
	HWND hwnd, 
	UINT message, 
	WPARAM wParam, 
	LPARAM lParam 
) 
{ 
	switch(message) 
	{ 
	case WM_DESTROY:  PostQuitMessage(0); 
	default: //缺省时采用系统消息缺省处理函数 
		return DefWindowProc(hwnd,message,wParam,lParam); 
	} 
	return (0); 
}