#include<iostream.h>
#include<fstream.h>
#include<ctype.h>
#include<stdlib.h>
#include<string.h>

int n=0;//定义一个全局变量 

class Goods
{
protected:
	char number[30];              //货物编号 
	char name[20];                //货物名称
	float price;                  //商品单价
	float incount;                //进货总数 
	float outcount;               //售出数目
    float recount;                //剩余库存数目 
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
		cout<<"货物编号："<<number<<endl;
		cout<<"货物名称："<<name<<endl;
		cout<<"货物单价："<<price<<endl;
		cout<<"进货总数："<<incount<<endl;
		cout<<"售出数目："<<outcount<<endl;
		cout<<"剩余库存数目："<<recount<<endl;
	}

	friend class Supermarket;
};

class Supermarket
{
private:
	Goods *goods;
   /* void Clear();  //清除内存中数据*/
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
	void Add();             //增加 

	void Delete();          //删除 

	void Modify();          //修改 

	void show();            //输出 

	void Query();           //查询 

	void BubbleSort();      //排序

	void up_count();        //购买

	void Save();            //基础数据存盘

	void Load();            //基础数据装入 

	void Goodsswap(Goods *p1,Goods *p2);
};

/*void Supermarket::Clear()     //清除内存中商品数据（内部使用）
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

void Supermarket::Add()//增加
{
	Goods *p;
	char number[30];
	char name[20];
    float price;                  
	float incount;
	float outcount;
    float recount;
	cout<<"\n请输入新增货物信息：\n";
	cout<<"请输入货物编号：";cin>>number;cout<<endl;
	cout<<"请输入货物名称：";cin>>name;cout<<endl;
	cout<<"请输入货物单价：";cin>>price;cout<<endl;
	cout<<"请输入进货总数：";cin>>incount;cout<<endl;
	cout<<"请输入售出数目：";cin>>outcount;cout<<endl;
	cout<<"请输入库存数目：";cin>>recount;cout<<endl;

	//创建新货物结点
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

void Supermarket::Delete()//删除
{
	char name[20];
	cout<<"\n请输入要删除货物的名称：\n";
	cin>>name;
	//查找要删除货物的结点
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

void Supermarket::Modify()//修改
{ 
	char number[30];
	char name[20];
	float price;
	float incount;
	float outcount;
	float recount;
	cout<<"\n修改货物，请输入要修改货物的名称：\n";
	cin>>name;
	//查找要修改的结点
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
	//修改结点
	if(p2!=NULL)//找到结点
	{
		p1->Output();
		cout<<"1-货物编号，2-货物名称，3-货物单价，4-进货总数，5-售出数目，6-剩余库存数目，7-修改全部信息\n"<<endl; 
		cout<<"请输入要修改的信息编号：\n";

		int a;cin>>a;
		switch(a)
		{
		case 1:cout<<"请输入新编号：";cin>>number;
			strcpy(name,p1->name);price=p1->price;incount=p1->incount;outcount=p1->outcount;recount=p1->recount;break;

		case 2:cout<<"请输入新名称：";cin>>name;
			strcpy(number,p1->number);price=p1->price;incount=p1->incount;outcount=p1->outcount;recount=p1->recount;break;

		case 3:cout<<"请输入新单价：";cin>>price;
     	    strcpy(number,p1->number);strcpy(name,p1->name);incount=p1->incount;outcount=p1->outcount;recount=p1->recount;break;

		case 4:cout<<"请输入新进货总数：";cin>>incount;
			strcpy(number,p1->number);strcpy(name,p1->name);price=p1->price;outcount=p1->outcount;recount=p1->recount;break;

		case 5:cout<<"请输入售出数目：";cin>>outcount;
			strcpy(number,p1->number);strcpy(name,p1->name);price=p1->price;incount=p1->incount;recount=p1->recount;break;

		case 6:cout<<"请输入剩余库存数目：";cin>>recount;
			strcpy(number,p1->number);strcpy(name,p1->name);price=p1->price;incount=p1->incount;outcount=p1->outcount;break;

		case 7:cout<<"请输入新信息 ：\n";
			cout<<"请输入新编号：";cin>>number; 
			cout<<"请输入新名称：";cin>>name;
			cout<<"请输入新单价：";cin>>price;
			cout<<"请输入新进货总数：";cin>>incount;
			cout<<"请输入售出数目：";cin>>outcount;
			cout<<"请输入剩余库存数目：";cin>>recount;
		}
			//创建新货物结点
			Goods *p3;
			p3=new Goods(number,name,price,incount,outcount,recount); 
			p3->next=p1->next;
			if(p1==goods)                      //若要替换的结点是第一个结点
				goods=p3;
			else                               //若要替换的结点是后续结点
				p2->next=p3;
			delete p1;                         //删除原来的货物结点
			cout<<"修改成功!\n";		
	}
		else  //未找到结点
		cout<<"Sorry,未找到!\n";
}

void Supermarket::show()         //输出
{
	Goods * p=goods;
	if(p!=NULL)
	{
		p->Output();
		p=p->next;
	}
}

void Supermarket::Query()       //查询 
{
	cout<<"\n****查询货物****\n";
	char name[20];
	cout<<"\n请输入要查询的货物名称：\n";
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
		cout<<"该类货物编号:\t"<<p1->number<<endl;
		cout<<"该类货物名称:\t"<<p1->name<<endl;
		cout<<"该类货物单价:\t"<<p1->price<<endl;
		cout<<"货物进口总数:\t"<<p1->incount<<endl;
		cout<<"货物售出数目:\t"<<p1->outcount<<endl;
		cout<<"剩余库存数目:\t"<<p1->recount/*(incount-outcount)*/<<endl;
	}
	else //未找到结点
		cout<<"\nSorry,未找到该类货物!\n";  
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

