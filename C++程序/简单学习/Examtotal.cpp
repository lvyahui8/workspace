#include "Examtotal.h"
#include <iostream>
using std::cout;
using std::endl;

int Examtotal::count = 0;
int Examtotal::sum = 0;
//Examtotal �� ʵ�ַ���
Examtotal::Examtotal(int m){
	num = ++count;					//����ѧ��
	score = m;						//���Է���
	sum += score;					//�޸��ܷ�
}

void Examtotal::Message(){
	cout<<"��"<<count<<"ѧ���μӿ���,�����ܷ�: "<<sum<<endl;
}

void Display(Examtotal &s){
	cout<<s.num<<' '<<s.score<<endl;
}
