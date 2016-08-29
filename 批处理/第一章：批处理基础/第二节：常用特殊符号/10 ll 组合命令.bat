@echo off 
::当第一条命令失败才执行第二条命令，当碰到执行正确的命令后将不执行后面的命令
::提示：组合命令与重定向命令一起使用时要注意优先级
::管道命令的优先级高于重定向命令，重定向命令的优先级高于组合命令，例如
dir c: && dir d: > a.txt
::执行后a.txt中只有D盘的信息！它将命令分成dir c: 和 dir d: > a.txt两部分，可以这样
::dir c: > a.txt && dir d: >> a.txt
::dir c: > a.txt & dir d: >> a.txt 
pause