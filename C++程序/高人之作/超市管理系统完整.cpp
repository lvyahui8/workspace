#include<iostream.h>
#include<fstream.h>
#include<ctype.h>
#include<stdlib.h>
#include<string.h>
int n=0;                         //全局数据,结点数量

class Goods
{
protected:
	char name[20];                //商品名称
	double num;                   //商品代码
	char address[30];             //商品产地
	int price;                    //商品单价
	double count;                 //该类商品库存量
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
	Goods *goods;          //商品表
	void Clear();  //清除内存中数据
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
	void Add();                //增加商品
	void Delete();             //删除商品
	void Modify();             //修改商品
	void Query();              //查询商品
	void Add_up();             //统计商品
	void Save();               //基础数据存盘
	void Load();               //基础数据装入
};

void Supermarket::Clear()     //清除内存中商品数据（内部使用）
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
	cout<<"\n请输入新增商品信息：\n";
    cout<<"商品代码:";cin>>num;
    cout<<"商品名称:";cin>>name;
    cout<<"商品产地:";cin>>address;
    cout<<"商品单价:";cin>>price;
    cout<<"该商品库存量:";cin>>count;
	//创建新商品类结点
	
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
void Supermarket::Delete()     //删除商品
{
	char name[20];
	cout<<"\n请输入要删除的商品名称:\n";
	cin>>name;
	//查找要删除的结点
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
	//删除结点
	if(p1!=NULL)                   //若找到结点，则删除
	{
		if(p1==goods)             //若要删除的结点是第一个结点
		{
			goods=p1->next;
			delete p1;
			n--;
		}
		else                      //若要删除的结点是后续结点
		{
			p2->next=p1->next;
			delete p1;
			n--;
		}
		cout<<"找到并删除\n";
	}
	else                        //未找到结点
		cout<<"Sorry,未找到!\n";
}
void Supermarket::Modify()     //修改商品信息
{
	double num,count;
	char name[20],address[30];  
	int price;
	cout<<"\n 修改商品，请输入要查的商品名称：\n";
	cout<<"Name:";  cin>>name;
	
	//查找要修改的结点
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
	//修改结点
	if(p1!=NULL)   //若找到结点
	{
		p1->Output();
		cout<<"\n请选择要修改的信息（1-商品代码，2-商品名称，3-产地，4-单价，5-该商品库存量，6-修改全部信息）:\n"; 
		int a; cin>>a;
		switch(a)
		{
		case 1:cout<<"请输入新代码："; cin>>num;
            strcpy(name,p1->name);strcpy(address,p1->address);price=p1->price;count=p1->count; break;
			
		case 2:cout<<"请输入新名称："; cin>>name;
            num=p1->num;strcpy(address,p1->address);price=p1->price;count=p1->count; break;
			
		case 3:cout<<"请输入新产地："; cin>>address;
            num=p1->num;strcpy(name,p1->name);price=p1->price;count=p1->count; break;
			
		case 4:cout<<"请输入新单价："; cin>>price;
            num=p1->num;strcpy(name,p1->name);strcpy(address,p1->address);count=p1->count; break;
			
		case 5:cout<<"请输入新库存数据："; cin>>count;
            num=p1->num;strcpy(name,p1->name);strcpy(address,p1->address);price=p1->price; break;
			
		case 6:cout<<"请输入新信息：\n";
			cout<<"商品代码:";     cin>>num;
			cout<<"商品名称:";     cin>>name;
			cout<<"商品产地:";     cin>>address;
			cout<<"商品单价:";     cin>>price;
			cout<<"该商品库存量:"; cin>>count; break;
		}
		
		//创建新商品结点
		Goods *p3;
		p3=new Goods(num,name,address,price,count); 
		//员工结点替换到链表
		p3->next=p1->next;
		if(p1==goods)  //若要替换的结点是第一个结点
			goods=p3;
		else          //若要替换的结点是后续结点
			p2->next=p3;
		delete p1;   //删除原来的商品结点
		cout<<"修改成功!\n";
	}
	else  //未找到结点
		cout<<"Sorry,未找到!\n";
}
void Supermarket::Query()
{
	cout<<"\n****查询商品****\n";
	char name[20];
	cout<<"\n请输入要查询的商品名称：\n";
	cin>>name;
	Goods *p1=goods;
	while(p1)
	{
		if(strcmp(p1->name,name)==0) break;
		else p1=p1->next;
	}
	if(p1!=NULL)          //若找到结点
	{
		cout<<"\n要查询的信息如下：\n";
		cout<<"该类商品代码:\t"<<p1->num<<"\t"<<"该类商品名称:\t"<<p1->name<<"\t\n";
		cout<<"该类商品产地:\t"<<p1->address<<"\t"<<"该类商品单价:\t"<<p1->price<<"\t\n";
		cout<<"该类商品库存量:\t"<<p1->count<<"\t";
	}
	else //未找到结点
		cout<<"\nSorry,未找到该类商品!\n";  
}

void Supermarket::Add_up()                  //统计超市商品总数量于价值
{
	cout<<"\n****商品统计****\n";
	double Amount=0,Value=0;
	char name[20];
    cout<<"\n请输入要统计的商品名称：\n";
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
        cout<<"商品总数量是：\n";
        cout<<Amount;
        cout<<"\n商品总价值是：\n";
        cout<<Value;
	}
    else 
        cout<<"\nSorry,未找到该类商品!\n"; 
}
void Supermarket::Save()                 //数据存盘
{   
    cout<<"是否保存？[Y/N]";
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
			outfile<<"商品代码\t\t"<<p->num<<endl;			
			outfile<<"商品名称\t\t"<<p->name<<endl;			
			outfile<<"商品产地\t\t"<<p->address<<endl;			
			outfile<<"商品单价\t\t"<<p->price<<endl;			
			outfile<<"该商品库存量\t"<<p->count<<endl;			
			cout<<endl;			
			p=p->next;			
		}
		outfile.close();		
		cout<<"已完成数据的保存\n";		
	}
}      
void Supermarket::Load()    //数据装入
{	
	Goods *p=goods;	
	ifstream infile("base.txt",ios::in|ios::nocreate);	
	//读一条信息	
	infile>>p->num>>p->name>>p->address>>p->price>>p->count;	
	while(infile.good())		
	{
		//创建商品结点		
		p=new Goods(p->num,p->name,p->address,p->price,p->count);		
		p->next=NULL;		
		//商品结点加入		
		if(goods)       //若已存在结点			
		{			
			Goods*p2;			
			p2=goods;			
			while(p2->next)  //查找尾结点				
				p2=p2->next;			
			p2->next=p;     //连接			
		}		
		else             //表空			
			goods=p;     //连接		
		//读下一条信息		
        infile>>p->num>>p->name>>p->address>>p->price>>p->count;		
	}	
	cout<<"\n商品数据已经装入\n";	
}
int main()
{	
	char c;	
	Supermarket a;	
	do{		
		cout<<"\n****超市进销存管理系统****\n";		
		cout<<"    1-增加商品\n";		
		cout<<"    2-删除商品\n";		
		cout<<"    3-修改商品\n";		
		cout<<"    4-查询商品\n";		
		cout<<"    5-统计商品\n";		
		cout<<"    6-退出  \t 请选择（1-6）:";    		
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
