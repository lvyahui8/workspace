
#include "stdafx.h"

int main(int argc, char* argv[])
{
    int n;
	scanf("n=%d",&n);
    if(n%3==0 && n%5==0)
	{
		printf("%d��ͬʱ��3��5����\n",n);
	}
	else
	{
		printf("%d����ͬʱ��3��5 ����\n",n);
	}
	return 0;
}