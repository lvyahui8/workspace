// 结构体与共用体.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <string.h>

struct date{
	int year;
	int moth;
	int day;
};//  后面一定要分号
//struct 类型名 
struct student
{	//声明部分不同于定义部分，他不涉及分配内存空间
	int num;
	//char * name;
	char name[20];
	char sex;
	int age;
	float score;
	//char * addr;
	char addr[30];
	struct date d;
};

int main(int argc, char* argv[])
{
	struct student s; // 指定 类型名 变量名 
	s.num = 2012;
	//s.name ="Lv Yahui";
	strcpy(s.name,"Lv Yahui");
	s.sex = 'M';
	s.age = 18;
	s.score = 90.5;
	//s.addr ="Hunan";
	strcpy(s.addr,"Hunan");
	/*
	printf("%d\n",sizeof(s));
	printf("%d\n",sizeof(s.num ));
	printf("%d\n",sizeof(s.name));
	printf("%d\n",sizeof(s.sex));
	printf("%d\n",sizeof(s.age));
	printf("%d\n",sizeof(s.score));
	printf("%d\n",sizeof(s.addr));
	*/
	printf("s.num:%d s.name:%s s.sex:%c ",
		s.num,s.name,s.sex);
	printf("s.age:%d s.score:%g s.addr:%s\n",
		s.age,s.score,s.addr);
	//s.num:2012 s.name:Lv Yahui s.sex:M s.age:18 s.score:90.5 s.addr:Hunan
	s.d.year=2012;
	s.d.moth=11;
	s.d.day=11;
	printf("student's birthday: %d.%d.%d\n",s.d.year,s.d.moth,s.d.day);
	printf("&s==%x\n",&s);
	printf("&s.num==%x\n",&s.num);
	printf("&s.d==%x\n",&s.d);
	printf("&s.d.year==%x\n",&s.d.year);
	return 0;
}

