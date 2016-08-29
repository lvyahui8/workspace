#!/bin/bash

var=`expr 2 + 2`
echo "sum : $var"

a=10
b=20
var=`expr $a + $b`
echo "add : $var"

var=`expr $a - $b`
echo "sub : $var"

var=`expr $a \* $b`
echo "* : $var"

var=`expr $a / $b`
echo "/ : $var"

var=`expr $a % $b`
echo "% : $var"

if [ $a == $b ]
then
	echo "a == b"
fi

if [ $a != $b ]
then
	echo "a != b"
fi
