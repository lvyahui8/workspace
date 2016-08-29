@echo off 
echo 格式:第一条命令 ^| 第二条命令 [^| 第三条命令...]
echo 将第一条命令的结果作为第二条命令的参数来使用
echo 例如
echo DIR e: ^| find "程序" 下面是执行结果
dir e: | find "程序"
pause

