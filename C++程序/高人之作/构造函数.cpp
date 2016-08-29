
#include<iostream>
using namespace std;


//�����װ��ʱ�ӵ����ݺ���Ϊ���ֱ��ΪClock������ݳ�Ա�ͺ�����Ա��
class Clock             //ʱ����Ķ���
{
public:                 //�ⲿ�ӿڣ����г�Ա������    �ⲿ�ӿڣ����Թ������������ʡ����á�
	Clock();  //���캯��
	Clock(const Clock& theClock){
		this->hour = theClock.hour;
		this->minute = theClock.minute;
		this->second = theClock.second;
	}
	void setTime(int newH,int newM,int newS);
	void showTime();
private:                 //˽�����ݳ�Ա
	int hour,minute,second;
};

Clock::Clock()
{
	hour=0;
	minute=0;
	second=0;
}
void Clock::setTime(int newH,int newM,int newS)
{
	hour=newH;
	minute=newM;
	second=newS;
}


inline void Clock::showTime()    //������Ա��������ʽ����
{
	cout<<hour<<":"<<minute<<":"<<second<<endl;
}

int main()
{
	Clock c;
	Clock newClock(c);
	Clock * pNewClock = &newClock;
	cout<<"First time set and output:"<<endl;
	c.showTime();        //��ʾʱ��
	cout<<"Second time set and output:"<<endl;
	c.setTime(8,30,30);   //����ʱ��Ϊ8:3:30
	return 0;
}
