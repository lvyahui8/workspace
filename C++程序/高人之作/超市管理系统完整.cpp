#include<iostream.h>
#include<fstream.h>
#include<ctype.h>
#include<stdlib.h>
#include<string.h>
int n=0;                         //ȫ������,�������

class Goods
{
protected:
	char name[20];                //��Ʒ����
	double num;                   //��Ʒ����
	char address[30];             //��Ʒ����
	int price;                    //��Ʒ����
	double count;                 //������Ʒ�����
	Goods *next;       
public:
	Goods(double num,char*name,char*address,int price,double count)
	{
		this->num=num;
		strcpy(this->name,name);
		strcpy(this->address,address);
		this->price=price;
		this->count=count;
	}
	void Output()
	{
		cout<<"num:"<<num<<"  name:"<<name<<"  address:"<<address
			<<"  price:"<<price<<"  count:"<<count<<endl;
	}
	friend class Supermarket;
};

class Supermarket
{
private:
	Goods *goods;          //��Ʒ��
	void Clear();  //����ڴ�������
public:
	Supermarket()
	{
		goods=NULL;
		Load();
	}
	~Supermarket()
	{
		Goods*p;
		p=goods;
		while(p)
		{
			p=p->next;
			delete goods;
			goods=p;
		}
		goods=NULL;
	}
	void Add();                //������Ʒ
	void Delete();             //ɾ����Ʒ
	void Modify();             //�޸���Ʒ
	void Query();              //��ѯ��Ʒ
	void Add_up();             //ͳ����Ʒ
	void Save();               //�������ݴ���
	void Load();               //��������װ��
};

void Supermarket::Clear()     //����ڴ�����Ʒ���ݣ��ڲ�ʹ�ã�
{ 
	Goods* p; 
	p=goods;
	while(p)
	{
		goods=p->next;
		delete p;
		p=goods;
	}
}

