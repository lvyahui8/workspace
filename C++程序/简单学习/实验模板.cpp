#include <iostream>
#include <string>
#include <windows.h>
#include <conio.h>
using namespace std;


bool GotoPos(int x,int y)//设定光标位置
{
	COORD pos={x,y};
	HANDLE hOut=GetStdHandle(STD_OUTPUT_HANDLE);
	if(INVALID_HANDLE_VALUE == hOut)
		return false;
    SetConsoleCursorPosition(hOut, pos);
	return true;
}
void SetWindowSize(int cx,int cy){
	char buffer[40]={0};
	sprintf(buffer,"mode con cols=%d lines=%d",cx,cy);
	system(buffer);
}

bool SetTextColor(WORD wAttributes){
	HANDLE hOut=GetStdHandle(STD_OUTPUT_HANDLE);
	if(INVALID_HANDLE_VALUE == hOut)
		return false;
	return ::SetConsoleTextAttribute(hOut, wAttributes | BACKGROUND_INTENSITY | FOREGROUND_INTENSITY);
}

bool GetTxetColor(WORD * lpwAttributes){
	CONSOLE_SCREEN_BUFFER_INFO info;
	HANDLE hOut=GetStdHandle(STD_OUTPUT_HANDLE);
	if(INVALID_HANDLE_VALUE == hOut)
		return false;
	GetConsoleScreenBufferInfo(hOut,&info);
	*lpwAttributes=info.wAttributes;
	return true;
}
void Cls(){
	system("cls & color 07");
}
/*
1. //一共有16种文字颜色，16种背景颜色，组合有256种。传入的值应当小于256   
2. BOOL SetConsoleColor(WORD wAttributes)   
3. {    
4.     HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);   
5.     if (hConsole == INVALID_HANDLE_VALUE)  
6.         return FALSE;  
7.    
8.     return SetConsoleTextAttribute(hConsole, wAttributes);   
9. }  
*/

template<class vType>
void Input(vType & value,const COORD & currentPos){
	string strTemp;
	GotoPos(currentPos.X,currentPos.Y);
	cout<<"   ";
	GotoPos(currentPos.X,currentPos.Y);
	cin>>strTemp;
	value = atoi(strTemp.c_str());
}

void main(){
//	SetWindowSize(160,38);

	int i,j;
/*	int i;
	cin>>i;
	SetWindowSize(80,20);
	*/
//	/*
	//SetTextColor(BACKGROUND_GREEN);
	cout<<"0123456789012345678901234567890"<<endl;

	for(j=0;j<4;j++){
		for(i=0;i<=9;i++){
			if(j==0 && i == 0)
				continue;
			cout<<i<<endl;
		}
	}
	GotoPos(3,0);
	
//	*/
	/*
	SetTextColor(BACKGROUND_BLUE);
	for(i=0;i<38;i++){
		GotoPos(140,i);
		cout<<" ";
	}
	
	SetTextColor(BACKGROUND_GREEN);
	COORD rPOs={0,0};
	for(i=0;i<20;i++){
		GotoPos(rPOs.X+3,rPOs.Y+2);
		for(j=0;j<11;j++)
			cout<<"■";
		GotoPos(rPOs.X+3,rPOs.Y+3);
		for(j=0;j<11;j++)
			cout<<"■";
		GotoPos(rPOs.X+3,rPOs.Y+4);
		for(j=0;j<11;j++)
			cout<<"■";
		GotoPos(rPOs.X+3,rPOs.Y+5);
		for(j=0;j<11;j++)
			cout<<"■";
		GotoPos(rPOs.X+3,rPOs.Y+6);
		for(j=0;j<11;j++)
			cout<<"■";
		GotoPos(rPOs.X+3,rPOs.Y+7);
		for(j=0;j<11;j++)
			cout<<"■";
		GotoPos(rPOs.X+3,rPOs.Y+8);
		rPOs.X+=28;
		if(rPOs.X>130){
			rPOs.X=0;
			rPOs.Y+=9;
		}
	}*/
	/*
	int cx = GetSystemMetrics(SM_CXFULLSCREEN);
	int cy = GetSystemMetrics(SM_CYFULLSCREEN);
	system("title 1232324");
	char  buffer[40];
	GetConsoleTitle(buffer,40);
	cout<<buffer<<endl;
	HWND hWnd=FindWindow(NULL,buffer);
	cout<<hWnd;
	//MoveWindow(hWnd,0, 0,cx, 768,true);
//	DeleteMenu(GetSystemMenu(hWnd, FALSE), SC_CLOSE, MF_BYCOMMAND);
//	DeleteMenu(GetSystemMenu(hWnd, FALSE), SC_MAXIMIZE, MF_BYCOMMAND);
//	DrawMenuBar(hWnd);
	//ShowWindow()
	GotoPos(30,10);
	SetTextColor(FOREGROUND_GREEN | FOREGROUND_BLUE);
	WORD wAttributes;
	GetTxetColor(&wAttributes);
	cin>>cx;
	GotoPos(30,11);
	SetTextColor(FOREGROUND_RED);
	cin>>cy;
	getchar();
	SetTextColor(wAttributes);
	*/
	/*
	char buffer[255];
	sprintf(buffer,"echo wo : %d : %d  >> 1.txt",3,4);
	system(buffer);
	*/
/*
	char str[100];
	char * pStr = str;
	while((*pStr=getch()) != 13){
		if(8 == *pStr){
			if(pStr>str){
				cout<<'\b'<<' '<<'\b';
				pStr--;
			}
			
		}
		else{
			cout<<"*";
			pStr++;
		}
	}
	*pStr='\0';
	string strTemp;
	strTemp.assign(str);
	if("asdf"==strTemp){
		cout<<endl<<"密码正确"<<endl;
	}
	else{
		cout<<endl<<"密码错误"<<endl;
	}
	*/
/*
	system("title syslib");
	char  buffer[40];
	::GetConsoleTitle(buffer,40);			//获的窗口标题
	HWND hMainWnd=FindWindow(NULL,buffer);
*/
/*
//删除标题栏

	long lStyle = ::GetWindowLong(hWnd, GWL_STYLE);
	::SetWindowLong(hWnd, GWL_STYLE, lStyle & ~WS_CAPTION);	//删除菜单
	::SetWindowPos(hWnd, NULL, 0, 0, 0, 0,SWP_NOSIZE			//重画窗口
		| SWP_NOMOVE | SWP_NOZORDER | SWP_NOACTIVATE | SWP_FRAMECHANGED);
*/	
//删除标题栏的最大化和关闭按钮
	/*
	::DeleteMenu(GetSystemMenu(hMainWnd, FALSE), SC_CLOSE, MF_BYCOMMAND);
	::DeleteMenu(GetSystemMenu(hMainWnd, FALSE), SC_MAXIMIZE, MF_BYCOMMAND);
	::DrawMenuBar(hMainWnd);		//重画菜单
	
	system("start Clock.exe");
	char ch;
	strcpy(buffer,"Clock");
	HWND hClockWnd=FindWindowEx(NULL,NULL,NULL,"Clock");
	SetWindowPos(hMainWnd, HWND_TOPMOST, 0,0,0,0, SWP_NOMOVE|SWP_NOSIZE|SWP_SHOWWINDOW);
	while((ch=getchar())!='\n');
	system("taskkill /IM Clock.exe");
	*/
	GotoPos(10,6);
	cout<<"___________";
	GotoPos(10,7);
	cout<<"|___________|";
	GotoPos(10,7);
	getchar();
}
