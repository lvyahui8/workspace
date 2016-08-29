#include <stdio.h>

struct s1 {

    char ch, *ptr;// 1 + 4 bit

    union {
        short a, b;
        unsigned int c:2, d:1;
    };

    struct s1 * next;// 4 bit
} ms,*pa,arr[10];

struct naturalalign
{
    char a;
    short b;
    int c;
};
#pragma pack (2)
//如果#pragma pack (n)中指定的 n 大于结构体中最大成员的 size，则其不起作用，结构体
//仍然按照 size 最大的成员进行对界。
struct naturalalign2
{
    char a;
    short b;
    int c;
};
#pragma pack ()
int main(){
    struct s1 s;
    struct s1 * p;
    p = &s;
    printf("%d\n",sizeof s);
    printf("%d\n",sizeof ms);
    printf("%d\n",sizeof p);
    printf("%d\n",sizeof *p);
    p = &ms;
    ms.ch = 's';
    pa = &ms;
    printf("%c\n",(*p).ch);
    printf("%c\n",p->ch);

    struct naturalalign n1;
    printf("%d\n",sizeof n1);

    struct naturalalign2 n2;
    printf("%d\n",sizeof n2);

    // C++ 中，依然可以在定义结构体时直接初始化，这是为了保留对c的兼容，这也是结构体和类的重要区别之一
    struct naturalalign n3 = {'2',2,2};

    return 0;
}

