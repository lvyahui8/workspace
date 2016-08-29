#include <stdafx.h>
#include <math.h>

void main()
{
	 //½üËÆÇó¦Ð£»¦Ð/4=1-1/3+1/5-1/7+1/9-¡¤¡¤¡¤
	float t=1,pi=0,n=1,s=1;
	//while(t>=10^(-6) || t<=-10^(-6))
	while(fabs(t)>=1e-6)
	{
		pi+=t;
		n+=2;
		s=-1*s;
		t=s/n;
	}
	printf("¦Ð=%g\n",pi*4);
}