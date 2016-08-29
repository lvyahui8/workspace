#include<iostream>
#include<fstream>
#include<string>
using namespace std;
int n=0;//定义一个全局变量 
class Goods
{
private:
         int number;//货物编号 
         char name[20];//货物名称 
         int incount;//进货总数 
         int outcount;//售出数目 
         int recount;//剩余库存数目 
         Goods *Next;
public:
       Goods(int number,char *name,int incount,int outcount,int recount)
       {this->number=number;
        strcpy(this->name,name);
        this->incount=incount;
        this->outcount;
        this->recount=recount;}
        void Output()
        {cout<<"货物编号："<<number<<"货物名称："<<name<<"进货总数："<<incount<<"售出数目："
         <<outcount<<"剩余库存数目："<<recount<<endl;}
         friend class Supermarket;
}
class Supermarket
{private:
         Goods *goods;
 public:
        Supermarket()
        {goods=NULL;
          Load();}
        ~Supermarket()
        {Goods *p;
         p=goods;
        while(p)
        {p=p->next;
         delete goods;
         goods=p;
         }
         goods=NULL;
         }
        void Add();//增加 
        void Delete();//删除 
        void Modify();//修改 
        void show();//输出 
        void Query(); //查询 
        void BubbleSort();//排序
        void up_count();//购买
        void Save();//基础数据存盘
        void Load();//基础数据装入 
}

void Supermarket::Add()//增加
{       Goods *p;
         int number;
         char name[20];
         int incount;
         int outcount;
         int recount;
cout<<"\n请输入新增货物信息：\n";
cout<<"请输入货物编号：";cin>>number;cout<<endl;
cout<<"请输入货物名称：";cin>>name;cout<<endl;
cout<<"请输入进货总数：";cin>>incount;cout<<endl;
cout<<"请输入售出数目：";cin>>outcount;cout<<endl;
cout<<"请输入库存数目：";cin>>recount;cout<<endl;
//创建新货物结点
p=new Goods(number,name,incount,outcount,recount);
p->next=NULL;
if(goods==NULL)
{goods=p;
 n++;}

else
{Goods *p2=goods;
 while(p2->next)
 p2=p2->next;
 p2->next=p;
 n++;}
}

void Supermarket::Delete()//删除
{char name[20];
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
{        int number;
         char name[20];
         int incount;
         int outcount;
         int recount;
cout<<"\n修改货物，请输入要修改货物的名称：\n";
cin>>name;
//查找要修改的结点
  Goods *p1,*p2; p1=goods;
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
if(p!=NULL)//找到结点
{p1->Output();
 cout<<"\n请输入要修改的信息（1-货物编号，2-货物名称，3-进货总数，4-售出数目，5-剩余库存数目，6-修改全部信息）：\n"; 
 int a;cin>>a;
switch(a)
{case 1:cout<<"请输入新编号：";cin>>number; 
        strcpy(name,p1->name);incount=p1->incount;outcount=p1->outcount;recount=->recount;
 case 2:cout<<"请输入新名称：";cin>>name;
        number=p1->number;incount=p1->incount;outcount=p1->outcount;recount=p1->recount;
 case 3:cout<<"请输入新进货总数：";cin>>incount;
        number=p1->number;strcpy(name,p1->name);outcount=p1->outcount;recount=p1->recount;
 case 4:cout<<"请输入售出数目：";cin>>outcount;
        number=p1->number;strcpy(name,p1->name);incount=p1->incount;recount=p1->recount;
 case 5:cout<<"请输入剩余库存数目：";cin>>recount;
        number=p1->number;strpty(name,p1->name);incount=p1->incount;outcount=p1->outcount;
 case 6:cout<<"请输入新信息 ：\n";
        cout<<"请输入新编号：";cin>>number; 
        cout<<"请输入新名称：";cin>>name;
        cout<<"请输入新进货总数：";cin>>incount;
        cout<<"请输入售出数目：";cin>>outcount;
        cout<<"请输入剩余库存数目：";cin>>recount;
//创建新货物结点
   Goods *p3;
    p3=new Goods(num,name,incount,outcount,recount); 
      p3->next=p1->next;
      if(p1==goods)  //若要替换的结点是第一个结点
       goods=p3;
      else          //若要替换的结点是后续结点
        p2->next=p3;
      delete p1;   //删除原来的货物结点
      cout<<"修改成功!\n";
  }
  else  //未找到结点
    cout<<"Sorry,未找到!\n";
}

void Supermarket::show()//输出
{if(goods!=NULL)
 {goods->Output();
  goods=goods->next;}
}

void Supermarket::Query()//查询 
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
      cout<<"该类货物编号:\t"<<p1->number<<"\t"<<"该类货物名称:\t"<<p1->name<<"\t\n";
         cout<<"货物进口总数:\t"<<p1->incount<<"\t"<<"货物售出数目:\t"<<p1->outcount<<"\t\n";
         cout<<"剩余库存数目:\t"<<p1->recount<<"\t";
  }
  else //未找到结点
         cout<<"\nSorry,未找到该类货物!\n";  
}
void Goodsswap(Goods *p1,Goods *p2)
{Goods *p3;
 p3=new Goods;
 p3->number=p2->number;
 strcmp(p3->name,p2->name);
 p3->incount=p2->incount;
 p3->outcount=p2->outcount;
 p3->recount=p2->recount;
 p2->number=p1->number;
 strcmp(p2->name,p1->name);
 p2->incount=p1->incount;
 p2->outcount=p1->outcount;
 p2->recount=p1->recount;
 p1->number=p3->number;
 strcmp(p1->name,p3->name);
 p1->incount=p3->incount;
 p1->outcount=p3->outcount;
 p1->recount=p3->recount;
 delete p3;}
 
