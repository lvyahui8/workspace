#include <stdafx.h>

enum weekday {sun,mon,tue=1,wed,thu=4,fri,sat};
// ö�ٳ�����Ĭ�ϵ�һ��Ϊ0 �������ǰ��Ļ����ϼ�1
void main(){
	enum weekday day;
	day=sun;
	printf("%d\n",day);
	day=wed;
	printf("%d\n",day);	
	day=(enum weekday)12;
	printf("%d\n",day);
}