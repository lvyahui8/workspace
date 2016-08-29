#include <iostream>

using std::cout;
using std::endl;

class Dog
{
private:
	char name[10];
	int age;
	int weight;
public:
	Dog(char *n,int a,int w);
	void setDog(int aj,int wj);
	void showDog()
	{
		cout<<"Name:"<<name<<endl;
		cout<<"Age:"<<age<<endl;
		cout<<"Weight:"<<weight<<endl;
	}
};

Dog::Dog(char *n,int a,int w)
{	
	strcpy(name,n);
	age=a;
	weight=w;
}

void Dog::setDog(int aj=0,int wj=0)
{
	cout<<"年龄增加"<<aj<<endl;
	cout<<"体重增加"<<wj<<endl;
	age+=aj;
	weight+=wj;
}

void main()
{
	Dog myDog("myMM",3,20);

	myDog.showDog();

	myDog.setDog(1,2);

	myDog.showDog();
}