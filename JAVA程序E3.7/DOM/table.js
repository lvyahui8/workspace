/**
 * @author Agrin
 */
var name;//保存旧的背景样式
function trColor(){
    var oTabNode = document.getElementsByTagName("table")[0];
    var collTrNodes = oTabNode.rows;
    //    alert("设置种 "+collTrNodes.nodeName);
    for (var i = 1; i < collTrNodes.length; i++) {
        if (i % 2 == 1) {
            collTrNodes[i].className = "one";
        }
        else {
            collTrNodes[i].className = "two";
        }
        collTrNodes[i].onmouseover = function(){
            //			over(this);//这样可以
            name = this.className;
            this.className = "over";
        }
        collTrNodes[i].onmouseout = function(){
            //			out(this);//这样可以
            this.className = name;
        }
    }
}

var flag = false;

function sort(){
    var oTabNode = document.getElementsByTagName("table")[0];
    
    var collTrNodes = oTabNode.rows;
    
    var trArr = [];
//    alert("ok");
    for (var i = 1; i < collTrNodes.length; i++) {
        trArr[i - 1] = collTrNodes[i];
    }
//	alert("ok");
    mySort(trArr);
//	alert("ok");
	if(flag){
		for(var i=0;i<trArr.length;i++){
			trArr[i].parentNode.appendChild(trArr[i]);
		}
		flag = false;
	}
	else{
		for(var i=trArr.length-1;i>=0;i--){
			trArr[i].parentNode.appendChild(trArr[i]);
		}
		flag = true;
	}
	
//	alert("over");
	trColor();
}

function mySort(arr){
    for (var i = 0; i < arr.length - 1; i++) {
        var p = i;
//		alert("OK"+arr[i].nodeName);
//		alert("ok"+arr.length);
//		alert("ok"+arr[i].cells[1].innerHTML);
        for (var j = i + 1; j < arr.length; j++) {
			
            if (arr[p].cells[1].innerHTML > arr[j].cells[1].innerHTML) {
            		p = j;
            }
        }
        
        if (p != i) {
//            arr[i].swapNode(arr[p]);
			var temp = arr[i]
			arr[i] = arr[p];
			arr[p] = temp;
        }
		
    }
}

function over(node){
    name = node.className;
    node.className = "over";
}

function out(node){
    node.className = name;
}

//删除复选右键
function deleteMail(){
	var collMailNodes = document.getElementsByName("mail");
	
	for(var i=0;i<collMailNodes.length;){
		if(collMailNodes[i].checked){
			var oTrNode = collMailNodes[i].parentNode.parentNode;//一般是input节点的父节点td的父节点tr
			oTrNode.parentNode.removeChild(oTrNode);
		}
		else{
			i++;
		}
	}
}
