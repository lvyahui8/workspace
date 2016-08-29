Run("notepad")
Dim $i,$b 
Sleep(1000)
For $i=1 To 100 Step 1
	$b=$i+$b
Next
Sleep(1000)
Send($b)