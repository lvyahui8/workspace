/*
*	再讲之前，先给各位看看国际C混码大赛（IOCCC）的经典得奖作品，能获奖的人毫无疑问是世界顶级C程序员。
*
*	希望大家能够明白代码规范整洁的重要性
*
*	大师把代码写成这样是经典，菜鸟写成这样就是垃圾


下面这个灵巧的飞行模拟器，为1998年IOCCC得奖作品

#include                                      <math.h>
#include                                    <sys/time.h>
#include                                    <X11/Xlib.h>
#include                                   <X11/keysym.h>
                                           double L ,o ,P
                                          ,_=dt,T,Z,D=1,d,
                                          s[999],E,h= 8,I,
                                          J,K,w[999],M,m,O
                                         ,n[999],j=33e-3,i=
                                         1E3,r,t, u,v ,W,S=
                                         74.5,l=221,X=7.26,
                                         a,B,A=32.2,c, F,H;
                                         int N,q, C, y,p,U;
                                        Window z; char f[52]
                                     ; GC k; main(){ Display*e=
  XOpenDisplay( 0); z=RootWindow(e,0); for (XSetForeground(e,k=XCreateGC (e,z,0,0),BlackPixel(e,0))
 ; scanf("%lf%lf%lf",y +n,w+y, y+s)+1; y ++); XSelectInput(e,z= XCreateSimpleWindow(e,z,0,0,400,400,
 0,0,WhitePixel(e,0) ),KeyPressMask); for(XMapWindow(e,z); ; T=sin(O)){ struct timeval G={ 0,dt*1e6}
 ; K= cos(j); N=1e4; M+= H*_; Z=D*K; F+=_*P; r=E*K; W=cos( O); m=K*W; H=K*T; O+=D*_*F/ K+d/K*E*_; B=
 sin(j); a=B*T*D-E*W; XClearWindow(e,z); t=T*E+ D*B*W; j+=d*_*D-_*F*E; P=W*E*B-T*D; for (o+=(I=D*W+E
 *T*B,E*d/K *B+v+B/K*F*D)*_; p<y; ){ T=p[s]+i; E=c-p[w]; D=n[p]-L; K=D*m-B*T-H*E; if(p [n]+w[ p]+p[s
 ]== 0|K <fabs(W=T*r-I*E +D*P) |fabs(D=t *D+Z *T-a *E)> K)N=1e4; else{ q=W/K *4E2+2e2; C= 2E2+4e2/ K
  *D; N-1E4&& XDrawLine(e ,z,k,N ,U,q,C); N=q; U=C; } ++p; } L+=_* (X*t +P*M+m*l); T=X*X+ l*l+M *M;
   XDrawString(e,z,k ,20,380,f,17); D=v/l*15; i+=(B *l-M*r -X*Z)*_; for(; XPending(e); u *=CS!=N){
                                    XEvent z; XNextEvent(e ,&z);
                                        ++*((N=XLookupKeysym
                                          (&z.xkey,0))-IT?
                                          N-LT? UP-N?& E:&
                                          J:& u: &h); --*(
                                          DN -N? N-DT ?N==
                                          RT?&u: & W:&h:&J
                                           ); } m=15*F/l;
                                           c+=(I=M/ l,l*H
                                           +I*M+a*X)*_; H
                                           =A*r+v*X-F*l+(
                                           E=.1+X*4.9/l,t
                                           =T*m/32-I*T/24
                                            )/S; K=F*M+(
                                            h* 1e4/l-(T+
                                            E*5*T*E)/3e2
                                            )/S-X*d-B*A;
                                            a=2.63 /l*d;
                                            X+=( d*l-T/S
                                             *(.19*E +a
                                             *.64+J/1e3
                                             )-M* v +A*
                                             Z)*_; l +=
                                             K *_; W=d;
                                             sprintf(f,
                                             "%5d  %3d"
                                             "%7d",p =l
                                            /1.7,(C=9E3+
                               O*57.3)%0550,(int)i); d+=T*(.45-14/l*
                              X-a*130-J* .14)*_/125e2+F*_*v; P=(T*(47
                              *I-m* 52+E*94 *D-t*.38+u*.21*E) /1e2+W*
                              179*v)/2312; select(p=0,0,0,0,&G); v-=(
                               W*F-T*(.63*m-I*.086+m*E*19-D*25-.11*u
                                )/107e2)*_; D=cos(o); E=sin(o); } }



下面是 Ian Phillipps于1988年IOCCC获奖作品,效果是打印出一首歌的歌词

#include <stdio.h>
main(t,_,a)char *a;
{return!0<t?t<3?main(-79,-13,a+main(-87,1-_,
main(-86,0,a+1)+a)):1,t<_?main(t+1,_,a):3,main(-94,-27+t,a)&&t==2?_<13?
main(2,_+1,"%s %d %d\n"):9:16:t<0?t<-72?main(_,t,
"@n'+,#'/*{}w+/w#cdnr/+,{}r/*de}+,/*{*+,/w{%+,/w#q#n+,/#{l+,/n{n+,/+#n+,/#\
;#q#n+,/+k#;*+,/'r :'d*'3,}{w+K w'K:'+}e#';dq#'l \
q#'+d'K#!/+k#;q#'r}eKK#}w'r}eKK{nl]'/#;#q#n'){)#}w'){){nl]'/+#n';d}rw' i;# \
){nl]!/n{n#'; r{#w'r nc{nl]'/#{l,+'K {rw' iK{;[{nl]'/w#q#n'wk nw' \
iwk{KK{nl]!/w{%'l##w#' i; :{nl]'/*{q#'ld;r'}{nlwb!/*de}'c \
;;{nl'-{}rw]'/+,}##'*}#nc,',#nw]'/+kd'+e}+;#'rdq#w! nr'/ ') }+}{rl#'{n' ')# \
}'+}##(!!/"):t<-50?_==*a?putchar(31[a]):main(-65,_,a+1):main((*a=='/')+t,_,a+1)
:0<t?main(2,2,"%s"):*a=='/'||main(0,main(-61,*a,
"!ek;dc i@bK'(q)-[w]*%n+r3#l,{}:\nuwloca-O;m.vpbks,fxntdCeghiry"),a+1);}

*/



