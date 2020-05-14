/**
 * 待办任务
 */

/**
 * 获得cookie 的值
 */
function getCookie( name ){    
   var cookieArray=document.cookie.split( "; " ); 
   for ( var i=0; i<cookieArray.length; i++ ){    
      var arr = cookieArray[i].split( "=" );       //将名和值分开    
      if( arr[0] == name ) return decodeURI( arr[1] ); //如果是指定的cookie，则返回它的值    
   } 
   return ""; 

} 

layui.use(['layer', 'form', 'laydate', 'table', 'element'], function(){
	//加载layui内置模块
	var form = layui.form
	,layer = layui.layer
	,element = layui.element
	,table = layui.table; //重点处,使用jQuery
	
	//待办任务点击事件
	$("#todo-task").click(function(){
		window.parent.postMessage('TODO', '*')
	});
	
 })
