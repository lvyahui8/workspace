::ECHO OFF可以关闭掉整个批处理命令的回显，但不能关掉 ECHO OFF这个命令，现在我们在 ECHO OFF这个命令前加个@，就可以达到所有命令均不回显的要求
echo 未关闭回显
@dir c:
echo off
@echo off 
pause