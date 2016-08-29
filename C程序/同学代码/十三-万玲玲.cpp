#include<stdio.h>
#include<string.h>
int struct student
{
	int name[10];
	int xuehao[10];
	int score[10];
}

int main()
{
	char str1(int name[10])
    char str2(int xuehao[10])
    char str3(int score[10])
	printf("请输入学生姓名，学号，成绩:");
	printf("\n");
	gets(student);
	str1(name);        //hanshudiaoyong
	for(i=0;i<10;i++)
	    printf("%d",stduent.score[i]);
     	printf("\n");
	    return 0;
}


char str3(int score[10])
{
	int i,j,k,t;
    for(i=0;i<9;i++)              //xuanzefa
        k=i;
    for(j=i+1;j<10;j++)
        if(strcmp(score[k],score[j])>0)
             k=j;
            t=score[k];score[k]=score[i];score[i]=t;
}

	int i,c,sum,mid;

	for(i=0;i<10;i++)
	{
		sum+=score[i];
	}
    mid=sum/10;
    printf("输入一个成绩:\n");
    scanf("%d",&c);
    if(c<=mid)
	{
		for(i=0;i<5;i++)
			if(c=str1[i])
				printf("%d",student.str1[i]);		
    else if(c>mid)
	{
		for(i=5;i<10,i++)
            if(c=str1[i])
				printf("%d",student.str1[i]);
	}
    else
	    printf("无此成绩的学生");
}



