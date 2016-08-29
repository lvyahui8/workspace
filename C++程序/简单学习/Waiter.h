#ifndef __WAITER_H__
#define __WAITER_H__

#include "Boss.h"

class CWaiter{
public:
	friend void CBoss::SetWaiterSalary(CWaiter *pWaiter);
};
#endif