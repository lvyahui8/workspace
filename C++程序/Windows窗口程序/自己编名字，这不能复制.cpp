#include <windows.h>
//����WndProd()����
LRESULT CALLBACK WndProc(HWND,UINT,WPARAM,LPARAM);   
//winmain������
int APIENTRY WinMain( HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nShowCmd )
{
    WNDCLASS wndclass;                  //���崰����ṹ����
	HWND     hwnd;                      //���崰�ھ��
	MSG      msg;                       //������Ϣ�ṹ����
	
	//��ƴ�������
	wndclass.style=CS_HREDRAW|CS_VREDRAW;     //�ı䴰�ڴ�С���ػ�
	wndclass.lpfnWndProc=WndProc;             //���ں���ΪWndProc
	wndclass.cbClsExtra=0;                    //����������չ
	wndclass.cbWndExtra=0;                    // ����ʵ������չ
	wndclass.hInstance=hInstance;             //ע�ᴰ����ʵ�����
	wndclass.hIcon=LoadIcon(NULL,IDI_APPLICATION);     //�ü�ͷ���
	wndclass.hCursor=LoadCursor(NULL,IDC_ARROW);
	wndclass.hbrBackground=(HBRUSH)GetStockObject(WHITE_BRUSH);    //����Ϊ��ɫ  
	wndclass.lpszMenuName=NULL;                                    //����Ĭ���޲˵�
	wndclass.lpszClassName="homework";
	//ע�ᴰ������
	if(!RegisterClass(&wndclass))
		return FALSE;
	//��������
	hwnd=CreateWindow("homework",
		"�ϻ���ҵ",
		WS_OVERLAPPEDWINDOW,
		CW_USEDEFAULT,CW_USEDEFAULT,CW_USEDEFAULT,CW_USEDEFAULT,
		NULL,NULL,
		hInstance,
		NULL);
	//��ʾ��ˢ�´���
    ShowWindow(hwnd,nShowCmd);                     //��ʾ����
	UpdateWindow(hwnd);                            //���´��ڵĿͻ���
	//��Ϣѭ��
    while (GetMessage(&msg,NULL,0,0))
    {
		TranslateMessage(&msg);                    //������Ϣת��	
		DispatchMessage(&msg);                     // ������Ϣ�����ں���
    } 
	return msg.wParam;                             //�����˳�ֵ
}

//��Ӧ������Ϣ
LRESULT CALLBACK WndProc(HWND hwnd,UINT message,WPARAM wparam,LPARAM lparam)
{
	//������Ϣֵת��Ӧ����Ϣ����
	switch(message)
	{
	case WM_PAINT:
		HDC hdc;            //�����豸��������
		PAINTSTRUCT ps;     //�����ͼ��Ϣ�ṹ����
		hdc=BeginPaint(hwnd,&ps); //��ȡҪ�ػ����ڵ��豸��������
		
		
		TextOut(hdc,100,100,"          ��                                     ��                      ",38);
		TextOut(hdc,100,110,"    ��������������������  ������������    ����������������           ",38);
		TextOut(hdc,100,120,"������������������������  ��        ��           ��    ��        ",38);
		TextOut(hdc,100,130,"��������������������      ������������    �� ����������������                 ",38);
		TextOut(hdc,100,140,"��  ��������������������  ��        ��             ��      ",38);
		TextOut(hdc,100,150,"����������������������������        ��           ��         ",38);
		TextOut(hdc,100,160,"��������������������      ������������          �� ��������           ",38);
		TextOut(hdc,100,170,"��  ������������������   ��         ��      ��         ��        ",38);
		TextOut(hdc,100,180,"            ��             ��         ��          �� ������������  ",38);   
		TextOut(hdc,100,190,"       ������������        ��         ��                ��",38);
		TextOut(hdc,100,200,"       ��         ��      ��          ��             �� ��",38);
		TextOut(hdc,100,210,"       ������������                                     ��",38);
		TextOut(hdc,890,440,"����������",10);
		TextOut(hdc,890,460,"�༶��12050941",14);
		TextOut(hdc,890,480,"ѧ�ţ�1205094123",16);        //����ı�    
		
		
		
		EndPaint(hwnd,&ps);
		break;
		
		
		
		
		//��Ӧ��굥����Ϣ
	case WM_LBUTTONDOWN:
		{
			MessageBeep(0);
		}
		break;
		
		//����������Ϣ����
	case WM_DESTROY:
		PostQuitMessage(0);
		break;
		//����תĬ�ϴ��ں���
	default:
		return DefWindowProc(hwnd,message,wparam,lparam);
	} 
	return 0;
}