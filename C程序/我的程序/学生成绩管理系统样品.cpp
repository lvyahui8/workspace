#include "stdafx.h"
#include <windows.h>
#include <stdlib.h>
#include <math.h>
//#include <color.h>
#define LE 10
// �������ģ�����

#define NAME 20 //���ֳ���
/*
#include <stdio.h>
#include "format.h"
*/

int number[LE]={0};//ѧ��
char name[LE][20];//����
float c_score[LE];//c���Գɼ�
float m_score[LE];//��ѧ�ɼ�
float e_score[LE];//Ӣ��ɼ�
//ͳ������ģ��
float m1,m2,m3;
int n1,n2,n3;
//�������ģ��
int n=0;
void f_swap(float *f1,float *f2)
{
	float temp;
	temp=*f1;
	*f1=*f2;
	*f2=temp;
}
//************************************************************ɾ������ģ��******************************************************************
void shanchu()
{
	int j;
	int n;
	printf("��������ɾ�������n\n");
	scanf("%d",&n);
	for(j=0;j<10;j++)
	{
		if(number[j]==n)
		{
			number[j]=0;
			break;
		}
	}
}

//************************************************************��������ģ��******************************************************************
void paixu()
{
	int i,j;
	float a[LE],t;
	for(i=0;i<10;i++)
	{
		a[i]=(float)(c_score[i]+e_score[i]+m_score[i])/3;
	}
	for(i=0;i<9;i++)
	{
		for(j=0;j<9-i;j++)
		{
			if(a[i]>a[i+1])
			{
				t=a[i];
				a[i]=a[i+1];
				a[i+1]=t;
			}
		}
	}
	
	for(i=0;i<10;i++)
	{
		if(a[i]!=0)
			printf("%f ",a[i]);
	}
	system("pause");
	system("cls");
}

//************************************************************��������ģ��******************************************************************


void charu()
{	
	int i,j;
	int m;
	char s[20];
	float c_s;
	float e_s;
	float m_s;
	printf("������Ҫ�����ѧ����Ϣ\n");
	printf("������ѧ��:");
	scanf("%d%*c",&m);	
	printf("����������:");
	gets(s);
	printf("������C���Գɼ�:");
	scanf("%f%*c",&c_s);
	printf("������Ӣ��ɼ�:");
	scanf("%f%*c",&e_s);
	printf("��������ѧ�ɼ�:");
	scanf("%f%*c",&m_s);
	n++;
	printf("n==%d\n",n);
	for(i=0;i<n && number[i]<m && number[i]!=0;i++);
	printf("i==%d\n",i);
	printf("%d %s %.2f %.2f %.2f\n",
			number[0],name[0],c_score[0],e_score[0],m_score[0]);
	if(i == n || number[i]==0)
		;
	else
	{
		for(j=n;j>=i;j--)
		{
			number[j+1]=number[j];
			strcpy(name[j+1],name[j]);
			c_score[j+1]=c_score[j];
			e_score[j+1]=e_score[j];
			m_score[j+1]=m_score[j];
			printf("%d %s %.2f %.2f %.2f\n",
				number[0],name[0],c_score[0],e_score[0],m_score[0]);
		}
	}
	number[i]=m;strcpy(name[i],s);
	c_score[i]=c_s;e_score[i]=e_s;
	m_score[i]=m_s;
	system("echo ������������ϲ�_ _ _ _ _ _ _ _ & pause > nul");
	system("cls");
}


//************************************************************�޸�����ģ��******************************************************************
void xiugai()
{
	int i;
	int n,m;
	printf("���������޸ĵ�ѧ��n\n");
	scanf("%d",&n);
	printf("���������޸ĳɵ�ѧ��m\n");
	scanf("%d",&m);
	for(i=0;i<10;i++)
	{
		if(number[i]==n)
		{
			number[i]=m;
			printf("���������޸ĳɵ�����:");
			gets(name[n]);
			printf("���������޸ĳɵ�C���Գɼ�:");
			scanf("%f%*c",&c_score[i]);
			printf("���������޸ĳɵ�Ӣ��ɼ�:");
			scanf("%f%*c",&e_score[i]);
			printf("���������޸ĳɵ���ѧ�ɼ�:");
			scanf("%f%*c",&m_score[i]);
		}
	}
	system("pause");
	system("cls");
}


//************************************************************��ѯ����ģ��******************************************************************
void chaxun1(int a)
{
	int i;
	for(i=0;i<LE;i++)
	{
		while(number[i]==a)
		{
			printf("������ѯ��ͬѧ�ľ�����Ϣ����:\n");
			printf("ѧ��:%d\n",number[i]);
			printf("����:%");
			puts(name[i]);
			printf("c���Գɼ�:%.2f\n",c_score[i]);
			printf("Ӣ��ɼ�:%.2f\n",e_score[i]);
			printf("�����ɼ�:%.2f\n",m_score[i]);
			break;
		}			
	}
	if(number[i]!=a)
		printf("���޴�ѧ��\n");
}

