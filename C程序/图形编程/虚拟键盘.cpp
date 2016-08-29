#include <graphics.h>
#include <stdio.h>
#define TEST
void PrintText(int x,int y,const char *str,int nHeight= 0 ,const char *fontName = NULL){
	LOGFONT oldFont;
	getfont(&oldFont);
	setbkmode(TRANSPARENT);
	if(0 != nHeight && fontName != NULL){
		
		setfont(nHeight,0,fontName);	
	}
	else if(0 != nHeight){
		TCHAR lfFaceName[LF_FACESIZE];
		strcpy(lfFaceName , oldFont.lfFaceName);
		setfont(nHeight,0,lfFaceName);
	}
	else if(NULL != fontName){
		setfont(oldFont.lfHeight,0,fontName);
	}

	outtextxy(x,y,str);
	setbkmode(OPAQUE);
	setfont(&oldFont);
}
void DrawRect(int left, int top, int right, int bottom,
					 color_t frameColor = BLACK ,color_t fillColor = -1 ,
					 int frameWidth = 0 ,
					 const char * caption = NULL ,
					 bool isSolid = true )
{
	color_t oldForeColor=getcolor();
	color_t oldFillColor=getfillcolor();
	setcolor(frameColor);
	setlinestyle(SOLID_LINE,NULL,frameWidth);
	setfillstyle(SOLID_FILL,fillColor);
	int point[10]={
		left,top,
		right,top,
		right,bottom,
		left,bottom,
		left,top
	};
	fillpoly(5,point);
	if(isSolid){
		for(int i=0;i<10;i++){
			point[i] -= frameWidth*2; 
		}
		fillpoly(5,point);
		setcolor(LIGHTGRAY);
		line(right-frameWidth,top+frameWidth/2,right-frameWidth,bottom-frameWidth);		//画竖直阴影
		line(left+frameWidth/2,bottom-frameWidth,right-frameWidth,bottom-frameWidth);	//画水平阴影
/*		//带边三角
		int trigonPoint1[]={
			right-(frameWidth/2),top,
			right-(3*frameWidth/2),top,
			right-(3*frameWidth/2),top-2*frameWidth,
			right-(frameWidth/2),top,
		};
		int trigonPoint2[]={
			left,bottom-(frameWidth/2),
			left,bottom-(3*frameWidth/2),
			left-2*frameWidth,bottom-(3*frameWidth/2),
			left,bottom-(frameWidth/2),
		};
		setfillstyle(SOLID_FILL,LIGHTGRAY);
		setlinestyle(NULL_LINE);
		fillpoly(4,trigonPoint1);
		fillpoly(4,trigonPoint2);
*/
	}
	
	if(NULL != caption){
		setfontbkcolor(fillColor);
		setcolor(frameColor);
		outtextxy(point[0]+15,point[1]-10,caption);
	}
	setcolor(oldForeColor);
	setfillcolor(oldFillColor);
}


