#include <stdafx.h>
#include <string.h>
void main()
{
	char str1[]="heLlOw";
	char str2[]="woRlD!";

	int i;
	//����Ƚ��ַ�ASCII�룬�Ƚϳ���С������Ƚϣ������ǱȽ��ַ�������
	i=strcmp(str1,str2);	
	printf("%d\n",i);
	i=strlen(str1);
	//���ַ����ӷ������ӵ�һ���ַ�����
	printf("%d\n",i);
	printf("%s\n",strlwr(str1));//����дת����Сд
	printf("%s\n",strupr(str1));//��Сдת���ɴ�д
}