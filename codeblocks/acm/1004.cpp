#include<stdio.h>
int main()
{
	printf("#include <stdio.h>\n");
	printf("int main()\n");
	printf("{\n");
	printf("    int a,b;\n");
	printf("    while(scanf(\"%%d%%d\",&a,&b) != EOF)\n");
	printf("        printf(\"%%d\\n\",a+b);\n");
	printf("    return 0;\n");
	printf("}\n");
	return 0;
}