void VirtualKeyboard(const char *hint,long * pDeposit){
	setfont(18,0,"黑体");
	//////////////////////////////////////////////////////////////////////////
	//	先画界面
	//////////////////////////////////////////////////////////////////////////
	const int HINT_STR_HEIGHT		=		18;							// 提示字符串的高度
	const int HINT_STR_WIDTH		=		textwidth(hint);			// 提示字符串的宽度
	const int KEYBOARD_HEIGHT		=		HINT_STR_HEIGHT+10;			// 虚拟键盘高度
	const int KEYBOARD_WIDTH		=		HINT_STR_WIDTH+10;			// 虚拟键盘宽度
	const int FRAME_WIDTH			=		4;
	RECT viewPort={0};
	getviewport((int *)&viewPort.left,(int *)&viewPort.top,(int *)&viewPort.right,(int *)&viewPort.bottom);
	RECT	keyborad = {
		((viewPort.right - viewPort.left)/2 - KEYBOARD_WIDTH/2),
		((viewPort.bottom - FRAME_WIDTH) - HINT_STR_HEIGHT*12),
		((viewPort.right - viewPort.left)/2 + KEYBOARD_WIDTH/2),
		(viewPort.bottom - FRAME_WIDTH)
	};
	xyprintf(0,0,"字符串宽: %3d 字符串高: %3d",HINT_STR_WIDTH,HINT_STR_HEIGHT);
	//	画底板
	DrawRect(keyborad.left,keyborad.top,keyborad.right,keyborad.bottom,YELLOW,GREEN,FRAME_WIDTH,NULL,false);
	setcolor(BLACK);
	//	画信息框
	char buffer[255];
	COORD currentPos = {keyborad.left+FRAME_WIDTH,keyborad.top+FRAME_WIDTH};
	DrawRect(currentPos.X,currentPos.Y,currentPos.X+KEYBOARD_WIDTH-FRAME_WIDTH*2,currentPos.Y+HINT_STR_HEIGHT*2,
		YELLOW,GREEN,FRAME_WIDTH,NULL,false);
	PrintText(currentPos.X,currentPos.Y+FRAME_WIDTH,hint);
	// 画数值框
	currentPos.Y+=HINT_STR_HEIGHT*2;
	DrawRect(currentPos.X,currentPos.Y,currentPos.X+KEYBOARD_WIDTH-FRAME_WIDTH*2,currentPos.Y+HINT_STR_HEIGHT*2,
		YELLOW,GREEN,FRAME_WIDTH,NULL,false);
	// 画按钮
	currentPos.Y+=HINT_STR_HEIGHT*2;
	for(int i=1;i<=12;i++){
		DrawRect(currentPos.X,currentPos.Y,currentPos.X+(KEYBOARD_WIDTH-FRAME_WIDTH*2)/3+1,currentPos.Y+HINT_STR_HEIGHT*2,
			YELLOW,GREEN,FRAME_WIDTH,NULL,false);
		if(i<=10)
			sprintf(buffer,"%d",i-1);
		else if(11==i)
			sprintf(buffer,"B");
		else
			sprintf(buffer,"E");
		PrintText(currentPos.X+10,currentPos.Y+FRAME_WIDTH,buffer,HINT_STR_HEIGHT*2-FRAME_WIDTH*2);
		currentPos.X+=(KEYBOARD_WIDTH-FRAME_WIDTH*2)/3;
		if(i%3==0){
			currentPos.X	=	keyborad.left+FRAME_WIDTH;
			currentPos.Y	+=	HINT_STR_HEIGHT*2-2;
		}
	}
	//////////////////////////////////////////////////////////////////////////
	//	读数据
	//////////////////////////////////////////////////////////////////////////
	key_msg		kmsg={0};
	mouse_msg	mmsg={0};
	currentPos.X = keyborad.left + FRAME_WIDTH, currentPos.Y = keyborad.top + HINT_STR_HEIGHT*4 + FRAME_WIDTH*2;
	char ch;				// 用来存放单个字符
	char szValue[255]={0};	// 用来存放值的字符串
	char * pStr = szValue;
	const RECT BUTTON_AREA = {currentPos.X,currentPos.Y,keyborad.right - FRAME_WIDTH,keyborad.bottom - FRAME_WIDTH};
	do{
		ch = 0;		// 置为0
		mmsg.y = mmsg.x = 0;
		if(mousemsg())
		{	
			setcolor(RED);
			mmsg = getmouse();
#ifdef TEST
			xyprintf(20,20,"x = %4d y = %4d",mmsg.x,mmsg.y);
			xyprintf(20,40,"cx = %3d cy = %3d",currentPos.X,currentPos.Y);
#endif//TEST
			if(mmsg.x>BUTTON_AREA.left		&& 
				mmsg.x<BUTTON_AREA.right	&& 
				mmsg.y>BUTTON_AREA.top		&& 
				mmsg.y<BUTTON_AREA.bottom	&& 
				mmsg.is_down()				&& 
				mmsg.is_left())
			{
#ifdef TEST
				xyprintf(20,60,"down_x = %3d down_y = %3d",mmsg.x,mmsg.y);
#endif//TEST
				int line	=	(mmsg.y - currentPos.Y)/(HINT_STR_HEIGHT*2-FRAME_WIDTH);
				int column	=	(mmsg.x - currentPos.X)/((keyborad.right-keyborad.left)/3);
#ifdef TEST
				xyprintf(20,80,"line = %3d column = %3d",line,column);
#endif//TEST
				ch = line*3+column + 48;
				if(58 == ch){
					ch = 8;
				}
				else if(59 == ch){
					ch = 13;
				}
#ifdef TEST
				xyprintf(20,100,"ch = '%c'",ch);
#endif//TEST
			}
		}
		else if (kbmsg()) {
			kmsg = getkey();
			if(kmsg.msg == key_msg_down				&&
				(
				(kmsg.key >= '0'&& kmsg.key <= '9')	||
				(key_back  == kmsg.key)				||
				(key_enter == kmsg.key)
				)
				)
			{
				ch = kmsg.key;
				if((ch>='0' && ch <='9') || 8 == ch || 13 == ch){
#ifdef TEST
				xyprintf(300,100,"kmsg.key = %d ch = '%c'",kmsg.key,ch);
#endif//TEST
				}
			}
		}
		if(ch!=0){
			if(13 == ch){
				break;
			}
			else if(8 == ch){
				if(pStr > szValue){
					pStr--;
				}
			}
			else{
				* pStr = ch;
				pStr ++;
			}
			* pStr = '\0';
		}
#ifdef TEST
		xyprintf(600,100,"                                              ");
		xyprintf(600,100,"%s",szValue);
#endif//TEST
		PrintText(keyborad.left+FRAME_WIDTH*2,keyborad.top+2*HINT_STR_HEIGHT+FRAME_WIDTH,szValue,HINT_STR_HEIGHT*2);
		delay_fps(60);
	}while(1);

	*pDeposit = atoi(szValue);
}

void main(){
	initgraph(1020,600);
	long value;
	char * hint = "请输入员工编号";
	VirtualKeyboard(hint,&value);
	cleardevice();
	xyprintf(0,0,"value = %ld",value);
	getch();
	getch();
	closegraph();
}