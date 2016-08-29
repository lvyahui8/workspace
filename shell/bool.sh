#!/bin/sh

a="abc"
b="efg"

if [ $a = $b ]
then
	echo "$a = $b : a==b"
else
	echo "$a = $b : a!=b"
fi

if [ $a != $b ]
then
	echo "$a != $b : a != b"
else
	echo "$a != $b : a == b"
fi

if [ -z $a ]
then
	echo "-n $a : a.length != 0"
else
	echo "-n $a : a.length == 0"
fi

if [ $a ]
then
	echo "$a : str not empty"
else
	echo "$a : str empty"
fi

