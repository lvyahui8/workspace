#include "Examtotal.h"
#include <iostream>
using std::cout;
using std::endl;
void main(){
	Examtotal::Message();					//���þ�̬���к�����Ա
	cout<<Examtotal::sum<<endl;				//���þ�̬�������ݳ�Ա
	Examtotal myEx1(100),myEx2(90);			//ʵ��������
	Display(myEx1);							//��ʾѧ���Ŀ��Գɼ�
	Display(myEx2);
	Examtotal::Message();					//��ʾ�ܷ���
}