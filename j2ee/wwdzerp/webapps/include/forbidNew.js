//<SCRIPT ID=clientEventHandlersJS LANGUAGE=javascript>
//<!--
document.onkeydown = function()
{
	//Forbid Ctrl+N
	if(event.ctrlKey==true && event.keyCode ==78)
	{
		event.keyCode =0;
		event.returnValue=false;
	}
	
	//Forbid F3
	if(event.keyCode==114)
	{
		event.keyCode=0;
		event.returnValue=false;
	}
	
	//Forbid F5
	if(event.keyCode==116)
	{
		event.keyCode=0;
		event.returnValue=false;
	}

	//Forbid F11
	if(event.keyCode==122)
	{
		event.keyCode=0;
		event.returnValue=false;
	}
	
	//Forbid Alt+F4
   if (event.altKey==true && event.keyCode==115)
   {
		window.showModelessDialog("about:blank","","dialogWidth:1px;dialogheight:1px");
		event.returnValue=false;
		
   }
   
   //Forbid Shift+F10
   if ((event.shiftKey==true)&&(event.keyCode==121))
     event.returnValue=false;
	 
}

//Forbid RightKey
document.oncontextmenu=function()
{
	//return false;
}

//Forbid Drag
document.ondragstart=function()
{
	return false;
}

//Forbid F1
function window.onhelp()
{
	return false;
}

//</SCRIPT>