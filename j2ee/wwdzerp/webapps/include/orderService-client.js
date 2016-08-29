OrderService.rowCount=0;
OrderService.confirmCelFuns=[];
//根据id名称得到行号
OrderService.getObjSequence=function(objName)
{
var s=objName.split("-");
if(s.length>0)return s[s.length-1];
}
//输入检测，一行输完后则插入另外一行
OrderService.inputRowCheck=function(objName)
{
var sequence=OrderService.getObjSequence(objName);
//alert(rowCount+"-"+sequence);
if($("product.id-"+sequence).value && $("price-"+sequence).value && $("num-"+sequence).value)
{
if(sequence>=OrderService.rowCount)
{
OrderService.calculateSum(sequence);
OrderService.doUpdateDetail(sequence,function(){
OrderService.newOrderDetail($("id").value);});
}
}
}
//计算产品价格
OrderService.calculateSum=function(objName)
{
var sequence=OrderService.getObjSequence(objName);
var price=$("price-"+sequence).value,num=$("num-"+sequence).value;
if( price && num)
{
$("amount-"+sequence).value=floatRound(price*num,3);
OrderService.calculateAmount();
}
}
OrderService.calculateAmount=function()
{
var sum=0;
for(var i=0;i<=OrderService.rowCount;i++)
{
	if($("amount-"+i))
	{		
		var price=$("price-"+i).value,num=$("num-"+i).value;
		if( price && num)
		{
		$("amount-"+i).value=floatRound(price*num,3);;		
		}	
		var a=parseFloat($("amount-"+i).value);
	   if(!isNaN(a))sum+=a;
	}
}
$("amount-text").innerText=sum;
$("amount").value=sum;
}
//删除一列
OrderService.inputDelRow=function(rowNum)
{
if(rowNum>1)
{
OrderService.delOrderDetail({id:$("detail-id-"+rowNum).value},function(ret){
if(ret)Element.remove($("orderdetail-"+rowNum));
});
}
}
//选择产品
OrderService.choiceProduct=function(rowNum,types,title)
{
	if(!types)types="water";
	if(!title)title="水";
ProductService.choiceProduct(types,title,function(obj){
$("product.title-"+rowNum).value=obj.title;
$("product.id-"+rowNum).value=obj.id;
if(!$("customer.id").value)$("price-"+rowNum).value=obj.salePrice;
else
{
CustomerService.getCustomerPrice({id:$("customer.id").value},obj,function(ret){		
		$("price-"+rowNum).value=ret.price;														  
	  });
}
});
}

OrderService.newOrderDetail=function(id)
{
OrderService.rowCount++;
OrderService.getLastOrderDetail({id:id,sequence:OrderService.rowCount},function(ret){
DWRUtil.addRows("mainTable",[ret],OrderService.waterCelFuns,{rowCreator:OrderService.addCelTr});
});
}

//保存订单信息，保存成功后将进入确认界面并执行回调函数
OrderService.saveOrder=function(confirmPage,callback)
{
if(!checkNotNull($("id"),"id号"))return;
if(!checkNotNull($("customer.id"),"客户"))return;
if(!checkDate($("vdate"),"时间"))return;
if(!checkNotNull($("types"),"类别"))return;
if(!checkNotNull($("paymentStatus"),"支付情况"))return;
if(!checkNumber($("amount"),"金额"))return;
if(OrderService.rowCount==1)
{
	if(!checkNumber($("product.id-1"),"产品"))return;
}
if(!confirmPage)confirmPage="/buyWaterConfirm.html";
var order={id:$("id").value,
	types:$("types").value,
	sn:$("id").value,
	customer:{id:$("customer.id").value},
	vdate:$("vdate").value,
	//payType:$("payType").value,
	paymentStatus:$("paymentStatus").value,
	requireDate:$("requireDate")?$("requireDate").value:"",
	address:$("address")?$("address").value:"",
	amount:$("amount")?$("amount").value:0,
	invoiceSum:$("invoiceSum")?$("invoiceSum").value:0,
	realSum:$("realSum")?$("realSum").value:0,
	managerFee:$("managerFee")?$("managerFee").value:0,
	workTip:$("workTip")?$("workTip").value:0,
	donateTickt:$("donateTickt")?$("donateTickt").value:0,
	donateMachine:$("donateMachine")?$("donateMachine").value:0,	
	status:-1,
	remark:$("remark").value
	}
var detailList=$("mainTable");
var totalRows=detailList.rows.length;
//保存每一列的数据
for(var i=1;i<OrderService.rowCount;i++)
{
if($("detail-id-"+i)){
OrderService.doUpdateDetail(i);
}
}

OrderService.currentOrder=order;//用currentOrder保存状态变量
OrderService.updateOrder(order,function(ret){
if(ret){
loadStaticPage(confirmPage,function(){
OrderService.lastOrderConfirm(OrderService.currentOrder.id,callback);
});
}
});

}
//修改定单详细列表
OrderService.doUpdateDetail=function(rowNum,callback)
{
if(callback==undefined)callback=function(){};
if($("num-"+rowNum).value && $("price-"+rowNum).value){
//alert("保存"+rowNum);
var orderDetail={id:$("detail-id-"+rowNum).value,
	sequence:rowNum,
	product:{id:$("product.id-"+rowNum).value},
	order:{id:$("id").value,customer:{id:$("customer.id").value}},
	num:$("num-"+rowNum).value,
	price:$("price-"+rowNum).value,
	amount:$("amount-"+rowNum).value,
	intro:$("intro-"+rowNum).value,
	status:0,
	beginSn:$("beginSn-"+rowNum)?$("beginSn-"+rowNum).value:0,
	endSn:$("endSn-"+rowNum)?$("endSn-"+rowNum).value:0
};
//alert(orderDetail.amount);
OrderService.updateOrderDetail(orderDetail,callback);
}
}


