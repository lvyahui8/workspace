/*
���󣺸����ַ���������2���ݸ��Ƹ���1
*/
#include <stdafx.h>
#define LEN1 16
#define LEN2 12

void strcopy(char * str1,char * str2)
{
	while(*str1++ = *str2++) //��str2ָ��'\0'ʱ����ֵ��*str1 ���ʽ��ֵΪ0 ��Ϊ�١��˳�ѭ��
		if(*str1 == '\0')	// ���ǵ� ��2�ĳ��ȴ��ڴ�1�ĳ��ȣ���ָֹ��Խ��
			break;
}

void main()
{
	int i;
	char string1[LEN1]="aaaaaaaaaaaaaaa";
	char string2[LEN2]="bbbbbbbbbbb";
	printf("String 1:%s\nString 2:%s\n",string1,string2);

	strcopy(string1,string2);

	puts("\nUses the puts function to output:");
	printf("String 1:%s\nString 2:%s\n",string1,string2);
	// Ϊ����ʾ���Ѿ���'\0'���ƹ�ȥ����ѭ������һ������
	printf("\nThe use of loop through the array:\nString 1:");
	for(i=0;i<LEN1;i++)
		putchar(string1[i]);
	printf("\nString 2:");
	for(i=0;i<LEN2;i++)
		putchar(string2[i]);
	putchar('\n');
		
}