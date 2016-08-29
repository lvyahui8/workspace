//这是系统中的客户端调用的通用JS代码
//选择客户
CustomerService.choiceCustomer=function(title,callback)
{
ModalDialog.show("180px","150px","loadPage.ejf?url=choiceCustomer.html",function(result){
if(!result)callback({id:"",title:""});
else{
callback(result);
}
},title);
}
//选择产品
ProductService.choiceProduct=function(types,title,callback)
{
//alert(obj);
ModalDialog.show("150px","150px",null,function(result){
if(!result)callback({id:"",title:""});
else{
callback(result);
}
},title);
ProductService.queryProduct("types='"+types+"'",null,1,15,ModalDialog.defaultQueryResult);
}
//选择数据字典对话框
SystemDictionaryService.choiceDictionary=function(sn,title,callback)
{
ModalDialog.show("150px","150px",null,function(result){
if(!result)callback({id:"",title:""});
else{
callback(result);
}
},title);

SystemDictionaryService.getDictionaryBySn(sn,function(obj){
var list=obj.children;
ModalDialog.dialogData=list;
$("modalDialogSelectList").options.length=0;
for(var i=0;i<list.length;i++)
{
$("modalDialogSelectList").options[i]=new Option(list[i].title,list[i].id+";"+list[i].title);
}
});
}

//客户信息处理公共模块
//查询客户信息
CustomerService.searchCustomer=function(tel,title,sn,addr,currentPage,pageSize,callback)
{
var scope="1=1";
if( tel && (""!=tel) )scope+=" and tel like '"+tel+"%'";  //判断tel有值并且不为空
if(title && (""!=title))scope+=" and title like '%"+title+"%'";
if(sn &&(""!=sn))scope+=" and sn like '%"+sn+"%'";
if(addr && (""!=addr))scope+=" and address like '%"+addr+"%'";
//CustomerService.beingInSearch=true;
CustomerService.queryCustomer(scope,null,currentPage,pageSize,function(result){
callback(result);
//CustomerService.beingInSearch=false;
});
}

/*
模式对话框，用于弹出输入信息
*/
ModalDialog={};
ModalDialog.result=null;
ModalDialog.callback=null;
ModalDialog.dialogData=null;
ModalDialog.show=function(width,height,url,callback,title)
{
var x=event.clientX ,y=event.clientY+10;
if(x>880)x=880;
var modalDialog =$("modalDialog");
if(!title)title="";
if(callback)ModalDialog.callback=callback;
if(!modalDialog)
{    modalDialog= document.createElement('div');
      modalDialog.setAttribute('id', 'modalDialog');
      modalDialog.style.position = "absolute";
      modalDialog.style.zIndex = "1000";     
	  modalDialog.style.background = "#BBD6FD";
	  modalDialog.style.border="1px solid #008400";
	  modalDialog.innerHTML="<table  cellSpacing=0 cellPadding=0 width=100%><TR><TD height=20 align=center class=titletxt bgcolor=#C1DAFF style=\"height:16px; border-bottom:1px solid #008400; color: #5575CA\">请选择"+title+"</TD></TR></table>";
	  modalDialog.innerHTML+="<div id=\"modalDialogContent\"></div>";
	  modalDialog.innerHTML+="<select id=\"modalDialogSelectList\" class=\"intro\" size=\"10\" onDblClick=\"ModalDialog.choice(this.selectedIndex);\" style=\"width:99%\"></select>";
	  modalDialog.innerHTML+="<table><TR><TD height=20 align=\"center\" class=\"titletxt\" style=\"padding-bottom:2px;\"><input type=\"button\" name=\"ok\" value=\"确定\" onClick=\"ModalDialog.choice($('modalDialogSelectList').selectedIndex);\" class=\"button\" />　<input type=\"button\" name=\"cancel\" value=\"取消\" onClick=\"ModalDialog.cancel();\" class=\"button\" />　<input type=\"button\"  value=\"关闭\" onClick=\"ModalDialog.close();\" class=\"button\" /></TD></TR></TBODY></TABLE>";
	  //  modalDialog.innerHTML="层的测试";   
	 document.body.appendChild(modalDialog);
	 }
modalDialog.style.left =x+"px";
modalDialog.style.top = y+"px";
modalDialog.style.width = width;
modalDialog.style.height = height; 
if(url)loadPage(url,null,"modalDialogContent");
modalDialog.style.visibility="visible";
}
ModalDialog.close=function()
{
var modalDialog =$("modalDialog");
if(modalDialog)
{ 
//modalDialog.style.visibility="hidden";
Element.remove(modalDialog);
}
}
ModalDialog.choice=function(index)
{
if(this.dialogData)
{
if(index<this.dialogData.length){
ModalDialog.result=this.dialogData[index];
if(this.callback)ModalDialog.callback(ModalDialog.result);
}
else alert("返回的坐标值超过对话框中的数据行数!");
}
else alert("对话框中没有数据");
this.close();
}
ModalDialog.choiceCustomValue=function(result)
{
ModalDialog.result=result;
if(ModalDialog.callback)ModalDialog.callback(result);
this.close();
}
ModalDialog.cancel=function()
{
ModalDialog.result=null;
if(ModalDialog.callback)ModalDialog.callback(null);
this.close();
}
ModalDialog.defaultQueryResult=function(pageList){
$("modalDialogSelectList").options.length=0;
ModalDialog.dialogData=pageList.result;
if(pageList.rowCount>0)
{
for(var i=0;i<pageList.result.length;i++)
{
$("modalDialogSelectList").options[i]=new Option(pageList.result[i].title,pageList.result[i].id+";"+pageList.result[i].title);
}
}
}