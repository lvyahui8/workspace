#include "Computer.h"
#include "CPU.h"
#include "RAM.h"
#include "CDROM.h"


extern enum CPU_Rank;

void main(){
	CPU myCPU((CPU_Rank)3,2300);	//CPU等级3，频率2300MHz
	RAM myRAM(1024,80);				//内存大小1024MB，速度 80ns
	CDROM myCDROM(60,85);			//倍速60，寻道时间85
	Computer myComputer(myCPU,myRAM,myCDROM);
	myComputer.Run(5);				//5V电压运行
	myComputer.Stop();
}
