#include<fstream.h>
#include<string.h>
#include<iomanip.h>

extern double managersalary=0;		//������
extern double pay=0;		//������Աÿ�¹���
extern double sale_man_percent=0;		//��ְ����Ա���
extern double sum_saleroom=0;	//�����ܶ�
extern double sale_managersalary=0;		//���۾�����
extern double manager_percent=0;			//���۾������
extern double tech_man_percent=0;          //������Ա���
extern int passwords=000000;
class person	//Ա����
{
protected:
	int number;			//���
	char name[20];		//����
	double salary;		//����
	int position;		//ְλ(1-����2-����Ա3-��ְ����Ա4-���۾���)
	person *next;		//����
public:
	person(int num,char *na)
	{
		number=num;
		strcpy(name,na);

	}
	virtual void calc_salary()=0;	//���㹤��
	virtual void print()=0;			//�����Ա��Ϣ
	friend class company;
};

class manager:public person		//������
{
public:
	manager(int num,char *na):person(num,na)
	{
		position=1;
	}
	void calc_salary()
	{
		salary=managersalary;
	}
	void print()
	{
		calc_salary();
		cout<<setw(5)<<number<<setw(10)<<name<<setw(15)
			<<"����"<<setw(5)<<salary<<endl;
	}
};

class tech_man:public person		//������Ա
{
private: double project_number;
public:
	tech_man(int num,char *na,double pn):person(num,na)
	{
		position=2;
		project_number=pn;
	}
	void set_project_number(double pn)
	{
		project_number=pn;
	}
	double get_project_number()
	{
		return project_number;
	}
	void calc_salary()
	{
		salary=pay+project_number*tech_man_percent/100;
	}
	void print()
	{
		calc_salary();
		cout<<setw(5)<<number<<setw(10)<<name<<setw(15)
			<<"������Ա"<<setw(5)<<salary<<setw(10)<<"�����Ŀ:"<<project_number<<endl;
	}
};

class sale_man:public person		//����Ա��
{
private:
	double saleroom;	//���۶�
public:
	sale_man(int num,char *na,double sal_room):person(num,na)
	{
		position=3;
		saleroom=sal_room;
	}
	void set_saleroom(double sal)
	{
		saleroom=sal;
	}
	double get_saleroom()
	{
		return saleroom;
	}
	void calc_salary()
	{
		salary=saleroom*sale_man_percent/100;
	}
	void print()
	{
		calc_salary();
		cout<<setw(5)<<number<<setw(10)<<name<<setw(15)
			<<"��ְ����Ա"<<setw(5)<<salary<<setw(10)<<"���۶�:"<<saleroom<<endl;
	}
};

class sale_manager:public person		//���۾�����
{

public:
	sale_manager(int num,char *na):person(num,na)
	{
		position=4;

	}
	void calc_salary()
	{
		salary=sale_managersalary+sum_saleroom*manager_percent/100;
	}
	void print()
	{
		calc_salary();
		cout<<setw(5)<<number<<setw(10)<<name<<setw(15)
			<<"���۾���"<<setw(5)<<salary<<setw(10)<<"�����ܶ�:"<<sum_saleroom<<endl;
	}
};