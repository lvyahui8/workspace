#include <stdio.h>
typedef int Count;
//	��s������ͬ�ַ���������ÿ���ַ��ĸ�����

void getDifferCharCout(char * const str,Count & difCount,Count ** chCount){
	*chCount = new int[255];
	for (int i=0;i<255;i++) {
		(*chCount)[i] = 0;
	}
	char * p = str;
	Count dCount =0 ;
	while (*p!='\0') {
		if (0==(*chCount)[*p]) {
			dCount ++;
		}
		(*chCount)[*p]++;
		p++;
	}
}

//��һ���ַ����е��ʵĸ���
Count getCount(char * const str){
	char * p = str;
	Count count = 0;
	bool bFlags = false;	//����Ƿ����ڶ�ͬһ������
	while (*p != '\0') {
		if ( ((*p>'a' && *p<'z')||(*p>'A' && *p<'Z'))  && false == bFlags) {
			//	�������Ϊ�棬��ʾ����һ���µ��ʵĿ�ʼ
			bFlags = true;
			count++;
		}
		else if (' ' == *p) {
			//	�������Ϊ���ʾ����һ���µ��ʵĽ���
			bFlags = false;
		}
		p++;
	}

	return count;
}
void main(){
	char str[] = "  how do you  do ?  ";
	int * chSub;
	int difCount;
	getDifferCharCout(str,difCount,&chSub);
	for (int i=0;i<255;i++) {
		if (i%8 == 0) {
			putchar(10);
		}
		printf("%3d%3d  ",i,chSub[i]);
		
	}
	printf("����ַ�������%d�����ʡ�\n",getCount(str));
}
