#include <stdafx.h>
#include <string.h>
#define LEN 10
/*
void str_sort(char str[][20]){
	char * p[LEN];
	int a[LEN]={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	int i,j=0,k=0,m=0;

	for(i=0;i<LEN;i++)
	{
		k=i;
		for(j=0;j<LEN;j++)
		{
			while(m<LEN-1 && j!=a[m]) 
				m++;
			if(m!=LEN-1)
			{
				m=0;
				continue;
			}
			m=0;
			if(strcmp(str[k],str[j])>=0)
				k=j;
		}
		a[i]=k;

		p[i]=str[k];
	}

	for(i=0;i<LEN;i++)
		puts(p[i]);
}
*/
void str_sort(char str[][20]){
	char * p[LEN];

	int i,j=0,k;
	for(i=0;i<LEN;i++)
	{
		k=i;
		for(j=0;j<LEN;j++)
		{
			if(str[j][0]=='1')
				continue;
			if(strcmp(str[k],str[j])>0)
			{
				k=j;
			}
		}
		str[k][0]='1';
		p[i]=str[k];
	}

	for(i=0;i<LEN;i++)
		printf("%s\n",p[i]+1);

}
void main(){
	char name[LEN][20]={{'0'},{'0'},{'0'},{'0'},{'0'},{'0'},{'0'},{'0'},{'0'},{'0'}};
	int i;
	printf("依次输入10个人的名字，并回车\n");
	for(i=0;i<LEN;i++)
		gets(name[i]+1);
	printf("\n\n排序后的结果:\n");
	str_sort(name);
	printf("\n原数组中储存的数据:\n");
	for(i=0;i<LEN;i++)
		printf("%s\n",name[i]+1);
	getchar();
}
