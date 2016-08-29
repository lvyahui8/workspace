// test.cpp : 定义控制台应用程序的入口点。
//



#include <windows.h>
#include <iostream>

using namespace std;

int main()
{
	setvbuf( stdout, NULL, _IOLBF, 1024 );  //设置控制台输出为行缓存模式，把缓冲区与流相关 
	cout <<"hello world\n";                
	Sleep(5000);                            
	cout <<"leeboy"<<endl;                 

	system("pause");
	return 0;
}

