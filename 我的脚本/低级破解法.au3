Run("破解密码.exe")	
WinActivate("ATM")												
Sleep(1000)
For $i=999999 To 100000 Step -100000
	Send ($i)
	Send("{Tab 12}")
	Send("{Enter}")
	WinWaitNotActive("工程2","密码正确！")
	Send("{Enter}")
	Send("{Tab}")
	Send("{Enter}")
	Send("{Tab 4}")
Next

For $i=99999 To 10000 Step -10000
	Send("0")
	Send ($i)
	Send("{Tab 12}")
	Send("{Enter}")
	WinWaitNotActive("工程2","密码正确！")
	Send("{Enter}")
	Send("{Tab}")
	Send("{Enter}")
	Send("{Tab 4}")
Next
For $i=9999 To 1000 Step -1000
	Send("00")
	Send ($i)
	Send("{Tab 12}")
	Send("{Enter}")
	WinWaitNotActive("工程2","密码正确！")
	Send("{Enter}")
	Send("{Tab}")
	Send("{Enter}")
	Send("{Tab 4}")
Next
For $i=999 To 100 Step -100
	Send("000")
	Send ($i)
	Send("{Tab 12}")
	Send("{Enter}")
	WinWaitNotActive("工程2","密码正确！")
	Send("{Enter}")
	Send("{Tab}")
	Send("{Enter}")
	Send("{Tab 4}")
Next
For $i=99 To 10 Step -10
	Send("0000")
	Send ($i)
	Send("{Tab 12}")
	Send("{Enter}")
	WinWaitNotActive("工程2","密码正确！")
	Send("{Enter}")
	Send("{Tab}")
	Send("{Enter}")
	Send("{Tab 4}")
Next
For $i=9 To 0 Step -1
	Send("00000")
	Send ($i)
	Send("{Tab 12}")
	Send("{Enter}")
	WinWaitNotActive("工程2","密码正确！")
	Send("{Enter}")
	Send("{Tab}")
	Send("{Enter}")
	Send("{Tab 4}")
Next