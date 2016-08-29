@echo off
echo 	#############################################
echo 	#########  The eclipse version   ############
echo 	#########   1.eclipse1.2         ############
echo 	#########   2.eclipse3.7         ############
echo 	#########   3.eclipse4.3         ############
echo 	#############################################
:RecVar
set /p var=Please Input:
if "%var%"=="" goto RecVar
if "%var%"=="1" echo 1.eclipse
if "%var%"=="2" echo 1.eclipse
if "%var%"=="3" echo 1.eclipse
pause