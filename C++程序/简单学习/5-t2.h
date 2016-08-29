#include <iostream>
using std::cout;
using std::endl;

enum CPU_Rank{P1=1,P2,P3,P4,P5,P6,P7};
//CPU类
class CPU{
private:
	const CPU_Rank rank;				//等级
	unsigned frequency;			//频率
	double voltage;				//电压
public:
	CPU(CPU_Rank ran,unsigned fre)
		:rank(ran),frequency(fre),voltage(0){}
	~CPU(){}
	void Run(double vol);		//供电
	void Stop();
};
void CPU::Run(double vol){
	voltage = vol;
	cout<<"-----runCPU----\nRank: "<<rank
		<<"\nFrequency: "<<frequency<<"MHz\nVoltage: "<<voltage<<"V\n---------------"<<endl;
}
void CPU::Stop(){
	voltage = 0;
}
// 内存类
class RAM{
private:
	const unsigned long size;		//大小 Mb
	unsigned short speed;			//速度 ns
	double voltage;					//电压 v
public:
	RAM(const unsigned long siz,unsigned short spe):size(siz),speed(spe),voltage(0){}
	void Run(double vol);
	void Stop();
};
void RAM::Stop(){
	voltage = 0;
}
void RAM::Run(double vol){
	voltage = vol;
	cout<<"-----runRAM----\nSize: "<<size
		<<"byte\nSpeed: "<<speed<<"ns\nVoltage: "<<voltage<<"V\n---------------"<<endl;
}
//光驱类
class CDROM{
private:
	unsigned short Tspeed;			//倍速  150KB/s标准单倍数
	unsigned short seektime;		//平均寻道时间 ms
	double voltage;					//电压 v
public:
	CDROM(unsigned short Tsp,unsigned short see):Tspeed(Tsp),seektime(see),voltage(0){}
	void Run(double vol);
	void Stop();
};
void CDROM::Run(double vol){
	voltage = vol;
	cout<<"-----runCDROM----\nTSpeed: "<<Tspeed
		<<" * 150KB/s\nSeek time: "<<seektime<<"ms\nVoltage: "<<voltage<<"V\n---------------"<<endl;
}
void CDROM::Stop(){
	voltage = 0;
}

class Computer{
private:
	CPU cpu;		
	RAM ram;			
	CDROM cdrom;	
public:
	Computer(CPU ncpu,RAM nram,CDROM ncdrom);
	~Computer(){};
	void Run(double voltage);
	void Stop();
};

Computer::Computer(CPU ncpu,RAM nram,CDROM ncdrom)
: cpu(ncpu),ram(nram),cdrom(ncdrom){cout<<"组装成功"<<endl;}

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