#include "CTest.h"

CTest::CTest()
{
    //ctor
}
CTest::CTest(unsigned int counter, unsigned id, string name)
{
    this.m_Counter = counter;
    this.id = id;
    this.name = name;
}

CTest::~CTest()
{
    //dtor
}


void main(){
    CTest test(23,34,"nihao");
    cout<<test.toString();
}
