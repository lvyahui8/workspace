#include <iostream>
using std::cout;
using std::endl;

enum CPU_Rank{P1=1,P2,P3,P4,P5,P6,P7};

class CPU{
private:
	const CPU_Rank rank;		//等级
	unsigned frequency;			//频率
	double voltage;				//电压
public:
	CPU(CPU_Rank ran,unsigned fre)
		:rank(ran),frequency(fre),voltage(0){}
	~CPU(){}
	void Run(double vol);
	void Stop();
};

void CPU::Run(double vol){
	voltage = vol;
	cout<<"-----runCPU----\nRank: "<<rank<<"\nFrequency: "<<frequency<<"MHz\nVoltage: "<<voltage<<"V\n---------------"<<endl;
}
void CPU::Stop(){
	voltage = 0;
}
void main(){
	CPU myCPU((CPU_Rank)3,2300);
	myCPU.Run(5);
}