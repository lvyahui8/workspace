#ifndef __NODE_H__
#define __NODE_H__

template<class T>
class Node{
private:
	Node<T> * next;
public:
	T data;
	Node(const T &data,Node<T>* next = 0);
	void InsertAfther(Node<T>*p);
	Node<T>*DeleteAfther();
	Node<T>*NextNode();
	const Node<T> * NextNode()const;
};
#endif//__NODE_H__