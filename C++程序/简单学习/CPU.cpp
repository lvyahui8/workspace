#include <iostream>
#include "CPU.h"
using std::cout;
using std::endl;

CPU::CPU(CPU_Rank ran,unsigned fre)
		:rank(ran),frequency(fre),voltage(0){}
CPU::~CPU(){}

void CPU::Run(double vol){
	voltage = vol;
	cout<<"-----runCPU----\nRank: "<<rank
		<<"\nFrequency: "<<frequency<<"MHz\nVoltage: "<<voltage<<"V\n---------------"<<endl;
}
void CPU::Stop(){
	voltage = 0;
}