void Supermarket::Add()  
{
	Goods *p;
	double num,count;
    char name[20],address[30];  
    int price;
	cout<<"\n������������Ʒ��Ϣ��\n";
    cout<<"��Ʒ����:";cin>>num;
    cout<<"��Ʒ����:";cin>>name;
    cout<<"��Ʒ����:";cin>>address;
    cout<<"��Ʒ����:";cin>>price;
    cout<<"����Ʒ�����:";cin>>count;
	//��������Ʒ����
	
	p=new Goods(num,name,address,price,count);
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
void Supermarket::Delete()     //ɾ����Ʒ
{
	char name[20];
	cout<<"\n������Ҫɾ������Ʒ����:\n";
	cin>>name;
	//����Ҫɾ���Ľ��
	Goods *p1,*p2;  p1=goods;
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
void Supermarket::Modify()     //�޸���Ʒ��Ϣ
{
	double num,count;
	char name[20],address[30];  
	int price;
	cout<<"\n �޸���Ʒ��������Ҫ�����Ʒ���ƣ�\n";
	cout<<"Name:";  cin>>name;
	
	//����Ҫ�޸ĵĽ��
	Goods *p1,*p2;  p1=goods;
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
	if(p1!=NULL)   //���ҵ����
	{
		p1->Output();
		cout<<"\n��ѡ��Ҫ�޸ĵ���Ϣ��1-��Ʒ���룬2-��Ʒ���ƣ�3-���أ�4-���ۣ�5-����Ʒ�������6-�޸�ȫ����Ϣ��:\n"; 
		int a; cin>>a;
		switch(a)
		{
		case 1:cout<<"�������´��룺"; cin>>num;
            strcpy(name,p1->name);strcpy(address,p1->address);price=p1->price;count=p1->count; break;
			
		case 2:cout<<"�����������ƣ�"; cin>>name;
            num=p1->num;strcpy(address,p1->address);price=p1->price;count=p1->count; break;
			
		case 3:cout<<"�������²��أ�"; cin>>address;
            num=p1->num;strcpy(name,p1->name);price=p1->price;count=p1->count; break;
			
		case 4:cout<<"�������µ��ۣ�"; cin>>price;
            num=p1->num;strcpy(name,p1->name);strcpy(address,p1->address);count=p1->count; break;
			
		case 5:cout<<"�������¿�����ݣ�"; cin>>count;
            num=p1->num;strcpy(name,p1->name);strcpy(address,p1->address);price=p1->price; break;
			
		case 6:cout<<"����������Ϣ��\n";
			cout<<"��Ʒ����:";     cin>>num;
			cout<<"��Ʒ����:";     cin>>name;
			cout<<"��Ʒ����:";     cin>>address;
			cout<<"��Ʒ����:";     cin>>price;
			cout<<"����Ʒ�����:"; cin>>count; break;
		}
		
		//��������Ʒ���
		Goods *p3;
		p3=new Goods(num,name,address,price,count); 
		//Ա������滻������
		p3->next=p1->next;
		if(p1==goods)  //��Ҫ�滻�Ľ���ǵ�һ�����
			goods=p3;
		else          //��Ҫ�滻�Ľ���Ǻ������
			p2->next=p3;
		delete p1;   //ɾ��ԭ������Ʒ���
		cout<<"�޸ĳɹ�!\n";
	}
	else  //δ�ҵ����
		cout<<"Sorry,δ�ҵ�!\n";
}
void Supermarket::Query()
{
	cout<<"\n****��ѯ��Ʒ****\n";
	char name[20];
	cout<<"\n������Ҫ��ѯ����Ʒ���ƣ�\n";
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
		cout<<"������Ʒ����:\t"<<p1->num<<"\t"<<"������Ʒ����:\t"<<p1->name<<"\t\n";
		cout<<"������Ʒ����:\t"<<p1->address<<"\t"<<"������Ʒ����:\t"<<p1->price<<"\t\n";
		cout<<"������Ʒ�����:\t"<<p1->count<<"\t";
	}
	else //δ�ҵ����
		cout<<"\nSorry,δ�ҵ�������Ʒ!\n";  
}

void Supermarket::Add_up()                  //ͳ�Ƴ�����Ʒ�������ڼ�ֵ
{
	cout<<"\n****��Ʒͳ��****\n";
	double Amount=0,Value=0;
	char name[20];
    cout<<"\n������Ҫͳ�Ƶ���Ʒ���ƣ�\n";
    cin>>name;
	Goods *p1;
	p1=goods;
	while(p1)
	{
		if(strcmp(p1->name,name)==0) break;
		else p1=p1->next;
	}
	if(p1)
	{
        while(p1)
        {
			Amount+=p1->count;
			Value+=p1->count*p1->price;
			p1=p1->next;
        }
        cout<<"��Ʒ�������ǣ�\n";
        cout<<Amount;
        cout<<"\n��Ʒ�ܼ�ֵ�ǣ�\n";
        cout<<Value;
	}
    else 
        cout<<"\nSorry,δ�ҵ�������Ʒ!\n"; 
}
void Supermarket::Save()                 //���ݴ���
{   
    cout<<"�Ƿ񱣴棿[Y/N]";
    char a;
    cin>>a;
    if(a=='n')return;
    if(a=='y'||a=='Y')		
	{		
		ofstream outfile("base.txt",ios::out);		
		if(!outfile)
		{cerr<<"open error!";exit(1);}		
		Goods* p;p=goods;		
		while(p)			
		{			
			outfile<<"��Ʒ����\t\t"<<p->num<<endl;			
			outfile<<"��Ʒ����\t\t"<<p->name<<endl;			
			outfile<<"��Ʒ����\t\t"<<p->address<<endl;			
			outfile<<"��Ʒ����\t\t"<<p->price<<endl;			
			outfile<<"����Ʒ�����\t"<<p->count<<endl;			
			cout<<endl;			
			p=p->next;			
		}
		outfile.close();		
		cout<<"��������ݵı���\n";		
	}
}      
void Supermarket::Load()    //����װ��
{	
	Goods *p=goods;	
	ifstream infile("base.txt",ios::in|ios::nocreate);	
	//��һ����Ϣ	
	infile>>p->num>>p->name>>p->address>>p->price>>p->count;	
	while(infile.good())		
	{
		//������Ʒ���		
		p=new Goods(p->num,p->name,p->address,p->price,p->count);		
		p->next=NULL;		
		//��Ʒ������		
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
        infile>>p->num>>p->name>>p->address>>p->price>>p->count;		
	}	
	cout<<"\n��Ʒ�����Ѿ�װ��\n";	
}
int main()
{	
	char c;	
	Supermarket a;	
	do{		
		cout<<"\n****���н��������ϵͳ****\n";		
		cout<<"    1-������Ʒ\n";		
		cout<<"    2-ɾ����Ʒ\n";		
		cout<<"    3-�޸���Ʒ\n";		
		cout<<"    4-��ѯ��Ʒ\n";		
		cout<<"    5-ͳ����Ʒ\n";		
		cout<<"    6-�˳�  \t ��ѡ��1-6��:";    		
		cin>>c;           		
        switch(c)			
		{			
		case '1':a.Add();			
			a.Save();break;			
		case '2':a.Load();			
			a.Delete();			
			a.Save();break;			
		case '3':a.Load();			
			a.Modify();			
			a.Save();break;			
		case '4':a.Load();			
			a.Query(); break;			
		case '5':a.Load();			
			a.Add_up();break;			
		}		
	}while(c!='6');
	return 0;
}
