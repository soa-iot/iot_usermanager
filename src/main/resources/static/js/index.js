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
	
	
	window.onmessage = function(e){
		console.log('-----------------------------');
		console.log(e);
       if( e.data ==  'TODO' ){
    
           //新增一个Tab项
           element.tabAdd('layadmin-layout-tabs', {
              title: '代办任务列表'
              ,id: 'pending-task' 
           })
           
           var tabsbody = '<div class="layadmin-tabsbody-item layui-show">'+
						  '<iframe src="index/pending-task.html" frameborder="0"'+
					      'class="layadmin-iframe"></iframe> </div>'
           
           $("#LAY_app_body").append(tabsbody);
           element.tabChange('layadmin-layout-tabs', 'pending-task'); 
           element.render('tab', 'layadmin-layout-tabs');
       }
    }
	
 })
