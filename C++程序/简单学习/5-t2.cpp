#include "Computer.h"
#include "CPU.h"
#include "RAM.h"
#include "CDROM.h"


extern enum CPU_Rank;

void main(){
	CPU myCPU((CPU_Rank)3,2300);	//CPU�ȼ�3��Ƶ��2300MHz
	RAM myRAM(1024,80);				//�ڴ��С1024MB���ٶ� 80ns
	CDROM myCDROM(60,85);			//����60��Ѱ��ʱ��85
	Computer myComputer(myCPU,myRAM,myCDROM);
	myComputer.Run(5);				//5V��ѹ����
	myComputer.Stop();
}
