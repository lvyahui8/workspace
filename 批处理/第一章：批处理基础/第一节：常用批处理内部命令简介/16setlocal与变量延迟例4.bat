@echo off
::Ŀ�ģ���������������ֵ�����ǲ�ʹ����ʱ����
::Code by JM 2007-1-24[email=CMD@xp]CMD@XP[/email]
set var1=abc
set var2=123
echo ����ǰ��var1=%var1% var2=%var2%
set var1=%var2% & set var2=%var1%
echo ������var1=%var1% var2=%var2%
pause 