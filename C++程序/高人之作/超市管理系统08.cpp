#include<iostream.h>
#include<fstream.h>
#include<ctype.h>
#include<stdlib.h>
#include<string.h>

int n=0;//����һ��ȫ�ֱ��� 

class Goods
{
protected:
	char number[30];              //������ 
	char name[20];                //��������
	float price;                  //��Ʒ����
	float incount;                //�������� 
	float outcount;               //�۳���Ŀ
    float recount;                //ʣ������Ŀ 
	Goods *next;
public:
	Goods(){}
	Goods(char *number,char *name,float price,float incount,float outcount,float recount)
	{
		strcpy(this->number,number);
        strcpy(this->name,name);
		this->price=price;
        this->incount=incount;
        this->outcount=outcount;
        this->recount=recount;
	}
	void Output()
	{
		cout<<"�����ţ�"<<number<<endl;
		cout<<"�������ƣ�"<<name<<endl;
		cout<<"���ﵥ�ۣ�"<<price<<endl;
		cout<<"����������"<<incount<<endl;
		cout<<"�۳���Ŀ��"<<outcount<<endl;
		cout<<"ʣ������Ŀ��"<<recount<<endl;
	}

	friend class Supermarket;
};

class Supermarket
{
private:
	Goods *goods;
   /* void Clear();  //����ڴ�������*/
public:
	Supermarket()
	{
		goods=NULL;
		Load();
	}
	~Supermarket()
	{
		Goods *p;
		p=goods;
        while(p)
        {
			p=p->next;
			delete goods;
			goods=p;
		}
		goods=NULL;
	}
	void Add();             //���� 

	void Delete();          //ɾ�� 

	void Modify();          //�޸� 

	void show();            //��� 

	void Query();           //��ѯ 

	void BubbleSort();      //����

	void up_count();        //����

	void Save();            //�������ݴ���

	void Load();            //��������װ�� 

	void Goodsswap(Goods *p1,Goods *p2);
};

/*void Supermarket::Clear()     //����ڴ�����Ʒ���ݣ��ڲ�ʹ�ã�
{ 
	Goods* p; 
	p=goods;
	while(p)
	{
		goods=p->next;
		delete p;
		p=goods;
	}
}*/

void Supermarket::Add()//����
{
	Goods *p;
	char number[30];
	char name[20];
    float price;                  
	float incount;
	float outcount;
    float recount;
	cout<<"\n����������������Ϣ��\n";
	cout<<"����������ţ�";cin>>number;cout<<endl;
	cout<<"������������ƣ�";cin>>name;cout<<endl;
	cout<<"��������ﵥ�ۣ�";cin>>price;cout<<endl;
	cout<<"���������������";cin>>incount;cout<<endl;
	cout<<"�������۳���Ŀ��";cin>>outcount;cout<<endl;
	cout<<"����������Ŀ��";cin>>recount;cout<<endl;

	//�����»�����
	p=new Goods(number,name,price,incount,outcount,recount);
	p->next=NULL;
	if(goods==NULL)
	{
		goods=p;
		n++;
	}	
	else
	{
		Goods *p2=goods;
		while(p2->next)
			p2=p2->next;
		p2->next=p;
		n++;
	}
}

void Supermarket::Delete()//ɾ��
{
	char name[20];
	cout<<"\n������Ҫɾ����������ƣ�\n";
	cin>>name;
	//����Ҫɾ������Ľ��
	Goods *p1,*p2;p1=goods;
	while(p1)
	{
		if(strcmp(p1->name,name)==0) break;
		else
		{
			p2=p1;
			p1=p1->next;
		}
	}
	//ɾ�����
	if(p1!=NULL)                   //���ҵ���㣬��ɾ��
	{
		if(p1==goods)             //��Ҫɾ���Ľ���ǵ�һ�����
		{
			goods=p1->next;
			delete p1;
			n--;
		}
		else                      //��Ҫɾ���Ľ���Ǻ������
		{
			p2->next=p1->next;
			delete p1;
			n--;
		}
		cout<<"�ҵ���ɾ��\n";
	}
	else                        //δ�ҵ����
		cout<<"Sorry,δ�ҵ�!\n";
}

