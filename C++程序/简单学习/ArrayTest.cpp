#include <iostream>
#include <iomanip>
#include "Array.h"
using std::cout;
using std::cin;
using std::endl;
using std::setw;
void main(){
	Array<int>iArray(5);
	int count =0;
	int n;
	cin>>n;
	int i;
	for(i=0;i<iArray.GetSize();i++){
		bool isPrime = true;
		for(int j=0;j<count;j++){
			if(i%iArray[j] == 0){
				isPrime = false;
				break;
			}
		}

		if(isPrime){
			if(count == iArray.GetSize())
				iArray.ReSize(count*2);
			iArray[count++] = i;
		}
	}

	for(i=0;i<count;i++)
		cout<<setw(8)<<iArray[i];
	cout<<endl;
}