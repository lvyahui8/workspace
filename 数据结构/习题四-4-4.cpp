#include <stdio.h>
#include <string.h>
int SubStrCount(char * strMain,char * strSub){
	int iCount=0;
	while('\0' != *strMain){
		int i=0;
		while(('\0' != strSub[i])){
			if('\0' == *strMain)
				break;
			if(strSub[i] != strMain[i])
				break;
			i++;
		}
		if('\0' == strSub[i])
			iCount++;
		strMain++;
	}
	return iCount;
}
void main(){
	char strMain[40]= "aaaaa##aaa##aaaa##aaaaaa##aaaa";
	char strSub[3]="##";
	puts(strMain);
	puts(strSub);
	printf("子串出现次数：%d\n",SubStrCount(strMain,strSub));
}