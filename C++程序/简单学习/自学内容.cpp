#include <iostream>		//For output to the screen
#include <iomanip>		//For manipulators  �ܹ�ʹ��setw
#include <cstdlib>		//��ѧ������

//using namespace std;
//�����ռ䡣�������������ϡ�ʹ������еĸ�����������������������³�ͻ�Ŀ����Խ������
//���ʡ��using��䡣�����ʹ��ȫ��������cout��Ҫ����stu::cout������::�Ƿ�Χ���������
// ���� using std::cout;

using std::cout;
using std::endl;// endl='\n'+ˢ�»�����
using std::setw;//manipulators�����ݳ���ֻ������һ��д��cout��ֵ
using std::cin;

void main()
{	// <<  >> ���������

//	cout<<"���"<<"�Ҿͺ�"<<endl<<'a';
	
/*********************************************************
	char str[10];
	cin>>str;		//������
	cout<<str;		//�����

	char ch;
	cin>>ch;
	cout<<ch;

	int i;
	cin>>i;
	cout<<i;
	
	float f;
	cin>>f;
	cout<<f;	//ֻ�������Чλ��	
*/

//	std::cout<<"dsad";

/*********************************************************
//ת������
	cout<<"\n\"Least said\n\t\tsoonest mended.\"\n\a";

	cout<< endl
		<< "\" Least said"
		<< endl
		<< "\t\tsoonest mended.\"\a"
		<< endl;
*/

/*********************************************************	
//setw
	cout<<setw(10)<<10<<endl;
	cout<<setw(10)<<-230<<endl;
*/

//	long int earth_d= 1234567L;// �ں������һ��L�ǽ�����ת��Long int���ͣ�����Ҳ�У����������Զ�����������

//�������岢��ʼ��
/*********************************************************
	int apples=10;
	int oranges=6;
	int boys=3;
	int girls=4;

	int fruit_per_child = (apples+oranges);

	cout<<endl
		<<"Each child gets "
		<<fruit_per_child<<" fruit.\n"
		<<endl;
*/

//	const int i=45;// const�������붨��֮�����丳��ֵ
/********************************************************
	const int inches_per_foot=12;
	const int feet_per_yards=3;
	int yards=0;
	int feet=0;
	int inches=0;

	//Read the length from the keyboard
	cout<<"Enter a length as yards,feet,and inches:";
	cin>>yards>>feet>>inches;	//�����ʱ���Կո���߻��з����

	//Output the length in inches
	cout<<endl
		<<"Length is inches is"
		<<inches+inches_per_foot * (feet+feet_per_yards*yards)
		<<endl;
*/

/*********************************************************
//<cstdlib>ͷ�ļ��Ǵ�C�̳����ģ��������ʵ�ַ�ʽ������ԭ��C����
//�Ķ��壬����û����std�����ռ��ж��壬���Ժ�������ʹ��std�޶�
//��.�⽫����C��������ͬ�Ļ����±����ִ�У�����C++�б���ʱ��
//Ӧ����Щ��������std�޶�����
//  ��ѧ�⺯���� div()
	int v=93;
	int d=17;
	div_t results=div(v,d);
	cout<<"Output is"<< results.quot<<endl;	
	cout<<"Remainder is"<< results.rem<<endl;
//   rand()��srand(int)�����
	int random=rand();//Ĭ�ϵ��������ֵ
	srand(15);//�����������ֵΪ15	
//time()���������Դ�1970��7��1��������ȥ��������
	std::srand((unsigned int)std::time(O));
*/

}