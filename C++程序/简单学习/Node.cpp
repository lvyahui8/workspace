#include "Node.h"

template<class T>
Node<T>::Node(const T& data,Node<T> *next/* = 0 */)
:data(data),next(next){
}
template<class T>
Node<T>*Node<T>::NextNode(){
	return next;
}

template<class T>
const Node<T>*Node<T>::NextNode()const{
	return next;
}

template<class T>
void Node<T>::InsertAfther(Node<T>*p){
	p->next = next;
	next = p;
}

template<class T>
Node<T>*Node<T>::DeleteAfther(){
	Node<T>*tempPtr = next;
	if(0==next)
		return 0;
	next = tempPtr->next;
	return tempPtr;
}
