@echo off
echo 生成11文件关联.txt
echo 显示所有“文件扩展名”关联的文件类型 > 11文件关联.txt
assoc >> 11文件关联.txt
echo.   >> 11文件关联.txt
echo.   >> 11文件关联.txt
echo.   >> 11文件关联.txt
echo 也可以单独显示，格式为 assoc .扩展名 >> 11文件关联.txt 
assoc .txt >> 11文件关联.txt
assoc .doc >> 11文件关联.txt
echo.   >> 11文件关联.txt
echo.   >> 11文件关联.txt
echo.   >> 11文件关联.txt
echo 显示所有“文件类型”关联的命令行 >> 11文件关联.txt
ftype >> 11文件关联.txt
echo.   >> 11文件关联.txt
echo.   >> 11文件关联.txt
echo.   >> 11文件关联.txt
echo 也可以单独显示，格式为 ftype 文件类型 >> 11文件关联.txt
ftype txtfile >> 11文件关联.txt
ftype exefile >> 11文件关联.txt
pause