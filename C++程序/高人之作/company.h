#include"person.h"	//�������
#include <iostream>
using std::ios_base;
class company		//��˾��
{
private:
	person *head;//Ա��ͷ�ڵ�
	int numdata;
public:
	company(void)
	{
		head=NULL;
		load();
	}
	void set();     //��������
	void add();     //������Ա
	void del();     //ɾ����Ա
	void modify();  //�޸���Ա��Ϣ
	void search();  //��ѯ��Ա��Ϣ
	void show();	//��ʾ��Ա��Ϣ
	void save();    //������Ա��Ϣ
	void load();	//�����ѱ��������
};

void company::set()
{
	system("cls");
	cout<<"\n  **** �������� ****\n";
	cout<<"������(Ԫ):";
	cin>>managersalary; 
	cout<<"���۾�����(Ԫ):";
	cin>>sale_managersalary;  
	cout<<"���۾������:";
	cin>>manager_percent; 
	cout<<"��ְ����Ա���(n%):";
	cin>>sale_man_percent;
	cout<<"������Աÿ��Ŀ���:"; 
	cin>>tech_man_percent;
	cout<<"������Ա�������ʣ��£���";
	cin>>pay;
}

void company::add()
{
	system("cls");
	person *p1,*p2;		//�������ָ��
	char name[20];
	int position;
	double project_number;
	double saleroom;
	int numdata;
	cout<<"  **** ������Ա ****\n";
	cout<<"������Ա��Ϣ:\n";
	cout<<"���:";
	cin>>numdata;
	cout<<"����:";
	cin>>name;
	cout<<"����ְλ(1-����2-����Ա3-��ְ����Ա4-���۾���):";
	cin>>position;
	if(position==2)
	{
		cout<<"������ĿΪ������:";
		cin>>project_number;
	}
	if(position==3)
	{
		cout<<"���۶�(Ԫ):";
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
	if(head!=NULL)		//��Ա��Ϊ��
	{
		p2=head;
		while(p2->next!=NULL)	//�ҵ�β�ڵ�
		{
			p2=p2->next;
		}
		p2->next=p1;
	}
	else     //��ԱΪ��
	{
		head=p1;
	}
	cout<<"������Ա�ɹ���";
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
	cout<<"  **** ɾ����Ա ****\n";
	cout<<"<1-�����ɾ�� 2-������ɾ��> ��ѡ��:";
	cin>>m;
	if(m==1)	//�����ɾ��
	{
		while(flag)
		{
			cout<<"������Ҫɾ����Ա���:";
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
	else if(m==2)	//������ɾ��
	{
		while(flag)
		{
			cout<<"������Ҫɾ����Ա����:";
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
	if(p1!=NULL)	//�ҵ���Ҫɾ���ڵ�
	{
		if(p1->position==3)
			sum_saleroom-=((sale_man*)p1)->get_saleroom();
		if(p1==head)  //��Ҫɾ���Ľڵ��ǵ�һ���ڵ�
		{
			head=p1->next;
			delete p1;
		}
		else  //��Ҫɾ���Ľڵ㲻�ǵ�һ���ڵ�
		{
			p2->next=p1->next;
			delete p1;
		}
		cout<<"�ҵ�����Ա����ɾ����\n";
	}
	else  //δ�ҵ���Ҫɾ�����
	{
		cout<<"\a����!��˶Ա�ź���������:\n";
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
	cout<<"  **** �޸���Ա ****\n";
	cout<<"<1-������޸� 2-�������޸�> ��ѡ��:";
	cin>>m;
	if(m==1)	//������޸�
	{
		while(flag)
		{
			cout<<"������Ҫ�޸���Ա���:";
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
	else if(m==2)	//�������޸�
	{
		while(flag)
		{
			cout<<"������Ҫ�޸���Ա����:";
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
	if(p1!=NULL)	//�ҵ���Ҫ�޸Ľڵ�
	{
		cout<<"�޸ĺ���Աְλ(1-����2-����Ա3-��ְ����Ա4-���۾���):";
		cin>>position;
		if(p1->position==position)	//ְλδ�ı�
		{
			if(position==1||position==4)
			{
				cout<<"�޿��޸����ݣ���ȷ�Ϻ�����ѡ��";
			}
			else if(position==2)
			{
				cout<<"�޸Ĺ�����ĿΪ������:";
				cin>>pn;
				((tech_man*)p1)->set_project_number(pn);
			}
			else if(position==3)
			{
				cout<<"�޸����۶�Ϊ(Ԫ):";
				cin>>saleroom;
				sum_saleroom-=((sale_man*)p1)->get_saleroom();
				((sale_man*)p1)->set_saleroom(saleroom);
				sum_saleroom+=((sale_man*)p1)->get_saleroom();
				}
			cout<<"�޸ĳɹ���";
		}
		else	//ְλ�ı�
		{
			if(p1->position==3)		//��ְ����Ա��Ϊ����ְλ
				sum_saleroom-=((sale_man*)p1)->get_saleroom();
			if(position==2)
			{
				cout<<"������ĿΪ������:";
				cin>>pn;
			}
			if(position==3)
			{
				cout<<"���۶�(Ԫ):";
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
			if(p1==head)   //��Ҫ�޸ĵĽ���ǵ�һ���ڵ�
				head=p3;
			else
				p2->next=p3;
			delete p1;		//ɾ��ԭ�ڵ�
			cout<<"�޸ĳɹ���";
		}
	}
	else  //δ�ҵ���Ҫ�޸Ľڵ�
	{
		cout<<"\a����!��˶Ա�ź���������:\n";
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
	cout<<"  **** ��ѯ��Ա��Ϣ ****\n";
	cout<<"<1-����Ų�ѯ 2-��������ѯ> ��ѡ��:";
	cin>>m;
	if(m==1)	//����Ų�ѯ
	{
		while(flag)
		{
			cout<<"������Ҫ��ѯ��Ա���:";
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
	else if(m==2)	//��������ѯ
	{
		while(flag)
		{
			cout<<"������Ҫ��ѯ��Ա����:";
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
		cout<<setw(5)<<"<���>"<<setw(10)<<"<����>"<<setw(15)
			<<"<ְλ> "<<setw(5)<<"<����>"<<setw(10)<<"<����>"<<endl;
		p1->print();
	}
	else  //δ�ҵ���Ҫ��ѯ�ڵ�
	{
		cout<<"\a����!��˶Ա�ź���������:\n";
		flag=0;
	}
}

void company::show()
{
	system("cls");
	person *p1;
	p1=head;
	cout<<"  **** ��ʾ��Ա��Ϣ ****\n";
	cout<<setw(5)<<"<���>"<<setw(10)<<"<����>"<<setw(15)
		<<"<ְλ> "<<setw(5)<<"<����>"<<setw(10)<<"<����>"<<endl;
	while(p1!=NULL)
	{
		p1->print();
		p1=p1->next;
	}
}

void company::save()
{
	ofstream f;		//�����ļ����������
	person *p;
	p=head;
	f.open("company_person.txt");
	//�洢������Ϣ
	f<<" "<<managersalary;
	f<<" "<<sale_managersalary;
	f<<" "<<manager_percent;
	f<<" "<<sale_man_percent;
	f<<" "<<tech_man_percent;
	f<<" "<<pay;
	f<<" "<<sum_saleroom;
	f<<endl;
	//�洢��Ա��Ϣ
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
	cout<<"����ɹ���";
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

	//���ع�������

	f.open("company_person.txt");
	f>>managersalary;
	f>>sale_managersalary;
	f>>manager_percent;
	f>>sale_man_percent;
	f>>tech_man_percent;
	f>>pay;
	f>>sum_saleroom;

	//������Ա����

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
		if(head!=NULL)		//��Ա��Ϊ��
		{
			p2=head;
			while(p2->next!=NULL)	//�ҵ�β�ڵ�
			{
				p2=p2->next;
			}
			p2->next=p1;
		}
		else     //��ԱΪ��
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
