#include <stdio.h>
#include <string.h>
bool strInsert(char * strMain,const char * strSub,const int i){
	char strTemp[20];
	if(i>strlen(strMain))
		return 0;
	strcpy(strTemp,&strMain[i-1]);
	strcpy(&strMain[i-1],strSub);
	strcat(strMain,strTemp);
	return 1;
}
void main(){
	char strMain[40]="asdfghjklzxcvbnm"; 
	char strSub[5]="####";
	strInsert(strMain,strSub,10);
	puts(strMain);
}