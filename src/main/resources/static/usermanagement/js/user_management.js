/**
 * 用户管理
 */

var userAccount = getCookie1("name").replace(/"/g, '');
layui.use(['layer', 'form', 'laydate', 'table'], function(){
	
	var layer = layui.layer
		,laydate = layui.laydate
	    ,form = layui.form
	    ,table = layui.table;
	
	/**
	 * 临时任务表格
	 */
	var userTable = table.render({
	    elem: '#userList'
	    ,url: '/iot_usermanager/user/management/query'
	    ,toolbar: '#toolbar'
	    ,page: true //开启分页
	    ,loading: true
	    ,parseData: function(res){ //res 即为原始返回的数据
			var data = res.data;
			
			if(data != null){
				for(var i=0;i<data.length;i++){
					if(data[i].sex == 0	){
						data[i].asex = '女';
					}else{
						data[i].asex = '男';
					}
					
					if(data[i].state == 1	){
						data[i].astate = '<span class="layui-badge layui-bg-green">正常</span>';
					}else{
						data[i].astate = '<span class="layui-badge">禁用</span>';
					}
					
					if(data[i].organ != null){
						data[i].organName = data[i].organ.parent_id;
					}
					var roles = data[i].roles, roleName='';
					if(roles != null && roles.length != 0){
						for(var j=0;j<roles.length;j++){
							if(roleName == ''){
								roleName += roles[j].name;
							}else{
								roleName += "，" + roles[j].name;
							}
						}
						data[i].roleName = roleName;
					}
				}
			}
			
			return {
				"code": res.code,      //解析接口状态
				"msg": res.msg,        //解析提示文本
				"count": res.count,   //解析数据长度
				"data": data      //解析数据列表
			};
	    }
	    ,cols: [[ //表头
	    	{type:'checkbox'}
	    	,{field:'nname', title:'姓名', width:'9%', sort:false, align:'center'}
	    	,{field:'usernum', title:'用户账号', width:'10%', sort:false, align:'center'}
	    	,{field:'organName', title:'所属部门', width:'15%', sort:false, align:'center'}
	    	,{field:'roleName', title:'角色', width:'20%', sort:false, align:'center'}
	    	,{field:'asex', title:'性别', width:'7%', sort:false, align:'center'}
	    	,{field:'telephone', title:'手机号', width:'10%', sort:false, align:'center'}
	    	,{field:'astate', title:'用户状态', width:'8%', sort:false, align:'center'}
	    	,{fixed:'right',  title:'操作', align:'center', toolbar:'#barBtn'} 
	    ]]
	  });
	
	
	/**
	 * 重新加载表
	 */
	function reloadTable(){
		userTable.reload({
    	   page: {
    		   curr: 1 //重新从第 1 页开始
    	   }
    	   ,where: {
    		    'nname': $.trim($("#nname").val()),
    		    'usernum': $.trim($("#usernum").val()),
    		    'state':	$.trim($("#state").val())
    	   }
    	})
	}
	
	/**
	 * 条件查询俺按钮点击事件
	 */
	$("#queryBtn").click(function(){
		console.log("----点击条件查询按钮----");
		
		reloadTable();
	})
	
	 /**
	  * 监听排序事件
	  */
	 /*table.on('sort(taskList)', function(obj){
		 console.log(obj.field); //当前排序的字段名
		 console.log(obj.type); //当前排序类型：desc（降序）、asc（升序）、null（空对象，默认排序）
		 var field = fieldMapping[obj.field];
		 reloadTable(field, obj.type);
	 });*/
	
	/**
	 * 监听表头工具按钮事件
	 */
	table.on('toolbar(userList)', function(obj){
		var checkStatus = table.checkStatus(obj.config.id);
		console.log(checkStatus)
	    if(obj.event === 'lock'){
	    	var data = checkStatus.data;
	    	if(data != undefined && data.length != 0){
	    		var usernum = null;
	    		for(var i=0;i<data.length;i++){
	    			if(usernum == null){
	    				usernum = data[i].usernum;
	    			}else{
	    				usernum += ',' + data[i].usernum;
	    			}
	    		}
	    		console.log(usernum);
	    		//调用后台接口更新账号状态
	    		$.ajax({
		    		type: 'post',
		    		url: '/iot_usermanager/user/management/state',
		    		data: {
		    			'usernum': usernum,
		    			'state': 2
		    		},
		    		dataType: 'json',
		    		success: function(json){
		    			if(json.state == 0){
		    				layer.msg("用户账号禁用成功！",{icon: 1, offset: '150px'});
		    				reloadTable();
		    			}else{
		    				layer.msg("用户账号禁用失败！",{icon: 2, offset: '150px'});
		    			}
		    		},
		    		error: function(){
		    			layer.msg("连接服务器失败，请联系管理员！",{icon: 2, offset: '150px'});
		    		}
		    	})
	    	}
	    	
	    	
	    }
	});
})


var fieldMapping = {
	"taskName":"TASK_NAME",
	"opeName":"OPE_NAME",
	"createPerson":"CREATE_PERSON",
	"createTime":"CREATE_TIME",
	"requireFinishTime":"REQUIRE_FINISH_TIME",
	"actualFinishTime":"ACTUAL_FINISH_TIME",
	"departmentName":"DEPARTEMENT_NAME",
	"executeDepartmentName":"EXECUTE_DEPARTEMENT_NAME",
	"executePerson":"EXECUTE_PERSON",
	"taskState":"TASK_STATE"
}