@echo off
set a=0
if %a%<=%10% goto 0
if %a%>%10$ goto 1
:0
set a+=1
echo > %a%.txt
:1
exit
