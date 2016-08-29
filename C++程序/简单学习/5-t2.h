#include <iostream>
using std::cout;
using std::endl;

enum CPU_Rank{P1=1,P2,P3,P4,P5,P6,P7};
//CPU��
class CPU{
private:
	const CPU_Rank rank;				//�ȼ�
	unsigned frequency;			//Ƶ��
	double voltage;				//��ѹ
public:
	CPU(CPU_Rank ran,unsigned fre)
		:rank(ran),frequency(fre),voltage(0){}
	~CPU(){}
	void Run(double vol);		//����
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
// �ڴ���
class RAM{
private:
	const unsigned long size;		//��С Mb
	unsigned short speed;			//�ٶ� ns
	double voltage;					//��ѹ v
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
//������
class CDROM{
private:
	unsigned short Tspeed;			//����  150KB/s��׼������
	unsigned short seektime;		//ƽ��Ѱ��ʱ�� ms
	double voltage;					//��ѹ v
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
: cpu(ncpu),ram(nram),cdrom(ncdrom){cout<<"��װ�ɹ�"<<endl;}

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