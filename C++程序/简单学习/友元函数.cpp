
#include <iostream>

using std::cout;
using std::endl;

class CA
{
	int i;
	void cam()
	{
		cout<<i<<endl;
	}
public:
	friend void gm();
};

void gm()
{
	CA a;
	a.i=10;
	cout<<a.i<<endl;
	a.cam();
}
void main()
{
	gm();
}