void Supermarket::Modify()//�޸�
{ 
	char number[30];
	char name[20];
	float price;
	float incount;
	float outcount;
	float recount;
	cout<<"\n�޸Ļ��������Ҫ�޸Ļ�������ƣ�\n";
	cin>>name;
	//����Ҫ�޸ĵĽ��
	Goods *p1,*p2; 
	p1=goods;
	while(p1)
	{
		if(strcmp(p1->name,name)==0) break;
		else
		{
			p2=p1;
			p1=p1->next;
		}
	}
	//�޸Ľ��
	if(p2!=NULL)//�ҵ����
	{
		p1->Output();
		cout<<"1-�����ţ�2-�������ƣ�3-���ﵥ�ۣ�4-����������5-�۳���Ŀ��6-ʣ������Ŀ��7-�޸�ȫ����Ϣ\n"<<endl; 
		cout<<"������Ҫ�޸ĵ���Ϣ��ţ�\n";

		int a;cin>>a;
		switch(a)
		{
		case 1:cout<<"�������±�ţ�";cin>>number;
			strcpy(name,p1->name);price=p1->price;incount=p1->incount;outcount=p1->outcount;recount=p1->recount;break;

		case 2:cout<<"�����������ƣ�";cin>>name;
			strcpy(number,p1->number);price=p1->price;incount=p1->incount;outcount=p1->outcount;recount=p1->recount;break;

		case 3:cout<<"�������µ��ۣ�";cin>>price;
     	    strcpy(number,p1->number);strcpy(name,p1->name);incount=p1->incount;outcount=p1->outcount;recount=p1->recount;break;

		case 4:cout<<"�������½���������";cin>>incount;
			strcpy(number,p1->number);strcpy(name,p1->name);price=p1->price;outcount=p1->outcount;recount=p1->recount;break;

		case 5:cout<<"�������۳���Ŀ��";cin>>outcount;
			strcpy(number,p1->number);strcpy(name,p1->name);price=p1->price;incount=p1->incount;recount=p1->recount;break;

		case 6:cout<<"������ʣ������Ŀ��";cin>>recount;
			strcpy(number,p1->number);strcpy(name,p1->name);price=p1->price;incount=p1->incount;outcount=p1->outcount;break;

		case 7:cout<<"����������Ϣ ��\n";
			cout<<"�������±�ţ�";cin>>number; 
			cout<<"�����������ƣ�";cin>>name;
			cout<<"�������µ��ۣ�";cin>>price;
			cout<<"�������½���������";cin>>incount;
			cout<<"�������۳���Ŀ��";cin>>outcount;
			cout<<"������ʣ������Ŀ��";cin>>recount;
		}
			//�����»�����
			Goods *p3;
			p3=new Goods(number,name,price,incount,outcount,recount); 
			p3->next=p1->next;
			if(p1==goods)                      //��Ҫ�滻�Ľ���ǵ�һ�����
				goods=p3;
			else                               //��Ҫ�滻�Ľ���Ǻ������
				p2->next=p3;
			delete p1;                         //ɾ��ԭ���Ļ�����
			cout<<"�޸ĳɹ�!\n";		
	}
		else  //δ�ҵ����
		cout<<"Sorry,δ�ҵ�!\n";
}

void Supermarket::show()         //���
{
	Goods * p=goods;
	if(p!=NULL)
	{
		p->Output();
		p=p->next;
	}
}

void Supermarket::Query()       //��ѯ 
{
	cout<<"\n****��ѯ����****\n";
	char name[20];
	cout<<"\n������Ҫ��ѯ�Ļ������ƣ�\n";
	cin>>name;
	Goods *p1=goods;
	while(p1)
	{
		if(strcmp(p1->name,name)==0) break;
		else p1=p1->next;
	}
	if(p1!=NULL)          //���ҵ����
	{
		cout<<"\nҪ��ѯ����Ϣ���£�\n";
		cout<<"���������:\t"<<p1->number<<endl;
		cout<<"�����������:\t"<<p1->name<<endl;
		cout<<"������ﵥ��:\t"<<p1->price<<endl;
		cout<<"�����������:\t"<<p1->incount<<endl;
		cout<<"�����۳���Ŀ:\t"<<p1->outcount<<endl;
		cout<<"ʣ������Ŀ:\t"<<p1->recount/*(incount-outcount)*/<<endl;
	}
	else //δ�ҵ����
		cout<<"\nSorry,δ�ҵ��������!\n";  
}
void Supermarket::Goodsswap(Goods *p1,Goods *p2)
{
	Goods *p3;
	p3=new Goods;
	strcmp(p3->number,p2->number);

	strcmp(p3->name,p2->name);
	p3->price=p2->price;
	p3->incount=p2->incount;
	p3->outcount=p2->outcount;
	p3->recount=p2->recount;
	strcmp(p3->number,p2->number);

	strcmp(p2->name,p1->name);
	p3->price=p2->price;
	p2->incount=p1->incount;
	p2->outcount=p1->outcount;
	p2->recount=p1->recount;
	strcmp(p3->number,p2->number);

	strcmp(p1->name,p3->name);
	p3->price=p2->price;
	p1->incount=p3->incount;
	p1->outcount=p3->outcount;
	p1->recount=p3->recount;
	delete p3;
}

