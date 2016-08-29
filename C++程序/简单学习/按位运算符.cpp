#include <iostream>
using std::cout;
using std::endl;
void main()
{
	//按位 与& 运算符，一般用于选择整数值中特定的一个位或一组位。例
	//指定一种 样式为6、   斜体、黑体、 12磅字号的字体。
	//即         00000110   1	  0	    01100    还多出一个没使用的位
	//那么就可以把font变量的值初始化为二进制数 0000 0110 0100 1100
	unsigned short font = 0x064C;	  // ==  0000 0110 0100 1100

	//要使用字号，需要从font变量中提取它，这个可以使用 按位与 运算符来实现。
	//只有当两个位都是1时，按位与 运算符才会产生1
	//为此我们只需定义一个值，该值在我们感兴趣的位上为1，在其他位为0。这种值称为掩码
	unsigned short size_mask = 0x1F;	// ==0000 0000 0001 1111

	//按位与 运算符
	unsigned short size = font & size_mask;
	//	font				0000 0110 0100 1100
	//	size_mask			0000 0000 0001 1111
	//	font & size_mask	0000 0000 0000 1100 == 12(10)

	//同样，要使用样式。也可以使用同样的方法。但需要把得到的值右移，在这里是右移 8 位
	unsigned short style_mask = 0xFF00;	// ==1111 1111 0000 0000
	unsigned short style = (font & style_mask) >> 8;
	//	font						0000 0110 0100 1100
	//	style_mask					1111 1111 0000 0000
	//	font & style_mask			0000 0110 0000 0000
	//	(font & style_mask) >> 8	0000 0000 0000 0110	== 6(10)

	//使用按位或运算符
	//可以使用按位或运算符设置一个位或者多个位。需要设置斜体和黑体位，下面定义掩码，选择这些位
	unsigned short italic = 0x40U;
	unsigned short bold = 0x20U;
	//下面的语句设置黑体位
	font |= bold;
	//	font			0000 0110 0100 1100
	//	bold			0000 0000 0010 0000
	//	font | bold		0000 0110 0110 1100

	//当然，可以同时设置 多个位。例,同时设置斜体与黑体
	font |= bold|italic;
	//在这里 如果要设置的位处于开（1），那么就要使用 按位与& 来设置，要设置的位为0，其他位为1
	//下面来关闭刚才打开的黑体位
	font &= ~bold;
	//还可以使用&运算符把几个掩码组织起来，把多个位设置为0
	font &= ~bold & ~italic;


	//按位异或运算符^，主要用于绘图
	unsigned long red = 0xFF0000UL;
	unsigned long white = 0xFFFFFFUL;
	//创建一个掩码，用于在红色和白色之间来回切换，并把包含绘图颜色的变量初始化为红色
	unsigned long mask = red ^ white;
	unsigned long draw_color = red;
	//	red		1111 1111 0000 0000 0000 0000
	//	white	1111 1111 1111 1111 1111 1111
	//	mask	0000 0000 1111 1111 1111 1111
	//很显然，mask与red进行异或，就会得到white，mask与white异或，就会得到red
	//所以可以用下面的 语句进行切换
	draw_color ^= mask;
}