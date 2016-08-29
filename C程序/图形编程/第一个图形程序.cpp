//颜色填充
#include <graphics.h>
#include <windows.h>

int main()
{
	initgraph(640, 480);

	//设置填充颜色，一般为图形内部颜色
	//setfillcolor(EGERGB(0xFF, 0x0, 0x80));
	setfillcolor(RED);

	setcolor(GREEN);
	/*
	line( 0, 80, 640, 80);
	line( 0,160, 640, 160);
	line( 0,240,640, 240);
	line( 0,320,640, 320);
	line( 0,400,640,400);
	line( 0,480,640,480);
	line( 0,560,640,560);
	*/


	//画一实心矩形，范围为：x坐标从50-300，y坐标从100-200
	//bar(50, 100, 300, 200);
	//bar(100,100, 400, 200);
	//bar(10 , 60, 500, 100);
	bar(80,80,560,160);
	Sleep(1000);
	//x  280->360  y 160 - > 320
	bar(280,160,360,320);
	Sleep(1000);
	//x  80 -> 560 y 320 -> 400
	bar(80,320,560,400);

	setfillcolor(CYAN);
	Sleep(1000);
	//yuanxing 160 240  bangjin 60
	circle(160,240,60);
	Sleep(1000);
	circle(160,240,40);


	Sleep(1000);
	//yuxing   480 240   banin 60
	circle(480,240,60);
	Sleep(1000);
	circle(480,240,40);

	getch();

	closegraph();
	return 0;
}
