/*
1. ����һ�� Employee�࣬���а����������ֵ���ַ�����к��ʱ�����ԣ��Լ� 
change_name() �� display() �Ⱥ����� display() ��ʾ�������ֵ���ַ������
���ʱ�����ԣ� change_name() �ı������������ԡ�ʵ�ֲ���������ࡣ
*/
#include "CEmployee.h"

void main(){
	CEmployee fineEmp1;
	CEmployee fineEmp2("AgrinDJ","����","����",0);
	CEmployee fineEmp3;

	fineEmp3 = fineEmp2;
	fineEmp1.fnChange_Name("AgrinLv");

	fineEmp1.fnDisplay();
	fineEmp2.fnDisplay();
	fineEmp3.fnDisplay();
}
