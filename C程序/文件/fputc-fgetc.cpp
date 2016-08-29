#include "stdafx.h"
#include <stdlib.h>

void main()
{
	char strptr1[]="dfd df df er dfg!1\n";
	char *p;

	p=strptr1;
	while( (*p != '\0') && fputc(*(p++),stdout) != EOF);
}