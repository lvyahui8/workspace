#include <iostream>
#include <cstring>
#include <csstdio>
#include <cstdlib>
#include <cmath>
#include <string>
#include <vector>
#include <list>
#include <map>
#include <queue>
#include <stack>
#include <bitset>
#include <algorithm>
#include <numeric>
#include <functional>

use namespace std;

int main(void){
    double n,m;
    while(cin >> n >> m){
        // an = (an - 1)^(1/2);
        double res = 0;
        while(m--){
            res += n;
            n = sqrt(n);
        }
    }
    return 0;
}
