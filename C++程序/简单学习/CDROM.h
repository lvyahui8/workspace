#ifndef CDROM_H
#define CDROM_H
//光驱类
class CDROM{
private:
	unsigned short Tspeed;			//倍速  150KB/s标准单倍数
	unsigned short seektime;		//平均寻道时间 ms
	double voltage;					//电压 v
public:
	CDROM(unsigned short Tsp,unsigned short see);
	void Run(double vol);
	void Stop();
};
#endif//CDROM_H