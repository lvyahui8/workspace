
#include "stdafx.h"

int main(int argc, char* argv[])
{
    int n;
	scanf("n=%d",&n);
    if(n%3==0 && n%5==0)
	{
		printf("%d能同时被3和5整除\n",n);
	}
	else
	{
		printf("%d不能同时被3和5 整除\n",n);
	}
	return 0;
}