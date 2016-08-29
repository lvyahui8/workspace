#ifndef __ARRAY_H__
#define __ARRAY_H__

template<class T>
class Array{
private:
	T * list;
	int size;
public:
	Array(int sz=50);
	Array(const Array<T>&a);
	~Array();
	Array<T>& operator = (const Array<T>&rhs);
	T & operator [] (int i);
	const T & operator [] (int i)const;
	operator T* ();
	operator const T* ()const;
	int GetSize()const;
	void ReSize(int sz);
};
#endif//__ARRAY_H__