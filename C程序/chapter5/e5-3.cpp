#include <stdafx.h>

void main()
{
	int a=3,b=4,c=5;
	int x,y;
	printf("%d\n",a+b>c && b==c);
	             // 0
	printf("%d\n",a || b+c && b-c);
	            // 1
	printf("%d\n",!(a>b) && !c || 1);
	           // 1 
	printf("%d\n",!(a=b) && (y=b) && 0);
	                // 0 
	printf("%d\n",!(a+b)+c-1 && b+c/2);
	           //    1
}