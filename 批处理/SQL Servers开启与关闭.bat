@echo off

for /f "skip=3 tokens=4" %%i in ('sc query MSSQLSERVER') do set "zt=%%i" &goto :next
:next
if /i "%zt%"=="RUNNING" (
echo �Ѿ����ָ÷��������У���ʼֹͣ
net stop MSSQLSERVER
echo sc config MSSQLSERVER start = DISABLED ���÷���
) else (

echo �÷������ڴ���ֹͣ״̬����ʼ����
echo sc config MSSQLSERVER start = Manual ���÷����ֶ�
net start MSSQLSERVER
)
pause