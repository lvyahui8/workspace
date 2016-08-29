#include "CEmployee.h"

void main(){
	CEmployee aCEm[5]={
		CEmployee("AgrinZH","零陵区杨塘村","永州",425007),
		CEmployee("AgrinLV","零陵区黄姑山路","永州",425006),
		CEmployee("AgrinDE","零陵区城标","永州",425005),
		CEmployee("AgrinLT","零陵区神仙岭","永州",425000),
		CEmployee("AgrinLO","零陵区南门口","永州",425010)};
	for(int i=0;i<5;i++){
		aCEm[i].fnDisplay();
	}
}
