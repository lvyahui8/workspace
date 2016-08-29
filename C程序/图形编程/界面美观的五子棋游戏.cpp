#include <stdio.h>
#include <graphics.h>
#include <dos.h>
#include <bios.h>
#define UP 72
#define DOWN 80
#define RIGHT 77
#define LEFT 75
#define ESC 27
#define ENTER 13
int board[32][32],x,y,chess,color,n,i;
int clear()
{
	for(x=0;x<32;x++)
	{
		for(y=0;y<32;y++)
			board[x][y]=0;
	}
	x=16;
	y=16;
	chess=1;
	color=0;
	n=1;
	i=0;
}
int check()
{
	int a,b,c,d,e,k;
	for(i=1;i<9;i++)
	{
		for(e=1;e<5;e++)
		{
			switch(i)
			{
				/*up*/
			case 1:
				a=y-e;
				b=0;
				c=x;
				d=y-e;
				break;
				/*down*/
			case 2:
				a=y+e;
				b=0;
				c=x;
				d=y+e;
				break;
				/*left*/
			case 3:
				a=x-e;
				b=0;
				c=x-e;
				d=y;
				break;
				/*right*/     
			case 4:
				a=x+e;
				b=0;
				c=x+e;
				d=y;
				break;
				/*left up*/
			case 5:
				a=x-e;
				b=y-e;
				c=a;
				d=b;
				break;
				/*right down*/
			case 6:
				a=x+e;
				b=y+e;
				c=a;
				d=b;
				break;
				/*left down*/
			case 7:
				a=x-e;
				b=y+e;
				c=a;
				d=b;
				break;
				/*right up*/ 
			case 8:
				a=x+e;
				b=y-e;
				c=a;
				d=b;
			}
			k=loop(a,b,c,d);
			if(k==0)
				break;
        }
        if(i%2==0)
		{
			if(chess<5) chess=1;
            return(1);
		}
		if(chess>=5)
		{
			chess=1;
			return(1);
		}
	}
	return(0);
}
int loop(int a,int b,int c,int d)
{
	if(a<0||a>31||b<0||b>31)
        return(0);
	if(board[c][d]!=color)
        return(0);
	chess++;
	return(1);
}
int key()
{
    int key;
    while(bioskey(1)==0)
		;
    key=bioskey(0);
    key=key&0xff?key&0xff:key>>8;
    return(key);
}
int chessbox()
{
	int a,b=40;
	cleardevice();
	clrscr();
	setbkcolor(12);
	setcolor(0);
	rectangle(150,30,490,35);
	rectangle(150,365,490,370);
	rectangle(150,40,155,360);
	rectangle(485,40,490,360);
	setfillstyle(8,0);
	floodfill(155,32,0);
	floodfill(152,367,0);
	floodfill(152,50,0);
	floodfill(487,50,0);
	for(a=160;a<=480;a=a+10)
	{
        line(a,40,a,360);
        line(160,b,480,b);
        b=b+10;
	}
	/*if these codes under can not arrive my idea it can be del*/
	setcolor(5);
	ellipse(30,335,0,360,20,5);
	ellipse(30,355,0,360,20,5);
	line(10,335,10,355);
	line(50,335,50,355);
	setfillstyle(1,5); 
	floodfill(30,355,5);
	floodfill(30,341,5);
	/**/
	outtextxy(500,60,"restart");
	outtextxy(500,76,"about");
	outtextxy(500,92,"exit");
	outtextxy(1,80,"who");
}
int begin()
{
    int gdriver=DETECT,mode,a,b=110,errorcode;
    initgraph(&gdriver,&mode,"");
    errorcode=graphresult();
    if(errorcode!=grOk)
    {
		printf("graphics error:%s\n",grapherrormsg(errorcode));
		printf("press any key to exit!");
		getch();
		exit(1);
	}
	setbkcolor(1);
	setcolor(5);
	for(a=160;a<=190;a++)
	{
		if(a<171)
			
		{
			line(a,100,a,200);
			delay(2500);
        }
        if(a>170)
        {
			line(a,140,a,150);
			line(a,100,a,110);
			delay(2500);
		}
		delay(2500);
	}
	/*draw i*/
	for(a=200;a<=220;a++)
	{
		line(a,100,a,110);
		line(a,190,a,200);
		if(a>205&&a<215)
			line(a,110,a,190);
		delay(5000);
	}
	/*draw v*/
	for(a=230;a<=240;a++)
		line(a,100,a,110);
	for(a=230;a<=255;a++)
	{
        line(a,b,a+10,b);
		delay(5000);
		b=b+3.5;
	}
	for(a=255;a<=275;a++)
	{
		line(a,b,a+10,b);
		b=b-3.5;
		delay(5000);
	}
	for(a=275;a<=285;a++)
		line(a,100,a,110);
	/*draw e*/
	for(a=290;a<=320;a++)
	{
        if(a<301)
			line(a,100,a,200);
		if(a>300)
		{
			line(a,100,a,110);
			line(a,140,a,150);
			line(a,190,a,200);
		}
		delay(5000);
	}
	outtextxy(330,180,"chesses");
	outtextxy(330,210,"---made by Kevin Z");
	outtextxy(330,240,"2004 5 4-5");
	getch();
}
int menu()
{
	int b=1,c=0,key1=0;
	setcolor(1);
	rectangle(498,60,560,76);
	while(key1!=ENTER)
	{
		c=b;
		key1=key();
		switch(key1)
		{
		case UP:
			if(b<2)
				b=3;
			else
				b=b-1;
			break;
		case DOWN:
			if(b<3)
				b=b+1;
			else
				b=1;
			break;
		}
		setcolor(5);
		rectangle(498,60+(c-1)*16,560,60+c*16);
		setcolor(1);
		rectangle(498,60+(b-1)*16,560,60+b*16);
	}
	switch(b)
	{
	case 3:
		end();      break;
	case 2:
		setviewport(1,1,400,200,10);              /*how to use it*/
		getch();
		/*此处添加清除图形窗口的代码*/
		break;
	case 1:
		clear();
		chessbox();
		break;
	}
}
int all()
{
    int x1,x2,y1,y2,key1=0;
    int flood,result;
    x1=315;y1=195;
    chessbox();
	
    setcolor(1);    
    rectangle(315,195,325,205);
    circle(60,90,4);
    while(1)
    {
		if(n%2!=0)
		{
			color=2;
			flood=15;
		}
		else
		{
			color=1;
			flood=5;
		}
		setfillstyle(1,flood);
		floodfill(60,90,flood);
		x2=x1;
		y2=y1;
		key1=key();
		switch(key1)
		{
		case UP:
			if(y<1)
				y=31;
			else
				y=y-1;
			break;
		case DOWN:
			if(y>30)
				y=0;
			else
				y=y+1;
			break;
		case LEFT:
			if(x<1)
				x=31;
			else
				x=x-1;
			break;
		case RIGHT:
			if(x>30)
				x=0;
			else
				x=x+1;
			break;
		case ESC:
			menu();
			break;
		case ENTER:
			if(board[x][y])
			{
				circle(160+10*x,40+10*y,4);
				floodfill(160+10*x,40+10*y,flood);
				board[x][y]=color;
				n++;
				result=check();
				if(result==1)judge();
			}
        }
        x1=165+10*x;
        y1=35+10*y;
        setcolor(12);
        rectangle(x2,y2,x2+10,y2+10);
        setcolor(1);
        rectangle(x1,y1,x1+10,y1+10);
	}
}
int judge()
{
	char ch;
	if(color==1)
		setviewport(1,1,400,200,10);                 
	else                                             
		setviewport(1,1,400,200,10);     
	ch=getch();
	if(ch=='n'||ch=='N')
		
		end();
	
	clear();
	chessbox();
}
int end()
{
	closegraph();
	exit(0);
}
main()
{
	clear();
	begin();
	all();
}
/*made by kevin z 2004.5.4-5*/         
