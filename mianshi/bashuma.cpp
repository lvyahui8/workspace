

/*---------------------------------------------八数码问题A*算法思想介绍---------------------------------------*/
//估价函数f(x)=g(x)+h(x)，其中g(x)表示从初始结点S0到当前节点X的实际代价，h(x)表示从x结点到目标结点Sg的最优路径的评估代价
//在本题中g(x)表示结点x在搜索树中的深度，h(x)表示结点x中相应位置数值与目标状态不符的位置个数。
//则可知，一般来说，f(x)的值越大，说明x越不是最优解，所以应选择f(x)值相对小的
//而h(x)中通过对“与目标状态相应位置数值不符的位置个数”的估计，可以得出至少需要多少步才能到达目标
//显然h(x)<=h*(x),因此该A算法满足A*算法的要求，所求出的也是最短路径
/*------------------------------------------------------------------------------------------------------------*/

#include <stdio.h>
#include <string>
#include <iostream>
using namespace std;

struct Node
{
	int father;     //父亲结点编号
	string state;   //当前棋局状态
};

Node OPEN[1000];	//open表，存储待加入的节点
int IsEmpty=1;      //标记OPEN表是否为空
int opencount=0;    //标记OPEN表元素的个数
Node CLOSED[1000];  //closed表，存储已生成的搜索树
int closedcount=0;    //closed表当前节点数，待加入节点直接存储在该位置



//把OPEN表中第一个结点加入CLOSED表
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

//判断搜索是否成功
int Succeed(string End)
{
	if(CLOSED[closedcount-1].state == End)
		return 0;
	else return -1;
}

//判断当前结点是否已在OPEN表中
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

//判断当前结点是否已在CLOSED表中
int InClosed(Node x)
{
	for(int i=0;i<closedcount;i++)
	{
		if(x.state ==CLOSED[i].state )
			return 0;
	}
	return -1;
}