void chaxun2(char z[20])
{
	int i;
	for(i=0;i<LE;i++)
	{
		while(strcmp(name[i],z)==0)
		{
			printf("������ѯ��ͬѧ�ľ�����Ϣ����:\n");
			printf("ѧ��:%d\n",number[i]);
			printf("����:");
			puts(name[i]);
			printf("c���Գɼ�:%.2f\n",c_score[i]);
			printf("Ӣ��ɼ�:%.2f\n",e_score[i]);
			printf("�����ɼ�:%.2f\n",m_score[i]);
			break;
		}
	}
	if(strcmp(name[i],z)!=0)
		printf("���޴�ͬѧ\n");
}

int Chaxun_main()
{
	int a,x;
	char ch;
	char z[20];
	int b;
P:	printf("��ѡ���ѯ��ʽ��\n");
	printf("1.��ѧ�Ų�ѯ\n2.��������ѯ\n3.����������\n");
	scanf("%d",&a);
	while(( ch=getchar() ) != '\n');
	switch(a)
	{
		case 1:
			printf("��������Ҫ��ѯ��ͬѧ��ѧ��:");
			scanf("%d",&x);
			chaxun1(x);
			break;
		case 2:
			printf("��������Ҫ��ѯ��ͬѧ������:");
			gets(z);
			chaxun2(z);
			break;
		case 3:;break;
		default:printf("�����������������!");system("cls");goto P;
	}

	printf("������ѯ�򷵻����˵���\n");
	printf("1.����\n2.�������˵�\n");
	scanf("%d",&b);
	while(( ch=getchar() ) != '\n');
	system("cls");
	if(b==1)
		goto P;
	return 0;
}

//************************************************************�������ģ��******************************************************************
void Entry_record()
{
	printf("������ѧ��:");
	scanf("%d%*c",&number[n]);
	printf("����������:");
	gets(name[n]);
	printf("������C���Գɼ�:");
	scanf("%f%*c",&c_score[n]);
	printf("������Ӣ��ɼ�:");
	scanf("%f%*c",&e_score[n]);
	printf("��������ѧ�ɼ�:");
	scanf("%f%*c",&m_score[n]);
	n++;
	system("echo ������������ϲ�_ _ _ _ _ _ _ _ & pause > nul");
	system("cls");
}

void Display_records()
{
	int i;
	puts("ѧ��\t����\tC����\tӢ��\t��ѧ\n");
	for(i=0;i<LE;i++)//i<n && 
	{
		if(0!=number[i])
			printf("%d %s %.2f %.2f %.2f\n",
			number[i],name[i],c_score[i],e_score[i],m_score[i]);
	}
	system("echo ������������ϲ�_ _ _ _ _ _ _ _ & pause > nul");
	system("cls");
}

//************************************************************ͳ������ģ��******************************************************************
void my_max(float x[LE])
{
	float m;
	int i,n;
	m=x[0];
	n=0;
	for(i=0;i<LE;i++)
	{
		if(x[i]>m)
		{
			m=x[i];
			n=i;
		}
	}
	printf("����Ŀ��߷���%.2f.\n",x[n]);
}

void no_pass(float y[LE])
{
	int i,j;
	j=0;
	for(i=0;i<LE;i++)
	{
		if(y[i]<60)
			j++;
	}
	printf("����Ŀ����%d���������ͬѧ.\n",j);
}

void all()
{
	int i;
	m1=c_score[0];
	m2=m_score[0];
	m3=e_score[0];
	n1=0;n2=0;n3=0;
	for(i=0;i<LE;i++)
	{
		if(c_score[i]>m1)
		{
			m1=c_score[i];
		}
	}
	for(i=0;i<LE;i++)
	{
		if(m_score[i]>m2)
		{
			m2=m_score[i];
		}
	}
	for(i=0;i<LE;i++)
	{
		if(e_score[i]>m3)
		{
			m3=e_score[i];
		}
	}
	for(i=0;i<LE;i++)
	{
		if(c_score[i]<60)
			n1++;
	}
	for(i=0;i<LE;i++)
	{
		if(m_score[i]<60)
			n2++;
	}
	for(i=0;i<LE;i++)
	{
		if(e_score[i]<60)
			n3++;
	}
}

