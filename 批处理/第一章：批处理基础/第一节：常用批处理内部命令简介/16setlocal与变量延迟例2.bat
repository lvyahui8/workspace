@echo off
::下一行是变量延迟的启动语句，其后的变量要用！！括起来
setlocal enabledelayedexpansion
set a=4
set a=5 & echo !a!
::得到的结果应该是5
pause 