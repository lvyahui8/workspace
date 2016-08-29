#include <stdafx.h>
/*
struct student
{
	int num;
	char name[20];
	char sex;
	int age;
	float score;
	char addr[20];
}	stu[3];// 这样的话即是全局变量

void f()
{
	stu[0].num=20;
}
*/

struct student
{
	int num;
	char name[20];
	char sex;
	int age;
	float score;
	char addr[20];
};

void main()
{

	struct student stu[3]={
	{100,"Lin li",'m',19,77,"hu nan"},
	{100,"Lin li",'m',19,77,"hu nan"},
	{100,"Lin li",'m',19,77,"hu nan"}};
	
}

