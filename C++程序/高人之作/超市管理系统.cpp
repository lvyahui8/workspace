#include<iostream>
#include<fstream>
#include<string>
using namespace std;
int n=0;//����һ��ȫ�ֱ��� 
class Goods
{
private:
         int number;//������ 
         char name[20];//�������� 
         int incount;//�������� 
         int outcount;//�۳���Ŀ 
         int recount;//ʣ������Ŀ 
         Goods *Next;
public:
       Goods(int number,char *name,int incount,int outcount,int recount)
       {this->number=number;
        strcpy(this->name,name);
        this->incount=incount;
        this->outcount;
        this->recount=recount;}
        void Output()
        {cout<<"�����ţ�"<<number<<"�������ƣ�"<<name<<"����������"<<incount<<"�۳���Ŀ��"
         <<outcount<<"ʣ������Ŀ��"<<recount<<endl;}
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
        void Add();//���� 
        void Delete();//ɾ�� 
        void Modify();//�޸� 
        void show();//��� 
        void Query(); //��ѯ 
        void BubbleSort();//����
        void up_count();//����
        void Save();//�������ݴ���
        void Load();//��������װ�� 
}

void Supermarket::Add()//����
{       Goods *p;
         int number;
         char name[20];
         int incount;
         int outcount;
         int recount;
cout<<"\n����������������Ϣ��\n";
cout<<"����������ţ�";cin>>number;cout<<endl;
cout<<"������������ƣ�";cin>>name;cout<<endl;
cout<<"���������������";cin>>incount;cout<<endl;
cout<<"�������۳���Ŀ��";cin>>outcount;cout<<endl;
cout<<"����������Ŀ��";cin>>recount;cout<<endl;
//�����»�����
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

void Supermarket::Delete()//ɾ��
{char name[20];
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
{        int number;
         char name[20];
         int incount;
         int outcount;
         int recount;
cout<<"\n�޸Ļ��������Ҫ�޸Ļ�������ƣ�\n";
cin>>name;
//����Ҫ�޸ĵĽ��
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
//�޸Ľ��
if(p!=NULL)//�ҵ����
{p1->Output();
 cout<<"\n������Ҫ�޸ĵ���Ϣ��1-�����ţ�2-�������ƣ�3-����������4-�۳���Ŀ��5-ʣ������Ŀ��6-�޸�ȫ����Ϣ����\n"; 
 int a;cin>>a;
switch(a)
{case 1:cout<<"�������±�ţ�";cin>>number; 
        strcpy(name,p1->name);incount=p1->incount;outcount=p1->outcount;recount=->recount;
 case 2:cout<<"�����������ƣ�";cin>>name;
        number=p1->number;incount=p1->incount;outcount=p1->outcount;recount=p1->recount;
 case 3:cout<<"�������½���������";cin>>incount;
        number=p1->number;strcpy(name,p1->name);outcount=p1->outcount;recount=p1->recount;
 case 4:cout<<"�������۳���Ŀ��";cin>>outcount;
        number=p1->number;strcpy(name,p1->name);incount=p1->incount;recount=p1->recount;
 case 5:cout<<"������ʣ������Ŀ��";cin>>recount;
        number=p1->number;strpty(name,p1->name);incount=p1->incount;outcount=p1->outcount;
 case 6:cout<<"����������Ϣ ��\n";
        cout<<"�������±�ţ�";cin>>number; 
        cout<<"�����������ƣ�";cin>>name;
        cout<<"�������½���������";cin>>incount;
        cout<<"�������۳���Ŀ��";cin>>outcount;
        cout<<"������ʣ������Ŀ��";cin>>recount;
//�����»�����
   Goods *p3;
    p3=new Goods(num,name,incount,outcount,recount); 
      p3->next=p1->next;
      if(p1==goods)  //��Ҫ�滻�Ľ���ǵ�һ�����
       goods=p3;
      else          //��Ҫ�滻�Ľ���Ǻ������
        p2->next=p3;
      delete p1;   //ɾ��ԭ���Ļ�����
      cout<<"�޸ĳɹ�!\n";
  }
  else  //δ�ҵ����
    cout<<"Sorry,δ�ҵ�!\n";
}

void Supermarket::show()//���
{if(goods!=NULL)
 {goods->Output();
  goods=goods->next;}
}

void Supermarket::Query()//��ѯ 
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
      cout<<"���������:\t"<<p1->number<<"\t"<<"�����������:\t"<<p1->name<<"\t\n";
         cout<<"�����������:\t"<<p1->incount<<"\t"<<"�����۳���Ŀ:\t"<<p1->outcount<<"\t\n";
         cout<<"ʣ������Ŀ:\t"<<p1->recount<<"\t";
  }
  else //δ�ҵ����
         cout<<"\nSorry,δ�ҵ��������!\n";  
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
 
void Supermarket::BubbleSort(Goods *good,int n)//ð������ 
{if(goods==NULL) {cout<<"û�л��������";return 0;}
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

void Supermarket::up_count()//����
{char name[20];
  cout<<"\n������Ҫ����Ļ������ƣ�\n";
  cin>>name;
  Goods *p1=goods;
  while(p1)
  {
    if(strcmp(p1->name,name)==0) break;
    else p1=p1->next;
  }
  if(p1!=NULL)          //���ҵ����
  {int n;
   cout<<"�����빺���������";
   cin>>n;
   p1->recount=p1->recount+n;
   } 
else 
{cout<<"û���ҵ�����Ʒ";} 
 
void Supermarket:: Save()//���ݴ��� 
{cout<<"�Ƿ񱣴�[Y/N]";
 char a;
 cin>>a;
 if(a=='N'||a=='n')return;
 if(a=='Y'||a=='y')
 {ofstream outfile("base.txt",ios::out);
  if(!outfile){cerr<<"open error!";exit(1);}
  Good *p;p=goods;
  while(p)
  {outfile<<"������\t\t"<<p->number<<endl;
   outfile<<"��������\t\t"<<p->name<<endl;
   outfile<<"��������\t\t"<<p->incount<<endl;
   outfile<<"�۳���Ŀ\t\t"<<p->outcount<<endl;
   outfile<<"ʣ�����Ŀ\t\t"<<p->recount<<endl;
   cout<<endl;
   p=p->next;
   }
  outfile.close();
  cout<<"��������ݱ���\n";
} 

void Supermarket::Load()    //����װ��

{     Goods *p=goods;
      ifstream infile("base.txt",ios::in|ios::nocreate);

       //��һ����Ϣ

       infile>>p->number>>p->name>>p->incount>>p->outcount>>p->recount;
       while(infile.good())
       {     //����������
              p=new Goods(p->number,p->name,p->incount,p->outcount,p->recount);
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

        infile>>p->number>>p->name>>p->incount>>p->outcount>>p->recount;
       }
       cout<<"\n���������Ѿ�װ��\n";
}

int main()
{ char c;
  Supermarket a;
  do
   { cout<<"\n****���й���ϵͳ****\n";
     cout<<"    1��¼�����\n";
     cout<<"    2��ɾ������\n"
     cout<<"    3���޸Ļ���\n";
     cout<<"    4���������\n";
     cout<<"    5����ѯ����\n";
     cout<<"    6���������\n";     
     cout<<"    7- �������\n";
     cout<<"    8- �������\n"; 
     cout<<"    9- װ�ػ���\n"; 
     cout<<"    0-�˳�\n"; 
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
 







