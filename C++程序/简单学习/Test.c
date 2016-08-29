
#include<stdio.h>
#include <string.h>
#include <stdlib.h>
void demo(char str1[],char str2[],char str3[]){

	int hasChar1[255]= {0};
	int hasChar2[255]= {0};
	int hasChar3[255]= {0};
	int i;

	for(i=0;i<strlen(str1);i++){
		hasChar1[str1[i]] = 1;
	}
	for(i=0;i<strlen(str2);i++){
		hasChar2[str2[i]] = 1;
	}
	for(i=0;i<strlen(str3);i++){
		hasChar3[str3[i]] = 1;
	}
    for(i=0;i<255;i++){
		//printf("%x = %x\t",hasChar3[i],hasChar1[i] | hasChar2[i]);
		if(hasChar3[i] != (hasChar1[i] | hasChar2[i]))
			break;
	}
	if(255 == i){
		printf("YES\n");
	}
	else{
		printf("NO\n");
	}
}
int main()
{ 
	char str1[100];
	char str2[100];
	char str3[200];
	char str4[100];
	char str5[100];
	char str6[200];
	scanf("%s %s %s",str1,str2,str3);
	scanf("%s %s %s",str4,str5,str6);
	demo(str1,str2,str3);
	demo(str4,str5,str6);
}
