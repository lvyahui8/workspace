#include "stdafx.h"
#include <stdlib.h>
#define SIZE 10

struct Student_type
{
	char name[10];
	int num;
	int age;
	char addr[15];
} stud[SIZE];

///***************************************************************************
//   录入部分
void save()
{
	FILE * fp;
	int i;
	if( (fp=fopen("stu.dat","wb")) == NULL)
	{
		printf("Can't open file!\n");
		return;
	}

	for(i=0;i<SIZE;i++)
	{
		if( fwrite(&stud[i],sizeof(struct Student_type),1,fp) != 1 )
			printf("File write error!\n");
	}
	fclose(fp);
}

int main()
{
	int i;
	printf("Please enter data of students:\n");
	for(i=0;i<SIZE;i++)
		scanf("%s%d%d%s",&stud[i].name,&stud[i].num,&stud[i].age,&stud[i].addr);
	save();
	return 0;
}

//***************************************************************************/

/***************************************************************************/
//输出部分
//void main()
//{
//	FILE * fp;
//	int i;
//	if( (fp=fopen("stu.dat","rb")) == NULL)
//	{
//		printf("cannot open file\n");
//		exit(0);
//	}
//
//	for(i=0;i<SIZE;i++)
//	{
//		fread(&stud[i],sizeof(struct Student_type),1,fp);
//		printf("%-10s %4d %4d %-15s\n",stud[i].name,stud[i].num,stud[i].age,stud[i].addr);
//	}
//
//	fclose(fp);
// }