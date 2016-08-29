#include <iostream>

using std::cout;
using std::cin;
using std::endl;

int i;							//在全局命名空间中的全局变量
namespace Ns{
	int j;						//在Ns命名空间中的全局变量
}

void main()
{
	i = 5;
	Ns::j = 6;			
	{							//子块 1
		using namespace Ns;		//使得在当前块中可以直接引用Ns命名空间中的标识符
		int i;					//局部变量，局部作用域
		i = 7;
		cout<<"i="<<i<<endl;
		cout<<"j="<<j<<endl;
	}
	cout<<"i="<<i<<endl;
}