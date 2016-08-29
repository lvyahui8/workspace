#include <stdafx.h>
// 统计字符串长度
int str_len(char *str){
	return *str ? str_len(str+1)+1 : 0 ;
}
// 字符串复制
void str_cpy(char *str1,char *str2){
	while(*str1++ = *str2++); //当str2指向'\0'时，赋值给*str1 表达式的值为0 即为假。退出循环
		//if(*str1 == '\0')	// 考虑到 串2的长度大于串1的长度，防止指针越界
			//break;
}
// 字符串比较
int str_cmp(char *str1,char *str2){
	int i;// i指向字符不同时数组下标
	for(i=0;str1[i]==str2[i] && str1[i]!='\0' && str2[i]!='\0';i++);
	return str1[i]-str2[i];
}
// 字符串连接
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
	printf("字符串1:%s\n",string1);
	printf("字符串2:%s\n\n",string2);

	printf("串1长为%d字节，串1长为%d字节\n\n",str_len(string1),str_len(string2));
	if(p>0)
		printf("串1大于串2\n\n");
	else if(p==0)
		printf("串1与串2相同\n\n");
	else
		printf("串1小于串2\n\n");
	str_cpy(string1,string2);
	printf("将串2复制到串1，输出串1，结果为%s\n\n",string1);
	str_cat(string1,string2);
	printf("将串2连接到串1后面，结果为%s\n\n",string1);
}