//下面进入正题
#include "stdafx.h"


// 空结构体的大小为1，并不是0
typedef struct stu
{
	int i;
	int a[];	
	// 柔性数组:结构体最后一个成员可以是未知大小的数组，但在这个数组成员之前结构体至少还要有一个成员，这样的数组称为柔性数组
	// 此时结构体的总大小不包括柔性数组
} Stu;


////////////////////////////////////////////////
//不需要任何局部变量（除去形参）和全局变量的strlen和strcopy函数
int str_len(char * str)
{
	//assert(NULL != str); // 
	return *str ? str_len(str+1)+1 : 0 ;
}

void strcpy(char *box,char *content)
{
	while(*box++ = *content++);
}


void main()
{
////////////////////////////////////////////////
	//关于sizeof的问题，sizeof并不是函数，它属于标准C定义的32个关键字之一，记住一点，并不是接括号的就是函数，并不是会变色的就是C关键字。
	/*
	int *p=NULL;
	int a[10];
	//sizeof  学习
	printf("%d\n",sizeof( (int)*p ));
	printf("%d\n",sizeof p );			//sizeof后面不接括号也可以，但后面不能接类型，接类型必须要加括号，原因自己思考。
	printf("%d\n",sizeof( *p ));
	printf("%d\n",sizeof(a));
	printf("%d\n",sizeof(a[100] ));
	printf("%d\n",sizeof(&a));
	printf("%d\n",sizeof(&a[0]));
	*/
////////////////////////////////////////////////
	
	
////////////////////////////////////////////////
	//关于变量的问题
	/*
	//无符号数引起的错误
	//死循环
	unsigned k;
	for(k=0;k>=0;k--)
		printf("%d ",k);
	//C中寄存器变量地址问题
	register int i;
	scanf("%d",&i);// 可能会有问题，C中不能去寄存器变量地址
	*/
////////////////////////////////////////////////

	
////////////////////////////////////////////////
	//关于if..else的问题
	/*
	if()

		if()
			int a;
		else
	//else 总是与他最近的if构成分支，上面要想将它与第一个if搭配，必须用{}把第一个if分支括起来
	*/
///////////////////////////////////////////////	
	

////////////////////////////////////////////////
	//关于注释的问题
	//int/*...*/i;
	char * s="abcdefg  //gjfdkh";
	//in/*...*/t i;
	//在注释时 \可能会被作为接续符，看下面的例子

	//it is a\
	valid comment?

	//a\
	dfs\
	df\
	df\
	df\
	sad

	/*
	int y,x,*p_x=&x;
	y=x/*p_x; //编译器会认为/*注释的开始，解决方法是在/ *之间留空格，或者(*p)括起来
	*/
	
	/*
	//这是一条合法d\
	单行注释	
	
	/\
		/这是一条合法的单行注释;

	#def\
		ine MAC\
		Ro 这是一条合法的\
		宏定义

	cha\
	r*s="这是一条合法的"\\
	n字符串";
	*/
////////////////////////////////////////////////


////////////////////////////////////////////////
	//关于逻辑运算符的问题
	/*
	int i=0;
	int j=0;
	if((++i>0) || (++j>0) )
	{
		printf("i=%d j=%d\n",i,j);
	}
	// 输出结果为i=1 j=0   
	// 为什么？  因为||运算符是优先级是从左至右，一旦左边表达式值不为0，那么条件一定为真，不会运算再 ++j>0。 && 也类似
	*/
////////////////////////////////////////////////


////////////////////////////////////////////////
	//关于花括号的问题
	/*
	char a[10]={"abcde"};
	char a[10]{="abcde"};
	//花括号的作用会将括号里的内容与外界隔绝开
	*/
////////////////////////////////////////////////


////////////////////////////////////////////////
	//关于++ --的问题
	/*
	int i=3;
	(++i) + (++i) + (++i); 
	++i+++i+++i;			//这个两个表达式的值为多少？
	// 不同编译器，上面两个表达式的值不同。写程序最顾忌出现这样复杂又不可移植的代码
	*/
////////////////////////////////////////////////


////////////////////////////////////////////////
	//关于2/(-2) 2%(-2)的问题
	printf("2/(-2)=%d 2%%(-2)=%d\n",2/(-2),2%(-2));
////////////////////////////////////////////////


////////////////////////////////////////////////
	//关于预处理的问题
	/*
#define SX1(x) x*x //如果x为10+1 则得到 10+1*10+1，显然有问题
#define SX2(x) (x)*(x) //如果SX(x)*SX(x)时，也会出问题
#define SX3(x) ((x)*(x)) // 这样才是最安全的

#pragma message("哈哈.......编译成功")// 在编译输出框输出文本

	// #运算符
#define SQR(x)	printf("The square of "#x" is %d\n",((x)*(x)));
	SQR(8);		//结果为The square of 8 is 64
	
	// ## 运算符 粘合剂 把前后两部分连起
#define XNAME(n) x##n
	XNAME(8);
	//展开会得到 x8
	*/
////////////////////////////////////////////////
	


////////////////////////////////////////////////
	//关于指针的问题
	int *p=(int*)0x12ff7c;
	*p=0x100;
	//等价于
	*(int*)0x12ff7c=0x100;
////////////////////////////////////////////////

	char str[]="ni hao a.";
	printf("strlen == %d\n",str_len(str));
}

