//�߼����滭����ɫ/�ʺ�
#include <graphics.h>

// alpha ��ϼ��㺯��
COLORREF alphasingle(COLORREF a, COLORREF b, COLORREF alpha)
{
	return (a * (0xFF - alpha) + b * alpha) >> 8;
}

// ��ɫalpha��ϼ��㺯��
COLORREF alphacol(COLORREF d, COLORREF s, COLORREF alpha)
{
	return (alphasingle(d&0xFF00FF, s&0xFF00FF, alpha) & 0xFF00FF)
		| (alphasingle(d&0xFF00, s&0xFF00, alpha) >> 8 << 8);
}

int main()
{
	initgraph(640, 480);
	int c;

	//������ɫ
	for (c=0; c<256; ++c)
	{
		COLORREF a = 0xFF0000, b = 0x0000FF;
		setcolor(alphacol(a, b, c));
		line(0, c, 200, c);
	}

	//���ʺ�
	for (c=0; c<360; ++c)
	{
		setcolor(hsl2rgb((float)c, 1.0f, 0.5f));
		line(200, c, 400, c);
	}
	getch();

	closegraph();
	return 0;
}
