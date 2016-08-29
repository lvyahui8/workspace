@echo off
::括号在for语句和if语句中常见，用来嵌套使用循环和条件语句，其实括号（）也可以单独使用，例如
echo 1 & echo 2 & echo 3

(
echo 1
echo 2
echo 3
)
::上面两种写法效果一样，这两种写法都被视为一条命令行
pause