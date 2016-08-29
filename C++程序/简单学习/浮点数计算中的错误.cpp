/*
//未使用操纵程序

#include <iostream>
using std::cout;
using std::endl;

void main()
{
	float value1 = 0.1f;
	float value2 = 2.1f;

	value1 -= 0.09f;			//Should be 0.01
	value2 -= 2.09f;			//Should be 0.01

	cout<<value1-value2<<endl;	//Should outout 0

	cout<<value1<<endl;
	cout<<value2<<endl;
}

//Operation result:

//7.45058e-009
//0.01
//0.00999999
*/

//使用操纵程序

#include <iostream>
#include <iomanip>

using std::cout;
using std::endl;
using std::setprecision;
using std::fixed;
using std::scientific;


void main()
{
	float value1 = 0.1f;
	float value2 = 2.1f;

	value1 -= 0.09f;					//Should be 0.01
	value2 -= 2.09f;					//Should be 0.01

	cout<<setprecision(14)<<fixed;		//Change to fixed notation	
	cout<<value1-value2<<endl;			//Should outout 0

	cout<<setprecision(5)<<scientific;	//Set scientific notation
	cout<<value1-value2<<endl;			//Should output 0
}

//Operation result:

//7.45058e-009
//0.01
//0.00999999
