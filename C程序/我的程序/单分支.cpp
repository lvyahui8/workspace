#include <stdafx.h>

//四道题答案1、1   2、68  3、 2  4、4

void question1()
{
	printf("#include <stdio.h>\n#define DUG\n\nvoid main()\n{\n\tif(5)\n");
	printf("\t{\n\t\t#ifdef DUG\n\t\t\tprintf(\"1\\n\");\n\t\t#else\n");
	printf("\t\t\tprintf(\"0\\n\");\n\t\t#endif\n");
	printf("\t}\n}\n");
	printf("此程序输出结果是什么:");
}

void question2()
{
	printf("#include <stdio.h>\n\nvoid main()\n{\n\tfloat x=2.5,y=4.7;\n\tint a=7,b=1;\n");
	printf("\tif(x+a%%3*(int)(x+y)%%2/4)\n\t{\n\t\tprintf(\"%%d\",(int)( (float)(a+b)/2+(int)x%%(int)y ));\n");
	printf("\n\t}\n\tprintf(\"8\\n\");\n}\n");
	printf("此程序输出结果是什么:");
}

void question3()
{
	printf("#include <stdio.h>\n\nvoid main()\n{\n\tchar str[10];\n\tchar *_str;\n\tgets(str);\n");
	printf("\tfor(_str=str;*_str !='\\0';_str++)\n\t{\n\t\tif(*_str>='a' && *_str<='z')\n\t\t{\n\t\t\t");
	printf("if('z'==*_str)\n\t\t\t{\n\t\t\t\t*_str=*_str-25;\n\t\t\t}\n\t\t\t\telse\n");
	printf("\t\t\t{\n\t\t\t\t\n\t\t\t\t*_str=*_str+1;\n\t\t\t}\n\t\t}\n\t}\n\tputs(str);\n}\n");
	printf("如果输入字符串zhe，则输出的是\t1、ifa 2、aif 3、bjg 4、jbg \n");
	printf("你的答案是什么:");
}

void question4()
{
	printf("前面三道题，以下哪些内容及知识点被用到了\n\n");
	printf("\t1、分支结构，条件编译，自定义函数，指针\n");
	printf("\t2，结构体，宏定义，整型数组，指针\n");
	printf("\t3、数据类型转换，字符数组，指针，全局变量\n");
	printf("\t4、宏定义，条件编译，指针，数据类型转换\n");
	printf("你的答案是:");
}

/*第一题:
#include <stdio.h>
#define DUG  //宏定义 DUG
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
	//输出结果  1
}


第二题:

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
	//    打印结果 68
}


第三题:

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

	输入zhe  输出  aif   答案是 2
}

第三题:


前面三道题，以下哪些内容及知识点被用到了
1、分支结构，条件编译，自定义函数，指针
2，结构体，宏定义，整型数组，指针
3、数据类型转换，字符数组，指针，全局变量
4、宏定义，条件编译，指针，数据类型转换

答案   4

*/



