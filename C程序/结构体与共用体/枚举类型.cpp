#include <stdafx.h>

enum weekday {sun,mon,tue=1,wed,thu=4,fri,sat};
// 枚举常量，默认第一个为0 后面的在前面的基础上加1
void main(){
	enum weekday day;
	day=sun;
	printf("%d\n",day);
	day=wed;
	printf("%d\n",day);	
	day=(enum weekday)12;
	printf("%d\n",day);
}