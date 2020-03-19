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

        //闭环流程代办任务
        table.render({
		    elem: '#pendingProcess'
		    ,url: '/iot_process/process/tasks/layui' //数据接口
		    ,where:{
		    	"userName": (getCookie("name")==null?null:getCookie("name").replace(/"/g,''))
		    }
          ,skin:'line'
		  ,parseData: function(res){ //res 即为原始返回的数据
				var data = res.data;
				
				if(data != null && data.length > 5){
					data.length = 5;
				}
				
				return {
					"code": res.code,      //解析接口状态
					"msg": res.msg,        //解析提示文本
					"count": res.count,   //解析数据长度
					"data": data           //解析数据列表
				};
		    }
	  		,skin:'line'
		    ,cols: [[ //表头
				{type:'numbers', title: '序号', align:'center', width:'8%'}
				,{field: 'name', title: '任务名',align:'center', width:'19%'}
		      ,{field: 'reportperson', title: '上报人',align:'center',width:'18%'}
		      ,{field: 'reporttime', title: '问题上报时间', align:'center', width:'22%'}
		      ,{field: 'tip', title: '任务超期', align:'center', width:'18%'}
		      ,{fixed: 'right',title: '操作', width: '15.3%', align:'center', toolbar: '#barDemo1'}
		    ]]
	  });
        
      //监听行工具事件
        table.on('tool(process)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        	var data = obj.data //获得当前行数据
        	,layEvent = obj.event; //获得 lay-event 对应的值
        	if(layEvent === 'edit'){
        		//根据属地判断跳转页面
        		console.log(data.currentnode);
        		var  toHtml={"问题上报":'report.html',"问题评估":"estimate-team-leader.html","作业安排":"assign-task.html","作业接收":"receive-task.html","作业完成":"finish-task.html","作业验收":"acceptance.html","生产办评估":"estimate-pure.html","问题分配":"estimate-pure.html","领导审核":"estimate.html"};
        		html=toHtml[data.currentnode];
				var href="/iot_process/html/"+html+"?piid="+data.piid+"&area="+data.area;
				console.log(href);
				window.open(href);
        	}
        });
        
        $("div [lay-id='pendingProcess']").css({"margin-top":"0px"});
  })
