#include <stdafx.h>
#include <math.h>

int main()
{
	int x,y,z;
	for(x=0;x<=100;x++)
		for(y=0;y<=100;y++)
			for(z=0;z<=(100-x-y);z++)
				if(5*x+3*y+double(z/3)==100 && x+y+z==100)
					printf("%d,%d,%d\n",x,y,z);
	return 0;
}