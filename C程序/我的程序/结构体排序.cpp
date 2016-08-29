#include "stdafx.h"
#include <string.h>
#define AMOUNT 3
typedef struct stu{
	unsigned int num;
	char name[20];
	float score[3];
} STU;
void int_swap(unsigned int *a,unsigned int *b){
	*a=*a+*b;
	*b=*a-*b;
	*a=*a-*b;
}
void str_swap(char str1[],char str2[]){
	char temp[30];
	strcpy(temp,str1);
	strcpy(str1,str2);
	strcpy(str2,temp);
}
void float_swap(float *a,float *b){
	*a=*a+*b;
	*b=*a-*b;
	*a=*a-*b;
}
void input(STU st[],int amount){
	int i;
	char ch;
	for(i=0;i<amount;i++){
		scanf("%d %s %f %f %f",&st[i].num,st[i].name,&st[i].score[0],&st[i].score[1],&st[i].score[2]);
		while( ch=getchar() != '\n');
	}
}
void sort(STU st[],int amount){
	int i,j,k;
	for(i=0;i<amount-1;i++){
		k=i;
		for(j=i+1;j<amount;j++){
			if(st[j].num < st[k].num)
				k=j;
		}
		if(k!=i)
		{
			int_swap(&st[i].num, &st[k].num);
			str_swap(st[i].name,st[k].name);
			float_swap(&st[i].score[0],&st[k].score[0]);
			float_swap(&st[i].score[1],&st[k].score[1]);
			float_swap(&st[i].score[2],&st[k].score[2]);
		}
	}
}
void output(STU st[],int amount){
	int i;
	for(i=0;i<amount;i++){
		printf("%d %s %g %g %g\n",st[i].num,st[i].name,st[i].score[0],st[i].score[1],st[i].score[2]);
	}
}
void main(){
	STU student[AMOUNT];
	input(student,AMOUNT);
	sort(student,AMOUNT);
	output(student,AMOUNT);
}
