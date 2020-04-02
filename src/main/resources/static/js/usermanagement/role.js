layui.use(['table', 'laydate','form','tree', 'util'], function() {
	var table = layui.table,form = layui.form,laydate = layui.laydate,tree  = layui.tree ,util = layui.util,rolid='';

				getTableList();//加载角色列表
				menuTree();//菜单树列表
				 userTree();//用户树
				function getTableList(){
					$.get(api.role.list, null, function(results) {
							if(results.code==0){
								 setTableList(results.data)
					}
					});
				}
				
				function setTableList(data) {
					console.log(data)
					var cols=[[
					      {type: 'checkbox', fixed: 'left'}
					      ,{field:'name', title:'角色名称', fixed: 'left'}
						  ,{field:'state', title:'状态', width:100, templet: '#switchTpl', unresize: true}
						  ,{fixed : 'right', width : 200,align : 'center',toolbar : '#table_role'}
					    ]];
					table.render({
								elem : '#role_list',
								toolbar : '#toolbar_role',
								height : TABLE_H-100,
								data : data,
								loading : true,
								page : true,
								limits : [30, 60, 90, 120, 150],
								limit : 30,
								cols : cols
							});
				}
				
				 //监听性别操作
				  form.on('switch(sexDemo)', function(obj){
				    layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
				  });
				
				function menuTree(){
					$("#menu_tree").height(TABLE_H-100);	
					$.get(api.resource.tree, {}, function(results) {
						tree.render({
						  elem: '#menu_tree'
						  ,data: results.data
						  ,showCheckbox: true  //是否显示复选框
						  ,id: 'menuid'
						  ,isJump: true //是否允许点击节点时弹出新窗口跳转
						  ,click: function(obj){
						    var data = obj.data;  //获取当前点击的节点数据
						    layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(data));
						  }
						});
						
					});
				}
				
				function userTree(){
					//借鉴他的数据封装
					$.get(api.resource.tree, {}, function(results) {
						console.log(results)
						tree.render({
						  elem: '#user_tree'
						  ,data: results.data
						  ,showCheckbox: true  //是否显示复选框
						  ,id: 'demoId1'
						  ,isJump: true //是否允许点击节点时弹出新窗口跳转
						  ,click: function(obj){
						    var data = obj.data;  //获取当前点击的节点数据
						    layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(data));
						  }
						});
					});
				}
				
				//头工具栏事件
				 table.on('toolbar(role_list)', function(obj){
				   var checkStatus = table.checkStatus(obj.config.id);
				   switch(obj.event){
				     case 'addRole':
					 //新增
					 alert(1111)
				     break;
				     case 'editRole':
					 
					 
				     break;
					 case 'delRole':
					  var a=layer.confirm('确定删除？', {
					    btn: ['确定','取消'] //按钮
					  }, function(){
					  });
					 break;
				   };
				 });
				
				
				  //监听行工具事件
				  table.on('tool(role_list)', function(obj){
					  setColor(obj);
				    var data = obj.data;
					console.log(data)
				    //console.log(obj)
				    if(obj.event === 'userSel'){
					  $.get(api.resource.ids, {rolid:data.rolid}, function(results) {
						  console.log(results)
					  	tree.setChecked('demoId', results.data); //批量勾选 id 为 2、3 的节点
						
						layer.open({
						      type    : 1,
						      offset  : 'r',
						      area    : ['50%', '100%'],
						      title   : '用户选择',
						      shade   : 0,
						      anim   : -1,
						      skin:'layer-anim-07',
						      move    : false,
						      content:$('#selUser_window'),
						      cancel  : function (index) {
						        var $layero = $('#layui-layer' + index);
						        $layero.animate({
						          left : $layero.offset().left + $layero.width()
						        }, 300, function () {
						          layer.close(index);
						        });
						        return false;
						      }
						    });
						
					  });
				    } 
				  });
				
				
				var tmpobj=null;
				  //监听行单击事件（双击事件为：rowDouble）
				  table.on('row(role_list)', function(obj){
					   var data = obj.data;
						setColor(obj);
				// //勾选
				$.get(api.resource.ids, {rolid:data.rolid}, function(results) {
										  tree.reload('menuid', {
										    //新的参数
										  });
					tree.setChecked('menuid', results.data); //批量勾选 id 为 2、3 的节点
				});
				  });
				
				function setColor(obj){
					if (tmpobj!=null){
					 tmpobj.tr[0].style='background-color: #ffffff;';
					 if (tmpobj.tr[1]){
					 tmpobj.tr[1].style='background-color: #ffffff;';
					 }
					 }
					 tmpobj=obj;
					 obj.tr[0].style='background-color: #00801c61;';
					 if (obj.tr[1]){
					 obj.tr[1].style='background-color: #00801c61;';
					 }
					var data= obj.data;
					eqId=data.equId;
					
					// var query_data={eqId:eqId};
					// 	getEqOrSpData(query_data);
				}
			
			//添加角色
			function addRoles(data){
				$.post(api.resource.add, data, function(results) {
					openCon(results.state,results.message);
				});
			}
			//修改菜单
			function editRoles(data){
				$.post(api.resource.edit, data, function(results) {
				openCon(results.state,results.message);
				});
			}
			//删除菜单
			function delRoles(data){
				$.post(api.resource.remove, data, function(results) {
				openCon(results.state,results.message);
				});
			}
			
			function openCon(state,message){
				if(state==0){
							//询问框
							layer.confirm(message, {
								icon: 6,
							  btn: ['确定'] //按钮
							}, function(){
								layer.closeAll(); 
								location.reload();
							});
				}else{
				var a=layer.confirm(message, {
					icon: 5,
				  btn: ['确定'] //按钮
				}, function(){
					// location.reload();
					layer.close(a); 
					});
				}	
			}
			
				//菜单关系添加
				$(document).on('click','#getMenuIDList',function(){
					
					if(rolid==''){
						layer.alert('请输入先选择角色', {icon: 5});
					}else{
						//获得选中的节点
						var checkedData = tree.getChecked('menuid');
						var a=getTreeIdarr(checkedData);
						console.log(a)
						// $.post(api.resource.remove, data, function(results) {
						// openCon(results.state,results.message);
						// });
					}
				});
				
				//用户关系添加
				
				$(document).on('click','#getUserList',function(){
					// if(rolid==''){
					// 	layer.alert('请输入先选择角色', {icon: 5});
					// }else{
						//获得选中的节点
						var checkedData = tree.getChecked('menuid');
						var a=getTreeIdarr(checkedData);
						$.post(api.resource.remove, data, function(results) {
						openCon(results.state,results.message);
						});
					// }
				});
				
	});
