//ɫ�ʵļ���
#include <graphics.h>

int main()
{
	initgraph(640, 480);

	//���û�ͼ��ɫ��ʹ��RGB�꣬��������ֵ�ķ�Χ��Ϊ0 - 255 (0xFF)
	//�ֱ��ʾ��ɫ���ȣ���ɫ���ȣ���ɫ����
	//EGERGB(0xFF, 0x0, 0x0) (����ɫ) �ȼ���0xFF0000
	setcolor(EGERGB(0xFF, 0x0, 0x0));
	
	//setcolor(EGERGB(0xBB,0xAA,0X8A));
	
	
	//��һԲ��Բ����(200,200)���뾶100
	circle(200, 200, 100);
	circle(100,100,50);
	circle(300,300,300);
	circle(200,200,200);
	circle(100,20,10);


	getch();


	closegraph();
	return 0;
}