int Tonji_main()
{
	int a,b,c;
	char ch;
A1:	printf("                                                                                \n");
	printf("                                  ͳ�Ƽ�¼ģ��                                  \n");
	printf("\n\n\n\n");
	printf("                                  1.����ͳ��\n");
	printf("                                  2.����ͳ��\n");
	printf("                                  3.�������˵�\n");
	printf("\n\n");
	printf("                                   ��ѡ��:");
	scanf("%d",&c);
	while(( ch=getchar() ) != '\n');
	system("cls");
	if(c==1)
	{
A2:		printf("������:\n1.C����\t2.��ѧ\t3.Ӣ��\n4.����ͳ�Ƽ�¼ģ��˵�\n");
		scanf("%d",&a);
		while(( ch=getchar() ) != '\n');
		if(a==4)
		{
			system("cls");
			goto A1;
		}
		else if(a==1)
		{
			printf("��ѡ����Ҫ��ѯ����Ŀ:\n1.��߷�\t2.����������\n");
			scanf("%d",&b);
			if(b==1)
			{
				my_max(c_score);
				system("pause");
				system("cls");
				goto A2;
			}
			else if(b==2)
			{
				no_pass(c_score);
				system("pause");
				system("cls");
				goto A2;
			}
			else
			{
				printf("��������,����������.\n");
				system("pause");
				system("cls");
				goto A2;
			}
		}
		else if(a==2)
		{
			printf("��ѡ����Ҫ��ѯ����Ŀ:\n1.��߷�\t2.����������\n");
			scanf("%d",&b);
			if(b==1)
			{
				my_max(m_score);
				system("pause");
				system("cls");
				goto A2;
			}
			else if(b==2)
			{
				no_pass(m_score);
				system("pause");
				system("cls");
				goto A2;
			}
			else
			{
				printf("��������,����������.\n");
				system("pause");
				system("cls");
				goto A2;
			}
			
		}
		else if(a==3)
		{
			printf("��ѡ����Ҫ��ѯ����Ŀ:\n1.��߷�\t2.����������\n");
			scanf("%d",&b);
			if(b==1)
			{
				my_max(e_score);
				system("pause");
				system("cls");
				goto A2;
			}
			else if(b==2)
			{
				no_pass(e_score);
				system("pause");
				system("cls");
				goto A2;
			}
			else
			{
				printf("��������,����������.\n");
				system("pause");
				system("cls");
				goto A2;
			}
			
		}
		else
		{
			printf("��������,����������.\n");
			system("pause");
			system("cls");
			goto A2;
		}
	}
	else if(c==2)
	{
		all();
		printf("********************************************************************************\n");
		printf("***********************     ��߷�     ***********     ����������     **********\n");
		printf("********************************************************************************\n");
		printf("***   C����   *********       %.2f     ***********          %d        **********\n",m1,n1);
		printf("********************************************************************************\n");
		printf("***   �� ѧ   *********       %.2f     ***********          %d        **********\n",m2,n2);
		printf("********************************************************************************\n");
		printf("***   Ӣ ��   *********       %.2f     ***********          %d        **********\n",m3,n3);
		printf("********************************************************************************\n");
		system("pause");
		system("cls");
		goto A1;
	}
	else if(c==3)
	{

	}
	else
	{
		printf("��������,����������.\n");
		system("pause");
		system("cls");
		goto A1;
	}
	return 0;
}

//************************************************************��������**********************************************************************
void menu()
{
	int key=-1,i;
	char ch;
	system("color 1d");
	while(key!=0)
	{
		system("title ѧ���ɼ�����ϵͳ");
		puts("\t     _____                 &&&&_) )");
		puts("\t   \\/,---<                &&&&&&\\ \\");
		puts("\t   ( )c~c~~@~@            )- - &&\\ \\");
		puts("\t    C   >/                \\<   |&/		1. ¼���¼");
		puts("\t     \\_O/ - ����          _`*-'_/ /	\t2. ɾ����¼");
		puts("\t   ,- >o<-.              / ____ _/		3. ��ѯ��¼");
		puts("\t  /   \\/   \\            / /\\  _)_)	\t4. �޸ļ�¼");
		puts("\t / /|  | |\\ \\          / /  )   |		5. �����¼");
		puts("\t \\ \\|  | |/ /          \\ \\ /    |	\t6. ͳ�Ƽ�¼");
		puts("\t  \\_\\  | |_/            \\ \\_    |	\t7. �����¼");
		puts("\t  /_/`___|_\\            /_/\\____|		8. �����¼(ά����)");
		puts("\t    |  | |                  \\  \\|		9. ��ʾ��¼");
		puts("\t    |  | |                   `. )		0. �˳�ϵͳ");
		puts("\t    |  | |                   / /");
		puts("\t    |__|_|_                 /_/|");
		puts("\t    (____)_)                |\\_\\_");
		printf("��������Ҫ�����ģ��ı��:");
		scanf("%d",&key); 
		while( (ch=getchar()) != '\n');
		for(i=0;i<6;i++)
		{
				system("title �ȴ���Ӧ.");Sleep(70);
				system("title �ȴ���Ӧ. .");Sleep(70);
				system("title �ȴ���Ӧ. . . ");Sleep(70);
				system("title �ȴ���Ӧ. . . .");Sleep(70);
				system("title �ȴ���Ӧ. . . . .");Sleep(70);
				system("title �ȴ���Ӧ. . . . . .");Sleep(70);
		}
		system("title ѧ���ɼ�����ϵͳ");
		system("cls");
		switch(key)
		{	
		case 1:Entry_record();break;
		case 2:shanchu();break;
		case 3:Chaxun_main();break;
		case 4:xiugai();break;
		case 5:charu();break;
		case 6:Tonji_main();break;
		case 7:paixu();break;
		//case 8:
		case 9:Display_records();break;
		case 0:break;
		default :break;
		}
	}
}

void main()
{	
	
	menu();
}
