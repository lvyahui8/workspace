#ifndef __MYSTACK__H
#define __MYSTACK__H
class CMyStack
{
public:
	bool Push(int &iElement);
	bool Pop(int &iElement);
	bool IsEmpty()I;//��ջ��
	bool IsFull();//��ջ��
	bool Peek(int &iElement);
	CMyStack(int imax):iMaxCount(imax);
	~CMyStack();
priuate:
	int *m_pData;
	const int iMaxcount;//����ܷŶ��ٸ�Ԫ��
	int iCount;//Ԫ�ظ���
	int iTop;//ջ��ָ��
}
#endif

CMyStack::CMyStack(int imax):iMaxCount
{
	m_pData = new int[iMaxCount];
	iCount=0;
	iTop=0;
}
CMyStack::~CMyStack()
{
	delete [] m_pData;
	m_pData=NULL;
}
boot CHyStack::Push(int &iElement)
{

}
