#include <iostream>
using std::cout;
using std::endl;
//知识点
// 1、在定义子类的对象时，父类的构造函数先被调用，子类后被调用，析构函数则相反
// 2、子类向父类传递数据可以通过构造函数初始化列表
// 3、函数覆盖，子类的函数覆盖父类的函数
// 4、多态性，我们将子类函数设为虚函数，那么用子类地址调用函数时，子类有，则调用子类的，子类没有就调用父类的
// 5、纯虚函数，父类只给出操作名，由子类去完善方法。但这样父类就不能实例化对象
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
	virtual void sleep() = 0;//纯虚函数，可以让子类去实现该方法，父类不指定具体方法
};

class Fish : public Animal{
public:
	// 构造函数的初始化列表
	Fish(int w,int h) : Animal(w,h),a(12){
		cout<<"fish construct"<<endl;
	}
	~Fish(){
		cout<<"fish deconstruct"<<endl;
	}
	//函数覆盖
//	virtual void breathe(){		//虚函数
	void breathe(){
		Animal::breathe(); //可以先用上父类的呼吸方式
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
	myFish.breathe();	//会调用子类的呼吸方式
	Animal *pAn;
	pAn=&myFish;
	fn(pAn);			//会调用父类的呼吸方式,如果想要调用鱼的呼吸方式，可以将鱼的呼吸方式设为虚函数
	*/
	myFish.sleep();
	int a=6;
	int &b=a;
	b=5;
	cout<<a<<endl;
}