@echo off
set /p stime=请输入时间(例如：23:59)：
at %stime% shutdown -r -t 5 
pause