#include <stdafx.h>
//为了使用system()和Sleep()命令，需包括<stdlib.h> 和 <windows.h>
#include <stdlib.h> 
#include <windows.h>
//声明用户自定义的函数texiao1和lading
void shuru();
void caidang(int k);
//这三个函数是组员写的
void wby();void spp();void zww();
//定义两个字符数组，用来存用户输入的姓名、学号
char str1[20],str2[20];


void main()
{
	int i;
	system("title 教务管理系统 & color 1a"); //更换标题和颜色,system命令格式为system("DOS 命令");

	


	printf("\t\t\t★你好！请按要求输入信息★  \t\n\n");


	printf("\n\n");
	printf("\t\t\t   输入姓名：");
	gets(str1);					//将用户输入的姓名存入数组str1
	printf("\t\t\t   输入学号：");
	gets(str2);					//将用户输入的学号存入数组str2
	printf("\n\n");



	printf("\n");


	printf("\t请稍候，登陆中 ");
	
	system("cls");				//清除屏幕
	//调用shuru()函数
	shuru();
	
	system("cls");
	printf("按1回车继续:");
	scanf("%d",&i);//1\n
	system("cls");
	getchar();
	
	if(i==1) main();
}



void shuru()
{
	//作用：显示菜单栏，供用户选择
	//char ch;
	//%s是格式控制符，对应的是字符串，在这里，第一个%s对应str1里面的姓名,第二个%s里面对应str2里的学号
	printf("\n\t姓名：%s 学号： %s 的同学，欢迎进入学管系统\n\n",str1,str2);

	printf("1. 成绩管理\t");
	printf("2. 学籍管理\t");
	printf("3. 基本信息\t");
	printf("0. 退出登陆\n\n");

	printf(" 请输入你要查询模块前数字，并回车：");
	int i;
	//等待用户输入i的值
	scanf("%d",&i);//0\n
	if(i!=0)
	{
		//调用函数caidang 将用户输入的值传递给 caidang 作形参
		caidang(i);
		system("cls");//system("DOs mingling")
	}
	//while((ch = getchar()) != '\n');

}

void caidang(int k)
{
	system("cls");
	switch(k)
	{
		//根据用户输入i的值的不同，分别调用不同的函数
	case 1: wby();break;
	case 2: spp();break;
	case 3: zww();break;
	default : break;
	}
	system("echo  按任意键返回 & pause > nul");
	system("cls");
	shuru();
}

void wby()
{	
	printf("\n姓名：%s 学号： %s 的同学，你的查询结果如下\n\n",str1,str2);


	printf("                                 学生成绩管理\n\n高等数学原始成绩：[______]          学分绩点：[______]\n\n大学英语原始成绩：[______]          学分绩点：[______]\n\n程序设计原始成绩：[______]          学分绩点：[______]\n\n");
	printf("╭(╯3╰)╮                         O(∩_∩)O\n");
}

void spp()
{
	printf("\n姓名：%s 学号： %s 的同学，你的查询结果如下\n\n",str1,str2);


	printf("                                学生学籍管理  \n\n");
	printf("===============================================================================\n\n\n");
	//int a,b;
	printf("    姓名 %s \n\n    学号 %s\n\n    密码 ********\n\n",str1,str2);
	//scanf("%d,%d",&a,&b);
	printf("\n\n\n\n          退出\n");
}

void zww()
{
	char str[10];

	printf("                            湖南中医药大学学生基本信息查询\n⊙o⊙  ⊙o⊙  ⊙o⊙\n	⊙o⊙  ⊙o⊙  ⊙o⊙\n               ⊙o⊙  ⊙o⊙  ⊙o⊙\n\n\n    文明\n    求实\n    继承\n    创新\n\n\n  	  	⊙o⊙  ⊙o⊙  ⊙o⊙  \n	⊙o⊙  ⊙o⊙  ⊙o⊙  \n⊙o⊙  ⊙o⊙  ⊙o⊙  \n\n\n\n\n\n                                         请输入您的真实信息：\n                                         学号：        \n                                         姓名:                     \n                                         密码\n                                         验证码:");
	gets(str);
}




	