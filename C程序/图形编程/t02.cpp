//��һ����ͼ����
#include <graphics.h>

int main()
{
	//initgraph(640, 480);
	//initgraph(800,800);
	//initgraph(600,400);
	initgraph(500,300);

	//���û�ͼ��ɫ��GREEN����ɫ��������ϸ���Բ�graphics.h�������Ķ����ֵ
	//setcolor(GREEN);
	//setcolor(RED);
	setcolor(YELLOW);
	/**************************************************************
	*
	0 - BLACK �� ��ɫ0 - 7
	1 - BLUE ��			2 - GREEN ��
	3 - CYAN ��			4 - RED ��
	5 - MAGENTA ���	6 - BROWN ��
	7 - LIGHTGRAY ����	8 - DARKGRAY ��� ��ɫ8 - 15
	9 - LIGHTBLUE ����	10 - LIGHTGREEN ����
	11 - LIGHTCYAN ���� 12 - LIGHTRED ����
	13 - LIGHTMAGENTA ����� 4 - YELLOW ��
	15 - WHITE ��
	*
	****************************************************************/

	//��һֱ�ߣ���(100,100)��(500,200)
	//�ر�ע����Ƕ˵㣬(100,100)�����ᱻ������ɫ����(500,200)���ử����ɫ
	//�������еľ��Σ�����˵���㣩������ʽ������ǰһ����ȡ�õ�������һ����ȡ����
	//line(100, 100, 500, 200);
	
	//line(400,0,400,800);
	
	//line(10,20,580,20);
	//line(300,20,300,380);
	
	line(0,0,500,300);
	getch();

	closegraph();
	return 0;
}
