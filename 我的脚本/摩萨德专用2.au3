#Region ;**** ���������� ACNWrapper_GUI ****
#PRE_Icon=H:\�½��ļ���\chinaz7.ico
#PRE_Outfile=Ħ����ר��2.exe
#PRE_Res_requestedExecutionLevel=None
#EndRegion ;**** ���������� ACNWrapper_GUI ****
Run("�ƽ�����.exe")
Sleep(500)
WinMinimizeAll()
ProgressOn("windows������-ATM", "", "0%")
For $i = 1 To 100 Step 2
    Sleep(250)
    ProgressSet( $i, $i & " %")
Next
ProgressSet(100 , "���", "ȫ�����")
ProgressOff()
For $i=50 To 1 Step -1
SplashImageOn("","H:\��ͼ00.jpg",1000,550,-1,-1,1)
Sleep (25)
Next
Sleep(4000)
SplashOff()
Beep(700,500)
SplashTextOn("��ʾ","�ƽ�ɹ�",180,50,-1,-1,33,"",-1,-1)
Sleep(3000)
SplashOff()
WinActivate("ATM")
Sleep(500)
Send("{Tab 13}")
Send("{Enter}")
Send("{Tab 4}")
For $i = 6 To 1 Step -1
	Send(Random(1, 9, 1))
	Sleep(500)
Next
Send("{Tab 12}")
MsgBox(8192, "����2", "������ȷ��", 500)
Send("{Tab 1}")
Send("{Enter}")