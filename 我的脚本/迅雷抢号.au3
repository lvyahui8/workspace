#Region ;**** ���������� ACNWrapper_GUI ****
#PRE_Icon=F:\ͼ��\IconLib\Animal\animat6.ico
#PRE_Compression=4
#PRE_Res_requestedExecutionLevel=None
#EndRegion ;**** ���������� ACNWrapper_GUI ****
For $i=1000000 To 1 Step -1
	WinWait("Ѹ��VIP�����","",100)
	If  WinActivate("Ѹ��VIP�����")  Then
		Send("{enter}")
	EndIf
	WinSetState("�ҵ����� - Ѹ��VIP�����","",@SW_MINIMIZE)
	Sleep(300)
	WinSetState("�ҵ����� - Ѹ��VIP�����","",@SW_HIDE)
Next