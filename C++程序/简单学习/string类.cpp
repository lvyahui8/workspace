已知类String的原型为：
class String
{
public:
	String(const char *str = NULL);// 普通构造函数
	String(const String &other); //拷贝构造函数
	~String(void); //析构函数
	String & operator =(const String &other);//赋值函数
private:
	char *m_data;// 用于保存字符串
};
请编写String的上述4个函数。
//普通构造函数
String::String(const char *str)
{
	if(str==NULL)
	{
		m_data = new char[1]; // 对空字符串自动申请存放结束标志'\0'的//加分点：对m_data加NULL 判断
		*m_data = '\0';
	}
	else
	{
		int length = strlen(str);
		m_data = new char[length+1]; // 若能加 NULL 判断则更好
		strcpy(m_data, str);
	}
}


// String的析构函数
String::~String(void)
{
	delete[] m_data; // 或delete m_data;
}
//拷贝构造函数
String::String(const String &other) // 输入参数为const型
{
	int length = strlen(other.m_data);
	m_data = new char[length+1]; //对m_data加NULL 判断
	strcpy(m_data, other.m_data);
}
//赋值函数
String & String::operator =(const String &other) // 输入参数为const
型
{
	if(this == &other) //检查自赋值
		return *this;
	delete[] m_data; //释放原有的内存资源
	int length = strlen( other.m_data );
	m_data = new char[length+1]; //对m_data加NULL 判断
	strcpy( m_data, other.m_data );
	return *this; //返回本对象的引用
}
