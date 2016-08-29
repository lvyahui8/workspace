#ifndef CPU_H
#define CPU_H
enum CPU_Rank{P1=1,P2,P3,P4,P5,P6,P7};
//CPU��
class CPU{
private:
	const CPU_Rank rank;		//�ȼ�
	unsigned frequency;			//Ƶ��
	double voltage;				//��ѹ
public:
	CPU(CPU_Rank ran,unsigned fre);
	~CPU();
	void Run(double vol);		//����
	void Stop();
};
#endif//CPU_H