#Region ;**** ���������� ACNWrapper_GUI ****
#PRE_Icon=H:\�½��ļ���\diva-liberty.ico
#PRE_Outfile=Ħ����ר��.exe
#PRE_Res_requestedExecutionLevel=None
#EndRegion ;**** ���������� ACNWrapper_GUI ****
Run("�ƽ�����.exe")
WinActivate("ATM")
Sleep(1000)
Send("******")
For $i = 50 To 0 Step -1
	Send("{LEFT 10}{RIGHT 10}")
Next
Send("{Tab 13}")
Send("{Enter}")
Send("{Tab 4}")
Beep(500,1000)
For $i = 6 To 1 Step -1
	Send(Random(1, 9, 1))
	Sleep(500)
Next
Send("{Tab 12}")
MsgBox(8192, "����2", "������ȷ��", 500)
Send("{Tab 1}")
Send("{Enter}")