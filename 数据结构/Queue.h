#ifndef __QUEUE_H__
#define __QUEUE_H__

//===========顺序存储队列的表示及定义=============
//template<class T>
//class SqQueue
//{
//private:
//	const unsigned MAX_SIZE;
//	T	* base;
//	int	front;
//	int	rear;
//private:
//	bool Init();
//public:
//	SqQueue(const unsigned & maxSize = 20)
//		:MAX_SIZE(maxSize+1){
//		Init();
//	}
//	~SqQueue(){
//		delete [] base;
//	}
//	int getLength() const;
//	void input(const T & elem);
//	T output();
//	bool isFull()const{
//		return ((this->rear+1)%this->MAX_SIZE == this->front);
//	}
//	bool isEmpty()const{
//		return this->rear == this->front;
//	}
//protected:
//};

//====================链式队列的实现======================
template<class T>
class LinkQueue
{
private:
	typedef struct Node{
		T data;
		struct Node * next;
	}Node;
	Node * pfont;
	Node * prear;
public:
	LinkQueue(){
		Init();
	}
private:
	void Init();
public:
	void Input(const T & elem);
	T Output();
};
#endif//__QUEUE_H__