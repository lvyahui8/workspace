#!/bin/sh

file="/etc/hosts"

if [ -r $file ]
then
	echo "has read access"
else
	echo "don't has read access"
fi

if [ -w $file ]
then
	echo "has write access"
else
	echo "don't has write access"
fi

if [ -x $file ]
then
	echo "has exec permission"
else
	echo "don't has exec permission"
fi

if [ -d $file ]
then
	echo "this is dir"
else
	echo "this is not dir"
fi

if [ -s $file ]
then
	echo "file.size != 0"
else
	echo "file.size == 0"
fi

if [ -e $file ]
then
	echo "file exisits"
else
	echo "file don't exist"
fi
