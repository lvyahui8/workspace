@echo off
::echo off  关闭回显，但本命令会显示出来
::@echo off 关闭回显，不显示本命令
::echo 查看回显状态
::echo. 回显相关命令学习 

::echo.|time
::（5）输出空行，即相当于输入一个回车  
::    格式：ECHO． 
::     值得注意的是命令行中的“．”要紧跟在 ECHO 后面中间不能有空格，否则“．”将被当作提示信息输出
::到屏幕。另外“．”可以用，：；”／[\]＋等任一符号替代。 
::     命令 ECHO．输出的回车，经 DOS 管道转向可以作为其它命令的输入，比如 echo.|time 即相当于在 TIME
::命令执行后给出一个回车。所以执行时系统会在显示当前时间后，自动返回到 DOS 提示符状态

echo Y|dir

pause
