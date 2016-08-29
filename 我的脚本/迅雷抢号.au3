#Region ;**** 参数创建于 ACNWrapper_GUI ****
#PRE_Icon=F:\图库\IconLib\Animal\animat6.ico
#PRE_Compression=4
#PRE_Res_requestedExecutionLevel=None
#EndRegion ;**** 参数创建于 ACNWrapper_GUI ****
For $i=1000000 To 1 Step -1
	WinWait("迅雷VIP尊享版","",100)
	If  WinActivate("迅雷VIP尊享版")  Then
		Send("{enter}")
	EndIf
	WinSetState("我的下载 - 迅雷VIP尊享版","",@SW_MINIMIZE)
	Sleep(300)
	WinSetState("我的下载 - 迅雷VIP尊享版","",@SW_HIDE)
Next