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
//	// ===============ADT Stack 的表示=================
//	#define ELEM_INPUT_FORM		"%c"//节点信息输入格式
//	#define STACK_INIT_SIZE	100		//	栈初始化空间大小
//	#define STACK_INCREMENT	10		//	栈空间分配增量
//	typedef char SElemType;
//	typedef struct ADTStack {
//		SElemType *base;
//		SElemType *top;
//		int	stacksize;
//	}ADTStack;

#endif//__STACK_H__