#include"person.h"	//编号数据
#include <iostream>
using std::ios_base;
class company		//公司类
{
private:
	person *head;//员工头节点
	int numdata;
public:
	company(void)
	{
		head=NULL;
		load();
	}
	void set();     //数据设置
	void add();     //增加人员
	void del();     //删除人员
	void modify();  //修改人员信息
	void search();  //查询人员信息
	void show();	//显示人员信息
	void save();    //保存人员信息
	void load();	//加载已保存的数据
};

void company::set()
{
	system("cls");
	cout<<"\n  **** 数据设置 ****\n";
	cout<<"经理工资(元):";
	cin>>managersalary; 
	cout<<"销售经理工资(元):";
	cin>>sale_managersalary;  
	cout<<"销售经理提成:";
	cin>>manager_percent; 
	cout<<"兼职推销员提成(n%):";
	cin>>sale_man_percent;
	cout<<"技术人员每项目提成:"; 
	cin>>tech_man_percent;
	cout<<"技术人员基本工资（月）：";
	cin>>pay;
}

void company::add()
{
	system("cls");
	person *p1,*p2;		//抽象类的指针
	char name[20];
	int position;
	double project_number;
	double saleroom;
	int numdata;
	cout<<"  **** 增加人员 ****\n";
	cout<<"输入人员信息:\n";
	cout<<"编号:";
	cin>>numdata;
	cout<<"姓名:";
	cin>>name;
	cout<<"输入职位(1-经理2-技术员3-兼职销售员4-销售经理):";
	cin>>position;
	if(position==2)
	{
		cout<<"工作项目为（个）:";
		cin>>project_number;
	}
	if(position==3)
	{
		cout<<"销售额(元):";
		cin>>saleroom;
		sum_saleroom+=saleroom;
	}
	switch(position)
	{
	case 1:p1=new manager(numdata,name);break;
	case 2:p1=new tech_man(numdata,name,project_number);break;
	case 3:p1=new sale_man(numdata,name,saleroom);break;
	case 4:p1=new sale_manager(numdata,name);break;
	}
	p1->next=NULL;
	if(head!=NULL)		//人员不为空
	{
		p2=head;
		while(p2->next!=NULL)	//找到尾节点
		{
			p2=p2->next;
		}
		p2->next=p1;
	}
	else     //人员为空
	{
		head=p1;
	}
	cout<<"增加人员成功！";
}

void company::del()
{
	system("cls");
	int number;
	int flag=1;
	int m;
	char name[20];
	person *p1,*p2;
	p1=head;
	cout<<"  **** 删除人员 ****\n";
	cout<<"<1-按编号删除 2-按姓名删除> 请选择:";
	cin>>m;
	if(m==1)	//按编号删除
	{
		while(flag)
		{
			cout<<"输入需要删除人员编号:";
			cin>>number;
			while(p1!=NULL)
			{
				if(p1->number!=number)
				{
					p2=p1;
					p1=p1->next;
				}
				else
					break;
			}
			break;
		}
	}
	else if(m==2)	//按姓名删除
	{
		while(flag)
		{
			cout<<"输入需要删除人员姓名:";
			cin>>name;
			while(p1!=NULL)
			{
				if(strcmp(p1->name,name)!=0)
				{
					p2=p1;
					p1=p1->next;
				}
				else
					break;
			}
			break;
		}
	}
	if(p1!=NULL)	//找到需要删除节点
	{
		if(p1->position==3)
			sum_saleroom-=((sale_man*)p1)->get_saleroom();
		if(p1==head)  //需要删除的节点是第一个节点
		{
			head=p1->next;
			delete p1;
		}
		else  //需要删除的节点不是第一个节点
		{
			p2->next=p1->next;
			delete p1;
		}
		cout<<"找到该人员并已删除！\n";
	}
	else  //未找到需要删除结点
	{
		cout<<"\a错误!请核对编号后重新输入:\n";
		flag=0;
	}
}

void company::modify()
{
	system("cls");
	int number;
	int position;
	int m;
	char name[20];
	double pn;
	double saleroom;
	int flag=1;
	person *p1,*p2,*p3;
	p1=head;
	cout<<"  **** 修改人员 ****\n";
	cout<<"<1-按编号修改 2-按姓名修改> 请选择:";
	cin>>m;
	if(m==1)	//按编号修改
	{
		while(flag)
		{
			cout<<"输入需要修改人员编号:";
			cin>>number;
			while(p1!=NULL)
			{
				if(p1->number!=number)
				{
					p2=p1;
					p1=p1->next;
				}
				else
					break;
			}
			break;
		}
	}
	else if(m==2)	//按姓名修改
	{
		while(flag)
		{
			cout<<"输入需要修改人员姓名:";
			cin>>name;
			while(p1!=NULL)
			{
				if(strcmp(p1->name,name)!=0)
				{
					p2=p1;
					p1=p1->next;
				}
				else
					break;
			}
			break;
		}
	}
	if(p1!=NULL)	//找到需要修改节点
	{
		cout<<"修改后人员职位(1-经理2-技术员3-兼职销售员4-销售经理):";
		cin>>position;
		if(p1->position==position)	//职位未改变
		{
			if(position==1||position==4)
			{
				cout<<"无可修改内容，请确认后重新选择！";
			}
			else if(position==2)
			{
				cout<<"修改工作项目为（个）:";
				cin>>pn;
				((tech_man*)p1)->set_project_number(pn);
			}
			else if(position==3)
			{
				cout<<"修改销售额为(元):";
				cin>>saleroom;
				sum_saleroom-=((sale_man*)p1)->get_saleroom();
				((sale_man*)p1)->set_saleroom(saleroom);
				sum_saleroom+=((sale_man*)p1)->get_saleroom();
				}
			cout<<"修改成功！";
		}
		else	//职位改变
		{
			if(p1->position==3)		//兼职销售员变为其他职位
				sum_saleroom-=((sale_man*)p1)->get_saleroom();
			if(position==2)
			{
				cout<<"工作项目为（个）:";
				cin>>pn;
			}
			if(position==3)
			{
				cout<<"销售额(元):";
				cin>>saleroom;
				sum_saleroom+=saleroom;
			}
			switch(position)
			{
			case 1:p3=new manager(p1->number,p1->name);break;
			case 2:p3=new tech_man(p1->number,p1->name,pn);break;
			case 3:p3=new sale_man(p1->number,p1->name,saleroom);break;
			case 4:p3=new sale_manager(p1->number,p1->name);break;
			}
			p3->next=p1->next;
			if(p1==head)   //若要修改的结点是第一个节点
				head=p3;
			else
				p2->next=p3;
			delete p1;		//删除原节点
			cout<<"修改成功！";
		}
	}
	else  //未找到需要修改节点
	{
		cout<<"\a错误!请核对编号后重新输入:\n";
		flag=0;
	}
}

