#include <graphics.h>

void main(){
	initgraph(1020,600);
	PIMAGE img = newimage();
	getimage(img, "F:\\ͼ��\\��ֽ\\����ֲ��԰��ֽ1366_768\\wallpaper_20120130huananzhiwuyuan_01.jpg");
	putimage(0, 0, img);
	delimage(img);
	getch();
	closegraph();
}