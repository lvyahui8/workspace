#include <stdafx.h>
//为了使用system()和Sleep()命令，需包括<stdlib.h> 和 <windows.h>
#include <stdlib.h> 
#include <windows.h>

void main()
{
	system("dir c:\ & pause & cls & dir d:\ ");
}