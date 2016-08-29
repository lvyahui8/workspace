
#include <iostream>

using std::cout;
using std::endl;

class R
{
private:
	int r1,r2;
public:
	R(int mr1,int mr2):r1(mr1),r2(mr2){}
	void Print();
	void Print() const;		//���Ƕ�Print����Ч����
};

void R::Print()
{
	cout<<r1<<':'<<r2<<endl;
}
//�����ǳ���Ա����
/*************************************************
*	1��������ֻ�ܵ��ó���Ա����,������Ա�������Ա��ǳ�������á�
*	2������Ա���������ڼ䣬���󶼻ᱻ��Ϊ��������˲��ܸ��¶�������ݳ�Ա��
*	Ҳ���ܵ��ø��������û����const���εĺ�����Ա��
*************************************************/
void R::Print() const
{
	cout<<r1<<';'<<r2<<endl;
}

void main()
{
	R a(5,4);
	a.Print();				//����void Print()
	const R b(20,52);
	b.Print();				//����void Print() const
}