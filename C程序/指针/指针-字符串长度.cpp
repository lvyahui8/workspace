#include <stdafx.h>
//�������ַ�������
int strlen(char *string);

void main()
{
	char str[]="hello world!";
	printf("%d\n",strlen(str));
}

int strlen(char *string)
{
	int length=0;
	//���η����ַ��������ݣ������ַ���
	while( (*string++) != '\0')
	{
		length += 1;
	}
	return length;
}