@echo off
::for /d %%variable IN (set) DO command [command-parameters]
::���������Ҫ����Ŀ¼����,���������ļ�,������������
for /d %%i in (f:\*) do echo %%i
::����һ�� ,��������Ҫ�ѵ�ǰ·�����ļ��е�����ֻ��1-3����ĸ�Ĵ����
for /d %%i in (???) do echo %%i
pause