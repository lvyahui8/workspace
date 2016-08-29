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
void Input(string &str,const COORD & pos){
	do{
		char ch;
		GotoPos(pos.X,pos.Y);
		while((ch=getchar()) != 10){
			str.append(1,ch);
		}
		if(""!=str) break;
	}while(1);
}
void main(){
	string str;
	COORD pos={0,0};
	Input(str,pos);
	cout<<str;
}