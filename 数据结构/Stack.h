#ifndef __STACK_H__
#define __STACK_H__
template<class T>
class ADTStack
{
private:
	T *base;
	T *top;
	int stacksize;
public:
	const unsigned INIT_SIZE;
	const unsigned INCREMENT;
public:
	ADTStack(const unsigned & initSize = 100,const unsigned & increment = 10);
	ADTStack(const ADTStack & stack);
	virtual ~ADTStack();
	void Push(const T & elem);
	T Pop();
	void Show() const;
	void Init();
	T GetTop()const;
protected:

};

//
//	// ===============ADT Stack �ı�ʾ=================
//	#define ELEM_INPUT_FORM		"%c"//�ڵ���Ϣ�����ʽ
//	#define STACK_INIT_SIZE	100		//	ջ��ʼ���ռ��С
//	#define STACK_INCREMENT	10		//	ջ�ռ��������
//	typedef char SElemType;
//	typedef struct ADTStack {
//		SElemType *base;
//		SElemType *top;
//		int	stacksize;
//	}ADTStack;

#endif//__STACK_H__