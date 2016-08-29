#include <iostream>

using std::cout;
using std::endl;

class Cat{
private:
	static int HowManyCats;
	char sex;
public:
	Cat(char sex);
	static void GetHowMany(const Cat &ThisCat);
};

int Cat::HowManyCats = 0;

Cat::Cat(char sex){
	HowManyCats++;
	this->sex=sex;
}

void Cat::GetHowMany(const Cat &ThisCat){
	//静态函数成员可以直接访问函数成员和静态数据。而访问非静态成员，必须通过对象名
	cout<<"现在共有"<<HowManyCats<<"只猫"<<endl;
	switch(ThisCat.sex){
	case 'W':cout<<"这只是母的"<<endl;break;
	case 'M':cout<<"这只是公的"<<endl;break;
	default:break;
	}
}

int main(int argc, char *argv[]){
	Cat myCat('W');
	myCat.GetHowMany(myCat);
	return 0;
}
