layui.config({
			base : '../../jsPackage/web/design/module/'
		}).extend({
			treetable : 'treetable-lay/treetable',
			iconPicker : 'iconPicker/iconPicker'
		}).use(['table', 'laydate','iconPicker', 'treetable', 'form'], function() {
	var table = layui.table,treetable = layui.treetable,form = layui.form,laydate = layui.laydate,iconPicker = layui.iconPicker,menudata=null,parentId='-1',modId=null;
	

var insTb=null;
	//图标选择
	 iconPicker.render({
	                // 选择器，推荐使用input
	                elem: '#iconPicker',
	                // 数据类型：fontClass/unicode，推荐使用fontClass
	                type: 'fontClass',
	                // 是否开启搜索：true/false
	                search: true,
	                // 点击回调
	                click: function (data) {
	                    console.log(data.icon);
						iconPicker.checkIcon('iconPicker', data.icon);
	                }
	            });
	
			//加载下拉树表格
				getTreeList();


function getTreeList(){
		$.get(api.resource.all, null, function(results) {
			if(results.code==0){
		menudata=results.data;	
				 setTreeLists(menudata)
	}
	});
}
				function setTreeLists(data) {
					var cols=[[
						{field: 'modId',title: 'id',hide: true}
					  , {field: 'name',minWidth: 200,title: '菜单名称'}
					  , {field: 'menuIcon',width: 100,title: '图标',templet: function(obj) {
										return '<i style="font-size:18px;" class = "' +obj.menuIcon + '"></i>';
									}}
					  , {field: 'type',title: '类型',width: 100,templet: function(obj) {
						  if(obj.type==0)
					return '<button type="button" style="background-color: #008200;color: white;" class="layui-btn layui-btn-primary layui-btn-xs">目录</button>';
						if(obj.type==1)
					return '<button type="button" style="background-color: #dada00;color: white;" class="layui-btn layui-btn-primary layui-btn-xs">菜单</button>';
							 if(obj.type==2)
					return '<button type="button" style="background-color: #a8a87e;color: white;" class="layui-btn layui-btn-primary layui-btn-xs">按钮</button>';
									}}
					  , {field: 'url',title: '资源URL'}
					  , {field: 'standby2',title: '权限标识'}
					  , {field: 'remark1',title: '排序号',width: 100}
					  , {title: '操作',fixed: 'right',width: 210,align: 'center',toolbar: '#barDemo'}
							]];
					insTb=treetable.render({
						treeColIndex: 1,
						treeSpid: -1,
						height : TABLE_H-100,
						treeIdName: 'modId',
						toolbar: '#toolbar',
						treePidName: 'parentId',
						elem: '#resource_table',
						data: data,
						page: false,
						cols: cols,
						done: function() {
							layer.closeAll('loading');
						}
					});
				}
				
				//头工具栏事件
				 table.on('toolbar(resource_table)', function(obj){
				   var checkStatus = table.checkStatus(obj.config.id);
				   switch(obj.event){
				     case 'add':
					 var is=0;
					 $.each(menudata,function(i,t){
						 if(t.parentId=='-1'){
							is++; 
						 }
					 });
					 $('#standby2').val('');
					 $('#describe').val('');
					 $('#menuname').val('');
					 $('#address').val('');
					 
					 $('#remark1').val(is+1);
					 parentId='-1';
					 modId='';
					 iconPicker.checkIcon('iconPicker', 'fa fa-bars');
					$(":radio[name='type'][value='0']").prop("checked", "checked");
					openHtml(0,'目录新增');
				     break;
				     case 'del_all':
				      var a=layer.confirm('确定删除？', {
				        btn: ['确定','取消'] //按钮
				      }, function(){
				      		  dataList=SoaIot.removeAaary(dataList,checkStatus.data);
				      		  setEqOrSpList();
				      			layer.close(a);
				      }, function(){
				      });
				     break;
				   };
				 });
				
				function openHtml(type,title){
					$('#directory').show();
					$('#menu').show();
					$('#button').show();
					if(type==0||type==1){//目录、菜单
					//隐藏按钮（单选）
					$('#button').hide();
					}else if(type==2){
					$('#menu').hide();
					$('#directory').hide();	
					}
					
					form.render();
					layer.open({
					  type: 1,
					  title:title,
					  area    : ['30%', '85%'],
					  closeBtn: 1,
					  shadeClose: true,
					  skin: 'yourclass',
					  content: $('#openProductBox')
					});
				}
		
		
		  //监听行工具事件
		  table.on('tool(resource_table)', function(obj){
		    var data = obj.data;
			parentId=data.modId;
		    if(obj.event === 'addMenu'){
				var is=0;
				 $.each(menudata,function(i,t){
					 if(t.parentId==data.modId){
						is++; 
					 }
				 });
				 $(":radio[name='type'][value='0']").prop("checked", "checked");
				 $('#standby2').val('');
				 $('#describe').val('');
				 $('#menuname').val('');
				 $('#address').val('');
				 modId='';
				 $('#remark1').val(is+1);
				 iconPicker.checkIcon('iconPicker', 'fa fa-bars');
				 //当前数据的类型
				openHtml(data.type,'新增');
		    } else if(obj.event === 'editMenu'){
				showhide(data.type);
				iconPicker.checkIcon('iconPicker', data.menuIcon);
				modId=data.modId;
				$('#menuname').val(data.name);
				$('#address').val(data.url);
				$(":radio[name='type'][value='"+data.type+"']").prop("checked", "checked");
				 $('#remark1').val(data.remark1);
				$('#standby2').val(data.standby2);
				$('#describe').val(data.describe);
				openHtml(data.type,'修改');
				
		    }else if(obj.event === 'delMenu'){
				var a=layer.confirm('确定删除？', {
				  btn: ['确定','取消'] //按钮
				}, function(){
						delMenu({'modId':data.modId});
				}, function(){
				});
		    }
		  });
		
		var tmpobj=null;
		  //监听行单击事件（双击事件为：rowDouble）
		 //  table.on('row(resource_table)', function(obj){
			// setColor(obj);
		 //  });
		
		function setColor(obj){
			// if (tmpobj!=null){
			//  tmpobj.tr[0].style='background-color: #ffffff;';
			//  if (tmpobj.tr[1]){
			//  tmpobj.tr[1].style='background-color: #ffffff;';
			//  }
			//  }
			//  tmpobj=obj;
			//  obj.tr[0].style='background-color: #00801c61;';
			//  if (obj.tr[1]){
			//  obj.tr[1].style='background-color: #00801c61;';
			//  }
			// var data= obj.data;
			// eqId=data.equId;
			
			// var query_data={eqId:eqId};
			// 	getEqOrSpData(query_data);
		}
		
		$('#url').hide();
	form.on('radio(erweima)', function (data) {
		var val=data.value;
		showhide(val);
	});
	
	function showhide(val){
		$('#icon').show();
		if(val=='0'){
			//隐藏url
			$('#url').hide();
		}
		if(val=='2'){
		  $('#icon').hide();
		}
		if(val=='1'){
		 $('#url').show();
		}
		form.render();
	}
	
	//菜单查询
	$(document).on('click','#button_search',function(){
	 var keyword = $('#menuname').val();
	 
	 var keywords = $('#edtSearch').val();
	 if (keywords) {
	     insTb.filterData(keywords);
	 } else {
	     insTb.clearFilter();
	 }
	    });
	
	//提交
	$(document).on('click','#addmenus',function(){
		var data={};
		var name = $('#menuname').val();
		var menuIcon =$('#iconPicker').val();
		var type=$("input[type='radio']:checked").val();
		var url = $('#address').val();
		var remark1 = $('#remark1').val();
		var standby2 = $('#standby2').val();
		var describe=$('#describe').val();
		if(menuIcon.length==0){
			menuIcon='fa fa-bars';
		}
		if(describe.length<=0){
			layer.alert('请输入说明', {icon: 5});
		}else{
							data.name=name;
							data.url=url;
							data.type=type;
							data.isParent=0;
							data.menuIcon=menuIcon;
							data.remark1=remark1;
							data.describe=describe;
		  data.standby2=standby2;
		  if(modId==''){
			  data.parentId=parentId;
			  addMenu(data);	
		  }else{
			  data.modId=modId;
			 editMenu(data);	 
		  }
		}
	});
	
	
	//添加菜单
	function addMenu(data){
		$.post(api.resource.add, data, function(results) {
			openCon(results.state,results.message);
		});
	}
	//修改菜单
	function editMenu(data){
		$.post(api.resource.edit, data, function(results) {
		openCon(results.state,results.message);
		});
	}
	//删除菜单
	function delMenu(data){
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
						getTreeList();
						// location.reload();
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
	});
