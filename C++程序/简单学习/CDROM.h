#ifndef CDROM_H
#define CDROM_H
//������
class CDROM{
private:
	unsigned short Tspeed;			//����  150KB/s��׼������
	unsigned short seektime;		//ƽ��Ѱ��ʱ�� ms
	double voltage;					//��ѹ v
public:
	CDROM(unsigned short Tsp,unsigned short see);
	void Run(double vol);
	void Stop();
};
#endif//CDROM_H