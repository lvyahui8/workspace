#include <iostream>
using namespace std;
class Employee 
{
	private:
		char *name,*address,*city,*postCode;
	public:
		Employee(char *_name,char *_address,char *_city,char *_postCode)
		{
			name = _name;
			address = _address;
			city = _city;
			postCode = _postCode;
		}
	void change_name(char *_name)
		{
			name = _name;
		}
	void display()
		{
			cout << "name : " << name << endl;
			cout << "address : " << address << endl;
			cout << "city : " << city << endl;
			cout << "postcode : " << postCode << endl;
		}
};

int main(int argc,char *argv[])
{
	Employee *e = new Employee("zhangsan","chang d d","beijing","100056");
	e->display();
	e->change_name("lisi");
	e->display();
	delete e;
}






