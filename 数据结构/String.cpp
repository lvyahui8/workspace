#include <stdio.h>
typedef int Count;
//	求串s所含不同字符的总数和每种字符的个数。

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

//求一个字符串中单词的个数
Count getCount(char * const str){
	char * p = str;
	Count count = 0;
	bool bFlags = false;	//标记是否正在读同一个单词
	while (*p != '\0') {
		if ( ((*p>'a' && *p<'z')||(*p>'A' && *p<'Z'))  && false == bFlags) {
			//	如果条件为真，表示这是一个新单词的开始
			bFlags = true;
			count++;
		}
		else if (' ' == *p) {
			//	如果条件为真表示这是一个新单词的结束
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
	printf("这个字符串中有%d个单词。\n",getCount(str));
}
