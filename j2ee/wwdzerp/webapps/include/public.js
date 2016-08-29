//<SCRIPT ID=clientEventHandlersJS LANGUAGE=javascript>
//<!--

function OpenWin(Url,name,Width,Height) {
//function OpenWin(Url,name,Width,Height,features) {
var Top = (screen.height -Height)/2;
var Left = (screen.width -Width)/2;
return window.open(Url,name,"width=" + Width +",height=" + Height +",top=" + Top + ",left=" + Left + ",resizable=no,scrollbars=no");
}
//打开屏幕大小的窗口
function OpenScreen(Url,name) {
var Top =0;
var Left =0;
var Width=screen.width-10;
var Height=screen.height-110;
return window.open(Url,name,"width=" + Width +",height=" + Height +",top=" + Top + ",left=" + Left + ",menubar=yes,resizable=no,scrollbars=yes");
}

function ObjectMouseOver(TagName,ClassName) {
	document.all(TagName).className=ClassName;
}

function ObjectMouseOut(TagName,SelectClassName,ClassName) {
	if(document.all(TagName).getAttribute("SELECT")=="1"){
		document.all(TagName).className=SelectClassName;
	}
	else{
		document.all(TagName).className=ClassName;
	}
}

function ChangeAttribValue(TagName,AttribValue,SelectClass,ClassName) {
for(var i=0;i<document.all.length;i++){
	if(document.all[i].getAttribute("SELECT")=="1"){
		document.all[i].setAttribute("SELECT","0");
		document.all[i].className=ClassName;
	}
}
document.all(TagName).setAttribute("SELECT",AttribValue);
document.all(TagName).className=SelectClass;
}

function ChangeImg(TagID,AttribValue,NewImg,OldImg) {
for(var i=0;i<document.all.length;i++){
	if (document.all[i].tagName=="IMG")
	{
		if(document.all[i].getAttribute("SELECT")==AttribValue){
			document.all[i].setAttribute("SELECT","");
			document.all[i].src=OldImg;
		}
	}
}
document.all(TagID).setAttribute("SELECT",AttribValue);
document.all(TagID).src=NewImg;
}

function CheckTopFrameUrl(urls){
	if(top.location==this.location)
	{
		top.location=urls;
	}

}

//***********默认设置定义.*********************
tPopWait=50;//停留tWait豪秒后显示提示。
tPopShow=5000;//显示tShow豪秒后关闭提示
showPopStep=20;
popOpacity=99;

//***************内部变量定义*****************
sPop=null;
curShow=null;
tFadeOut=null;
tFadeIn=null;
tFadeWaiting=null;

document.write("<style type='text/css'id='defaultPopStyle'>");
document.write(".cPopText {  background-color: #FFFFE7;color:#000000; border: 1px #000000 solid;font-color:; font-size: 9pt; padding-right: 4px; padding-left: 4px; height: 20px; padding-top: 2px; padding-bottom: 2px; filter: Alpha(Opacity=0)}");
document.write("</style>");
document.write("<div id='dypopLayer' style='position:absolute;z-index:1000;' class='cPopText'></div>");

function showPopupText(){
var o=event.srcElement;
	MouseX=event.x;
	MouseY=event.y;
	if(o.alt!=null && o.alt!=""){o.dypop=o.alt;o.alt=""};
    if(o.title!=null && o.title!=""){o.dypop=o.title;o.title=""};
	if(o.dypop!=sPop) {
			sPop=o.dypop;
			clearTimeout(curShow);
			clearTimeout(tFadeOut);
			clearTimeout(tFadeIn);
			clearTimeout(tFadeWaiting);	
			if(sPop==null || sPop=="") {
				dypopLayer.innerHTML="";
				dypopLayer.style.filter="Alpha()";
				dypopLayer.filters.Alpha.opacity=0;	
				}
			else {
				if(o.dyclass!=null) popStyle=o.dyclass 
					else popStyle="cPopText";
				curShow=setTimeout("showIt()",tPopWait);
			}
			
	}
}

function showIt(){
		dypopLayer.className=popStyle;
		dypopLayer.innerHTML=sPop;
		popWidth=dypopLayer.clientWidth;
		popHeight=dypopLayer.clientHeight;
		if(MouseX+12+popWidth>document.body.clientWidth) popLeftAdjust=-popWidth-24
			else popLeftAdjust=0;
		if(MouseY+12+popHeight>document.body.clientHeight) popTopAdjust=-popHeight-24
			else popTopAdjust=0;
		dypopLayer.style.left=MouseX+12+document.body.scrollLeft+popLeftAdjust;
		dypopLayer.style.top=MouseY+12+document.body.scrollTop+popTopAdjust;
		dypopLayer.style.filter="Alpha(Opacity=0)";
		fadeOut();
}

