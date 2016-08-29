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
	//��̬������Ա����ֱ�ӷ��ʺ�����Ա�;�̬���ݡ������ʷǾ�̬��Ա������ͨ��������
	cout<<"���ڹ���"<<HowManyCats<<"ֻè"<<endl;
	switch(ThisCat.sex){
	case 'W':cout<<"��ֻ��ĸ��"<<endl;break;
	case 'M':cout<<"��ֻ�ǹ���"<<endl;break;
	default:break;
	}
}

int main(int argc, char *argv[]){
	Cat myCat('W');
	myCat.GetHowMany(myCat);
	return 0;
}
