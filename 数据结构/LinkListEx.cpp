
#include "LinkListEx.h"
#include <iostream>
using namespace  std;

template<class T>
DulLinkList<T>::DulLinkList(){
	Init();
}

template<class T>
void DulLinkList<T>::Init(){
    // 初始化第一个结点
	this->frist = new DulNode;
	this->frist->prior = NULL;
	this->frist->next = NULL;
}

template<class T>
void DulLinkList<T>::AddElem(const T & data){
    // 直接头部插入节点
	DulNode * newNode = new DulNode;
	newNode->data = data;
	newNode->next = this->frist;
	newNode->prior = NULL;
	this->frist->prior = newNode;
	this->frist = newNode;
}


template<class T>
void DulLinkList<T>::DelElem(const T & data){
	DulNode * current = this->frist->next;
	while (current  != NULL  && current->data != data) {
		current = current->next;
	}
	if (!current)
	{
		return;
	}
	Del(current);
}

template<class T>
void DulLinkList<T>::Del(DulNode * delNode){
    // 调整当前节点两端的节点的指针
	delNode->prior->next = delNode->next;
	delNode->next->prior = delNode->prior;
	delete delNode;
}
template<class T>
DulLinkList<T>::~DulLinkList(){
	DulNode * current = this->frist;
	while (current)
	{
		DulNode * old = current;
		current = current->next;
		delete old;
	}
}

template<class T>
string DulLinkList<T>::ToString()const{
	string res;
	DulNode * current = this->frist->next;
	while (current)
	{
		res.append(1,current->data);
		current = current->next;
	}
	return res;
}

void main(){
	DulLinkList<int>myLink;
	
	for (int i=0;i<10;i++)
	{
		myLink.AddElem(i);
	}

	cout<<myLink.ToString()<<endl;

	for(i = 5;i>0;i--){
		myLink.DelElem(i);
	}
}


