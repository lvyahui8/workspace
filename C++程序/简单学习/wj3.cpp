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
	ifstream infile;//�����ļ�
	ofstream outfile;//д���ļ�
	
	char dir[100];
	_getcwd(dir,100); //��ȡ��ǰ����Ŀ¼ ע������ط������㣬getcwd�Ѿ�������Ӧʹ��_getcwd. strcat������ȫ��ʹ��strcat_s
	strcat_s(dir,"\\�齱����������.csv");
	infile.open(dir);
	if (!infile)
	{
		cout<<"���ļ���ʧ��";
		exit(1);
	}
	char chs[20];
	cout<<"����ļ��е�����\n";
	
	
	vector<string> VectorInfo;
	VectorInfo.clear();//����ڴ�����
	
	infile.getline(chs,256,'\n');//����ļ���һ�еı�������
	
	
	//��д���ļ�
	_getcwd(dir,100); //��ȡ��ǰ����Ŀ¼
	strcat_s(dir,"\\������.txt");
	outfile.open(dir);
	if (!outfile)
	{
		cout<<"д�ļ���ʧ��";
		exit(1);
	}
	
	unsigned int count=0;
	while(infile.getline(chs,256,'\n'))
	{
		cout<<chs<<"\n";
		
		if (chs!="") //��ֹ����
		{
			count++;//ͳ��Ԫ�صĸ���
			
			if (count>= VectorInfo.capacity())//ʹ�õİ취���ǲ�������Ӵ�С
			{
				VectorInfo.reserve(VectorInfo.capacity());
				
			}
			VectorInfo.push_back(chs);//���
		}
	}
	infile.close();
	
	bool* flag= new bool[count];	
	for (unsigned int i=0;i<count;i++)
		flag[i] = false;  //Ϊ�˱����ظ�������һ����־���飬��СΪ��¼�ĸ��� 
	
	
	
	int number ;//����ĳ齱����
	cout<<"������齱�����������ܴ���"<<count<<"��"<<endl;
	cin>>number;
	
    srand(unsigned(time(NULL)));//���������
	for(int i = 0; i<number;)
	{
		
		int a = rand()%(count)+1;
		if (flag[a]==false)//����ñ���Ѿ������ʣ����������������������������֪���������ķ�����
		{
			cout<<"�񽱱��Ϊ"<<a<<"  "<<setw(-20)<<VectorInfo[a-1]<<"\n"; //�����
			outfile<<VectorInfo[a-1]<<"\n";
			++i;
			flag[a]=true;
			
		}
	}
	outfile.close();
}