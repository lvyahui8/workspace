// ������01.cpp : Defines the entry point for the console application.
//

#include <stdafx.h>
#include <stdlib.h>

void tj(char x,char y);
int sum=0;

int main()
{
    char a;
	float b;
	printf("		***ͬѧ����ӭ���뿼�Խ���\n		����ϸ�Ķ�������Ŀ����������Ѵ𰸡�\n		�����Ծ�ʮ���⣬ÿ��ʮ�֣�����120�֡�\n		ÿ����������һ��������ᣬ���󽫲������\n		�밴�������𣬷��򽫲�������\n");
	printf("�밴������س�����");
	a=getchar();
	getchar();
	tj('_',a);

	printf("1.���������ȷ����\nA.if(a+b=10)	B.if(i<10)		C.if(a=1) i=a-b;	D.���ϱ��ʽȫ��\n  {  	          {			  {\n	i++;					else if(a<1) i=a+b;\n  else		  else\n	++i;		++i;		  }\n  }		  }			\n\n");
	a=getchar();
	getchar();
	tj('C',a);//scanf("%d %d",&tihao,&daan)   switch(tihao) {case 1: if(daan!=zdaan) goto pi;}

	/*if( a=='B')
	{ b=10;
	 printf("b=%f��\n",b);
    } 
	else 
	{ b=0;
      system("cls");
	}*/
    printf("2.��������д���ĵط�����\nswitch(ch)\n{\ncase '1':i+=10;\ncase '2':i+=0;\n}\nA.���ʽ��ch����	B.�����е�''��	C.û��default���	D.û�д���\n");
    a=getchar();
	getchar();
	tj('B',a);

	/*if( a=='C')
	{ b=10;
	 printf("b=%f��\n",b);
    } 
	else 
	{ b=0;
      system("cls");
	}
	*/
	printf("3.���г����д���ĵط���\n#include\"stdio.h\"----1\nint main()\n{\n	int i;\n	char ch;----2\n		swtich----3(ch)\n	{\n		case 'a':i+=5;\n	case 'b':i+=5;\n	case 'c':i+=0;\nA.��1���д���\nB.��2���д���\nC.��3���д���\nD.û�д���\n");
	a=getchar();
	getchar();
	tj('C',a);


	printf("4.��˫��֧�ṹif* else�е�*��Ƕ�뵥��֧�ṹif����Vc�����л�����\n");
	printf(" A.����ִ�������ṹ�������������ݶ��ᰴ�������\n"); 
    printf(" B.����ִ�г��򣬵�����ɶ�ʧ\n"); 
    printf(" C.�޷����У��ᱨ��\n"); 
    printf(" D.���ϴ𰸶�����\n");
	a=getchar();
	getchar();
	tj('C',a);

	printf("5.if����еġ����ʽ���������ǣ��� \n");
	printf("A.��ϵ���ʽ  B.�߼����ʽ  C.��ֵ���ʽ  D.�жϱ��ʽ \n");
	a=getchar();
	getchar();
	tj('D',a);

	printf("6. switch���������ڵġ����ʽ������ֵ������ӦΪ�������͡�\n");
	printf("A.������  B.����  C.��  D.����\n");
	a=getchar();
	getchar();
	tj('B',a);

	printf("7.��ϵ����������ȼ������������������ϵ����������ȼ�������ֵ�������\n");	
	printf("A.���ڡ�����   B.���ڡ�����   C.���ڡ�����   D.���ڡ�����\n");
	a=getchar();
	getchar();
	tj('A',a);

	printf("8.���й���C���Ե������������____ \n");
	printf("A. ��д��ĸ��Сд��ĸ��������ͬ \nB. ��ͬ���͵ı���������һ�����ʽ�� \nC. �ڸ�ֵ���ʽ�еȺ�(=)��ߵı������ұߵ�ֵ�����ǲ�ͬ����  \nD. ͬһ����������ڲ�ͬ�ĳ��Ͽ����в�ͬ�ĺ��� \n");
    a=getchar();
	getchar();
	tj('A',a);

	printf("9.if�����, if����û�л����ſ���ִ�м������\n");
	printf("A.һ��	B.����	C.����	D.�޷�ִ��\n");
	a=getchar();
	getchar();
	tj('A',a);

    printf("10.switch����У�case����������ͬô\n");
	printf("A.���ԣ�ֻ��ִ�е�һ��	B.���ԣ����ᶪʧ	C.���ԣ�ȫ��ִ��	D.������\n");
    a=getchar();
	getchar();
	tj('D',a);

	printf("11.if����еġ����ʽ����������ֵ���ʽô__;\nswitch����������ڵı��ʽ��ֵ���Ϳ������ַ���ô__ \n");
	printf("A.���ԣ�������	B.���ԣ�����	C.�����ԣ�����	D.�����ԣ�������\n");
    a=getchar();
	getchar();
	tj('B',a);

	printf("12.��˫��֧�ṹif��{ }��else����Ƕ��һ��˫��֧if else�ṹ�����û�С�{}��������\n");
	printf("  A.ִֻ��һ��if else\n  B.����ִ�У�������ɶ�ʧ\n  C.�޷�ִ�У��ᱨ��\n  D.��̫��Ӱ�죬ֻ�ǲ����Ҵ�\n");
    a=getchar();
	getchar();
	tj('D',a);

    if(sum>=90)
	{
		 printf("		�����ܵ÷�Ϊ%d��\n",sum);
	     printf("		��ϲ�������ĳɼ��ﵽ����!\n");
	}
	else
	{
         
         printf("		�����ܵ÷�Ϊ%d��\n",sum);
	     printf("		���������Ŭ��!\n");
	}
	printf("		������죬лл���Ĳ���!\n");
	a=getchar();
	getchar();
	tj('_',a);
	return 0;
}

void tj(char x,char y)
{
	if(x==y)
	{
		sum+=10;
	}
	system("cls");
}

