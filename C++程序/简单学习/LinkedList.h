#ifndef __LINKEDLIST_H__
#define __LINKEDLIST_H__

template<class T>
class LinkedList{
private:
	Node<T>*front,*rear;
	Node<T>*prevPtr,*currPtr;
	int size;
	int position;

	Node<T>* newNode(const T &item,Node<T>*ptrNext=NULL);
	void freeNode(Node<T>*p);
	void copy(const LinkedList<T>&L);
public:
	LinkedList();
	LinkedList(const LinkedList<T>&L);
	~LinkedList();
	LinkedList<T>&operator=(const LinkedList<T>&L);

	int getSize()const;
	bool isEmpty()const;

	void next();
	bool endOfList()const;
	int currentPosition()const;

	void insertFront(const T & item);
	void insertRear(const T & item);
	void insertAt(const T & item);
	void insertAfther(const T & item);

	T deleteFornt();
	void deleteCurrent();

	T& data();
	const T& data()const;

	void clear();
};
#endif//__LINKEDLIST_H__