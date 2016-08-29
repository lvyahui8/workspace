#include "Queue.h"
#include <iostream>
using namespace std;

//==============顺序存储队列的实现============================
//template<class T>
//SqQueue<T>::getLength()const{	
//	return (this->rear-this->front+this->MAX_SIZE)%(this->MAX_SIZE);
//}
//
//template<class T>
//bool SqQueue<T>::Init(){
//	this->base = new T[this->MAX_SIZE];
//	if (!this->base) {
//		return false;
//	}
//	this->front = this->rear = 0;
//	return true;
//}
//
//template<class T>
//void SqQueue<T>::input(const T & elem){
//	if (this->isFull())
//	{
//		return;
//	}
//	this->base[this->rear] = elem;
//	this->rear = (this->rear+1)%(this->MAX_SIZE);
//}
//
//template<class T>
//T SqQueue<T>::output(){
//	if (this->isEmpty())
//	{
//		return NULL;
//	}
//	T temp = this->base[this->front];
//	this->front = (this->front +1)%(this->MAX_SIZE);
//	return temp;
//}
//
//void main(){
//	SqQueue<int> mySqQueue(5);
//	for (int i=0;i<5;i++)
//	{
//		mySqQueue.input(i);
//	}
//	for (i=0;i<5;i++)
//	{
//		cout<<mySqQueue.output()<<" ";
//	}
// }


//=============================链队的实现=============================
template<class T>
void LinkQueue<T>::Init(){
	this->prear = this->pfont = new Node;
	this->prear->next = NULL;
}
template<class T>
void LinkQueue<T>::Input(const T & elem){
	Node * p = new Node;
	p->data = elem;
	p->next = NULL;
	this->prear->next = p;
	this->prear = p;
}

template<class T>
T LinkQueue<T>::Output(){
	if(this->prear == this->pfont)
		return -1;		//对列是空的
	Node * oldNode = this->pfont->next;
	T temp = oldNode->data;
	this->pfont->next = this->pfont->next->next;
	delete oldNode;
	return temp;
}

void main(){
	LinkQueue<int>myLinkQ;
	for (int i = 0; i<5;i++)
	{
		myLinkQ.Input(i);
	}
	for (i = 0 ; i<5;i++)
	{
		cout<<myLinkQ.Output()<<"  ";
	}
}	