#include <stdafx.h>
#include <stdlib.h>

#define Student 11 // 指定了二维数组的行
#define Subject 6  // 指定了二维数组的列，这么做是为了方便改动

void Stu_score_aver(float float_s[Student][Subject]);// 计算每个学生的平均分
void Sub_score_aver(float float_S[Student][Subject]);// 计算每门课程的平均分
void score_max(float float_s[Student][Subject]);// 找出所有的最高分及其对应的学生和课程
float score_var(float float_s[Student][Subject]);// 计算每个学生的平均分的方差

void main()
{
	system("title Student achievement management & color 02");//换标题和颜色

	float float_score[Student][Subject]={0};  // 定义2维数组，给所有元素赋初值为0
	int i,j;   // 循环变量 i 控制行  j  控制列

	printf("Please input the each student achievement\nseparated by spaces\n");
	printf("a student achievement after the completion of the input and press the Enter key\n\n");

	// 给数组元素赋值，每行最后一列不赋值  最后一行不赋值
	for(i=0;i<Student-1;i++)
	{
		printf("Please input number %-2d score:",i+1);
		for(j=0;j<Subject-1;j++)
		{
			scanf("%f",&float_score[i][j]);	
		}
	}
	
	Stu_score_aver(float_score);// 计算每个学生的平均分

	Sub_score_aver(float_score);// 计算每门课程的平均分

	system("cls");

	printf("\nName    Chinese Mathematics English  Physics  C_language  Stu_average\n\n");
	// 遍历数组元素 打印出所有元素（最后一行最后一列的元素除外）
	for(i=0;i<Student;i++)
	{
		if(i!=Student-1)
		{
			printf("Number%-2d: ",i+1);
			for(j=0;j<Subject;j++)
			{
				printf("%-10g",float_score[i][j]);
			}
		}
		else
		{
			printf("\nSub_aver: ");
			for(j=0;j<Subject-1;j++)
			{
				printf("%-10g",float_score[i][j]);
			}
			printf("\n");
		}
		printf("\n");
	}

	printf("___________________________________________________________________\n\n");
	score_max(float_score);// 找出所有的最高分及其对应的学生和课程
	//第二步在所有元素（最后一行和最后一列的元素除外）中找是否有和最高分相同的
	// 如果有的话，把姓名（行号）和科目（列号）打印出来
	for(i=0;i<Student-1;i++)
	{
		for(j=0;j<Subject-1;j++)
		{
			if(float_s[i][j]==float_s[Student-1][Subject-1])
			{
				printf("The highest score:%g\n",float_s[Student-1][Subject-1]);
				printf("Get the highest score is: Number%d\n",i+1);
				printf("The award-winning subject is: ");
				switch(j+1)
				{
					case 1:printf("Chinese");break; 
					case 2:printf("Mathematics");break;
					case 3:printf("English");break;
					case 4:printf("Physics");break; 
					case 5:printf("C_language");break; 
					default :break;
				}
				printf("\n\n");
			}
		}
	}
	printf("___________________________________________________________________\n\n");
	printf("Variance of average scores: %g\n\n",score_var(float_score));// 打印所有学生的平均分的方差

	system("pause");// 暂停 
}


void Stu_score_aver(float float_s[Student][Subject])
{
	int i,j;
	float sum;
	for(i=0;i<Student-1;i++)
	{
		sum=0; //计算下一个学生的平均分时，将sum 归 0 
		for(j=0;j<Subject-1;j++)
		{
			sum+=float_s[i][j];	
		}
		float_s[i][j]=sum/(Subject-1); // 此时的j 已经指向最后一列  把前 Subject-1 项的平均值存到最后一列的元素里
	}
}


void Sub_score_aver(float float_s[Student][Subject])
{
	int i,j;
	// 把最后一行前前Subjcet-1 个元素分别用来存各科的平均分
	for(j=0;j<Subject-1;j++)
	{
		for(i=0;i<Student-1;i++)
		{
			float_s[Student-1][j]+=float_s[i][j];   
		}
		float_s[Student-1][j]/=(Student-1);
	}
}


float score_max(float float_s[Student][Subject])
{
	int i,j;
	float_s[Student-1][Subject-1]=float_s[0][0];//最后一行最后一列的元素闲着也是闲着，拿出来存最高分
	//第一步： 先找到所有元素（最后一行和最后一列的元素除外）最高分
	for(i=0;i<Student-1;i++)
	{
		for(j=0;j<Subject-1;j++)
		{
			if(float_s[i][j]>float_s[Student-1][Subject-1])
			{
				float_s[Student-1][Subject-1]=float_s[i][j];
			}
		}
	}

}

float score_var(float float_s[Student][Subject])
{
	int i;
	float temp1=0,temp2=0,var;
	// 列号不需要改变，所以只要一重循环
	for(i=0;i<Student-1;i++)
	{
		temp2+=float_s[i][Subject-1];//  循环完之后temp2存的应是每个学生平均分的和
		temp1+=(float_s[i][Subject-1]*float_s[i][Subject-1]);//  循环完之后temp1存的应是每个学生平均分的平方和
	}

	var=temp1/(Student-1)-(temp2/(Student-1))*(temp2/(Student-1));// 根据方差的公式计算方差，把结果赋值给var

	return var;
}
/*
程序运行之后的效果

Please input the each student achievement
separated by spaces
a student achievement after the completion of the input and press the Enter key

Please input number 1  score:60 65 70 80 70
Please input number 2  score:70 55 72 65 81
Please input number 3  score:60 54 80 70 79
Please input number 4  score:60 50 40 80 95
Please input number 5  score:95 65 78 88 75
Please input number 6  score:65 66 64 95 62
Please input number 7  score:90 70 80 70 80
Please input number 8  score:60 95 70 80 90
Please input number 9  score:80 70 95 75 77
Please input number 10 score:51 65 87 95 66

清屏



Name    Chinese Mathematics English  Physics  C_language  Stu_average

Number1 : 60        65        70        80        70        69
Number2 : 70        55        72        65        81        68.6
Number3 : 60        54        80        70        79        68.6
Number4 : 60        50        40        80        95        65
Number5 : 95        65        78        88        75        80.2
Number6 : 65        66        64        95        62        70.4
Number7 : 90        70        80        70        80        78
Number8 : 60        95        70        80        90        79
Number9 : 80        70        95        75        77        79.4
Number10: 51        65        87        95        66        72.8

Sub_aver: 69.1      65.5      73.6      79.8      77.5

___________________________________________________________________

The highest score:95
Get the highest score is: Number4
The award-winning subject is: C_language

The highest score:95
Get the highest score is: Number5
The award-winning subject is: Chinese

The highest score:95
Get the highest score is: Number6
The award-winning subject is: Physics

The highest score:95
Get the highest score is: Number8
The award-winning subject is: Mathematics

The highest score:95
Get the highest score is: Number9
The award-winning subject is: English

The highest score:95
Get the highest score is: Number10
The award-winning subject is: Physics

___________________________________________________________________

Variance of average scores: 27.9207

请按任意键继续. . .



*/
