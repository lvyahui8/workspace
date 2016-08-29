@echo off
for %%variable IN (set) DO command [command-parameters]
  %%variable 指定一个单字母表示可替换的参数
  （set） 指定一个或者一组文件。可以使用通配符
  command 指定对每个文件执行的命令
  command-parameters 为特定命令指定参数或命令行开关
 