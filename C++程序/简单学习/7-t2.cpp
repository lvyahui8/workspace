#include "CEmployee.h"

void main(){
	CEmployee aCEm[5]={
		CEmployee("AgrinZH","������������","����",425007),
		CEmployee("AgrinLV","�������ƹ�ɽ·","����",425006),
		CEmployee("AgrinDE","�������Ǳ�","����",425005),
		CEmployee("AgrinLT","������������","����",425000),
		CEmployee("AgrinLO","���������ſ�","����",425010)};
	for(int i=0;i<5;i++){
		aCEm[i].fnDisplay();
	}
}
