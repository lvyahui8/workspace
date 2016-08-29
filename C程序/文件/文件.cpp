// 文件.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <stdlib.h>
int main(int argc, char* argv[])
{
	/*
	FILE * fp;

	fp=fopen("a.txt","r");
 
	//  read/write functions
	
	fclose(fp);
	*/

/*
	FILE *stream, *stream2;

	int numclosed;

	// Open for read (will fail if file "data" does not exist) 
	if( (stream  = fopen( "data", "r" )) == NULL )
	{
		printf( "The file 'data' was not opened\n" );
		//exit(0);
	}
	else
		printf( "The file 'data' was opened\n" );

	// Open for write 
	if( (stream2 = fopen( "data2", "w+" )) == NULL )
		printf( "The file 'data2' was not opened\n" );
	else
		printf( "The file 'data2' was opened\n" );

	// Close stream 
	if( NULL!=stream )
		if( fclose( stream ))
			printf( "The file 'data' was not closed\n" );

	// All other files are closed: 
	numclosed = _fcloseall( );
	printf( "Number of files closed by _fcloseall: %u\n", numclosed );
*/
/*
	FILE * fp;
	char c;
	if( (fp=fopen("data","w") ) == NULL )
	{
		printf("打开失败！\n");
		exit(0);
	}
	//while(fp != 

	fputc('t',fp);   //只读方式打开本行无效
//	fflush(fp);		//将缓存区的数据存到文件里
	fclose(fp);
//	rewind(fp);		//将文件位指针重新指向第一个字节

	if( (fp=fopen("data","r") ) == NULL )
	{
		printf("打开失败！\n");
		exit(0);
	}

	c=fgetc(fp);
	printf("%c\n",c);

*/

	/*
	c=fgetc(fp);
	printf("%c\n",c);
	c=fgetc(fp);
	printf("%c\n",c);
	c=fgetc(fp);
	printf("%c\n",c);
	*/
/*
	FILE * fp;
	char c;
	if( (fp=fopen("data","a") ) == NULL )	//以 a 方式打开追加信息，文件可以不存在
	{
		printf("打开失败！\n");
		exit(0);
	}
	fputc('g',fp);
	fputc('h',fp);
	fputc('j',fp);
	fclose(fp);
*/
	//3个标准文件：标准输入、标准输出、标准出错输出
	//				stdin     stdout     stderr
	fputc('a',stdout);
	printf("%c\n",fgetc(stdin));

}

 