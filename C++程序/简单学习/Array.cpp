#include "Array.h"
#include <cassert>

template<class T>
Array<T>::Array(int sz/* =50 */){
	assert(sz>=0);
	this->size = sz;
	this->list = new T [this->size];
}

template<class T>
Array<T>::Array(const Array<T>&a){
	this->size = a.size;
	this->list = new T [this->size];
	for(int i=0;i<this->size;i++)
		this->list[i]=a.list[i];
}

template<class T>
Array<T>::~Array(){
	delete [] this->list;
}

template<class T>
Array<T>&Array<T>::operator=(const Array<T>&rhs){
	if(&rhs!=this){
		if(this->size!=rhs.size){
			delete [] this->list;
			this->size = rhs.size;
			this->list = new T [this->size];
		}
		for(int i=0;i<this->size;i++){
			this->list[i] = rhs.list[i];
		}
	}
	return * this;
}

template<class T>
T &Array<T>::operator [] (int i){
	assert(i>=0 && i<this->size);
	return list[i];
}

template<class T>
const T &Array<T>::operator[](int i) const{
	assert(i>=0 && i<this->size);
	return list[i];
}

template<class T>
Array<T>::operator T*(){
	return this->list;
}

template<class T>
Array<T>::operator const T* ()const{
	return this->list;
}

template<class T>
int Array<T>::GetSize()const{
	return this->size;
}

template<class T>
void Array<T>::ReSize(int sz){
	assert(sz>0);
	if(this->size == sz)
		return;
	T * newList = new T[size];
	int n= (sz<size) ? sz : this->size;
	for(int i=0;i<n;i++){
		newList[i]=list[i];
		delete [] this->list;
		this->list = newList;
		this->size = sz;
	}
}
