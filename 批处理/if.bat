echo 实验
::echo off

::1、if "参数" == "字符串"   待执行的命令 
::if"%1"=="批处理" echo chengong >if1.txt
::if"%2"=="程序" echo chengong >if2.txt

::2、if exist  文件名    待执行的命令  
::if exist 批处理.bat edit 批处理.bat

::3、if errorlevel  数字    待执行的命令

choice /c:dme defrag,mem,end
pause