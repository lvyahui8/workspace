/*=====================================================================
// FOOLTRS.C: Fool tetris game v1.0 by skywind
// ������˹����Ϸ�������ɵ�ϰ棬��ΰ 1999��8��11��
//
// ��Ϸ�����κ���չ��������򵥵ķ�ʽ����˵������˹����Ļ�������ʵ��
// ����������MS-DOS����Ȼ����д��Ϸ��ƽ̨���ѱ仯����࣬
// �����Ҿ���������һЩ�������ۣ�ϣ�������ŵ���Ϸ������ܵõ�һЩ����
// �÷����/�ո���Ϸ�����벻���������У���ѧC�߽��ܶ���������TC20����
//
//=====================================================================*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <conio.h>
#include <string.h>
#include <dos.h>

/*---------------------------------------------------------------------
// �������壺��ͼ��ש��
//---------------------------------------------------------------------*/
int map[26][10]; /* ��Ϸ��ͼ����: ����ש�齫�������ڵ�ͼ�� ............*/

typedef struct { int d[4][4]; } Block;  /* ש��ṹ���� ...............*/
int BlockList[7][4][4] = {      /* ���ִ�ͳ�ķ��鶨�� .................*/
	{ { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 1, 0, 0 }, { 0, 1, 1, 0 } },
	{ { 0, 0, 0, 0 }, { 0, 0, 2, 0 }, { 0, 0, 2, 0 }, { 0, 2, 2, 0 } },
	{ { 0, 3, 0, 0 }, { 0, 3, 0, 0 }, { 0, 3, 0, 0 }, { 0, 3, 0, 0 } },
	{ { 0, 4, 0, 0 }, { 0, 4, 4, 0 }, { 0, 0, 4, 0 }, { 0, 0, 0, 0 } },
	{ { 0, 0, 5, 0 }, { 0, 5, 5, 0 }, { 0, 5, 0, 0 }, { 0, 0, 0, 0 } },
	{ { 0, 6, 6, 6 }, { 0, 0, 6, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
	{ { 0, 0, 0, 0 }, { 0, 7, 7, 0 }, { 0, 7, 7, 0 }, { 0, 0, 0, 0 } }};
	unsigned char cmap[]={0,0x72,0x30,0x47,0x57,0x27,0x60,0x74}; /* ��ɫ�� */
	long GameMode = 0, GameSpeed = -1, GameScore = 0; /* ȫ�ֶ��壺��״̬ .*/
	
	/*---------------------------------------------------------------------
	// ��Ƶ������ݶ���
	//---------------------------------------------------------------------*/
	char far* TextBuf = (char far*)0xb8000000l; /* �ı�״̬���Դ��ַ .....*/
	char TextBck[20][10];                       /* �ı�״̬�Ķ������� .....*/
#define SCREEN(x,y) (TextBuf[((y) * 160) + ((x) * 2)])   /* �Դ����ַ� */
#define SCOLOR(x,y) (TextBuf[((y) * 160) + ((x) * 2) + 1]) /* ��Ļ��ɫ */
	
	/*---------------------------------------------------------------------
	// ����ש���������
	//---------------------------------------------------------------------*/
	void Rotate(const Block* src, Block* dest)  /* ��תש��src��dest ......*/
	{
		int i, j;
		for (j = 0; j < 4; j++) for (i = 0; i < 4; i++)
			dest->d[i][j] = src->d[j][3 - i];
	}
	
	int MapCheck(int x, int y) /* ����ͼ��ĳ�����Ƿ���ש�� ..............*/
	{
		if (x < 0 || x >=10 || y < 0 || y >= 26) return -1;
		return map[y][x];
	}
	
	int BlockCheck(int x, int y, const Block* src) /* ���ש��λ�úϷ��� ..*/
	{
		int i, j;
		for (j = 0; j < 4; j++) for (i = 0; i < 4; i++)
			if (MapCheck(x + j, y - i) && src->d[i][j]) return 0;
			return 1;
	}
	
	void CreateBlock(Block* src) /* �������һ��ש�飬Ȼ�󱣴浽src .......*/
	{
		int i,j,k = rand() % 7;
		Block t;
		for (i = 0; i < 4; i++) for (j = 0; j < 4; j++)
			src->d[i][j] = BlockList[k][i][j];
		for (i = rand() % 4; i > 0; i--, *src = t) Rotate(src, &t);
	}
	
	long TimePass = 0, TimeExit = -1, GameTime = -1, w;
	void GameMain(void);
	/*---------------------------------------------------------------------
	// ������ں���
	//---------------------------------------------------------------------*/
	void main(void)
	{
		clrscr();                               /* ��ʼ�������� ...........*/
		randomize();                            /* ��ʼ������������� .....*/
		for (w = 0; w < 26; w++) memset(map[w], 0, sizeof(int) * 10);
		for (w = 0; w < 22; w++)                /* ��ʼ�������Ʊ߿� .......*/
			SCREEN(w,0)=254, SCOLOR(w,0)=8, SCREEN(w,21)=254, SCOLOR(w,21)=8,
			SCREEN(0,w)=254, SCOLOR(0,w)=8, SCREEN(21,w)=254, SCOLOR(21,w)=8;
		GameSpeed = 2;                          /* ��ʼ���������ٶ� .......*/
		
		GameMain();                             /* ������Ϸ������ .........*/
	}
	
	int readkey(void)           /* �޵ȴ��Ľ���һ��������Ϣ ...............*/
	{
		if (!kbhit()) return 0; /* �����ǰû�а�����Ϣ��ֱ�ӷ��� .........*/
		if ((w = getch()) == 0) return getch();   /* ���طǿ��Ƽ� .........*/
		return (int)w;
	}
	
	int SpeedX[10] = { 17, 15, 13, 11, 9, 7, 5, 4, 3, 2 }; /* �ٶȼ��� ....*/
	int x = 3, y = 20, v = 0, level;    /* ȫ�ֶ��壺ש������꣬�ٶ� .....*/
	Block A, B, C;                      /* ȫ�ֶ��壺A, B, C�����ש�� ..*/
	
	void GameDriver(void);
	void GameView(void);
	
	/*---------------------------------------------------------------------
	// ��Ϸ�߼�����(��Ҫ): ÿ��ѭ��18.2�Σ�����ש���ƶ�/����/�������߼�
	//---------------------------------------------------------------------*/
	void GameMain(void)
	{
		long key, i, j, m, n, old_time = 0;         /* ��������� .........*/
		CreateBlock(&A); CreateBlock(&C);           /* ��ʼ��ש�� .........*/
		
		for (GameMode = 0, v = SpeedX[GameSpeed]; GameMode == 0; TimePass++)
		{
			while (clock() == old_time);   /* �ٶȿ��ƣ�clock()Ϊ 18.2Hz ..*/
			old_time = clock();
			nosound();
			key = readkey();               /* ����һ��������Ϣ ............*/
			if (key == 75) if (BlockCheck(x - 1, y, &A)) x--;   /* ���� ...*/
			if (key == 77) if (BlockCheck(x + 1, y, &A)) x++;   /* ���� ...*/
			if (key == 80) v = 0;                   /* ����: SET v = 0 ....*/
			if (key == ' ') {                       /* ֱ������ ...........*/
				for (i = y; i >= 0; i--) if (!BlockCheck(x, i - 1, &A)) break;
				y = i; v = 0;
			}
			if (key == 27) GameMode = 1;            /* ESC: �˳���Ϸ ......*/
			if (key == 72) {                        /* UP: ת��ש�� .......*/
				Rotate(&A, &B);
				if (BlockCheck(x, y, &B)) A = B;
			}
			if (--v <= 0) {                     /* �����������ʱ�� .......*/
				v = SpeedX[GameSpeed];          /* ����ש���ٶ� ...........*/
				if (BlockCheck(x, y - 1, &A) == 0) {/* �������map�ײ� ....*/
					for (i=0, m=y; i<4; i++,m--) for (j=0,n=x; j<4; j++,n++) 
						if (MapCheck(n,m)==0 && A.d[i][j]) /* ��A���Ƶ�map */
							map[m][n] = A.d[i][j];
						A = C;                          /* ��C���Ƶ�A .........*/
						CreateBlock(&C);                /* �����µ�Cש�� ......*/
						if (y >= 20) GameMode = -1;     /* �ж����� ...........*/
						else y = 20, x = 3;
						GameDriver();                   /* ������ɵ��� .......*/
				}   else y--;                       /* �����½� .........*/
			}
			GameView();                             /* ��ʾ: ������Ļ .....*/
		}
		while (kbhit()) getch();                    /* ����������� .......*/
		while (!kbhit());
		nosound();                                  /* �ر������� .........*/
	}
	
	void GameDriver(void)      /* ���������� ..............................*/
	{
		int inc[5]={10,100,300,600,1000}, count = 0, x, y, k, i, j;
		
		for (y = 0; y < 25; y++) for (; ; count++) { /* ɨ��map�������� ...*/
			for (x = 0, k = 0; x < 10; x++) k += (map[y][x])? 1 : 0;
			if (k < 10) break;              /* ����һ���Ƿ������ȥ .......*/
			for (j = y; j < 25; j++) memcpy(map[j], map[j+1], 10 * sizeof(int));
		}
		if ((GameScore / 10000) != ((GameScore + inc[count]) / 10000))
			GameSpeed = (GameSpeed + 1) % 10;       /* �����ٶ����� ...........*/
		GameScore += inc[count];                /* �����µķ��� ...........*/
		sound((count == 0)? 75 : 900);
	}
	
	void GameView(void)        /* ���ƣ���map�����ש����Ƶ���Ļ .........*/
	{
		int i, j, m, n;
		
		for (i=0; i<10; i++) for (j=0; j<20; j++) /* ����TextBck�������� ..*/
			TextBck[j][i] = map[j][i];
		for (i=0, n=x; i<4; i++, n++) for (j = 0, m=y; j < 4; j++, m--)
			if (m>=0&&m<20 && n>=0&&n<10 && A.d[j][i]) TextBck[m][n] = A.d[j][i];
			
			for (i = 0; i < 10; i++) for (j = 0; j < 20; j++) { /* ��ʾ��ͼ ...*/
				m = TextBck[19 - j][i], n = i * 2;
				SCREEN(n+1,j+1) = (m)? '[':'.', SCOLOR(n+1,j+1) = (m)? cmap[m] : 8;
				SCREEN(n+2,j+1) = (m)? ']':'.', SCOLOR(n+2,j+1) = (m)? cmap[m] : 8;
			}
			for (j = 0; j < 4; j++) for (i = 0; i < 4; i++) {   /* ��ʾ�¸�ש��*/
				m = C.d[j][i], n = 160 * (j + 8) + 4 * i + 58;
				TextBuf[n+0] = (m)? '[':'.', TextBuf[n+1] = (m)? cmap[m] : 8;
				TextBuf[n+2] = (m)? ']':'.', TextBuf[n+3] = (m)? cmap[m] : 8;
			}
			if (TimePass & 3) return;
			textcolor(0xa-8);
			gotoxy(30,1); printf("POSITION: [%2d,%2d]", x, y);  /* ��ʾ������ .*/
			gotoxy(30,2); printf("SPEED: %d", GameSpeed);
			gotoxy(30,6); printf("SCORE: "); cprintf("%ld", GameScore);
			gotoxy(30,5); printf("TIME:  ");                    /* ��ʾʱ�� ...*/
			m = (int)(TimePass / 18.2) / 60, n = (int)(TimePass / 18.2) % 60;
			cprintf("%d%d:%d%d", (m/10), (m%10), (n/10), (n%10));
			gotoxy(1, 23);
	}
