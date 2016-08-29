

/*---------------------------------------------����������A*�㷨˼�����---------------------------------------*/
//���ۺ���f(x)=g(x)+h(x)������g(x)��ʾ�ӳ�ʼ���S0����ǰ�ڵ�X��ʵ�ʴ��ۣ�h(x)��ʾ��x��㵽Ŀ����Sg������·������������
//�ڱ�����g(x)��ʾ���x���������е���ȣ�h(x)��ʾ���x����Ӧλ����ֵ��Ŀ��״̬������λ�ø�����
//���֪��һ����˵��f(x)��ֵԽ��˵��xԽ�������Ž⣬����Ӧѡ��f(x)ֵ���С��
//��h(x)��ͨ���ԡ���Ŀ��״̬��Ӧλ����ֵ������λ�ø������Ĺ��ƣ����Եó�������Ҫ���ٲ����ܵ���Ŀ��
//��Ȼh(x)<=h*(x),��˸�A�㷨����A*�㷨��Ҫ���������Ҳ�����·��
/*------------------------------------------------------------------------------------------------------------*/

#include <stdio.h>
#include <string>
#include <iostream>
using namespace std;

struct Node
{
	int father;     //���׽����
	string state;   //��ǰ���״̬
};

Node OPEN[1000];	//open���洢������Ľڵ�
int IsEmpty=1;      //���OPEN���Ƿ�Ϊ��
int opencount=0;    //���OPEN��Ԫ�صĸ���
Node CLOSED[1000];  //closed���洢�����ɵ�������
int closedcount=0;    //closed��ǰ�ڵ�����������ڵ�ֱ�Ӵ洢�ڸ�λ��



//��OPEN���е�һ��������CLOSED��
int OpenToClosed()
{
	if(IsEmpty==1)
		return -1;
	CLOSED[closedcount].father = OPEN[0].father ;
	CLOSED[closedcount].state = OPEN[0].state ;
	closedcount++;
	opencount=0;
	IsEmpty=1;
	return 0;
}

//�ж������Ƿ�ɹ�
int Succeed(string End)
{
	if(CLOSED[closedcount-1].state == End)
		return 0;
	else return -1;
}

//�жϵ�ǰ����Ƿ�����OPEN����
int InOpen(Node x)
{
	if(IsEmpty==1)
		return -1;
	for(int i=0;i<opencount;i++)
	{
		if(x.state==OPEN[i].state)
			return 0;
	}
	return -1;
}

//�жϵ�ǰ����Ƿ�����CLOSED����
int InClosed(Node x)
{
	for(int i=0;i<closedcount;i++)
	{
		if(x.state ==CLOSED[i].state )
			return 0;
	}
	return -1;
}

