#include <iostream>
#include <cstdlib>
using namespace std;

struct Student{
	int id;
	float gpa;
};

template<class T>
class Store{
private:
	T		item;
	bool	haveValue;
public:
	Store();
	const T& GetElem()const;
	void PutElem(const T &x);
};

template<class T>
Store<T>::Store():haveValue(false){}

template<class T>
const T& Store<T>::GetElem()const{
	if(!haveValue){
		cout<<"No item present!"<<endl;
		exit(0);
	}
	return item;
}
template<class T>
void Store<T>::PutElem(const T &x){
	haveValue = true;
	item = x;
}

void main(){
	Store<int>s1,s2;
	s1.PutElem(3);
	s2.PutElem(-7);
	cout<<s1.GetElem()<<" "<<s2.GetElem()<<endl;

	Student g = {1000,23};
	Store<Student>s3;
	s3.PutElem(g);
	cout<<"The student id is "<<s3.GetElem().id<<endl;

	Store<double>d;
	cout<<"Retrieving object d...";
	cout<<d.GetElem()<<endl<<"nihao";
}
