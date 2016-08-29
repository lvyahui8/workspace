@echo off
::for /d %%variable IN (set) DO command [command-parameters]
::这个参数主要用于目录搜索,不会搜索文件,看这样的例子
for /d %%i in (f:\*) do echo %%i
::在来一个 ,比如我们要把当前路径下文件夹的名字只有1-3个字母的打出来
for /d %%i in (???) do echo %%i
pause