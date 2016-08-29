#include <iostream>
using std::cout;
using std::endl;

class Clock
{
private:
	int hour,minute,second;
public:
	Clock(int newH,int newM,int newS);		//�������Ĺ��캯��
	Clock();								//���캯������
	~Clock(){};								//����������������Ϊ�ղ����������¡�
	void Showtime();
};

Clock::Clock()
{
	hour=0;minute=0;second=0;
}

Clock::Clock(int newH,int newM,int newS)
{
	hour=newH;
	minute=newM;
	second=newS;
}

inline void Clock::Showtime()
{
	cout<<"The time: "<<hour<<':'<<minute<<':'<<second<<endl;
}

void main()
{
	Clock myClock1(12,6,30);			//���ô������Ĺ��캯��
	myClock1.Showtime();
	Clock myClock2;						//���ò��������Ĺ��캯��
	myClock2.Showtime();
}