#include <iostream>
using std::cout;
using std::endl;
enum CPU_Rank{P1=1,P2,P3,P4,P5,P6,P7};

class CPU{
private:
	const CPU_Rank rank;				//�ȼ�
	unsigned frequency;			//Ƶ��
	double voltage;				//��ѹ
public:
	CPU(CPU_Rank ran,unsigned fre)
		:rank(ran),frequency(fre),voltage(0){}
	~CPU(){}
	void Run(double vol);
	friend void Stop();
};

void CPU::Run(double vol){
	voltage = vol;
	cout<<"-----runCPU----\nRank: "<<rank<<"\nFrequency: "<<frequency<<"MHz\nVoltage: "<<voltage<<"V\n---------------"<<endl;
}



class RAM{
private:
	const unsigned long size;		//��С byte
	unsigned short speed;			//�ٶ� ns
	double voltage;					//��ѹ v
public:
	void Run(double vol);
	friend void Stop();
};

void RAM::Run(double vol){
	voltage = vol;
	cout<<"-----runRAM----\nSize: "<<size<<"byte\nSpeed: "<<speed<<"ns\nVoltage: "<<voltage<<"V\n---------------"<<endl;
}

class Computer{
private:
	CPU cpu;		//��С byte
	RAM ram;			//�ٶ� ns
	CDROM cdrom;					//��ѹ v
public:
	void Run();
	friend void Stop();
};
void Stop(){
	voltage = 0;
}

void main(){
	CPU myCPU((CPU_Rank)3,2300);
	myCPU.Run(5);
}