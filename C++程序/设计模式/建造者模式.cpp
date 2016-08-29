#include <iostream>
#include <string>
using std::cout;
using std::endl;
using std::string;
class Product{
private:
	string str;
public:
	void AddString(string adStr){
		str+=adStr;
	}
	void ShowString()const{
		cout<<str<<endl;
	}
};

class Builder{
	virtual void BuildPartA() =0;
	virtual void BuildPartB() =0 ;
	virtual Product GetProduct();
};

class ConcreteBuilder1 : public Builder{
private:
	Product product;
public:
	void BuildPartA(){
		product.AddString("PartA");
	}
	void BuildPartB(){
		product.AddString("PartB");
	}
	Product GetProduct(){
		return product;
	}
};

class ConcreteBuilder2 : public Builder{
private:
	Product product;
public:
	void BuildPartA(){
		product.AddString("PartX");
	}
	void BuildPartB(){
		product.AddString("PartY");
	}
	Product GetProduct(){
		return product;
	}
};
class Director{
	void Construct(Builder *pbuilder){
		pbuilder->BuildPartA();
		pbuilder->BuildPartB();
	}
};

void main(){
	Director director;
	Builder *pB1 = new ConcreteBuilder1();
	Builder *pB2 = new ConcreteBuilder2();
	director.Construct(pB1);
	Product *pPro1 = pB1->GetProduct();
	director.Construct(pB2);
	pPro2->ShowString();
	Product *pPro2 = pB2->GetProduct();
	pPro2->ShowString();
}