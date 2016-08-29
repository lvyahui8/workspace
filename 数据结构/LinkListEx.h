#ifndef __LINKLISTEX_H__
#define __LINKLISTEX_H__
#include <string>
using std::string;
//================双向链表的定义===============
template<class T>
class DulLinkList
{
private:
	typedef struct DulNode{
		struct DulNode * prior;
		T	data;
		struct DulNode * next;
	}DulNode;
	DulNode * frist;
	void Init();
	void Del(DulNode * delNode);
public:
	DulLinkList();
	~DulLinkList();
	void AddElem(const T &  data);
	void DelElem(const T & data);
	string ToString()const;
protected:
};
#endif//__LINKLISTEX_H__