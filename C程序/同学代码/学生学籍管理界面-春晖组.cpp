// ��½����.cpp : Defines the entry point for the console application.
//

#include <stdafx.h>
#include<stdlib.h>
#include <windows.h>
char xm[10][20];
int xh[10];
float c[10],sx[10],yy[10];


void lr()  //¼�뺯��
{
	int i;
	for( i=0 ; i<10 ; i++)
	{
		printf("�밴���������%d��ѧ������Ϣ������ ѧ�� c���Գɼ� ��ѧ�ɼ� Ӣ��ɼ�:\n",i+1);
		scanf("%s %d %f %f %f",xm[i],&xh[i],&c[i],&sx[i],&yy[i]);
		//printf("%d=%f\n",i,c[i]);
		system("pause");
		system("cls");
	}
	
}

		/*printf("������\n����:");
		scanf("%s",name[i]);
	
		printf("\nѧ��:");
		scanf("%d",&a[i]);	
		//getchar();
		printf("c���Գɼ�:");
		scanf("%d",&b[i]);
		getchar();
		printf("��ѧ�ɼ�:");
		scanf("%d",&e[i]);
		printf("Ӣ��ɼ�:");
		scanf("%d",&d[i]);
		system("cls");
		printf("�������%d����",i+2);*/


void shanchu(int a[10])  //ɾ������
{
    int j,k;
	printf("����������Ҫɾ����Ϣ��ѧ��ѧ��:\n");
	scanf("%d",&j);
    printf("��������Ҫɾ����Ϣ����Ҫɾ�����밴��1���������밴��2��\n");
	scanf("%d",&k);
	if(k==1)
		switch(j)
		{
		case 1:a[0]=0;break;
		case 2:a[1]=0;break;
		case 3:a[2]=0;break;
		case 4:a[3]=0;break;
		case 5:a[4]=0;break;
		case 6:a[5]=0;break;
		case 7:a[6]=0;break;
		case 8:a[7]=0;break;
		case 9:a[8]=0;break;
		case 10:a[9]=0;break;
		}
}










int main(int argc, char* argv[])
{   
	int a,b,i,s[16];
	char C;
	
	/*
	printf("\n\n\n");
	printf("\t	        ___  |   __   __            ___\n");
	printf("\t      \\  /\\  / |___  |  /    /  \\  /\\  /\\  |___\n");
	printf("\t       \\/  \\/  |___  |  \\__  \\__/ /  \\/  \\ |___\n");
	printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t����\t�ڴ���\tҦ��\t���\t̷����");
    for(i=0;i<20;i++)
	{
		system("color 0c");
		Sleep(20);
		system("color 0e");
		Sleep(20);
		system("color 09");
		Sleep(20);
		system("color 0a");
		Sleep(20);
		system("color 0d");
		Sleep(20);
	}
	Sleep(300);
	system("cls");*/
A:	system("color b2");
/*	printf("\n\n\n���������ѧ��");
	scanf("%d",&a);
	while( (ch=getchar()) != '\n');
	printf("\n\n\n����У���½�У����Ժ�\n");
	for(i=1;i<=80;i++)
	{
		printf("%c",16);
		Sleep(35);
	}
	printf("\n");
	printf("��¼�ɹ�\n");
	for(i=1;i<=6;i++)
	{
		printf("\n");
		Sleep(200);
	}
	system("cls");*/
 B: printf("\t\t\t\t%d��ͬѧ�����\n\n\t\t\t       ��ӭ��½����ϵͳ\n\n\n\n",a);
    printf("\t\t\t\t%c%c����Ŀ¼%c%c\n\n",16,16,17,17);
	printf("\t\t\t\t %c%d�û�����\n\t\t\t\t %c%d�����¼\n\t\t\t\t %c%dɾ����¼\n\t\t\t\t %c%d��ѯ��¼\n\t\t\t\t %c%d�޸ļ�¼\n\t\t\t\t %c%d�����¼\n\t\t\t\t %c%dͳ�Ƽ�¼\n\t\t\t\t %c%d�����¼\n\t\t\t\t %c%d��ʾ��¼\n\t\t\t\t %c%d���µ�¼\n\n\n\n",3,1,3,2,3,3,3,4,3,5,3,6,3,7,3,8,3,9,3,0);
	printf("��������Ҫ����Ľ������");
	
	scanf("%d",&b);
	getchar();
    system("cls");
	switch(b)
	{
		case 1:	system("color 9E");printf("\t\t�û����ϲ�ѯ����\n");
			    printf("���ز�ѯ���������롰R��\n");
			    scanf("%c",&C); 
				getchar();
			    if(C=='R')
				{
					system("cls");
					goto B;
				}
				else 
				{
					break;
				}
		case 2:	system("color A1");printf("\t\t�����¼����\n");
			    lr(); //¼�뺯��
				printf("���ز�ѯ���������롰R��\n");
				scanf("%c",&C);
				getchar();
					if(C=='R')
					{
						system("cls");
						goto B;
					}
					else 
					{
						break;
					}
		case 3:	system("color B5");printf("\t\tɾ����¼����\n");
			  //  shanchu(xh);  //ɾ������
			    printf("���ز�ѯ���������롰R��\n");
				scanf("%c",&C);
				getchar();
					if(C=='R')
					{
						system("cls");
						goto B;
					}
					else
					{
						break;
					}
		case 4:	system("color C1");printf("\t\t��ѯ��¼����\n");
			    printf("���ز�ѯ���������롰R��\n");
				scanf("%c",&C); 
				getchar();
					if(C=='R')
					{
						system("cls");
						goto B;
					}
					else 
					{
						break;
					}
        case 5:	system("color D1");printf("\t\t�޸ļ�¼����\n");
			    printf("���ز�ѯ���������롰R��\n");
			    scanf("%c",&C); 
				getchar();
			    if(C=='R')
				{
					system("cls");
					goto B;
				}
				else 
				{
					break;
				}
        case 6:	system("color E1");printf("\t\t�����¼����\n");
			    printf("���ز�ѯ���������롰R��\n");
			    scanf("%c",&C); 
				getchar();
			    if(C=='R')
				{
					system("cls");
					goto B;
				}
				else 
				{
					break;
				}
        case 7:	system("color F1");printf("\t\tͳ�Ƽ�¼����\n");
			    printf("���ز�ѯ���������롰R��\n");
			    scanf("%c",&C); 
				getchar();
			    if(C=='R')
				{
					system("cls");
					goto B;
				}
				else 
				{
					break;
				}
        case 8:	system("color C1");printf("\t\t�����¼����\n");
			    printf("���ز�ѯ���������롰R��\n");
			    scanf("%c",&C); 
				getchar();
			    if(C=='R')
				{
					system("cls");
					goto B;
				}
				else 
				{
					break;
				}
        case 9:	system("color D1");printf("\t\t��ʾ��¼����\n");
			    printf("���ز�ѯ���������롰R��\n");
			    scanf("%c",&C); 
				getchar();
			    if(C=='R')
				{
					system("cls");
					goto B;
				}
				else 
				{
					break;
				}
       
        
		case 0: system("cls");goto A;
		default:printf("���������������������\n");goto B;
	}
	return 0;
}
