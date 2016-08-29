package dj.regex.demo;
/*
 * 正则表达式用于操作字符串数据
 * 通过一些特定的符号来体现的
 * 
 */
public class RegexDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String qq = "123456789012";
//		checkQQ(qq);
		
		String regex = "[1-9][0-9]{4,14}";//正则表达式
		
		if(qq.matches(regex)){
			System.out.println("合法");
		}
		else{
			System.out.println("不合法");
		}
	}

	/*
	 * 需求：定义一个功能对QQ号进行校验
	 * 需求：长度5-15，只能是数字，0不能开头
	 * 
	 */
	
	public static void checkQQ(String qq){
		int len = qq.length();
		
		if(len >= 5 && len <=15){
			if(!qq.startsWith("0")){
				try {
					long l  = Long.parseLong(qq);
					System.out.println("QQ号合法");
				} catch (NumberFormatException e) {
					// TODO: handle exception
					System.out.println("含有非法字符");
				}
			}
			else{
				System.out.println("不能是0开头");
			}
		}else{
			System.out.println("长度不对");
		}
	}
}
