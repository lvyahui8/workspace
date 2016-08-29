#include <iostream>
#include "Computer.h"
using std::cout;
using std::endl;

Computer::Computer(CPU ncpu,RAM nram,CDROM ncdrom)
: cpu(ncpu),ram(nram),cdrom(ncdrom){cout<<"��װ�ɹ�"<<endl;}

Computer::~Computer(){}

void Computer::Run(double voltage){
	cout<<"runMyComputer>>>>>>>>>>>>>>>>>>>>>>>>"<<endl;
	cpu.Run(voltage);
	ram.Run(voltage);
	cdrom.Run(voltage);
}
void Computer::Stop(){
	cpu.Stop();
	ram.Stop();
	cdrom.Stop();
}