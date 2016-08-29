@echo off
echo 产生一个临时文件 > temp.txt
rem 下行先保存当前目录，再将c:\windows设为当前目录
pushd c:\windows
call :sub tmp.txt
rem 下行恢复前次的当前目录
popd
call :sub tmp.txt
pause
del tmp.txt
exit
:sub
Echo 删除引号： %~1 
Echo 扩充到路径： %~f1 
Echo 扩充到一个驱动器号： %~d1 
Echo 扩充到一个路径： %~p1  
Echo 扩充到一个文件名： %~n1 
Echo 扩充到一个文件扩展名： %~x1 
Echo 扩充的路径指含有短名： %~s1  
Echo 扩充到文件属性： %~a1  
Echo 扩充到文件的日期/ 时间：  %~t1  
Echo 扩充到文件的大小： %~z1  
Echo 扩展到驱动器号和路径：%~dp1 
Echo 扩展到文件名和扩展名：%~nx1 
Echo 扩展到类似 DIR  的输出行：%~ftza1 
Echo. 


::例2
::@echo off
::set aa=123456 
::set cmdstr=echo %aa% 
::call %cmdstr% 

pause