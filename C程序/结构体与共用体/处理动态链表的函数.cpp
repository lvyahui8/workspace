#include <stdafx.h>
#include <stdlib.h>
/*
void main(){
	// malloc  free函数
	char *string;
	string = (char *)malloc(3);

	if(string==NULL)
		printf("空间不足\n");
	else
	{
		printf("分配成功\n");
		*string='a';
		*(string+1)='b';
		*(string+2)='\0';
		puts(string);
		free(string);// 释放空间
		printf("释放成功\n");
	}
}
*/
void main(){
	// calloc 函数   给数组元素分配空间
	// 第一个参数为 元素个数，第二个参数为每个元素的字节数
	// 均为无符号整型
	long * buffer;
	int i;
	buffer = (long *)calloc( 40,sizeof(long));
	
	if(buffer != NULL)
	{
		printf("分配成功\n");
		for(i=0;i<40;i++)
			buffer[i]=i;
	}		
	else
		printf("空间不足\n");
	
	for(i=0;i<40;i++)
		printf("%d ",buffer[i]);

	free( buffer );
}