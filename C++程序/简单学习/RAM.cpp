#include <iostream>
#include "RAM.h"
using std::cout;
using std::endl;

RAM::RAM(const unsigned long siz,unsigned short spe):size(siz),speed(spe),voltage(0){}
void RAM::Stop(){
	voltage = 0;
}
void RAM::Run(double vol){
	voltage = vol;
	cout<<"-----runRAM----\nSize: "<<size
		<<"byte\nSpeed: "<<speed<<"ns\nVoltage: "<<voltage<<"V\n---------------"<<endl;
}