void company::search()
{
	system("cls");
	int number;
	int m;
	int flag=1;
	char name [20];
	person *p1,*p2;
	p1=head;
	cout<<"  **** 查询人员信息 ****\n";
	cout<<"<1-按编号查询 2-按姓名查询> 请选择:";
	cin>>m;
	if(m==1)	//按编号查询
	{
		while(flag)
		{
			cout<<"输入需要查询人员编号:";
			cin>>number;
			while(p1!=NULL)
			{
				if(p1->number!=number)
				{
					p2=p1;
					p1=p1->next;
				}
				else
					break;
			}
			break;
		}
	}
	else if(m==2)	//按姓名查询
	{
		while(flag)
		{
			cout<<"输入需要查询人员姓名:";
			cin>>name;
			while(p1!=NULL)
			{
				if(strcmp(p1->name,name)!=0)
				{
					p2=p1;
					p1=p1->next;
				}
				else
					break;
			}
			break;
		}
	}
	if(p1!=NULL)
	{
		cout<<setw(5)<<"<编号>"<<setw(10)<<"<姓名>"<<setw(15)
			<<"<职位> "<<setw(5)<<"<工资>"<<setw(10)<<"<其他>"<<endl;
		p1->print();
	}
	else  //未找到需要查询节点
	{
		cout<<"\a错误!请核对编号后重新输入:\n";
		flag=0;
	}
}

void company::show()
{
	system("cls");
	person *p1;
	p1=head;
	cout<<"  **** 显示人员信息 ****\n";
	cout<<setw(5)<<"<编号>"<<setw(10)<<"<姓名>"<<setw(15)
		<<"<职位> "<<setw(5)<<"<工资>"<<setw(10)<<"<其他>"<<endl;
	while(p1!=NULL)
	{
		p1->print();
		p1=p1->next;
	}
}

void company::save()
{
	ofstream f;		//定义文件输出流对象
	person *p;
	p=head;
	f.open("company_person.txt");
	//存储工资信息
	f<<" "<<managersalary;
	f<<" "<<sale_managersalary;
	f<<" "<<manager_percent;
	f<<" "<<sale_man_percent;
	f<<" "<<tech_man_percent;
	f<<" "<<pay;
	f<<" "<<sum_saleroom;
	f<<endl;
	//存储人员信息
	while(p!=NULL)
	{
		f<<p->number<<" "<<p->name<<" "<<p->position<<" ";
		if(p->position==2)
			f<<((tech_man*)p)->get_project_number()<<" ";
		if(p->position==3)
			f<<((sale_man*)p)->get_saleroom()<<" ";
		f<<endl;
		p=p->next;
	}
	f.close();
	cout<<"保存成功！";
}

void company::load()
{
	ifstream f;
	person *p1,*p2;
	p1=head;
	int number;
	char name[20];
	int position;
	int pn;
	double saleroom;

	//加载工资数据

	f.open("company_person.txt");
	f>>managersalary;
	f>>sale_managersalary;
	f>>manager_percent;
	f>>sale_man_percent;
	f>>tech_man_percent;
	f>>pay;
	f>>sum_saleroom;

	//加载人员数据

	f>>number;
	f>>name;
	f>>position;
	if(position==2)
		f>>pn;
	if(position==3)
		f>>saleroom;
	if(position==4)
		f>>sum_saleroom;
	while(f)
	{
		switch(position)
		{
		case 1:p1=new manager(number,name);break;
		case 2:p1=new tech_man(number,name,pn);break;
		case 3:p1=new sale_man(number,name,saleroom);break;
		case 4:p1=new sale_manager(number,name);break;
		}
		p1->next=NULL;
		if(head!=NULL)		//人员不为空
		{
			p2=head;
			while(p2->next!=NULL)	//找到尾节点
			{
				p2=p2->next;
			}
			p2->next=p1;
		}
		else     //人员为空
		{
			head=p1;
		}
		f>>number;
		f>>name;
		f>>position;
		if(position==2)
			f>>pn;
		if(position==3)
			f>>saleroom;
		//if(position==4)
			//f>>sum_saleroom;
	}
	numdata=number;
	f.close();
}
