#include <stdafx.h>
//Ϊ��ʹ��system()��Sleep()��������<stdlib.h> �� <windows.h>
#include <stdlib.h> 
#include <windows.h>
//�����û��Զ���ĺ���texiao1��lading
void shuru();
void caidang(int k);
//��������������Աд��
void wby();void spp();void zww();
//���������ַ����飬�������û������������ѧ��
char str1[20],str2[20];


void main()
{
	int i;
	system("title �������ϵͳ & color 1a"); //�����������ɫ,system�����ʽΪsystem("DOS ����");

	


	printf("\t\t\t����ã��밴Ҫ��������Ϣ��  \t\n\n");


	printf("\n\n");
	printf("\t\t\t   ����������");
	gets(str1);					//���û������������������str1
	printf("\t\t\t   ����ѧ�ţ�");
	gets(str2);					//���û������ѧ�Ŵ�������str2
	printf("\n\n");



	printf("\n");


	printf("\t���Ժ򣬵�½�� ");
	
	system("cls");				//�����Ļ
	//����shuru()����
	shuru();
	
	system("cls");
	printf("��1�س�����:");
	scanf("%d",&i);//1\n
	system("cls");
	getchar();
	
	if(i==1) main();
}



void shuru()
{
	//���ã���ʾ�˵��������û�ѡ��
	//char ch;
	//%s�Ǹ�ʽ���Ʒ�����Ӧ�����ַ������������һ��%s��Ӧstr1���������,�ڶ���%s�����Ӧstr2���ѧ��
	printf("\n\t������%s ѧ�ţ� %s ��ͬѧ����ӭ����ѧ��ϵͳ\n\n",str1,str2);

	printf("1. �ɼ�����\t");
	printf("2. ѧ������\t");
	printf("3. ������Ϣ\t");
	printf("0. �˳���½\n\n");

	printf(" ��������Ҫ��ѯģ��ǰ���֣����س���");
	int i;
	//�ȴ��û�����i��ֵ
	scanf("%d",&i);//0\n
	if(i!=0)
	{
		//���ú���caidang ���û������ֵ���ݸ� caidang ���β�
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
		//�����û�����i��ֵ�Ĳ�ͬ���ֱ���ò�ͬ�ĺ���
	case 1: wby();break;
	case 2: spp();break;
	case 3: zww();break;
	default : break;
	}
	system("echo  ����������� & pause > nul");
	system("cls");
	shuru();
}

void wby()
{	
	printf("\n������%s ѧ�ţ� %s ��ͬѧ����Ĳ�ѯ�������\n\n",str1,str2);


	printf("                                 ѧ���ɼ�����\n\n�ߵ���ѧԭʼ�ɼ���[______]          ѧ�ּ��㣺[______]\n\n��ѧӢ��ԭʼ�ɼ���[______]          ѧ�ּ��㣺[______]\n\n�������ԭʼ�ɼ���[______]          ѧ�ּ��㣺[______]\n\n");
	printf("�q(�s3�t)�r                         O(��_��)O\n");
}

void spp()
{
	printf("\n������%s ѧ�ţ� %s ��ͬѧ����Ĳ�ѯ�������\n\n",str1,str2);


	printf("                                ѧ��ѧ������  \n\n");
	printf("===============================================================================\n\n\n");
	//int a,b;
	printf("    ���� %s \n\n    ѧ�� %s\n\n    ���� ********\n\n",str1,str2);
	//scanf("%d,%d",&a,&b);
	printf("\n\n\n\n          �˳�\n");
}

void zww()
{
	char str[10];

	printf("                            ������ҽҩ��ѧѧ��������Ϣ��ѯ\n��o��  ��o��  ��o��\n	��o��  ��o��  ��o��\n               ��o��  ��o��  ��o��\n\n\n    ����\n    ��ʵ\n    �̳�\n    ����\n\n\n  	  	��o��  ��o��  ��o��  \n	��o��  ��o��  ��o��  \n��o��  ��o��  ��o��  \n\n\n\n\n\n                                         ������������ʵ��Ϣ��\n                                         ѧ�ţ�        \n                                         ����:                     \n                                         ����\n                                         ��֤��:");
	gets(str);
}




	