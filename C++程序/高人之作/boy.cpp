#include<iostream>
#include<string>
#include<stdlib.h>
/*
������ܣ�
����һ���������й��ε�׷��ɧ�꣬Ϊ��Ѱ��pure love and truth�������ˡ���ש��ѧ������˵����ľ�ҵ��һֱ��100%������ש!
������ש�Ҿͱ������㣬����ש�Ҿ��������㣡��
��ש�ɣ�ɧ�꣡
�����������������

  ֱ������Ϊ�ȼ�3��������ǿ�-������ָ-������ɱ�������ڱǿף�
  ���飺
  �������1.��дѧ������ϵͳ�������ļ���
  �ȼ�������У����-��ʳʺ
  �������Σ����ʣ��������ιӥ��-��������ʦ����дѧ������������2��
  -���������Σ�������ݺݵس����ӹ������������ˣ������Ѿ���У���칫�ң�������3����-��У�����ٻ�ʳʺ�ޣ�ʹ�ó���ɱ��-������n�꣬���ڱ�ҵ����óɾ͡���ש�����ʹ������
  You:
  ���ܣ�����ǿ�
  �ȼ���1
  
	ÿ���ѡ���У�1.˯��2.�ϿΣ�Ϊ��������3.����4.��У��������3���ͳ�ʺ��������
	
	  ���ࣺ
	  ����
	  �Ա�
	  �Ը�
	  
		�����ࣺ���������Σ�
		
		  �����ࣺ��������ʦ��
		  
			�����ࣺ��У����
�ر����ԣ��ٻ�ʳʺ�ޣ�ͳͳ���ҳ�ʺ�ɣ�*/
using namespace std;

int n=1;
void ch1();
char ch;

class Teather//��ʦ
{
public:
	void set(string name1,string sex1,string charming1)
	{
		name=name1;
		sex=sex1;
		charming=charming1;
	}
	void show_T()
	{
		cout<<name<<endl;
		cout<<"�Ա�"<<sex<<endl;
		cout<<"�Ը�"<<charming<<endl;			
	}
private:
	string name;
	string sex;
	string charming;
};
class Teather_Father:public Teather//��������
{
public:
	void X()
	{
		cout<<"�������ιӥ�Ĺ�����������ţ�"<<endl;
		
		cout<<"��ķ�Ӧ�� 1.ʹ�ü���ȥս���� 2.�ش�"<<endl;
		while((ch = getchar())!= '\n');
		
	}
	
};
class You//ɧ��
{
public:
	You(string energy1="",int rate1=1)
	{
		
		energy=energy1;
		rate=rate1;
	}
	void show()
	{
		cout<<"You"<<endl;
		cout<<"���ܣ�"<<energy<<endl;
		cout<<"�ȼ���"<<rate<<endl;
	}
	
	
	void showRate()//��ʾ����
	{
		cout<<rate;
	}
	void setRate()//����
	{
		rate++;
		cout<<"�����ˣ�";
	}
private:
	string energy;
	int rate;
};
You you;
Teather_Father f;	


void sleep()//˯��
{
	if(n%2 ==0)
		cout<<"��һ�챻���˯�ˡ���"<<endl;
	else
		cout<<"��ĩ�ֵ��ˣ���Һã�������ĩ����ף�����ĩ��죡"<<endl;
	
	n++;
	while((ch = getchar())!= '\n'); 
	ch1();	
	
}



void lesson()//�Ͽ�
{
	
	system("cls");
	f.set("��������","��","����׽��������û��������������������ò����Ϊһ������������ζ�š�������Ҫ�����ˡ�");
	f.show_T();
	f.X();
	
	
	n++;
	while((ch = getchar())!= '\n');
	ch1();	
	
}
void gril()//����
{
	if(n%2 ==0)
		cout<<"o(>_<)o��ή�ˡ����۷�����"<<endl;
	else 
	{
		cout<<"�ſ��Ǹ�Ů����"<<endl;
		cout<<"�������ƣ�"<<endl;
		cout<<"һ��ɵ�ӣ�һ���ưͣ������ҳ�ʺȥ�ɣ�"<<endl;
	}
	n++;
	while((ch = getchar())!= '\n');
	ch1();
}
void president()//��У��
{
	
	n++;
	while((ch = getchar())!= '\n');
	ch1();
}
void ch1()
{
	int i;
	system("cls");
	cout<<"��"<<n<<"���ѡ���У�"<<endl;
	cout<<"1.˯��"<<endl<<"2.�Ͽ�"<<endl<<"3.����"<<endl<<"4.��У��"<<endl;
	cin>>i;
	while((ch = getchar())!= '\n');
	switch(i)
	{
	case 1:sleep();
	case 2:lesson();
	case 3:gril();
	case 4:president();
	}
	
}

void main()
{
	int i;
	
	
	system("cls");
	system("color 4f");
	for(i=0;i<20;i++)
		cout<<"****";
	cout<<"\t\t\t������ܣ�    \n";
	cout<<"����һ���������й��ε�׷��ɧ�꣬Ϊ��Ѱ��pure love and truth�������ˡ���ש��ѧ������˵����ľ�ҵ��һֱ��100%������ש!"<<endl;
	cout<<"	����ש�Ҿͱ������㣬����ש�Ҿ��������㣡"<<endl;
	cout<<"	 ��ש�ɣ�ɧ�꣡"<<endl;
	cout<<"	�����������������"<<endl;
	for(i=0;i<20;i++)
		cout<<"****";
	cout<<endl;
	while((ch = getchar())!= '\n');
	system("cls");
	you.show();
	while((ch = getchar())!= '\n');
	ch1();
}