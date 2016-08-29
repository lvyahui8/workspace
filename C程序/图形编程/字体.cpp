//颜色填充
#include <graphics.h>
#include <windows.h>

int main()
{
	initgraph(640, 480);
	
	setfillcolor(RED);
	// 设置当前字体为高 16 像素的“宋体”（忽略行距）。
	setfont(-16, 0,"宋体");
	outtextxy(0, 0,"测试");
	// 设置输出效果为抗锯齿（LOGFONTA是MBCS版本，LOGFONTW是UTF16版本）
	LOGFONTA f;
	getfont(&f);                          // 获取当前字体设置
	f.lfHeight = 48;                      // 设置字体高度为 48（包含行距）
	strcpy(f.lfFaceName, "黑体");         // 设置字体为“黑体”
	//f.lfQuality = DRAFT_QUALITY;    // 设置输出效果为抗锯齿  ANTIALIASED_QUALITY
	f.lfPitchAndFamily =  FF_SCRIPT;
	setfont(&f);                          // 设置字体样式
	outtextxy(0,58,"抗锯齿效果");
	getch();

	closegraph();
	return 0;
}