void Supermarket::BubbleSort(Goods *good,int n)//冒泡排序 
{if(goods==NULL) {cout<<"没有货物可排序";return 0;}
 Goods *p1,*p2;
 for(int w=1;w<=n;w++)
 {p1=goods;
  p2=goods->next;
  while(p2)
{if(p1->number>p2->number)
   {Goodsswap(p1,p2);
    p1=p1->next;
    p2=p2->next;}

else
{p1=p1->next;
 p2=p2->next;}
}
}
}

void Supermarket::up_count()//购买
{char name[20];
  cout<<"\n请输入要购买的货物名称：\n";
  cin>>name;
  Goods *p1=goods;
  while(p1)
  {
    if(strcmp(p1->name,name)==0) break;
    else p1=p1->next;
  }
  if(p1!=NULL)          //若找到结点
  {int n;
   cout<<"请输入购买的数量：";
   cin>>n;
   p1->recount=p1->recount+n;
   } 
else 
{cout<<"没有找到该商品";} 
 
void Supermarket:: Save()//数据存盘 
{cout<<"是否保存[Y/N]";
 char a;
 cin>>a;
 if(a=='N'||a=='n')return;
 if(a=='Y'||a=='y')
 {ofstream outfile("base.txt",ios::out);
  if(!outfile){cerr<<"open error!";exit(1);}
  Good *p;p=goods;
  while(p)
  {outfile<<"货物编号\t\t"<<p->number<<endl;
   outfile<<"货物名称\t\t"<<p->name<<endl;
   outfile<<"进货总数\t\t"<<p->incount<<endl;
   outfile<<"售出数目\t\t"<<p->outcount<<endl;
   outfile<<"剩余库数目\t\t"<<p->recount<<endl;
   cout<<endl;
   p=p->next;
   }
  outfile.close();
  cout<<"已完成数据保存\n";
} 

void Supermarket::Load()    //数据装入

{     Goods *p=goods;
      ifstream infile("base.txt",ios::in|ios::nocreate);

       //读一条信息

       infile>>p->number>>p->name>>p->incount>>p->outcount>>p->recount;
       while(infile.good())
       {     //创建货物结点
              p=new Goods(p->number,p->name,p->incount,p->outcount,p->recount);
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

        infile>>p->number>>p->name>>p->incount>>p->outcount>>p->recount;
       }
       cout<<"\n货物数据已经装入\n";
}

int main()
{ char c;
  Supermarket a;
  do
   { cout<<"\n****超市管理系统****\n";
     cout<<"    1—录入货物\n";
     cout<<"    2—删除货物\n"
     cout<<"    3—修改货物\n";
     cout<<"    4—输出货物\n";
     cout<<"    5—查询货物\n";
     cout<<"    6—排序货物\n";     
     cout<<"    7- 购买货物\n";
     cout<<"    8- 保存货物\n"; 
     cout<<"    9- 装载货物\n"; 
     cout<<"    0-退出\n"; 
     cin>>c;           
  switch(c)
  {case '1':a.Add();breeak;
   case '2':a.Delete();break;
   case '3':a.Modify();break;
   case '4':a.show();break;
   case '5':a.Query();break;
   case '6':a.BubbleSort();break;
   case '7':a.up_count();break;
   case '8':a.Save();break;
   case '9':a.Load();break;
  }
}while(c!='0')
return 0;
}
 







