#ifndef RAM_H
#define RAM_H
// �ڴ���
class RAM{
private:
	const unsigned long size;		//��С Mb
	unsigned short speed;			//�ٶ� ns
	double voltage;					//��ѹ v
public:
	RAM(const unsigned long siz,unsigned short spe);
	void Run(double vol);
	void Stop();
};
#endif//RAM_H