//扩展CLOSED表中结点N
int Spread()
{
	int ct=0;  //标记空格在棋盘中的位置
	Node SP[4]; //标记可扩展出的状态,最多为4个
	int NOfSP=0; //标记扩展出的状态的个数，即SP数组的个数
	string st; //用做状态转换的中间变量
	for(int i=0;i<CLOSED[closedcount-1].state .length ();i++)
	{
		if(CLOSED[closedcount-1].state[i]!='0')
			ct++;
		else break;
	}
	switch(ct)
	{
	//X0为空格的情况可变换得4个新状态
	case 0:
		NOfSP=4;
		//把X0与X2交换得新状态，存在SP[0]中
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[2]= '0';
		st[0]=CLOSED[closedcount-1].state[2];
		SP[0].state =st;

		//把X0与X4交换得新状态，存在SP[1]中
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[4]='0';
		st[0]=CLOSED[closedcount-1].state[4];
		SP[1].state =st;

		//把X0与X6交换得新状态，存在SP[2]中
		SP[2].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[6]='0';
		st[0]=CLOSED[closedcount-1].state[6];
		SP[2].state =st;

		//把X0与X8交换得新状态，存在SP[3]中
		SP[3].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[8]='0';
		st[0]=CLOSED[closedcount-1].state[8];
		SP[3].state =st;
		break;

	//X1为空格的情况可以交换得2个新状态
	case 1:
		NOfSP=2;
		//把X1与X2交换得新状态，存在SP[0]中
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[2]='0';
		st[1]=CLOSED[closedcount-1].state[2];
		SP[0].state =st;

		//把X1与X8交换得新状态，存在SP[1]中
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[8]='0';
		st[1]=CLOSED[closedcount-1].state [8];
		SP[1].state =st;
		break;

	//X2为空格的情况可以交换得3个新状态
	case 2:
		NOfSP=3;
		//把X2与X1交换得新状态，存在SP[0]中
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[1]='0';
		st[2]=CLOSED[closedcount-1].state[1];
		SP[0].state =st;

		//把X2与X0交换得新状态，存在SP[1]中
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[0]='0';
		st[2]=CLOSED[closedcount-1].state[0];
		SP[1].state =st;

		//把X2与X3交换得新状态，存在SP[2]中
		SP[2].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[3]='0';
		st[2]=CLOSED[closedcount-1].state[3];
		SP[2].state =st;
	    break;

	//X3为空格的情况下可以交换得2个新状态
	case 3:
		NOfSP=2;
		//把X3与X2交换得新状态，存在SP[0]中
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[2]='0';
		st[3]=CLOSED[closedcount-1].state[2];
		SP[0].state =st;

		//把X3与X4交换得新状态，存在SP[1]中
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[4]='0';
		st[3]=CLOSED[closedcount-1].state[4];
		SP[1].state =st;
		break;

    //X4为空格的情况下可以交换得3个新状态
	case 4:
		NOfSP=3;
		//把X4与X3交换得新状态，存在SP[0]中
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[3]='0';
		st[4]=CLOSED[closedcount-1].state[3];
		SP[0].state =st;

		//把X4与X0交换得新状态，存在SP[1]中
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[0]='0';
		st[4]=CLOSED[closedcount-1].state[0];
		SP[1].state =st;

		//把X4与X5交换得新状态，存在SP[2]中
		SP[2].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[5]='0';
		st[4]=CLOSED[closedcount-1].state[5];
		SP[2].state =st;
		break;

	//X5为空格的情况下可以交换得2个新状态
	case 5:
		NOfSP=2;
		//把X5与X4交换得新状态，存在SP[0]中
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[4]='0';
		st[5]=CLOSED[closedcount-1].state[4];
		SP[0].state =st;

		//把X5与X6交换得新状态，存在SP[1]中
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[6]='0';
		st[5]=CLOSED[closedcount-1].state[6];
		SP[1].state =st;
	    break;

	//X6为空格的情况下可以交换得3个新状态
	case 6:
		NOfSP=3;
		//把X6与X7交换得新状态，存在SP[0]中
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[7]='0';
		st[6]=CLOSED[closedcount-1].state[7];
		SP[0].state =st;

		//把X6与X0交换得新状态，存在SP[1]中
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[0]='0';
		st[6]=CLOSED[closedcount-1].state[0];
		SP[1].state =st;

		//把X6与X5交换得新状态，存在SP[2]中
		SP[2].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[5]='0';
		st[6]=CLOSED[closedcount-1].state[5];
		SP[2].state =st;
		break;

	//X7为空格的情况下可以交换得2个新状态
	case 7:
		NOfSP=2;
		//把X7与X8交换得新状态，存在SP[0]中
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[8]='0';
		st[7]=CLOSED[closedcount-1].state[8];
		SP[0].state =st;

		//把X7与X6交换得新状态，存在SP[1]中
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[6]='0';
		st[7]=CLOSED[closedcount-1].state[6];
		SP[1].state =st;
		break;

	//X8为空格的情况下可以交换得3个新状态
	case 8:
		NOfSP=3;
		//把X8与X1交换得新状态，存在SP[0]中
		SP[0].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[1]='0';
		st[8]=CLOSED[closedcount-1].state[1];
		SP[0].state =st;

		//把X8与X0交换得新状态，存在SP[1]中
		SP[1].father =closedcount-1;
		st=CLOSED[closedcount-1].state ;
		st[0]='0';
		st[8]=CLOSED[closedcount-1].state[0];
		SP[1].state =st;

		//把X8与X7交换得新状态，存在SP[2]中
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

//计算本节点在搜索树中的深度，提交参数为本节点的父节点号
int TreeDeepth(int father)
{
	int result=1;//根节点深度为1
	while(father!=-1)//根节点标志
	{
		result++;
		father=CLOSED[father].father;//从本节点依次找寻父节点直到找到根节点
	}
	return result;
}

//估价函数主体
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

//选择估价函数值最小的OPEN表中的结点
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

//把选择得到的OPEN表中Value值最小的结点放到OPEN表的第一位
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

//算法结束后打印CLOSED表中的搜索树
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

//A*算法主体
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
   //输入开始和结束状态
    cout<<"请输入棋盘内9个数，0表示空格，九宫格中央为X0，其余位置按顺时针方向分别为X1-X8！"<<endl;
	cout<<"请输入开始时的棋盘状态："<<endl;
	cin>>Start;
	if(Start.length()!=9)
	{
		cout<<"ERROR!输入不是9个数！重输！"<<endl;
		cin>>Start;
	}
	else
	{
		for(int i=0;i<Start.length();i++)
		{
			if(Start[i]<'0'||Start[i]>'8')
			{
				cout<<"ERROR!输入值不全在0-8之间!重输!"<<endl;
				cin>>Start;
				break;
			}
		}
	}
	cout<<"您输入的开始状态为："<<Start<<endl;
	cout<<"请输入结束时的棋盘状态："<<endl;
	cin>>End;
    if(End.length()!=9)
	{
		cout<<"ERROR!输入不是9个数！重输！"<<endl;
		cin>>End;
	}
	else
	{
		for(int i=0;i<End.length();i++)
		{
			if(End[i]<'0'||End[i]>'8')
			{
				cout<<"ERROR!输入值不全在0-8之间!重输!"<<endl;
				cin>>End;
				break;
			}
		}
	}
	cout<<"您输入的结束状态为："<<End<<endl;

	/*---------------------初始化OPEN表-------------------*/
	//father值为-1的Node表示根结点
	OPEN[0].father = -1;
	OPEN[0].state =Start;
	IsEmpty=0;
	opencount++;
	Do(Start,End);
	return 0;
}

