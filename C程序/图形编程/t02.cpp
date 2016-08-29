//第一个画图程序
#include <graphics.h>

int main()
{
	//initgraph(640, 480);
	//initgraph(800,800);
	//initgraph(600,400);
	initgraph(500,300);

	//设置画图颜色，GREEN是颜色常数，详细可以查graphics.h对这个宏的定义的值
	//setcolor(GREEN);
	//setcolor(RED);
	setcolor(YELLOW);
	/**************************************************************
	*
	0 - BLACK 黑 深色0 - 7
	1 - BLUE 兰			2 - GREEN 绿
	3 - CYAN 青			4 - RED 红
	5 - MAGENTA 洋红	6 - BROWN 棕
	7 - LIGHTGRAY 淡灰	8 - DARKGRAY 深灰 淡色8 - 15
	9 - LIGHTBLUE 淡兰	10 - LIGHTGREEN 淡绿
	11 - LIGHTCYAN 淡青 12 - LIGHTRED 淡红
	13 - LIGHTMAGENTA 淡洋红 4 - YELLOW 黄
	15 - WHITE 白
	*
	****************************************************************/

	//画一直线，从(100,100)到(500,200)
	//特别注意的是端点，(100,100)这个点会被画上颜色，但(500,200)不会画上颜色
	//以下所有的矩形（或者说两点）描述方式，总是前一个点取得到，但后一个点取不到
	//line(100, 100, 500, 200);
	
	//line(400,0,400,800);
	
	//line(10,20,580,20);
	//line(300,20,300,380);
	
	line(0,0,500,300);
	getch();

	closegraph();
	return 0;
}