//��չCLOSED���н��N
int Spread()
{
	int ct=0;  //��ǿո��������е�λ��
	Node SP[4]; //��ǿ���չ����״̬,���Ϊ4��
	int NOfSP=0; //�����չ����״̬�ĸ�������SP����ĸ���
	string st; //����״̬ת�����м����
	for(int i=0;i<CLOSED[closedcount-1].state .length ();i++)
	{
		if(CLOSED[closedcount-1].state[i]!='0')
			ct++;
		else break;
	}
	switch(ct)
	{
	//X0Ϊ�ո������ɱ任��4����״̬
	case 0:
		NOfSP=4;
		//��X0��X2��������״̬������SP[0]��
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[2]= '0';
		st[0]=CLOSED[closedcount-1].state[2];
		SP[0].state =st;

		//��X0��X4��������״̬������SP[1]��
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[4]='0';
		st[0]=CLOSED[closedcount-1].state[4];
		SP[1].state =st;

		//��X0��X6��������״̬������SP[2]��
		SP[2].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[6]='0';
		st[0]=CLOSED[closedcount-1].state[6];
		SP[2].state =st;

		//��X0��X8��������״̬������SP[3]��
		SP[3].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[8]='0';
		st[0]=CLOSED[closedcount-1].state[8];
		SP[3].state =st;
		break;

	//X1Ϊ�ո��������Խ�����2����״̬
	case 1:
		NOfSP=2;
		//��X1��X2��������״̬������SP[0]��
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[2]='0';
		st[1]=CLOSED[closedcount-1].state[2];
		SP[0].state =st;

		//��X1��X8��������״̬������SP[1]��
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[8]='0';
		st[1]=CLOSED[closedcount-1].state [8];
		SP[1].state =st;
		break;

	//X2Ϊ�ո��������Խ�����3����״̬
	case 2:
		NOfSP=3;
		//��X2��X1��������״̬������SP[0]��
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[1]='0';
		st[2]=CLOSED[closedcount-1].state[1];
		SP[0].state =st;

		//��X2��X0��������״̬������SP[1]��
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[0]='0';
		st[2]=CLOSED[closedcount-1].state[0];
		SP[1].state =st;

		//��X2��X3��������״̬������SP[2]��
		SP[2].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[3]='0';
		st[2]=CLOSED[closedcount-1].state[3];
		SP[2].state =st;
	    break;

	//X3Ϊ�ո������¿��Խ�����2����״̬
	case 3:
		NOfSP=2;
		//��X3��X2��������״̬������SP[0]��
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[2]='0';
		st[3]=CLOSED[closedcount-1].state[2];
		SP[0].state =st;

		//��X3��X4��������״̬������SP[1]��
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[4]='0';
		st[3]=CLOSED[closedcount-1].state[4];
		SP[1].state =st;
		break;

    //X4Ϊ�ո������¿��Խ�����3����״̬
	case 4:
		NOfSP=3;
		//��X4��X3��������״̬������SP[0]��
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[3]='0';
		st[4]=CLOSED[closedcount-1].state[3];
		SP[0].state =st;

		//��X4��X0��������״̬������SP[1]��
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[0]='0';
		st[4]=CLOSED[closedcount-1].state[0];
		SP[1].state =st;

		//��X4��X5��������״̬������SP[2]��
		SP[2].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[5]='0';
		st[4]=CLOSED[closedcount-1].state[5];
		SP[2].state =st;
		break;

	//X5Ϊ�ո������¿��Խ�����2����״̬
	case 5:
		NOfSP=2;
		//��X5��X4��������״̬������SP[0]��
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[4]='0';
		st[5]=CLOSED[closedcount-1].state[4];
		SP[0].state =st;

		//��X5��X6��������״̬������SP[1]��
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[6]='0';
		st[5]=CLOSED[closedcount-1].state[6];
		SP[1].state =st;
	    break;

	//X6Ϊ�ո������¿��Խ�����3����״̬
	case 6:
		NOfSP=3;
		//��X6��X7��������״̬������SP[0]��
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[7]='0';
		st[6]=CLOSED[closedcount-1].state[7];
		SP[0].state =st;

		//��X6��X0��������״̬������SP[1]��
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[0]='0';
		st[6]=CLOSED[closedcount-1].state[0];
		SP[1].state =st;

		//��X6��X5��������״̬������SP[2]��
		SP[2].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[5]='0';
		st[6]=CLOSED[closedcount-1].state[5];
		SP[2].state =st;
		break;

	//X7Ϊ�ո������¿��Խ�����2����״̬
	case 7:
		NOfSP=2;
		//��X7��X8��������״̬������SP[0]��
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[8]='0';
		st[7]=CLOSED[closedcount-1].state[8];
		SP[0].state =st;

		//��X7��X6��������״̬������SP[1]��
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[6]='0';
		st[7]=CLOSED[closedcount-1].state[6];
		SP[1].state =st;
		break;

	//X8Ϊ�ո������¿��Խ�����3����״̬
	case 8:
		NOfSP=3;
		//��X8��X1��������״̬������SP[0]��
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[1]='0';
		st[8]=CLOSED[closedcount-1].state[1];
		SP[0].state =st;

		//��X8��X0��������״̬������SP[1]��
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[0]='0';
		st[8]=CLOSED[closedcount-1].state[0];
		SP[1].state =st;

		//��X8��X7��������״̬������SP[2]��
		SP[2].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[7]='0';
		st[8]=CLOSED[closedcount-1].state[7];
		SP[2].state =st;
		break;
	}
	for(int j=0;j<NOfSP;j++)
	{
		if(InOpen(SP[j])==0||InClosed(SP[j])==0)
		{
			if(j==NOfSP-1)
				NOfSP--;
			else
			{
				for(int k=j;k<NOfSP-1;k++)
				{
					SP[k].father =SP[k+1].father ;
					SP[k].state =SP[k+1].state ;
				}
				NOfSP--;
			}
		}
	}
	if(NOfSP!=0)
	{
		for(int l=0;l<NOfSP;l++)
		{
			OPEN[opencount]=SP[l];
			opencount++;
		}
		if(IsEmpty==1)
			IsEmpty=0;
		return 0;
	}
	else return -1;
}