function fadeOut(){
	if(dypopLayer.filters.Alpha.opacity<popOpacity) {
		dypopLayer.filters.Alpha.opacity+=showPopStep;
		tFadeOut=setTimeout("fadeOut()",1);
		}
		else {
			dypopLayer.filters.Alpha.opacity=popOpacity;
			tFadeWaiting=setTimeout("fadeIn()",tPopShow);
			}
}

function fadeIn(){
	if(dypopLayer.filters.Alpha.opacity>0) {
		dypopLayer.filters.Alpha.opacity-=1;
		tFadeIn=setTimeout("fadeIn()",1);
		}
}
//document.onmouseover=showPopupText;

function ChoiceObj(obj,types)
{
var x=event.screenX;
var y=event.screenY;
var result=window.showModalDialog('/choice.ejf?easyJWebCommand='+types,'Choice',"dialogLeft:"+x+"px;dialogTop:"+y+"px;dialogWidth:195px;dialogHeight:400px;help:no;status:no");
//result 返回格式为：title;sn;　的字符串
//a->td->input
var title="",sn="";
if(result!=""){
var s=result.split(";");
title=s[0];
sn=s[1]
}
obj.parentElement.children[0].value=title;
obj.parentElement.children[1].value=sn;
}
function getCalendar(obj)
{
    if (arguments.length==0){
	  //如果是文本框的onmousedown世间是由脚本绑定的,且没有参数  modified by qiuchun
	  if (event.srcElement){
	    var pchild = event.srcElement;
	    if (pchild.type && pchild.type.toLowerCase() == "text")
	      arguments[0] = pchild.id;
	  }
	}
	var x=event.screenX;
	var y=event.screenY;
	var result=window.showModalDialog('/include/Calendar.htm','Calendar',"dialogLeft:"+x+"px;dialogTop:"+y+"px;dialogWidth:195px;dialogHeight:200px;help:no;status:no");
	//alert(arguments[0]);
	if(result!=null)
	arguments[0].value=result;
		//eval(arguments[0]+".value=result");		
	return false;
}
function ChoiceOpUser(obj)
{
var x=event.screenX;
var y=event.screenY;
var result=window.showModalDialog('/Choice-OpUser.do','ChoiceOpuser',"dialogLeft:"+x+"px;dialogTop:"+y+"px;dialogWidth:120px;dialogHeight:230px;help:no;status:no");
//result 返回操作员名称
obj.parentElement.children[0].value=result;
//obj.parentElement.children[1].value=sn;
}


function CheckElements(the)
{
        
	for(var x=0;x<the.elements.length;x++){
		if(!CheckFieldLength(the.elements[x]))
		{
			the.elements[x].focus();
			return false;
		}
	}
	return true;

}
function checkNotNull(obj,msg)
{
if(obj.value=="")
{
alert(msg+"不能为空！");
if(obj.type!="hidden")obj.focus();
return false;
}
return true;
}
function checkLength(obj,length,msg)
{
if(!checkNotNull(obj,msg))return false;
if(obj.value.length()>length)
{
alert(msg+"的长度不能超过！"+length);
obj.focus();
return false;
}
return true;
}
function checkDate(obj,msg)
{
if(!checkNotNull(obj,msg))return false;
var str=obj.value.length>10?obj.value.substring(0,10):obj.value;
if (!strDateTime(str)) 
{
alert(msg+"必须填写日期型数据！(格式:2005-1-1)");
obj.focus();
return false;
}
return true;
}
function checkNumber(obj,msg)
{
if(!checkNotNull(obj,msg))return false;
var tempNumber = new Number(obj.value); 
if (isNaN(tempNumber)) 
{
alert(msg+"必须填写数字型数据！");
obj.focus();
return false;
}
return true;
}
function strDateTime(str) 
{ 
var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/); 
if(r==null)return false; 
var d= new Date(r[1], r[3]-1, r[4]); 
return (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]); 
} 

function strLongDateTime(str) 
{ 
var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/; 
var r = str.match(reg); 
if(r==null)return false; 
var d= new Date(r[1], r[3]-1,r[4],r[5],r[6],r[7]); 
return (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]&&d.getHours()==r[5]&&d.getMinutes()==r[6]&&d.getSeconds()==r[7]); 
} 

function floatRound(myFloat,mfNumber)
{
     var cutNumber = Math.pow(10,mfNumber-1);
     return Math.round(myFloat * cutNumber)/cutNumber;
}


function strTelNumber(str){
	var reg = /\D/g;
	if( reg.test(str.value) ){
		str.value="";
		alert("只能为数字");
	}
}
