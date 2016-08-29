@echo off
dir c:
rem 退出代码为>=1就跳至标题1处执行，>=0 就跳至标题0处执行
if errorlevel 1 goto 1
if errorlevel 0 goto 0
rem 上面两行不可交换位置，否则失败了也显示成功
:0
echo 命令执行成功！
rem 程序执行完毕跳至标题exit处退出
goto exit
:1
echo 命令执行失败！
rem 程序执行完毕跳至标题exit处退出
goto exit
:exit
pause