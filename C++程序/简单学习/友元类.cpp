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
	friend class CB;

};
class CB
{
public:
	void bm(CA &a)
	{
		a.i = 10;
		a.cam();
	}
};
void main()
{

}