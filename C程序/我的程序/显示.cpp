#include <stdafx.h>
//Ϊ��ʹ��system()��Sleep()��������<stdlib.h> �� <windows.h>
#include <stdlib.h> 
#include <windows.h>

void main()
{
	system("dir c:\ & pause & cls & dir d:\ ");
}