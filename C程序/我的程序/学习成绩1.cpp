#include <stdafx.h>
#include <stdlib.h>

#define Student 11 // ָ���˶�ά�������
#define Subject 6  // ָ���˶�ά������У���ô����Ϊ�˷���Ķ�

void Stu_score_aver(float float_s[Student][Subject]);// ����ÿ��ѧ����ƽ����
void Sub_score_aver(float float_S[Student][Subject]);// ����ÿ�ſγ̵�ƽ����
void score_max(float float_s[Student][Subject]);// �ҳ����е���߷ּ����Ӧ��ѧ���Ϳγ�
float score_var(float float_s[Student][Subject]);// ����ÿ��ѧ����ƽ���ֵķ���

void main()
{
	system("title Student achievement management & color 02");//���������ɫ

	float float_score[Student][Subject]={0};  // ����2ά���飬������Ԫ�ظ���ֵΪ0
	int i,j;   // ѭ������ i ������  j  ������

	printf("Please input the each student achievement\nseparated by spaces\n");
	printf("a student achievement after the completion of the input and press the Enter key\n\n");

	// ������Ԫ�ظ�ֵ��ÿ�����һ�в���ֵ  ���һ�в���ֵ
	for(i=0;i<Student-1;i++)
	{
		printf("Please input number %-2d score:",i+1);
		for(j=0;j<Subject-1;j++)
		{
			scanf("%f",&float_score[i][j]);	
		}
	}
	
	Stu_score_aver(float_score);// ����ÿ��ѧ����ƽ����

	Sub_score_aver(float_score);// ����ÿ�ſγ̵�ƽ����

	system("cls");

	printf("\nName    Chinese Mathematics English  Physics  C_language  Stu_average\n\n");
	// ��������Ԫ�� ��ӡ������Ԫ�أ����һ�����һ�е�Ԫ�س��⣩
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
	score_max(float_score);// �ҳ����е���߷ּ����Ӧ��ѧ���Ϳγ�
	//�ڶ���������Ԫ�أ����һ�к����һ�е�Ԫ�س��⣩�����Ƿ��к���߷���ͬ��
	// ����еĻ������������кţ��Ϳ�Ŀ���кţ���ӡ����
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
	printf("Variance of average scores: %g\n\n",score_var(float_score));// ��ӡ����ѧ����ƽ���ֵķ���

	system("pause");// ��ͣ 
}


void Stu_score_aver(float float_s[Student][Subject])
{
	int i,j;
	float sum;
	for(i=0;i<Student-1;i++)
	{
		sum=0; //������һ��ѧ����ƽ����ʱ����sum �� 0 
		for(j=0;j<Subject-1;j++)
		{
			sum+=float_s[i][j];	
		}
		float_s[i][j]=sum/(Subject-1); // ��ʱ��j �Ѿ�ָ�����һ��  ��ǰ Subject-1 ���ƽ��ֵ�浽���һ�е�Ԫ����
	}
}


void Sub_score_aver(float float_s[Student][Subject])
{
	int i,j;
	// �����һ��ǰǰSubjcet-1 ��Ԫ�طֱ���������Ƶ�ƽ����
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
	float_s[Student-1][Subject-1]=float_s[0][0];//���һ�����һ�е�Ԫ������Ҳ�����ţ��ó�������߷�
	//��һ���� ���ҵ�����Ԫ�أ����һ�к����һ�е�Ԫ�س��⣩��߷�
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
	// �кŲ���Ҫ�ı䣬����ֻҪһ��ѭ��
	for(i=0;i<Student-1;i++)
	{
		temp2+=float_s[i][Subject-1];//  ѭ����֮��temp2���Ӧ��ÿ��ѧ��ƽ���ֵĺ�
		temp1+=(float_s[i][Subject-1]*float_s[i][Subject-1]);//  ѭ����֮��temp1���Ӧ��ÿ��ѧ��ƽ���ֵ�ƽ����
	}

	var=temp1/(Student-1)-(temp2/(Student-1))*(temp2/(Student-1));// ���ݷ���Ĺ�ʽ���㷽��ѽ����ֵ��var

	return var;
}
/*
��������֮���Ч��

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

����



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

�밴���������. . .



*/
