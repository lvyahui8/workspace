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
//���#pragma pack (n)��ָ���� n ���ڽṹ��������Ա�� size�����䲻�����ã��ṹ��
//��Ȼ���� size ���ĳ�Ա���жԽ硣
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

    // C++ �У���Ȼ�����ڶ���ṹ��ʱֱ�ӳ�ʼ��������Ϊ�˱�����c�ļ��ݣ���Ҳ�ǽṹ��������Ҫ����֮һ
    struct naturalalign n3 = {'2',2,2};

    return 0;
}