void Supermarket::BubbleSort(/*Goods *good,int n*/)//ð������ 
{
	if(goods==NULL)
	{
		cout<<"û�л��������";
		/*return 0;*/
	}
	Goods *p1,*p2;
	for(int w=1;w<=n;w++)
	{
		p1=goods;
		p2=goods->next;
		while(p2)
		{
			if(strcmp(p1->number,p2->number)>0)     //������  if(p1->number>p2->number) 
			{
				Goodsswap(p1,p2);
				p1=p1->next;
				p2=p2->next;
			}			
			else
			{
				p1=p1->next;
				p2=p2->next;
			}
		} 
	}
}

void Supermarket::up_count()//����
{
	char name[20];
	cout<<"\n������Ҫ����Ļ������ƣ�\n";
	cin>>name;
	Goods *p1=goods;
	while(p1)
	{
		if(strcmp(p1->name,name)==0) break;
		else p1=p1->next;
	}
	if(p1!=NULL)          //���ҵ����
	{
		int n;
		cout<<"�����빺���������";
		cin>>n;
		p1->recount=p1->recount+n;
	} 
	else 
	{
		cout<<"û���ҵ�����Ʒ";
	} 
}
	
void Supermarket:: Save()//���ݴ��� 
{
	cout<<"�Ƿ񱣴�[Y/N]";
	char a;
	cin>>a;
	if(a=='N'||a=='n')return;
	if(a=='Y'||a=='y')
	{
		ofstream outfile("base.txt",ios::out);
		if(!outfile)
		{
			cerr<<"open error!";exit(1);
		}
		Goods *p;p=goods;
		while(p)
		{
			outfile<<p->number<<' '<<p->name<<' '<<p->price<<' '<<p->incount<<' '<<p->outcount<<' '<<p->recount<<endl;
			p=p->next;
		}
		outfile.close();
		cout<<"��������ݱ���\n";
	} 
}
	
void Supermarket::Load()    //����װ��
{ 
	Goods *p=goods;
	ifstream infTemp("base.txt");//,ios::in|ios::nocreate
	
	//��һ����Ϣ
	
	
	while(infTemp.good())
	{  
		infTemp>>p->number>>p->name>>p->price>>p->incount>>p->outcount>>p->recount;
		//����������
		p=new Goods(p->number,p->name,p->price,p->incount,p->outcount,p->recount);
		p->next=NULL;
		//���������
		if(goods)       //���Ѵ��ڽ��
		{
			Goods*p2;
			p2=goods;
			while(p2->next)  //����β���				
				p2=p2->next;
			p2->next=p;     //����
			
		}
		else             //���
			goods=p;     //����
		
		//����һ����Ϣ
	}
	cout<<"\n���������Ѿ�װ��\n";
}

int main()
{ 
	system("color e1");
	system("title  ���й���ϵͳ     ���   ���");
	char c;
	Supermarket a;
	do
	{
		cout<<"\n���������������     ���й���ϵͳ    ����������������\n\n\n";
		cout<<"               1��¼�����        2��ɾ������       3���޸Ļ���\n\n";
		cout<<"               4���������        5����ѯ����       6���������\n\n";   
		cout<<"               7���������        8���������       9��װ�ػ���\n\n";
		cout<<"                                  0���˳�\n"; 
		cout<<" ������ѡ��ı��룺  "; 
		cin>>c;  
		/*system("cls");*/
		switch(c)
		{
		case '1':a.Add();break;           //¼�����
		case '2':a.Delete();break;        //ɾ������
		case '3':a.Modify();break;        //�޸Ļ���
		case '4':a.show();break;          //¼�����
		case '5':a.Query();break;         //��ѯ����
		case '6':a.BubbleSort();break;    //�������
		case '7':a.up_count();break;      //�������
		case '8':a.Save();break;          //�������
		case '9':a.Load();break;          //װ�ػ���
		}
	}while(c!='0');
	return 0;
}

		
		
		
		
		
		
		
