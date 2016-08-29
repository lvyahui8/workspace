#include<fstream.h>
#include<string.h>
#include<iomanip.h>

extern double managersalary=0;		//经理工资
extern double pay=0;		//技术人员每月工资
extern double sale_man_percent=0;		//兼职推销员提成
extern double sum_saleroom=0;	//销售总额
extern double sale_managersalary=0;		//销售经理工资
extern double manager_percent=0;			//销售经理提成
extern double tech_man_percent=0;          //技术人员提成
extern int passwords=000000;
class person	//员工类
{
protected:
	int number;			//编号
	char name[20];		//姓名
	double salary;		//工资
	int position;		//职位(1-经理2-技术员3-兼职销售员4-销售经理)
	person *next;		//链表
public:
	person(int num,char *na)
	{
		number=num;
		strcpy(name,na);

	}
	virtual void calc_salary()=0;	//计算工资
	virtual void print()=0;			//输出人员信息
	friend class company;
};

class manager:public person		//经理类
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
			<<"经理"<<setw(5)<<salary<<endl;
	}
};

class tech_man:public person		//技术人员
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
			<<"技术人员"<<setw(5)<<salary<<setw(10)<<"完成项目:"<<project_number<<endl;
	}
};

class sale_man:public person		//推销员类
{
private:
	double saleroom;	//销售额
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
			<<"兼职推销员"<<setw(5)<<salary<<setw(10)<<"销售额:"<<saleroom<<endl;
	}
};

class sale_manager:public person		//销售经理类
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
			<<"销售经理"<<setw(5)<<salary<<setw(10)<<"销售总额:"<<sum_saleroom<<endl;
	}
};