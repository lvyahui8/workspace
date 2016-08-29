@echo off
::目的：交换两个变量的值，但是不使用临时变量
::Code by JM 2007-1-24[email=CMD@xp]CMD@XP[/email]
set var1=abc
set var2=123
echo 交换前：var1=%var1% var2=%var2%
set var1=%var2% & set var2=%var1%
echo 交换后：var1=%var1% var2=%var2%
pause 