// test.cpp : �������̨Ӧ�ó������ڵ㡣
//



#include <windows.h>
#include <iostream>

using namespace std;

int main()
{
	setvbuf( stdout, NULL, _IOLBF, 1024 );  //���ÿ���̨���Ϊ�л���ģʽ���ѻ������������ 
	cout <<"hello world\n";                
	Sleep(5000);                            
	cout <<"leeboy"<<endl;                 

	system("pause");
	return 0;
}