//自定义操作参数
OrderService.addCelTr = function(options) {
var tr=document.createElement("tr");
tr.setAttribute("id","orderdetail-"+OrderService.rowCount);
tr.onmouseover=function(){this.className='over';};
tr.onmouseout=function(){this.className='out';};
//alert(tr.outerHTML);
return tr;
}

//定单编辑处理程序
OrderService.editOrder=function(obj){
DWRUtil.setValues(obj);
$("sn-text").innerText=obj.sn;
//if(obj.payType)SystemDictionaryService.getDictionaryDetailByValue("payType",obj.payType,function(result){if(result)$("payType-title").value=result.title;});
if(obj.paymentStatus)SystemDictionaryService.getDictionaryDetailByValue("payment",obj.paymentStatus,function(result){if(result)$("paymentStatus-title").value=result.title;});
if(obj.customer){
$("customer.id").value=obj.customer.id;
$("customer.title").value=obj.customer.title;
}
OrderService.rowCount=0;
DWRUtil.removeAllRows("mainTable");
for(var i=0;i<obj.children.length;i++)
{
if(obj.children[i].status>=0)
{
OrderService.rowCount=obj.children[i].sequence;
DWRUtil.addRows("mainTable",[obj.children[i]],OrderService.waterCelFuns,{rowCreator:OrderService.addCelTr});
}
}
OrderService.calculateAmount();
OrderService.newOrderDetail($("id").value);
}
//调用服务器端的getLastOrder方法，开始读取最后一条订单信息
OrderService.inputOrder=function(types)
{
if(!types)types=0;
if(!OrderService.currentOrder)
OrderService.getLastOrder(types,OrderService.editOrder);
else OrderService.getOrder(OrderService.currentOrder.id,OrderService.editOrder);
}


//调用服务器端的getLastOrder方法，开始读取最后一条订单信息
OrderService.lastOrderConfirm=function(id,callback)
{
OrderService.getOrder(id,function(obj){
DWRUtil.setValues(obj);
$("sn-text").innerText=obj.sn;
//if(obj.payType)SystemDictionaryService.getDictionaryDetailByValue("payType",obj.payType,function(result){if(result)$("payType").innerText=result.title;});
if(obj.paymentStatus)SystemDictionaryService.getDictionaryDetailByValue("payment",obj.paymentStatus,function(result){if(result)$("paymentStatus").innerText=result.title;});
if(obj.customer){
$("customer.title").innerText=obj.customer.title;
}

DWRUtil.removeAllRows("mainTable");
for(var i=0;i<obj.children.length;i++)
{
if(obj.children[i].status>=0)
{
OrderService.rowCount=obj.children[i].sequence;
DWRUtil.addRows("mainTable",[obj.children[i]],OrderService.confirmCelFuns);
}
}
//OrderService.newOrderDetail($("id").value);
if(callback)callback();//如果有回调方法则执行
});
}