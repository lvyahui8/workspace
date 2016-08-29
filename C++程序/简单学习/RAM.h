#ifndef RAM_H
#define RAM_H
// 内存类
class RAM{
private:
	const unsigned long size;		//大小 Mb
	unsigned short speed;			//速度 ns
	double voltage;					//电压 v
public:
	RAM(const unsigned long siz,unsigned short spe);
	void Run(double vol);
	void Stop();
};
#endif//RAM_H