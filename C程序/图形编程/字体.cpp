//��ɫ���
#include <graphics.h>
#include <windows.h>

int main()
{
	initgraph(640, 480);
	
	setfillcolor(RED);
	// ���õ�ǰ����Ϊ�� 16 ���صġ����塱�������оࣩ��
	setfont(-16, 0,"����");
	outtextxy(0, 0,"����");
	// �������Ч��Ϊ����ݣ�LOGFONTA��MBCS�汾��LOGFONTW��UTF16�汾��
	LOGFONTA f;
	getfont(&f);                          // ��ȡ��ǰ��������
	f.lfHeight = 48;                      // ��������߶�Ϊ 48�������оࣩ
	strcpy(f.lfFaceName, "����");         // ��������Ϊ�����塱
	//f.lfQuality = DRAFT_QUALITY;    // �������Ч��Ϊ�����  ANTIALIASED_QUALITY
	f.lfPitchAndFamily =  FF_SCRIPT;
	setfont(&f);                          // ����������ʽ
	outtextxy(0,58,"�����Ч��");
	getch();

	closegraph();
	return 0;
}
