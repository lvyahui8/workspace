var value = $("#xxx").val();		//获取表单控件的值

$.ajax({
		url:"/loginServlet",
		data:{method:"ajax",val:value},				//{key:value...}表示一个对象，封装请求参数，服务器通过request.getParamter(key)获取;
		async:true,							//是否为异步请求
		cache:false,							//是否缓存结果
		type:"POST",							//请求方法
		dataType:"json",						//服务器返回的数据类型，“json”为javascript对象
		success:function(result){				//这个函数在服务器执行成功时被调用，参数result就是服务器返回值（dataType）
			
		}
});
