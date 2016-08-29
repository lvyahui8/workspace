#ifndef CTEST_H
#define CTEST_H

#include <string>
using std::string;

class CTest
{
    public:
        CTest();
        CTest(unsigned int counter,unsigned id , string name);
        virtual ~CTest();
        unsigned int GetCounter() { return m_Counter; }
        void SetCounter(unsigned int val) { m_Counter = val; }
        unsigned int GetId() { return m_Id; }
        void SetId(unsigned int val) { m_Id = val; }
        String Getname() { return name; }
        void Setname(String val) { name = val; }
        string toString();
    protected:
    private:
        unsigned int m_Counter;
        unsigned int m_Id;
        string name;
};

#endif // CTEST_H
