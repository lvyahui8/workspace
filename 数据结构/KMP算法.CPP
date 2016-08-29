#include <stdio.h>
#include <string.h>
#include <malloc.h>

void GetNext(const char * mode,int * next){
	//求模式mode的next值并存入数组next中
	int i=1,j=0;
	next[1] = 0;
	while(i < mode[0]){
		if(0 == j || mode[i] == mode[j]){
			i++;j++;
			next[i] = j;
		}
		else
			j = next[j];
	}
}
int Index_KMP(const char * str,const char * mode,int pos){
	int i=pos,j=1;
	int * next = (int *)malloc(sizeof(int)*(mode[0]+1));
	next[0]=mode[0];
	GetNext(str,next);
	while (i<=str[0] && j<= mode[0]) {
		if (0==j || str[i] == mode[j]) {
			i++;j++;
		}
		else{
            // 滑动模式串，注意next[j]是小于j的，这才是向右滑动
			j = next[j];
		}
	}
    return j>mode[0] ?  i - mode[0] : 0;
}

void main(){
	char string[16] = "\016abcabcabaabcac";
	char mode[10] = "\010abaabcac";
	printf("模式串在主串中的位置:%d\n",Index_KMP(string,mode,1));
}