void Supermarket::BubbleSort(/*Goods *good,int n*/)//冒泡排序 
{
	if(goods==NULL)
	{
		cout<<"没有货物可排序";
		/*return 0;*/
	}
	Goods *p1,*p2;
	for(int w=1;w<=n;w++)
	{
		p1=goods;
		p2=goods->next;
		while(p2)
		{
			if(strcmp(p1->number,p2->number)>0)     //有问题  if(p1->number>p2->number) 
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

void Supermarket::up_count()//购买
{
	char name[20];
	cout<<"\n请输入要购买的货物名称：\n";
	cin>>name;
	Goods *p1=goods;
	while(p1)
	{
		if(strcmp(p1->name,name)==0) break;
		else p1=p1->next;
	}
	if(p1!=NULL)          //若找到结点
	{
		int n;
		cout<<"请输入购买的数量：";
		cin>>n;
		p1->recount=p1->recount+n;
	} 
	else 
	{
		cout<<"没有找到该商品";
	} 
}
	
void Supermarket:: Save()//数据存盘 
{
	cout<<"是否保存[Y/N]";
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
		cout<<"已完成数据保存\n";
	} 
}
	
void Supermarket::Load()    //数据装入
{ 
	Goods *p=goods;
	ifstream infTemp("base.txt");//,ios::in|ios::nocreate
	
	//读一条信息
	
	
	while(infTemp.good())
	{  
		infTemp>>p->number>>p->name>>p->price>>p->incount>>p->outcount>>p->recount;
		//创建货物结点
		p=new Goods(p->number,p->name,p->price,p->incount,p->outcount,p->recount);
		p->next=NULL;
		//货物结点加入
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
	}
	cout<<"\n货物数据已经装入\n";
}

int main()
{ 
	system("color e1");
	system("title  超市管理系统     付瑜   李海庆");
	char c;
	Supermarket a;
	do
	{
		cout<<"\n★☆★☆★☆★☆★☆★☆★☆     超市管理系统    ★☆★☆★☆★☆★☆★☆★☆★\n\n\n";
		cout<<"               1—录入货物        2—删除货物       3—修改货物\n\n";
		cout<<"               4—输出货物        5—查询货物       6—排序货物\n\n";   
		cout<<"               7—购买货物        8—保存货物       9—装载货物\n\n";
		cout<<"                                  0—退出\n"; 
		cout<<" 请输入选项的编码：  "; 
		cin>>c;  
		/*system("cls");*/
		switch(c)
		{
		case '1':a.Add();break;           //录入货物
		case '2':a.Delete();break;        //删除货物
		case '3':a.Modify();break;        //修改货物
		case '4':a.show();break;          //录入货物
		case '5':a.Query();break;         //查询货物
		case '6':a.BubbleSort();break;    //排序货物
		case '7':a.up_count();break;      //购买货物
		case '8':a.Save();break;          //保存货物
		case '9':a.Load();break;          //装载货物
		}
	}while(c!='0');
	return 0;
}

		
		
		
		
		
		
		
