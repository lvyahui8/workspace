#include <stdafx.h>
// ͳ���ַ�������
int str_len(char *str){
	return *str ? str_len(str+1)+1 : 0 ;
}
// �ַ�������
void str_cpy(char *str1,char *str2){
	while(*str1++ = *str2++); //��str2ָ��'\0'ʱ����ֵ��*str1 ���ʽ��ֵΪ0 ��Ϊ�١��˳�ѭ��
		//if(*str1 == '\0')	// ���ǵ� ��2�ĳ��ȴ��ڴ�1�ĳ��ȣ���ָֹ��Խ��
			//break;
}
// �ַ����Ƚ�
int str_cmp(char *str1,char *str2){
	int i;// iָ���ַ���ͬʱ�����±�
	for(i=0;str1[i]==str2[i] && str1[i]!='\0' && str2[i]!='\0';i++);
	return str1[i]-str2[i];
}
// �ַ�������
void str_cat(char *str1,char *str2){
	while(*str1 != '\0')
		str1++;
	while(*str1++ = *str2++);
}
void main()
{
	char string1[40];
	char string2[40];
	int p;
	gets(string1);
	gets(string2);
	p=str_cmp(string1,string2);
	printf("�ַ���1:%s\n",string1);
	printf("�ַ���2:%s\n\n",string2);

	printf("��1��Ϊ%d�ֽڣ���1��Ϊ%d�ֽ�\n\n",str_len(string1),str_len(string2));
	if(p>0)
		printf("��1���ڴ�2\n\n");
	else if(p==0)
		printf("��1�봮2��ͬ\n\n");
	else
		printf("��1С�ڴ�2\n\n");
	str_cpy(string1,string2);
	printf("����2���Ƶ���1�������1�����Ϊ%s\n\n",string1);
	str_cat(string1,string2);
	printf("����2���ӵ���1���棬���Ϊ%s\n\n",string1);
}