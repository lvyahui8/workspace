#include <iostream>
#include "CDROM.h"
using std::cout;
using std::endl;
CDROM::CDROM(unsigned short Tsp,unsigned short see):Tspeed(Tsp),seektime(see),voltage(0){}

void CDROM::Run(double vol){
	voltage = vol;
	cout<<"-----runCDROM----\nTSpeed: "<<Tspeed
		<<" * 150KB/s\nSeek time: "<<seektime<<"ms\nVoltage: "<<voltage<<"V\n---------------"<<endl;
}
void CDROM::Stop(){
	voltage = 0;
}