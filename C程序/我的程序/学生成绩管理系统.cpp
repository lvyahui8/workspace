#include <stdafx.h>
#include <stdlib.h>
#include <string.h>
#define NUMP 2 //人数
#define NAME 20 //名字长度
#define DEBUG
/*
** 说明：学生记录为学生的基本信息，包括学号，姓名，c语言成绩，数学成绩，英语成绩，总分，平均分。
*/
struct student{
	int sign;//标记该结构体有无值 1为有值
	int num;//学号
	char name[NAME];//姓名
	float c_score;//c语言成绩
	float m_score;//数学成绩
	float e_score;//英语成绩
	float aggr_score;//总分
	float aver_score;//平均分
};

int n=0;

//此函数用来录入
void Entry_record(struct student s[],int i){
	puts("按此格式录入：\n学号 姓名 c语言成绩 数学成绩 英语成绩");
#ifdef DEBUG
	printf("&s==%x\n",s);
#endif
	s[i].sign=1;//标记有值
	scanf("%d%*c",&s[i].num);
	scanf("%s",s[i].name);
	scanf("%f%*c",&s[i].c_score);
	scanf("%f%*c",&s[i].e_score);
	scanf("%f%*c",&s[i].m_score);
	system("pause");
	system("cls");
}

void Entry(struct student s[]){
	struct student *s_p=s;
	Entry_record(s_p,n);
	n++;
}
/*
void Del_record(struct student s[]){
	int k;
	scanf("%d",&k);
	k-=1;
	int i;
	for(i=k;i<NUMP
}
void Del_record(struct student s[]){
	struct student *s_p=s;
	char temp[20];
	int i;
	printf("输入你要删除的学生的姓名:");
	scanf("%s",temp);
	for(i=0;i<n;i++)
		if(strcmp(temp,s[i].name)==0)
			s[i].sign=0;
	system("cls");
}
*/
void menu(struct student s[]){
	int key=-1;
	struct student *s_p=s;

#ifdef DEBUG
	printf("&s==%x\n",s_p);
#endif

	while(key!=0)
	{
		scanf("%d%*c",&key); 
		system("cls");//
		switch(key)
		{	
		case 1:Entry(s_p);break;
		//case 2:Del_record(s_p);break;
		//case 3:
		//case 4:
		//case 5:
		//case 6:
		//case 7:
		//case 8:
		//case 9:
		case 0:break;
		default :break;
		}
	}
}
void main(){
	int i;
	struct student stu[NUMP], *stu_p=stu;

#ifdef DEBUG
	printf("&s==%x\n",stu_p);
#endif

	menu(stu_p);

#ifdef DEBUG
	for(i=0;i<NUMP;i++)
	{
		if(1==stu[i].sign)
			printf("%d %s %.2f %.2f %.2f\n",
			stu[i].num,stu[i].name,stu[i].c_score,stu[i].e_score,stu[i].m_score);
	}
#endif
}

/*
1
12 df 45 56 45
23 dsf 45 78 89
*/
