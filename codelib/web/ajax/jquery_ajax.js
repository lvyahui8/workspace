var value = $("#xxx").val();		//��ȡ���ؼ���ֵ

$.ajax({
		url:"/loginServlet",
		data:{method:"ajax",val:value},				//{key:value...}��ʾһ�����󣬷�װ���������������ͨ��request.getParamter(key)��ȡ;
		async:true,							//�Ƿ�Ϊ�첽����
		cache:false,							//�Ƿ񻺴���
		type:"POST",							//���󷽷�
		dataType:"json",						//���������ص��������ͣ���json��Ϊjavascript����
		success:function(result){				//��������ڷ�����ִ�гɹ�ʱ�����ã�����result���Ƿ���������ֵ��dataType��
			
		}
});
