#include <stdafx.h>

void main()
{

	int a[3][4]={0,1,2,3,4,5,6,7,8,9,10,11};
	int i,j;
	int (*p)[4];
	/*
	*	它与 int *p[4] 是有区别的
	*	它只是指明指针指向的是4个
	*	元素的一维数组
	*/
	p=a;
	

	scanf("%d %d",&i,&j);

	printf("%d\n",*(*(p+i)+j));
	//       *(p+i) == a[i]
	//        *(p+i) + j == & ( a[i][j] )
	//		*(*(p+i)+j) == a[i][j]

}