@echo off

for /f "skip=3 tokens=4" %%i in ('sc query MSSQLSERVER') do set "zt=%%i" &goto :next
:next
if /i "%zt%"=="RUNNING" (
echo 已经发现该服务在运行，开始停止
net stop MSSQLSERVER
echo sc config MSSQLSERVER start = DISABLED 禁用服务
) else (

echo 该服务现在处理停止状态，开始启动
echo sc config MSSQLSERVER start = Manual 设置服务手动
net start MSSQLSERVER
)
pause