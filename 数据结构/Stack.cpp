#include "Stack.h"
#include <malloc.h>
#include <iostream>
using namespace std;
template<class T>
ADTStack<T>::ADTStack(const unsigned & initSize /* = 100 */,const unsigned & increment /* = 10 */)
:INIT_SIZE(initSize),INCREMENT(increment)
{
	this->Init();
}
template<class T>
ADTStack<T>::ADTStack(const ADTStack & stack)
:INIT_SIZE(stack.INIT_SIZE),INCREMENT(stack.INCREMENT)
{
	this->stacksize = stack.stacksize;
	this->top = this->base = this->base = (T*)malloc(sizeof(T)*(this->stacksize));
	T * p = stack.base+1;
	for (;(p-1)!=stack.top;p++)
	{
		this->Push(*p);
	}
}
template<class T>
ADTStack<T>::~ADTStack(){
	free(this->base);
}
template<class T>
void ADTStack<T>::Push(const T & elem){
	if (this->top == this->base+this->stacksize) {		//栈满，需开辟额外的空间
		this->base = (T*)realloc(this->base,(this->stacksize+INCREMENT)*(sizeof T));
		this->stacksize +=INCREMENT;
	}
	*(++(this->top)) = elem;
}
template<class T>
T ADTStack<T>::Pop(){
	if (this->base == this->top) {
		return NULL;
	}
	return *(this->top--);
}
template<class T>
void ADTStack<T>::Show() const{
	T * p = this->base+1;
	while((p-1)!=this->top){
		cout<<*p<<" ";
		p++;
	}
	cout<<endl;
}
template<class T>
void ADTStack<T>::Init(){
	this->stacksize = INIT_SIZE;
	this->top = this->base = (T*)malloc(sizeof(T)*INIT_SIZE);
	T newElem;
	while (true) {
		cin>>newElem;
		if ('0'==newElem) {
			break;
		}
		Push(newElem);
	}
}
template<class T>
T ADTStack<T>::GetTop()const{
	if (this->base == this->top)
	{
		return NULL;
	}
	return *this->top;
}


void main(){
	
	{
		ADTStack<char> myStack(100,10);
		myStack.Show();
		ADTStack<char> itStack(myStack);
		itStack.Pop();
		itStack.Show();
	}

}

