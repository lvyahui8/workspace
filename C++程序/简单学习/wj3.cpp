#include "iostream"
#include "fstream"
#include "ctime"
#include "cstdlib"
#include "vector"
#include "string"
#include "iomanip"
#include "direct.h"
using namespace std;

int main()
{
	ifstream infile;//读入文件
	ofstream outfile;//写入文件
	
	char dir[100];
	_getcwd(dir,100); //获取当前工作目录 注意这个地方的两点，getcwd已经废弃，应使用_getcwd. strcat并不安全，使用strcat_s
	strcat_s(dir,"\\抽奖程序用数据.csv");
	infile.open(dir);
	if (!infile)
	{
		cout<<"读文件打开失败";
		exit(1);
	}
	char chs[20];
	cout<<"输出文件中的数据\n";
	
	
	vector<string> VectorInfo;
	VectorInfo.clear();//清除内存杂质
	
	infile.getline(chs,256,'\n');//舍掉文件第一行的标题内容
	
	
	//打开写入文件
	_getcwd(dir,100); //获取当前工作目录
	strcat_s(dir,"\\获奖名单.txt");
	outfile.open(dir);
	if (!outfile)
	{
		cout<<"写文件打开失败";
		exit(1);
	}
	
	unsigned int count=0;
	while(infile.getline(chs,256,'\n'))
	{
		cout<<chs<<"\n";
		
		if (chs!="") //防止空行
		{
			count++;//统计元素的个数
			
			if (count>= VectorInfo.capacity())//使用的办法就是不够就添加大小
			{
				VectorInfo.reserve(VectorInfo.capacity());
				
			}
			VectorInfo.push_back(chs);//添加
		}
	}
	infile.close();
	
	bool* flag= new bool[count];	
	for (unsigned int i=0;i<count;i++)
		flag[i] = false;  //为了避免重复，设置一个标志数组，大小为记录的个数 
	
	
	
	int number ;//输入的抽奖人数
	cout<<"请输入抽奖的人数，不能大于"<<count<<"人"<<endl;
	cin>>number;
	
    srand(unsigned(time(NULL)));//随机数种子
	for(int i = 0; i<number;)
	{
		
		int a = rand()%(count)+1;
		if (flag[a]==false)//如果该编号已经被访问，则重新生成随机数。。。。。不知道更高明的方法了
		{
			cout<<"获奖编号为"<<a<<"  "<<setw(-20)<<VectorInfo[a-1]<<"\n"; //左对齐
			outfile<<VectorInfo[a-1]<<"\n";
			++i;
			flag[a]=true;
			
		}
	}
	outfile.close();
}