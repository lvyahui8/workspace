#include <iostream>
using std::cout;
using std::endl;
using std::cin;
//�࣬��װ�˸������ͬ���Լ��ϡ���ͬ��Ϊ���ϡ�������ָ�������Ժ���Ϊ�ĸ����Ա

class Student
{
private:					//˽�г�Ա
	int num;
	char name[10];
	char sex;
public:						//���г�Ա
	void Display1(int n=0,char * m=NULL,char s='O')			//�����Ա������ֱ�Ӷ������ඨ��֮�ڵ�
	{														//��������ʽ����Display1Ϊ��������
		num=n;
		strcpy(name,m);
		sex=s;
		cout<<"Num:"<<num<<endl;
		cout<<"Name:"<<name<<endl;
		cout<<"Sex:"<<sex<<endl;
	}
	void Enter();		//��Ա���� ��ԭ�����������ｫ���Ķ���������ඨ��֮��
	void Display2()
	{
		cout<<"Num:"<<num<<endl;
		cout<<"Name:"<<name<<endl;
		cout<<"Sex:"<<sex<<endl;
	}
	//������Ա�����Լ���Ա��������
	void ShowMe(char c);
	void ShowMe(int n,char * m,char s);

};

void Student::Enter()		//::�������������������޶����ĳ�Ա�������������Ϊ::����ǰ������������
{
	cin>>num>>name>>sex;
}

inline void Student::ShowMe(char c)		//��ʽ����ShowMeΪ��������
{
	cout<<num<<'\t'<<name<<'\t'<<sex<<c<<endl;
}

inline void Student::ShowMe(int n=0,char * m=NULL,char s='O')
{
	num=n;
	strcpy(name,m);
	sex=s;
	cout<<num<<'\t'<<name<<'\t'<<sex<<endl;
}

void main()
{
	Student stu1,stu2;		//�� Student �ඨ������������
	//���еĹ������ݳ�Ա�����÷���ṹ��������ƣ������ڴ�������ʱ���г�ʼ��������˽�г�Ա�ͱ�����Ա�������ٴ���ʱ��ʼ����
	//�������ڶ�����Ĺ����ж����ݳ�Ա���г�ʼ����C++�涨ֻ�����������֮����ܸ����ݳ�Ա����ֵ��
	
	stu1.Display1(201201,"dengjie",'G');
	stu2.Display1(201202,"lvyahui",'B');
//	stu1.Enter();
//	stu2.Enter();
	stu1.Display2();
	stu2.Display2();
	stu1.ShowMe('y');
	stu1.ShowMe(11010,"Dengjie",'G');
}