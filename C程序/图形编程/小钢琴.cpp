#include<dos.h>
#include<graphics.h>
#include<stdio.h>
#include<conio.h>
#define closegr closegraph

#define KEY_WIDTH 60
#define KEY_HEIGHT 280

#define s 8051
#define d 8292
#define f 8550
#define g 8807
#define h 9064
#define j 9322
#define k 9579
#define ESC 283

/*function's prototype*/
void initgr()
{
    int gd=DETECT,gm=0;
    registerbgidriver(EGAVGA_driver);/*register BGI driver */
    registerbgifont(triplex_font); /*register BGI font*/
    registerbgifont(small_font);
    registerbgifont(sansserif_font);
    registerbgifont(gothic_font);
    initgraph(&gd,&gm,"");
    }   /*initialize the graphic*/

void down(int x,int y)
{
    setcolor(WHITE);
    setfillstyle(SOLID_FILL,WHITE);
    bar(x,y,x+KEY_WIDTH,y+KEY_HEIGHT-13);

    setcolor(DARKGRAY);
    setfillstyle(SOLID_FILL,DARKGRAY);
    bar(x,y+KEY_HEIGHT-13,x+KEY_WIDTH,y+KEY_HEIGHT);
    }   /*the key being pressed*/

void up(int x,int y)
{
    setcolor(WHITE);
    setfillstyle(SOLID_FILL,WHITE);
    bar(x,y,x+KEY_WIDTH,y+KEY_HEIGHT-20);

    setcolor(DARKGRAY);
    setfillstyle(SOLID_FILL,DARKGRAY);
    bar(x,y+KEY_HEIGHT-20,x+KEY_WIDTH,y+KEY_HEIGHT);
    }    /*the key being release*/

void start()
{
    int i=0;

    initgr(); /* initialize the BGI */

    setbkcolor(LIGHTGRAY);
                /*set the background*/
    settextstyle(4,0,5);
    setcolor(BLUE);
    outtextxy(170,40,"SUPER PIANO");
    setcolor(RED);
    outtextxy(172,42,"SUPER PIANO");
    setcolor(YELLOW);
    outtextxy(174,44,"SUPER PIANO");
    setcolor(GREEN);
    outtextxy(176,46,"SUPER PIANO");
         /*this is the title*/
    for(i=0;i<7;i++)
    {
        up(100+i*(KEY_WIDTH+5),110);
        }     /*the key*/

    settextstyle(0,0,1);
    setcolor(LIGHTRED);
    outtextxy(175,420,"KEY:1-s,2-d,3-f,4-g,5-h,6-j,7-k,Quit-Esc");
    setcolor(BLUE);
    outtextxy(215,440,"All Rights Reversed @ 2004-7");
    }

main()
{
    int i=0;
    int key=0;
    start();
    while(key!=ESC)
    {
        for(i=0;i<7;i++)
        {
            up(100+i*(KEY_WIDTH+5),110);
            }     /*release the key first*/

    key=bioskey(0);
    switch(key)
        {
        case s:down(100,110);sound(523);delay(3000);nosound();break;
        case d:down(165,110);sound(587);delay(3000);nosound();break;
        case f:down(230,110);sound(659);delay(3000);nosound();break;
        case g:down(295,110);sound(699);delay(3000);nosound();break;
        case h:down(360,110);sound(784);delay(3000);nosound();break;
        case j:down(425,110);sound(880);delay(3000);nosound();break;
        case k:down(490,110);sound(988);delay(3000);nosound();break;
            default:break;
            }
    }
    closegr();
    }.

/*图形驱动和字体均注册（可生成完全独立的exe文件），因而要求有相应的图形驱动和字体连库*/

