/*
������������������������������������������������������������
��	�����Ǿ�̬���黹��new��̬���������飬���Լ���±�Խ���
��	����Ϊ����������C++�ṩ�˱���װ�Ķ�̬����-vector����
��	�ֱ���װ������������κ����ͣ�Ϊ�˿���Ϊ������ȥ�ܶ��鷳
��	�Ĳ�����vector����һ���࣬��ֻ����ģ�塣ʹ�÷�������
��		vector<Ԫ������>���������(���鳤��);
��	���鳤����һ�����ʽ�����ʽ��������б�����
��	���磺		int x=10;
��				vector<int>arr(x);
������������������������������������������������������������*/

#include <iostream>
#include <vector>
using std::cout;
using std::cin;
using std::endl;
using std::vector;
//��������arr�е�ƽ��ֵ
double average(const vector<double>&arr){
	double sum = 0;
	for(unsigned i=0;i<arr.size();i++)
		sum += arr[i];
	return sum/arr.size();
}

void main(){
	unsigned n;
	cout<<"n=";
	cin>>n;

	vector<double>arr(n);			//�����������
	cout<<"Please input "<<n<<" real numbers:"<<endl;
	for(unsigned i=0;i<n;i++)
		cin>>arr[i];

	cout<<"Average = "<<average(arr)<<endl;
}