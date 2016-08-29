
#ifndef COMPUTER__H
#define COMPUTER__H

#include "CDROM.h"
#include "CPU.h"
#include "RAM.h"

class Computer{
private:
	CPU cpu;		
	RAM ram;			
	CDROM cdrom;	
public:
	Computer(CPU ncpu,RAM nram,CDROM ncdrom);
	~Computer();
	void Run(double voltage);
	void Stop();
};

#endif//COMPUTER__H