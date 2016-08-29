
#include <iostream>
#include <iomanip>
using std::cout;
using std::cin;
using std::endl;
using std::setw;

//����������
class Date{
private:
	unsigned short year;
	unsigned short month;
	unsigned short day;
public:
	Date(unsigned short y=0,						//���캯��
		unsigned short m=0,
		unsigned short d=0);
	Date(Date & p);									//���ƹ��캯��
	void setDate(unsigned short y=0,
		unsigned short m=0,
		unsigned short d=0);
	void showDate(){								//�����������
		cout<<setw(6)<<year
			<<'.'<<setw(2)<<month
			<<'.'<<setw(2)<<day<<endl;
	}
	~Date(){}
};

Date::Date(unsigned short y,				
		unsigned short m,
		unsigned short d){
	year=y;month=m;day=d;
}

Date::Date(Date & p){
	year = p.year;
	month = p.month;
	day = p.day;
}

inline void Date::setDate(unsigned short y,
		unsigned short m,
		unsigned short d){
	year=y;month=m;day=d;
}




//������Ա��
class Person{
private:
	unsigned num;					//���
	char sex;						//�Ա�
	Date date;						//����
	unsigned long id;				//���֤
public:
	Person(unsigned n,char s,Date d,unsigned long i);	//�����Ĺ��캯��
	Person(Person & P);									//�����ĸ��ƹ��캯��
	void Entry();
	void Show();
	~Person(){}
};
//�����Ĺ��캯��
Person::Person(unsigned n,char s,
			   Date d,unsigned long i=0)
			   :date(d){
	num=n;sex=s;id=i;
}
//�����ĸ��ƹ��캯��
Person::Person(Person & P):date(P.date){
	num = P.num;
	sex = P.sex;
	id = P.id;
}
//¼�뺯��
void Person::Entry(){
	int y,m,d;					//��Ϊ����ֱ��ʹ������������˽�г�Ա��������Ҫ�����������������
	cout<<"¼����Ա��������ʾ���룩"<<endl;
	cout<<"�������س���";
	cin>>num;
	cout<<"�Ա𣨻س���";
	cin>>sex;
//	cin>>y>>".">>m>>".">>d;		//������ô¼��
	cout<<"���գ��м��ÿո��������1994 8 16��Ȼ��س���\n";
	cin>>y>>m>>d;
	cout<<"���֤���س���";
	cin>>id;
	date.setDate(y,m,d);		//
}
//�������
inline void Person::Show(){
	cout<<"���:"<<setw(16)<<num<<endl;
	cout<<"�Ա�:"<<setw(16)<<sex<<endl;
	cout<<"��������:";
	date.showDate();
	cout<<"���֤��:"<<setw(12)<<id<<endl;
}
void main(){		
	Date D(1994,8,16);								//�������ڶ��� D
	Person P1(1,'G',D,2012060),P2(P1);				//����������Ա�����P1,P2
	P1.Show();										//��ʾP1,P2�����ݳ�Ա
	cout<<"���г�Ա"<<endl;
	P2.Show();
	D.setDate(2012,6,8);							//�������ڶ���D
	cout<<"\n\n�½���Ա"<<endl;
	Person P3(3,'M',D,2012007);						//������Ա���� P3
	P3.Entry();										//P3 ����¼��
	P3.Show();
}
