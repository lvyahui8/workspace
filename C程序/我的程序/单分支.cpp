#include <stdafx.h>

//�ĵ����1��1   2��68  3�� 2  4��4

void question1()
{
	printf("#include <stdio.h>\n#define DUG\n\nvoid main()\n{\n\tif(5)\n");
	printf("\t{\n\t\t#ifdef DUG\n\t\t\tprintf(\"1\\n\");\n\t\t#else\n");
	printf("\t\t\tprintf(\"0\\n\");\n\t\t#endif\n");
	printf("\t}\n}\n");
	printf("�˳�����������ʲô:");
}

void question2()
{
	printf("#include <stdio.h>\n\nvoid main()\n{\n\tfloat x=2.5,y=4.7;\n\tint a=7,b=1;\n");
	printf("\tif(x+a%%3*(int)(x+y)%%2/4)\n\t{\n\t\tprintf(\"%%d\",(int)( (float)(a+b)/2+(int)x%%(int)y ));\n");
	printf("\n\t}\n\tprintf(\"8\\n\");\n}\n");
	printf("�˳�����������ʲô:");
}

void question3()
{
	printf("#include <stdio.h>\n\nvoid main()\n{\n\tchar str[10];\n\tchar *_str;\n\tgets(str);\n");
	printf("\tfor(_str=str;*_str !='\\0';_str++)\n\t{\n\t\tif(*_str>='a' && *_str<='z')\n\t\t{\n\t\t\t");
	printf("if('z'==*_str)\n\t\t\t{\n\t\t\t\t*_str=*_str-25;\n\t\t\t}\n\t\t\t\telse\n");
	printf("\t\t\t{\n\t\t\t\t\n\t\t\t\t*_str=*_str+1;\n\t\t\t}\n\t\t}\n\t}\n\tputs(str);\n}\n");
	printf("��������ַ���zhe�����������\t1��ifa 2��aif 3��bjg 4��jbg \n");
	printf("��Ĵ���ʲô:");
}

void question4()
{
	printf("ǰ�������⣬������Щ���ݼ�֪ʶ�㱻�õ���\n\n");
	printf("\t1����֧�ṹ���������룬�Զ��庯����ָ��\n");
	printf("\t2���ṹ�壬�궨�壬�������飬ָ��\n");
	printf("\t3����������ת�����ַ����飬ָ�룬ȫ�ֱ���\n");
	printf("\t4���궨�壬�������룬ָ�룬��������ת��\n");
	printf("��Ĵ���:");
}

/*��һ��:
#include <stdio.h>
#define DUG  //�궨�� DUG
void main()
{
	if(5)
	{
		#ifdef DUG
			printf("1\n");
		#else
			printf("0\n");
		#endif
	}
	//������  1
}


�ڶ���:

#include <stdio.h>

void main()
{
	float x=2.5,y=4.7;
	int a=7,b=1;
	if(x+a%3*(int)(x+y)%2/4) //2.5 +  0
	{
		printf("%d",(int)( (float)(a+b)/2+(int)x%(int)y ));
		//							4.0   +  2.0  
	}
	printf("8\n");
	//    ��ӡ��� 68
}


������:

#include <stdio.h>

void main()
{
	char str[10];
	char *_str;
	gets(str);
	for(_str=str;*_str != '\0';_str++)
	{
		if(*_str>='a' && *_str<='z')
		{
			if('z'==*_str)
			{
				*_str=*_str-25;
			}
			else
			{
				*_str=*_str+1;
			}
		}
	}
	puts(str);

	����zhe  ���  aif   ���� 2
}

������:


ǰ�������⣬������Щ���ݼ�֪ʶ�㱻�õ���
1����֧�ṹ���������룬�Զ��庯����ָ��
2���ṹ�壬�궨�壬�������飬ָ��
3����������ת�����ַ����飬ָ�룬ȫ�ֱ���
4���궨�壬�������룬ָ�룬��������ת��

��   4

*/



