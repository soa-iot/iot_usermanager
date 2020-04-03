/**
 * 用户管理
 */

var userAccount = getCookie1("name").replace(/"/g, '');
layui.use(['layer', 'form', 'laydate', 'table', 'tree'], function(){
	
	var layer = layui.layer
		,laydate = layui.laydate
	    ,form = layui.form
	    ,tree = layui.tree
	    ,table = layui.table;
	
	/**
	 * 用户表格
	 */
	var userTable = table.render({
	    elem: '#userList'
	    ,url: '/user/management/query'
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
		    		url: '/user/management/state',
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
		if(obj.event === 'unlock'){
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
		    		url: '/user/management/state',
		    		data: {
		    			'usernum': usernum,
		    			'state': 1
		    		},
		    		dataType: 'json',
		    		success: function(json){
		    			if(json.state == 0){
		    				layer.msg("用户账号恢复成功！",{icon: 1, offset: '150px'});
		    				reloadTable();
		    			}else{
		    				layer.msg("用户账号恢复失败！",{icon: 2, offset: '150px'});
		    			}
		    		},
		    		error: function(){
		    			layer.msg("连接服务器失败，请联系管理员！",{icon: 2, offset: '150px'});
		    		}
		    	})
	    	}
	    }
		if(obj.event === 'create'){
    		layer.open({
    	    	title: '新增用户信息',
    	    	type: 1,
    	    	id: obj.event+1,
    	    	btnAlign: 'c',
    	    	btn: ['确定', '取消'],
    	    	closeBtn: 0,
    	    	offset: '10px',
    	    	area: ['500px','570px'],
    	        content: $("#create-window"),
    	        yes: function(index, layero){
    	        	
    	        	var usernum = $.trim($("#usernum_").val());
    	        	var nname = $.trim($("#nname_").val());
    	        	var password = $.trim($("#password_").val());
    	        	var telephone = $.trim($("#telephone_").val());
    	        	var organ = $.trim($("#organ_").val());
    	        	var role = $.trim($("#role-list").val());
    	        	var note = $.trim($("#note_").val());
    	        	var sex = form.val("create-window-form").sex_;
    	        	
    	        	if(usernum == null || usernum == ''){
    	        		layer.msg("用户账号不能为空",{icon: 7, offset: '150px'});
    	        		return;
    	        	}
    	        	if(nname == null || nname == ''){
    	        		layer.msg("用户姓名不能为空",{icon: 7, offset: '150px'});
    	        		return;
    	        	}
    	        	if(password == null || password == ''){
    	        		layer.msg("用户密码不能为空",{icon: 7, offset: '150px'});
    	        		return;
    	        	}
    	        	if(organ == null || organ == ''){
    	        		layer.msg("组织不能为空",{icon: 7, offset: '150px'});
    	        		return;
    	        	}
    	        	if(role == null || role == ''){
    	        		layer.msg("角色不能为空",{icon: 7, offset: '150px'});
    	        		return;
    	        	}
    	        	
    	        	$.ajax({
    	        		type: 'post',
    	        		url: '/user/management/create',
    	        		data: {
    	        			'usernum': usernum,
    	        			'nname': nname,
    	        			'password': password,
    	        			'telephone': telephone,
    	        			'parentId': organ,
    	        			'rolid': role,
    	        			'note': note,
    	        			'sex': sex
    	        		},
    	        		dataType: 'json',
    	        		success: function(json){
    	        			if(json.state == 0){
    	        				layer.msg(json.message,{icon: 1, offset: '150px'});
    	        				reloadTable();
    	        				layer.close(index); 
    	        			}else{
    	        				layer.msg(json.message,{icon: 2, offset: '150px'});
    	        			}
    	        		}
    	        	})
    	        },
    	        success: function(layero, index){
    	        	//表单清空
    	        	form.val("create-window-form", { 
    	        		  "usernum_": ""
    	        		  ,"nname_": ""
    	        		  ,"password_": ""
    	        		  ,"telephone_": ""
    	        		  ,"role-list": ""
    	        		  ,"organ_": ""
    	        		  ,"note_": ""
    	        	});
    	        	form.render();
    	        }
    		});
    	}
	});
	
	/**
	 * 监听每一行工具按钮事件
	 */
	table.on('tool(userList)', function(obj){
		var data = obj.data;
		
		console.log(data)
		if(obj.event === 'edit'){
    		layer.open({
    	    	title: '编辑用户信息',
    	    	type: 1,
    	    	id: obj.event+1,
    	    	btnAlign: 'c',
    	    	btn: ['确定', '取消'],
    	    	closeBtn: 0,
    	    	offset: '10px',
    	    	area: ['500px','570px'],
    	        content: $("#edit-window"),
    	        yes: function(index, layero){
    	        	
    	        	var usernum = $.trim($("#usernum_1").val());
    	        	var nname = $.trim($("#nname_1").val());
    	        	var telephone = $.trim($("#telephone_1").val());
    	        	var organ = $.trim($("#organ_1").val());
    	        	var note = $.trim($("#note_1").val());
    	        	var sex = form.val("edit-window-form").sex_1;
    	        	
    	        	if(usernum == null || usernum == ''){
    	        		layer.msg("用户账号不能为空",{icon: 7, offset: '150px'});
    	        		return;
    	        	}
    	        	if(nname == null || nname == ''){
    	        		layer.msg("用户姓名不能为空",{icon: 7, offset: '150px'});
    	        		return;
    	        	}
    	        	if(organ == null || organ == ''){
    	        		layer.msg("组织不能为空",{icon: 7, offset: '150px'});
    	        		return;
    	        	}
    	        	
    	        	$.ajax({
    	        		type: 'post',
    	        		url: '/user/management/edit',
    	        		data: {
    	        			'usernum': usernum,
    	        			'nname': nname,
    	        			'telephone': telephone,
    	        			'parentId': organ,
    	        			'note': note,
    	        			'sex': sex
    	        		},
    	        		dataType: 'json',
    	        		success: function(json){
    	        			if(json.state == 0){
    	        				layer.msg(json.message,{icon: 1, offset: '150px'});
    	        				reloadTable();
    	        				layer.close(index); 
    	        			}else{
    	        				layer.msg(json.message,{icon: 2, offset: '150px'});
    	        			}
    	        		}
    	        	})
    	        },
    	        success: function(layero, index){
    	        	//表单清空
    	        	form.val("edit-window-form", { 
  	        		  "usernum_1": ""
  	        		  ,"nname_1": ""
  	        		  ,"telephone_1": ""
  	        		  ,"sex_1": ""
  	        		  ,"organ_1": ""
  	        		  ,"note_1": ""
  	        	    });
    	        	//附初始值
    	        	form.val("edit-window-form", { 
    	        		  "usernum_1": data.usernum
    	        		  ,"nname_1": data.nname
    	        		  ,"telephone_1": data.telephone
    	        		  ,"sex_1": data.sex
    	        		  ,"organ_1": data.organName
    	        		  ,"note_1": data.note
    	        	});
    	        	form.render();
    	        }
    		});
    	}
		
		if(obj.event === 'reset'){
			layer.open({
    	    	title: '重置用户密码',
    	    	type: 1,
    	    	id: obj.event+1,
    	    	btnAlign: 'c',
    	    	btn: ['确定', '取消'],
    	    	closeBtn: 0,
    	    	offset: '100px',
    	    	area: ['500px','300px'],
    	        content: $("#reset-window"),
    	        yes: function(index, layero){
    	        	
    	        	var usernum = $.trim($("#usernum_2").val());
    	        	var password = $.trim($("#password_2").val());
    	        	
    	        	if(password == null || password == ''){
    	        		layer.msg("新密码不能为空",{icon: 7, offset: '150px'});
    	        		return;
    	        	}
    	        	
    	        	$.ajax({
    	        		type: 'post',
    	        		url: '/user/password/reset',
    	        		data: {
    	        			'usernum': usernum,
    	        			'password': password,
    	        		},
    	        		dataType: 'json',
    	        		success: function(json){
    	        			if(json.state == 0){
    	        				layer.msg(json.message,{icon: 1, offset: '150px'});
    	        				reloadTable();
    	        				layer.close(index); 
    	        			}else{
    	        				layer.msg(json.message,{icon: 2, offset: '150px'});
    	        			}
    	        		}
    	        	})
    	        },
    	        success: function(layero, index){
    	        	$("#usernum_2").val('');
    	        	$("#password_2").val('');
    	        	$("#usernum_2").val(data.usernum);
    	        }
			})
		}
	});
	
	/**
	 * 请求所有角色列表
	 */
	$.ajax({
		type: 'get',
		url: '/role/roles',
		dataType: 'json',
		success: function(json){
			if(json.code == 0){
				var data = json.data;	
				if(data != null && data.length != 0){
					for(var i=0;i<data.length;i++){
						var option = "<option value='"+data[i].rolid+"'>"+data[i].name+"</option>";
						$("#role-list").append(option);
					}
				}
				form.render();
			}
		}
	})
	
	
	/**
	 * 请求人员组织树
	 */
	var organTree = [], organId = null;
	$.ajax({
		type: 'post',
		url: '/user/list',
		dataType: 'json',
		success: function(json){
			if(json.code == 0){
				var data = json.data;
				if(data != null && data.length != 0){
					for(var i=0;i<data.length;i++){
						if(data[i].parent_id == null || data[i].parent_id == '' ){
							var obj = {};
							obj.title = data[i].name;
							obj.id = data[i].orgid;
							obj.children = [];
							
							if(i != 0){
								var temp = data[0];
								data[0] = data[i];
								data[i] = temp;
							}
							//删除第一个元素
							data.shift();
							organTree.push(obj);
							createTree(data, organTree);
						}
					}
				}
				//手风琴模式
				tree.render({
					elem: '#organ-tree'
					,data: organTree
					,accordion: true 
					,click: function(obj){
					    console.log(obj.data); //得到当前点击的节点数据
					    organId = null;
					    if(obj.data.children.length == 0){
					    	organId = obj.data.id;
					    	$("#organ_").val(obj.data.title);
					    	$("#organ_1").val(obj.data.title);
					    	layer.close(index_);
					    }
					  }
				});
				form.render();
			}
		}
	})
	
	/**
	 * 组织选择点击事件
	 */
	var index_ = null;
	$("#organ_").click(function(){
		layer.open({
	    	title: '人员组织',
	    	type: 1,
	    	id: "organTree",
	    	btnAlign: 'c',
	    	btn: ['关闭'],
	    	closeBtn: 0,
	    	offset: '10px',
	    	area: ['300px','350px'],
	        content: $("#organ-window"),
	        yes: function(index, layero){
	        	
	            layer.close(index); //如果设定了yes回调，需进行手工关闭
	        },
	        success: function(layero, index){
	        	index_ = index;
	        }
		});
	})
	
	$("#organ_1").click(function(){
		layer.open({
	    	title: '人员组织',
	    	type: 1,
	    	id: "organTree1",
	    	btnAlign: 'c',
	    	btn: ['关闭'],
	    	closeBtn: 0,
	    	offset: '10px',
	    	area: ['300px','350px'],
	        content: $("#organ-window"),
	        yes: function(index, layero){
	        	
	            layer.close(index); //如果设定了yes回调，需进行手工关闭
	        },
	        success: function(layero, index){
	        	index_ = index;
	        }
		});
	})
})

/**
 * 递归生成人员组织树数据
 */
function createTree(data, parent){
	var flag = false;
	for(var i=0;i<data.length;i++){
		for(var j=0;j<parent.length;j++){
			if(data[i].parent_id == parent[j].title){
				var obj = {};
				obj.title = data[i].name;
				obj.id = data[i].orgid;
				obj.children = [];
				
				if(i != 0){
					var temp = data[0];
					data[0] = data[i];
					data[i] = temp;
				}
				//删除第一个元素
				data.shift();
				flag = true;
				parent[j].children.push(obj);
				createTree(data, parent[j].children);
			}
		}
		if(flag){
			flag = false;
			i=-1;
		}
	}
}



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