//���㱾�ڵ����������е���ȣ��ύ����Ϊ���ڵ�ĸ��ڵ��
int TreeDeepth(int father)
{
	int result=1;//���ڵ����Ϊ1
	while(father!=-1)//���ڵ��־
	{
		result++;
		father=CLOSED[father].father;//�ӱ��ڵ�������Ѱ���ڵ�ֱ���ҵ����ڵ�
	}
	return result;
}

//���ۺ�������
int Value(Node x,string End)
{
	int vl=TreeDeepth(x.father);
	for(int i=0;i<x.state.length();i++)
	{
		if(x.state[i]!=End[i])
			vl++;
	}
	return vl;
}

//ѡ����ۺ���ֵ��С��OPEN���еĽ��
int Select(string End)
{
	int x=0;
	int min=Value(OPEN[0],End);
	if(IsEmpty==1)
		return -1;
	for(int i=1;i<opencount;i++)
	{
		if(Value(OPEN[i],End)<min)
		{
			x=i;
			min=Value(OPEN[i],End);
		}
	}
	return x;
}

//��ѡ��õ���OPEN����Valueֵ��С�Ľ��ŵ�OPEN��ĵ�һλ
int MoveToFst(string End)
{
	int x=Select(End);
	if(x==-1)
		return -1;
	Node op[1000];
	for(int i=0;i<opencount;i++)
	{
		op[i]=OPEN[i];
	}
	OPEN[0]=op[x];
	for(int j=0;j<opencount;j++)
	{
		if(j<x)
		{
			OPEN[j+1]=op[j];
		}
		if(j>x)
		{
			OPEN[j]=op[j];
		}
	}
	return 0;
}

//�㷨�������ӡCLOSED���е�������
int Print()
{
	if(closedcount==0)
		return -1;
	for(int i=0;i<closedcount;i++)
	{
		cout<<CLOSED[i].state[1]<<" "<<CLOSED[i].state[2]<<" "<<CLOSED[i].state[3]<<endl;
	    cout<<CLOSED[i].state[8]<<" "<<CLOSED[i].state[0]<<" "<<CLOSED[i].state[4]<<endl;
		cout<<CLOSED[i].state[7]<<" "<<CLOSED[i].state[6]<<" "<<CLOSED[i].state[5]<<endl;
		cout<<endl;
	}
	return 0;
}

//A*�㷨����
int Do(string Start,string End)
{
	while(1)
	{
		if(opencount==0)
			return -1;
		if(OpenToClosed()==-1)
			return -1;
		if(Succeed(End)==0)
		{
			Print();
			return 0;
		}
		Spread();
		MoveToFst(End);
	}
}

int main()
{
	string Start,End;
   //���뿪ʼ�ͽ���״̬
    cout<<"������������9������0��ʾ�ո񣬾Ź�������ΪX0������λ�ð�˳ʱ�뷽��ֱ�ΪX1-X8��"<<endl;
	cout<<"�����뿪ʼʱ������״̬��"<<endl;
	cin>>Start;
	if(Start.length()!=9)
	{
		cout<<"ERROR!���벻��9���������䣡"<<endl;
		cin>>Start;
	}
	else
	{
		for(int i=0;i<Start.length();i++)
		{
			if(Start[i]<'0'||Start[i]>'8')
			{
				cout<<"ERROR!����ֵ��ȫ��0-8֮��!����!"<<endl;
				cin>>Start;
				break;
			}
		}
	}
	cout<<"������Ŀ�ʼ״̬Ϊ��"<<Start<<endl;
	cout<<"���������ʱ������״̬��"<<endl;
	cin>>End;
    if(End.length()!=9)
	{
		cout<<"ERROR!���벻��9���������䣡"<<endl;
		cin>>End;
	}
	else
	{
		for(int i=0;i<End.length();i++)
		{
			if(End[i]<'0'||End[i]>'8')
			{
				cout<<"ERROR!����ֵ��ȫ��0-8֮��!����!"<<endl;
				cin>>End;
				break;
			}
		}
	}
	cout<<"������Ľ���״̬Ϊ��"<<End<<endl;

	/*---------------------��ʼ��OPEN��-------------------*/
	//fatherֵΪ-1��Node��ʾ�����
	OPEN[0].father = -1;
	OPEN[0].state =Start;
	IsEmpty=0;
	opencount++;
	Do(Start,End);
	return 0;
}

