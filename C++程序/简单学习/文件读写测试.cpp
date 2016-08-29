#include <iostream>
#include <string>
#include<fstream>
using namespace std;

int main(){
	string strTemp="lvyahi";

	ofstream ofstr("string.dat");
	if(!ofstr){
		return 0;
	}
	ofstr.write((char*)& strTemp,sizeof(char*));
	ofstr.close();

	ifstream ifstr("string.dat");
	if(!ifstr){
		return 0;
	}
	string string2;
	ifstr.read((char*)& string2,sizeof(char*));
	string2 +='\0';
	cout<<string2<<endl;
	return 1;
}
