Run("�ƽ�����.exe")
WinActivate("ATM")
Sleep(1000)
For $i=9 To 0 Step -1
	For $s=199999 To 100000 Step -1
		Send($i)
		Local $var = StringMid($s, 2, 5)
		Send($var)
	    Send("{Tab 12}")
	    Send("{Enter}")
	    WinWaitNotActive("����1","������ȷ��")
	    Send("{Enter}")
	    Send("{Tab}")
	    Send("{Enter}")
	    Send("{Tab 4}")
	Next
Next