#include <stdio.h>
#define SQR(x) printf("x^2 = %d\n",((x)*(x)));
#define SQR2(x) printf(""#x"^2 = %d\n",((x)*(x)));
#define SQR3(x) printf("%d^2 = %d\n",x,((x)*(x)));
/**
*  �ѵ���
*   �ڽڵ���Ϊn�Ķ��д�i�ڵ㿪ʼ���жѵ���
*/
void heapAjust(int arr[] ,int i,int n){
    // ��i�ڵ㿪ʼ�����ѳ�ΪС�׶�
    int tmp = arr[i],min;
    // ���ӣ����ڽڵ�i���������Ӿ���2i+1���Һ��Ӿ���2i+2;
    for(;(min = 2*i + 1)<n;i = min){
        if(min+1 != n && arr[min] > arr[min+1]) min ++;
        if(arr[i] > arr[min]){
            //  ��СԪ�ط��õ��Ѷ�
            arr[i] = arr[min];
        }
        else break;
    }
    arr[i] = tmp;
}
void heapSort(int arr[],int n){
    // ����
    int i;
    for(i=n>>1;i>=0;i--){
        heapAjust(arr,i,n);
    }
    // ȡ�Ѷ���������
    for(i = n-1;i>0;i--){
        //  ÿ��ȡ�Ѷ���С��Ԫ��������Ԫ�ؽ���������õ��ݼ�����
        int tmp = arr[0];arr[0] = arr[i],arr[i] = tmp;
        //  ɾ��һ��Ԫ�غ���Ҫ�Ӹ�Ԫ�������µ�����
        heapAjust(arr,0,i);
    }
}

/* struct s{
 *     int a;
 *     int b;
 *     int c;
 *     int arr[];
 * };
 *
 * typedef struct s NS;
 * typedef struct s * PNS;
 *
 * void fun(int arr[100]){
 *     printf("%d\n",sizeof(arr));
 * }
 * int arr[5];
 */
/*
 * int f(int * p){
 *     p = NULL;
 * }
 * int f2( int ** pp){
 *     *pp = (int *) malloc(sizeof (int));
 *     **pp = 9;
 * }
 */
int * getP(){
    int a = 4;
    return &a;
}
 int * getP1(){
     int * p = (int *) malloc(sizeof(int));
     *p = 4;
    return p;
 }
struct emptyS{
};
int main(){
    printf("%d\n",sizeof(struct emptyS));
/*         int *p = getP();
 *         int *p1 = getP1();
 *         printf("%d\n",*p);
 *         printf("%d\n",*p1);
 */
/*     int a = 3;
 *     int *p = &a;
 *     f(p);
 *     printf("%d\n",*p);
 *
 *     f2(&p);
 *     printf("%d\n",*p);
 */

    // ֱ�ӳ�ʼ��
/*     struct s ele = {1,2};
 *     struct s ele2 = {.a = 1};
 *
 *     NS ns;
 *     const PNS pns1 = &ns;
 *     pns1->a = 8;
 *     NS ns2 ;
 *     //pns1 = &ns2;
 *     PNS const pns2 = &ns;
 *     pns2->a = 8;
 */
    //pns2 = &ns2;
    //int arr[] = {1,3,2,5,2,9,6},i,n=sizeof(arr)/sizeof(arr[0]);
    //heapSort(arr,n);
    //for(i=0;i<n;i++){
    //    printf("%d ",arr[i]);
    //}

    //PNS p = (PNS) malloc(sizeof(NS)+100*sizeof(int));

    //printf("%d\n",sizeof int);
    //register int a = 0;
    //printf("%d\n",&a);
    //const int a = 4;
    //int arr[a];


/*     int str = 'ABCD';
 *
 *     int a = 3,b = 4,m;
 *     switch(a){
 *     case 1:
 *         printf("1");
 *         break;
 *         if(b == 4){
 *             case 2:
 *                 printf("2");
 *                 ;
 *         }else case 3:{
 *             printf("3");
 *             for(m = 1;m<3;m++){
 *             case 4:
 *                 printf("4");
 *                 ;
 *             }
 *         }
 *             default:
 *                 break;
 *     }
 *     // ���н�� 344
 *     char ch = 'c';
 *     switch(ch){
 *     case 'a'...'z':
 *         printf("a-z");
 *         break;
 *     case 'A'...'Z':
 *         printf("A-Z");
 *         break;
 *     default:
 *         break;
 *     }
 *     //���н��a-z
 *     char c1,c2;
 *     scanf("%c%*c%c",&c1,&c2);
 *     putchar(c1);
 *     putchar(c2);
 */
/*     SQR(3);
 *     SQR2(3);
 *     SQR3(3);
 */

    //int arr[3] = {1,2,3};
/*     int a2[3];
 *     int * p = a2;
 *     arr = p;
 *     arr = a2;
 */

/*     int arr[3] = {1,2,3};
 *     fun(arr); // 4
 *
 *     int a=3;
 *     float m = 3.1415926;
 *     printf("%.*f\n",a,m);   // 3.142
 */

    //*(int*)0x12ff7c = 100;
    //printf("%d\n",*(int*)0x12ff7c);

    //int arr[5] = {1,2,3,4,5};
    //printf("%d\n",*(*(&arr+1)-1));
/*     int arr[5] = {1,2,3,4,5};
    *     int * p = a;
 *     printf("%d\n",*(*(&p+1)-1));
 */


    return 0;
}
