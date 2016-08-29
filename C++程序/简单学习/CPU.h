#ifndef CPU_H
#define CPU_H
enum CPU_Rank{P1=1,P2,P3,P4,P5,P6,P7};
//CPU类
class CPU{
private:
	const CPU_Rank rank;		//等级
	unsigned frequency;			//频率
	double voltage;				//电压
public:
	CPU(CPU_Rank ran,unsigned fre);
	~CPU();
	void Run(double vol);		//供电
	void Stop();
};
#endif//CPU_H