/*
■■□□■■□□■■□□■■□□■■□□■■□□■■□□■■
□	无论是静态数组还是new动态创建的数组，难以检测下标越界的
□	错误，为解决这个问题C++提供了被封装的动态数组-vector。这
■	种被封装的数组可以是任何类型，为此可以为我们免去很多麻烦
■	的操作。vector不是一个类，而只是类模板。使用方法如下
□		vector<元素类型>数组对象名(数组长度);
□	数组长度是一个表达式，表达式里面可以有变量。
■	例如：		int x=10;
■				vector<int>arr(x);
□□■■□□■■□□■■□□■■□□■■□□■■□□■■□□*/

#include <iostream>
#include <vector>
using std::cout;
using std::cin;
using std::endl;
using std::vector;
//计算数组arr中的平均值
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

	vector<double>arr(n);			//创建数组对象
	cout<<"Please input "<<n<<" real numbers:"<<endl;
	for(unsigned i=0;i<n;i++)
		cin>>arr[i];

	cout<<"Average = "<<average(arr)<<endl;
}