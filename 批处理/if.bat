echo ʵ��
::echo off

::1��if "����" == "�ַ���"   ��ִ�е����� 
::if"%1"=="������" echo chengong >if1.txt
::if"%2"=="����" echo chengong >if2.txt

::2��if exist  �ļ���    ��ִ�е�����  
::if exist ������.bat edit ������.bat

::3��if errorlevel  ����    ��ִ�е�����

choice /c:dme defrag,mem,end
pause