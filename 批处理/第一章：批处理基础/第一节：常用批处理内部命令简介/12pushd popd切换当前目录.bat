@echo off


::将当前目录换到e:\程序\批处理，在该目录建立MP3文件夹
e: & cd e:\程序\批处理 & md mp3 & echo 已建立MP3文件夹
::建立MP4文件夹
md mp4
::进入MP4文件夹，新建一个包含xx内容的11.MP4文件
cd mp4 & echo xx > 11.mp4
::保存当前目录，并切换到e:\程序\批处理\mp3文件夹
pushd e:\程序\批处理\mp3
::新建一个包含11内容的MP3.txt文件
echo 11 > mp3.txt
::恢复当前目录为先前保存的MP4文件夹
popd
::新建一个包含dfj内容的MP4.txt文件
echo dfj >MP4.txt



pause

