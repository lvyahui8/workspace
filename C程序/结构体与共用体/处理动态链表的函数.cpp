#include <stdafx.h>
#include <stdlib.h>
/*
void main(){
	// malloc  free����
	char *string;
	string = (char *)malloc(3);

	if(string==NULL)
		printf("�ռ䲻��\n");
	else
	{
		printf("����ɹ�\n");
		*string='a';
		*(string+1)='b';
		*(string+2)='\0';
		puts(string);
		free(string);// �ͷſռ�
		printf("�ͷųɹ�\n");
	}
}
*/
void main(){
	// calloc ����   ������Ԫ�ط���ռ�
	// ��һ������Ϊ Ԫ�ظ������ڶ�������Ϊÿ��Ԫ�ص��ֽ���
	// ��Ϊ�޷�������
	long * buffer;
	int i;
	buffer = (long *)calloc( 40,sizeof(long));
	
	if(buffer != NULL)
	{
		printf("����ɹ�\n");
		for(i=0;i<40;i++)
			buffer[i]=i;
	}		
	else
		printf("�ռ䲻��\n");
	
	for(i=0;i<40;i++)
		printf("%d ",buffer[i]);

	free( buffer );
}