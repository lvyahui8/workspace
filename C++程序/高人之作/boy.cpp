#include<iostream>
#include<string>
#include<stdlib.h>
/*
剧情介绍：
你是一名怀揣着中国梦的追风骚年，为了寻找pure love and truth，考上了【搬砖大学】，传说这儿的就业率一直是100%——搬砖!
“搬起砖我就抱不动你，放下砖我就养不活你！”
搬砖吧，骚年！
按任意键继续。。。

  直到升级为等级3，：扩大鼻孔-》伸手指-》超必杀（嘲讽：挖鼻孔）
  剧情：
  获得任务：1.填写学籍管理系统（调用文件）
  等级过低找校长就-》食屎
  教务主任（提问：佛祖割肉喂鹰）-》代课老师（填写学籍管理，升级了2）
  -》教务主任（捡肥皂，狠狠地朝你扔过来。被打晕了，醒来已经在校长办公室，升级了3！）-》校长（召唤食屎兽！使用超必杀！-》读了n年，终于毕业！获得成就“搬砖形象大使！”）
  You:
  技能：扩大鼻孔
  等级：1
  
	每天的选项有：1.睡觉2.上课（为了升级）3.把妹4.找校长（不够3级就吃屎！重来）
	
	  基类：
	  姓名
	  性别
	  性格
	  
		派生类：（教务主任）
		
		  派生类：（代课老师）
		  
			派生类：（校长）
特别属性：召唤食屎兽，统统给我吃屎吧！*/
using namespace std;

int n=1;
void ch1();
char ch;

class Teather//教师
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
		cout<<"性别："<<sex<<endl;
		cout<<"性格："<<charming<<endl;			
	}
private:
	string name;
	string sex;
	string charming;
};
class Teather_Father:public Teather//教务主任
{
public:
	void X()
	{
		cout<<"佛祖割肉喂鹰的故事你可曾耳闻？"<<endl;
		
		cout<<"你的反应： 1.使用技能去战斗！ 2.回答"<<endl;
		while((ch = getchar())!= '\n');
		
	}
	
};
class You//骚年
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
		cout<<"技能："<<energy<<endl;
		cout<<"等级："<<rate<<endl;
	}
	
	
	void showRate()//显示技能
	{
		cout<<rate;
	}
	void setRate()//升级
	{
		rate++;
		cout<<"升级了！";
	}
private:
	string energy;
	int rate;
};
You you;
Teather_Father f;	


void sleep()//睡觉
{
	if(n%2 ==0)
		cout<<"这一天被你给睡了。。"<<endl;
	else
		cout<<"周末又到了！大家好，我是周末君，祝大家周末愉快！"<<endl;
	
	n++;
	while((ch = getchar())!= '\n'); 
	ch1();	
	
}



void lesson()//上课
{
	
	system("cls");
	f.set("教务主任","男","行踪捉摸不定，没有人真正看到过他的容貌，因为一旦看到，就意味着。。。你要留级了。");
	f.show_T();
	f.X();
	
	
	n++;
	while((ch = getchar())!= '\n');
	ch1();	
	
}
void gril()//把妹
{
	if(n%2 ==0)
		cout<<"o(>_<)o你萎了。。雄风难正"<<endl;
	else 
	{
		cout<<"放开那个女孩！"<<endl;
		cout<<"如来神掌！"<<endl;
		cout<<"一个傻子，一个哑巴，都给我吃屎去吧！"<<endl;
	}
	n++;
	while((ch = getchar())!= '\n');
	ch1();
}
void president()//找校长
{
	
	n++;
	while((ch = getchar())!= '\n');
	ch1();
}
void ch1()
{
	int i;
	system("cls");
	cout<<"第"<<n<<"年的选项有："<<endl;
	cout<<"1.睡觉"<<endl<<"2.上课"<<endl<<"3.把妹"<<endl<<"4.找校长"<<endl;
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
	cout<<"\t\t\t剧情介绍：    \n";
	cout<<"你是一名怀揣着中国梦的追风骚年，为了寻找pure love and truth，考上了【搬砖大学】，传说这儿的就业率一直是100%——搬砖!"<<endl;
	cout<<"	搬起砖我就抱不动你，放下砖我就养不活你！"<<endl;
	cout<<"	 搬砖吧，骚年！"<<endl;
	cout<<"	按任意键继续。。。"<<endl;
	for(i=0;i<20;i++)
		cout<<"****";
	cout<<endl;
	while((ch = getchar())!= '\n');
	system("cls");
	you.show();
	while((ch = getchar())!= '\n');
	ch1();
}