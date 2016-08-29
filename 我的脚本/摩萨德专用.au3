#Region ;**** 参数创建于 ACNWrapper_GUI ****
#PRE_Icon=H:\新建文件夹\diva-liberty.ico
#PRE_Outfile=摩萨德专用.exe
#PRE_Res_requestedExecutionLevel=None
#EndRegion ;**** 参数创建于 ACNWrapper_GUI ****
Run("破解密码.exe")
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
MsgBox(8192, "工程2", "密码正确！", 500)
Send("{Tab 1}")
Send("{Enter}")