#!/bin/sh

name="helloKey"
str="you are $name"
echo $str
echo ${#name}
echo ${name:1:4}
echo `expr index "$str" is`
