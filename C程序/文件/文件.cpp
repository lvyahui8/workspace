// �ļ�.cpp : Defines the entry point for the console application.
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
		printf("��ʧ�ܣ�\n");
		exit(0);
	}
	//while(fp != 

	fputc('t',fp);   //ֻ����ʽ�򿪱�����Ч
//	fflush(fp);		//�������������ݴ浽�ļ���
	fclose(fp);
//	rewind(fp);		//���ļ�λָ������ָ���һ���ֽ�

	if( (fp=fopen("data","r") ) == NULL )
	{
		printf("��ʧ�ܣ�\n");
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
	if( (fp=fopen("data","a") ) == NULL )	//�� a ��ʽ��׷����Ϣ���ļ����Բ�����
	{
		printf("��ʧ�ܣ�\n");
		exit(0);
	}
	fputc('g',fp);
	fputc('h',fp);
	fputc('j',fp);
	fclose(fp);
*/
	//3����׼�ļ�����׼���롢��׼�������׼�������
	//				stdin     stdout     stderr
	fputc('a',stdout);
	printf("%c\n",fgetc(stdin));

}

 