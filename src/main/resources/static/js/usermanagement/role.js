layui.use(['table', 'laydate','form','tree', 'util'], function() {
	var table = layui.table,form = layui.form,laydate = layui.laydate,tree  = layui.tree ,util = layui.util,rolid='';

				getTableList({});//加载角色列表
				menuTree();//菜单树列表
				 userTree();//用户树
				function getTableList(data){
					var b=layer.load(1);
					$.get(api.role.list, data, function(results) {
						layer.close(b); 
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
				
				 //监听状态操作
				  form.on('switch(sexDemo)', function(obj){
					   var rolid = obj.value;
						console.log();
					  var i=1;
					  if(obj.elem.checked){
						 i=0; 
					  }
					var datas={};
					datas.rolid=rolid;
					datas.state =i;
					var b=layer.load(1);
					$.post(api.role.update, datas, function(results) {
						layer.close(b); 
						 layer.tips( results.message, obj.othis);
					});
				  });
				
				function menuTree(){
					$("#menu_tree").height(TABLE_H-100);	
					var b=layer.load(1);
					$.get(api.resource.tree, {}, function(results) {
						layer.close(b); 
						tree.render({
						  elem: '#menu_tree'
						  ,data: results.data
						  ,showCheckbox: true  //是否显示复选框
						  ,id: 'menuid'
						  ,isJump: true //是否允许点击节点时弹出新窗口跳转
						  ,click: function(obj){
						    var data = obj.data;  //获取当前点击的节点数据
						  }
						});
					});
				}
				
				function userTree(){
					$("#user_tree").height(TABLE_H-100);	
					var b=layer.load(1);
					//借鉴他的数据封装
					$.get(api.user.list,{}, function(results) {
						layer.close(b); 
						tree.render({
						  elem: '#user_tree'
						  ,data: results.data
						  ,showCheckbox: true  //是否显示复选框
						  ,id: 'userid'
						  ,isJump: true //是否允许点击节点时弹出新窗口跳转
						  ,click: function(obj){
						    var data = obj.data;  //获取当前点击的节点数据
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
					 layer.prompt({title: '输入角色名称', formType: 3}, function(pass, index){
						 var data={};
						 data.name =pass;
						 data.state =0;
						addRoles(data);
					 });
				     break;
				     case 'editRole':
					 var arr=checkStatus.data;
					 if(arr.length<=0){
						 layer.alert('请勾选需要编辑的角色', {icon: 5});
					 }else if(arr.length>1){
						layer.alert('请勾选一条需要编辑的角色', {icon: 5}); 
					 }else{
						//编辑
						layer.prompt({title: '输入角色名称',value:arr[0].name, formType: 3}, function(pass, index){
												var datas={};
						  						datas.name =pass;
												datas.rolid=arr[0].rolid;
											 editRoles(datas);
						}); 
					 }
				     break;
					 case 'delRole':
					 var arr=checkStatus.data;
					  var a=layer.confirm('确定删除？', {
					    btn: ['确定','取消'] //按钮
					  }, function(){
						  if(arr.length<=0){
						  						 layer.alert('请勾选需要删除的角色', {icon: 5});
						  }else{
							  var arrdata=[];
							  $.each(arr,function(i,t){
							  							  console.log(t)
							  							  arrdata.push(t.rolid);
							  });
							  delRoles(arrdata);
						  }
					  });
					 break;
				   };
				 });
				
				
				  //监听行工具事件
				  table.on('tool(role_list)', function(obj){
					  setColor(obj);
				    var data = obj.data;
				    if(obj.event === 'userSel'){
						var b=layer.load(1);
					  $.post(api.role.user_list, {rolid:data.rolid}, function(results) {
						 layer.close(b); 
						   tree.reload('userid', {});
					  	tree.setChecked('userid', results.data); //批量勾选 id 为 2、3 的节点
						
						layer.open({
						      type    : 1,
						      offset  : 'r',
						      area    : ['35%', '103%'],
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
						rolid=data.rolid;
						var b=layer.load(1);
				// //勾选
				$.get(api.resource.ids, {rolid:rolid}, function(results) {
					layer.close(b); 
										  tree.reload('menuid', {});
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
				var b=layer.load(1);
				$.post(api.role.add, data, function(results) {
					layer.close(b); 
					openCon(results.state,results.message);
				});
			}
			//修改菜单
			function editRoles(data){
var b=layer.load(1);
				$.post(api.role.update, data, function(results) {
					layer.close(b); 
				openCon(results.state,results.message);
				});
			}
			//删除菜单
			function delRoles(data){
				var b=layer.load(1);
				console.log(JSON.stringify(data))
				$.ajax({
								url : api.role.deletes,
								type : 'post',
								data : JSON.stringify(data),
								dataType : 'json',
								contentType : 'application/json',
								success : function(results) {
									layer.close(b); 
									openCon(results.state,results.message);
								},
								error : function() {
									layer.msg('数据保存失败，请联系管理员！！！', {
												icon : 2
											});
								}
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
			
			//角色查询
			$(document).on('click','#selrole',function(){
				var name=$('#name').val();//角色名称
				var state=$("#state option:selected").val();//状态
				var data={};
				data.roleName=name;
				data.state=state;
				getTableList(data);
			});
			
				//菜单关系添加
				$(document).on('click','#getMenuIDList',function(){
					if(rolid==''){
						layer.alert('请输入先选择角色', {icon: 5});
					}else{
						//获得选中的节点
						var checkedData = tree.getChecked('menuid');
						var arr=getTreeIdarr(checkedData);
						var qure_data={};
						qure_data.rolid =rolid ;
						qure_data.authIds =arr;
						//加载层-风格2
						var b=layer.load(1);
						$.post(api.role.resource, qure_data, function(results) {
							layer.close(b); 
							if(results.state==0){
										//询问框
										layer.confirm(results.message, {
											icon: 6,
										  btn: ['确定'] //按钮
										}, function(){
											layer.closeAll(); 
										});
							}else{
								
							var a=layer.confirm(results.message, {
								icon: 5,
							  btn: ['确定'] //按钮
							}, function(){
								// location.reload();
								layer.close(a); 
								});
							}	
							
						});
					}
				});
				
				
				//用户关系添加
				$(document).on('click','#getUserList',function(){
					// if(rolid==''){
					// 	layer.alert('请输入先选择角色', {icon: 5});
					// }else{
						//获得选中的节点
						var checkedData = tree.getChecked('userid');
						var arr=getTreeIdarruser(checkedData);
						var qure_data={};
						qure_data.rolid =rolid ;
						qure_data.userids =arr;
						//加载层-风格2
						var b=layer.load(1);
						$.post(api.role.organ, qure_data, function(results) {
							layer.close(b); 
							if(results.state==0){
										//询问框
										var c=layer.confirm(results.message, {
											icon: 6,
										  btn: ['确定'] //按钮
										}, function(){
											layer.close(c); 
										});
							}else{
							var a=layer.confirm(results.message, {
								icon: 5,
							  btn: ['确定'] //按钮
							}, function(){
								// location.reload();
								layer.close(a); 
								});
							}	
							
						});
					// }
				});
				
	});
