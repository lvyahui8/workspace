#include <stdafx.h>
#include <stdlib.h>
#include <string.h>

#define NUMP 3 //����
#define NAME 20 //���ֳ���
#define DEBUG
/*
** ˵����ѧ����¼Ϊѧ���Ļ�����Ϣ������ѧ�ţ�������c���Գɼ�����ѧ�ɼ���Ӣ��ɼ����ܷ֣�ƽ���֡�
*/

int num[NUMP];//ѧ��
char name[NUMP][NAME];//����
float c_score[NUMP];//c���Գɼ�
float m_score[NUMP];//��ѧ�ɼ�
float e_score[NUMP];//Ӣ��ɼ�
float aggr_score[NUMP];//�ܷ�
float aver_score[NUMP];//ƽ����

int n=0;

//�˺�������¼��
void Entry_record(){
	printf("������ѧ��:");
	scanf("%d%*c",&num[n]);
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
void Display_records(){
	int i;
	puts("ѧ��\t����\tC����\tӢ��\t��ѧ\n");
	for(i=0;i<n && i<NUMP;i++)
	{
		if(0!=num[i])
			printf("%d %s %.2f %.2f %.2f\n",
			num[i],name[i],c_score[i],e_score[i],m_score[i]);
	}
	system("echo ������������ϲ�_ _ _ _ _ _ _ _ & pause > nul");
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
		puts("\t    C   >/                \\<   |&/		1. ¼���¼");
		puts("\t     \\_O/ - ����          _`*-'_/ /	\t2. ɾ����¼");

		puts("\t   ,- >o<-.              / ____ _/		3. ��ѯ��¼");
		puts("\t  /   \\/   \\            / /\\  _)_)	\t4. �޸ļ�¼");
		puts("\t / /|  | |\\ \\          / /  )   |		5. �����¼");
		puts("\t \\ \\|  | |/ /          \\ \\ /    |	\t6. ͳ�Ƽ�¼");
		puts("\t  \\_\\  | |_/            \\ \\_    |	\t7. �����¼");

		puts("\t  /_/`___|_\\            /_/\\____|		8. �����¼");
		puts("\t    |  | |                  \\  \\|		9. ��ʾ��¼");
		puts("\t    |  | |                   `. )		0. �˳�ϵͳ");
		puts("\t    |  | |                   / /");
		puts("\t    |__|_|_                 /_/|");

		puts("\t    (____)_)                |\\_\\_");
		printf("��������Ҫ�����ģ��ı��:");
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
