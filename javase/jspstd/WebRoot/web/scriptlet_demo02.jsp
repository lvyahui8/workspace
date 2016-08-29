<%!
	//<%!%/>中声明的是全局变量
	public static final String INFO = "hello world";
	public int i = 0;
%>

<%!
	public int add(int x,int y){
		return x + y;
	}
%>

<%!
	class Person {
		private String name;
		private int age;
		public Person(String name,int age){
			this.name = name;
			this.age = age;
		}

		public String toString(){
			return "name = "+this.name+";age = "+this.age;
		}
	}
%>

<%
	out.println("<h3>i ="+ i++ +"</h3>");
	out.println("<h3>info="+INFO+"</h3>");
	out.println("<h3>add="+add(3,4)+"</h3>");
	out.println("<h3>"+new Person("jdf",12)+"</h3>");
%>