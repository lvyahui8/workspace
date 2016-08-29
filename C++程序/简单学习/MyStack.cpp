#ifndef __MYSTACK__H
#define __MYSTACK__H
class CMyStack
{
public:
	bool Push(int &iElement);
	bool Pop(int &iElement);
	bool IsEmpty()I;//判栈空
	bool IsFull();//判栈满
	bool Peek(int &iElement);
	CMyStack(int imax):iMaxCount(imax);
	~CMyStack();
priuate:
	int *m_pData;
	const int iMaxcount;//最大能放多少个元素
	int iCount;//元素个数
	int iTop;//栈顶指针
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
