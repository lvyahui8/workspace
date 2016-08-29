#include <iostream>
using std::cout;
using std::endl;
//֪ʶ��
// 1���ڶ�������Ķ���ʱ������Ĺ��캯���ȱ����ã�����󱻵��ã������������෴
// 2���������ഫ�����ݿ���ͨ�����캯����ʼ���б�
// 3���������ǣ�����ĺ������Ǹ���ĺ���
// 4����̬�ԣ����ǽ����ຯ����Ϊ�麯������ô�������ַ���ú���ʱ�������У����������ģ�����û�о͵��ø����
// 5�����麯��������ֻ������������������ȥ���Ʒ���������������Ͳ���ʵ��������
class Animal{
public:
	Animal(int weight,int height){
		cout<<"animal construct"<<weight<<":"<<height<<endl;
	}
	~Animal(){
		cout<<"animal deconstruct"<<endl;
	}
	void breathe(){
		cout<<"animal breathe"<<endl;
	}
	virtual void sleep() = 0;//���麯��������������ȥʵ�ָ÷��������಻ָ�����巽��
};

class Fish : public Animal{
public:
	// ���캯���ĳ�ʼ���б�
	Fish(int w,int h) : Animal(w,h),a(12){
		cout<<"fish construct"<<endl;
	}
	~Fish(){
		cout<<"fish deconstruct"<<endl;
	}
	//��������
//	virtual void breathe(){		//�麯��
	void breathe(){
		Animal::breathe(); //���������ϸ���ĺ�����ʽ
		cout<<"fish breathe"<<endl;
	}
	void sleep(){
		cout<<"fish sleep"<<endl;
	}
private:
	const int a;
};
void fn(Animal *pAn){
	pAn->breathe();
}

void main(){
	Fish myFish(30,60);
	/*
	myFish.breathe();	//���������ĺ�����ʽ
	Animal *pAn;
	pAn=&myFish;
	fn(pAn);			//����ø���ĺ�����ʽ,�����Ҫ������ĺ�����ʽ�����Խ���ĺ�����ʽ��Ϊ�麯��
	*/
	myFish.sleep();
	int a=6;
	int &b=a;
	b=5;
	cout<<a<<endl;
}