#include <stdafx.h>
#include <stdlib.h>
#include <string.h>

#define NUMP 3 //人数
#define NAME 20 //名字长度
#define DEBUG
/*
** 说明：学生记录为学生的基本信息，包括学号，姓名，c语言成绩，数学成绩，英语成绩，总分，平均分。
*/

int num[NUMP];//学号
char name[NUMP][NAME];//姓名
float c_score[NUMP];//c语言成绩
float m_score[NUMP];//数学成绩
float e_score[NUMP];//英语成绩
float aggr_score[NUMP];//总分
float aver_score[NUMP];//平均分

int n=0;

//此函数用来录入
void Entry_record(){
	printf("请输入学号:");
	scanf("%d%*c",&num[n]);
	printf("请输入姓名:");
	gets(name[n]);
	printf("请输入C语言成绩:");
	scanf("%f%*c",&c_score[n]);
	printf("请输入英语成绩:");
	scanf("%f%*c",&e_score[n]);
	printf("请输入数学成绩:");
	scanf("%f%*c",&m_score[n]);
	n++;
	system("echo 按任意键返回上层_ _ _ _ _ _ _ _ & pause > nul");
	system("cls");
}
void Display_records(){
	int i;
	puts("学号\t姓名\tC语言\t英语\t数学\n");
	for(i=0;i<n && i<NUMP;i++)
	{
		if(0!=num[i])
			printf("%d %s %.2f %.2f %.2f\n",
			num[i],name[i],c_score[i],e_score[i],m_score[i]);
	}
	system("echo 按任意键返回上层_ _ _ _ _ _ _ _ & pause > nul");
	system("cls");
}
void menu(){
	int key=-1;
	char ch;
	while(key!=0)
	{
		puts("\t     _____                 &&&&_) )");
		puts("\t   \\/,---<                &&&&&&\\ \\");
		puts("\t   ( )c~c~~@~@            )- - &&\\ \\");
		puts("\t    C   >/                \\<   |&/		1. 录入记录");
		puts("\t     \\_O/ - 哇塞          _`*-'_/ /	\t2. 删除记录");

		puts("\t   ,- >o<-.              / ____ _/		3. 查询记录");
		puts("\t  /   \\/   \\            / /\\  _)_)	\t4. 修改记录");
		puts("\t / /|  | |\\ \\          / /  )   |		5. 插入记录");
		puts("\t \\ \\|  | |/ /          \\ \\ /    |	\t6. 统计记录");
		puts("\t  \\_\\  | |_/            \\ \\_    |	\t7. 排序记录");

		puts("\t  /_/`___|_\\            /_/\\____|		8. 保存记录");
		puts("\t    |  | |                  \\  \\|		9. 显示记录");
		puts("\t    |  | |                   `. )		0. 退出系统");
		puts("\t    |  | |                   / /");
		puts("\t    |__|_|_                 /_/|");

		puts("\t    (____)_)                |\\_\\_");
		printf("请输入你要进入的模块的标号:");
		scanf("%d",&key); 
		while( (ch=getchar()) != '\n');
		system("cls");//
		switch(key)
		{	
		case 1:Entry_record();break;
		//case 2:Del_record(s_p);break;
		//case 3:
		//case 4:
		//case 5:
		//case 6:
		//case 7:
		//case 8:
		case 9:Display_records();break;
		case 0:break;
		default :break;
		}
	}
}

void main(){	
	menu();
}
