Run("notepad")
Sleep(1000)
Dim $i,$b
For $i=1 To 500 Step 1
	$b=$b+$i
Next
Sleep(1000)
Send($b)
Sleep(1000)
Send("!{f4}")
Send("n")