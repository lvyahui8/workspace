//�û����������ַ�����������* �����ص㣩
//#define SHOW_CONSOLE  //������̨����
#include <graphics.h>

#include <stdio.h>

int main()
{
	setinitmode(0x0);
	initgraph(640, 480);

	//������������
	char str[100];
	//���öԻ�����
	inputbox_getline("������", "�㰮����ʲô������ʲô���س�ȷ�ϣ�", str, 100);

	//��ʾ���������
	outtextxy(0, 0, str);

	getch();

	closegraph();
	return 0;
}
