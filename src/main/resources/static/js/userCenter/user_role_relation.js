$(function(){
	var table = layui.table,
	layer=layui.layer,
	laypage = layui.laypage
	form=layui.form,
	element=layui.element;
	table.render({
		toolbar: '#toolbarDemo'
	    ,elem: '#role'
	    ,url:'/role/roles/'
	    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
	    ,loading:true
	    ,page:true
	    ,cols: [[
	      {type:'checkbox'}
	      ,{type:'numbers'}
	      ,{field:'rolid', title: '角色id',hide:true}
	      ,{field:'name', title: '角色名称'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
	      ,{field:'state', title: '状态',templet: '#titleTpl'}
	      ,{field:'create_time', title: '创建时间', sort: true}
	      ,{field:'last_modify_time', title: '修改时间', sort: true}
	      ,{field:'note', title: '备注休息', align: 'center'} //单元格内容水平居中
	      ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
	    ]]
	  });			
	//表格头工具事件简单封装
	var toolbarAction={
			openLayer:function(){
				 layer.open({
					 type:1,
					 content: $('#popUpdateTest'),
					 offset: 'auto',
					 area: ['500px', '450px'],
					 cancel: function(){ 
						 $('#popUpdateTest').hide();
					 },
					 success:function(layero){
					     var mask = $(".layui-layer-shade");
					     mask.appendTo(layero.parent());
					     //其中：layero是弹层的DOM对象
					     element.init();
					     form.render(); 
					}
				 });
			}
	}
	//监听表单提交事件
	
	form.on('submit(formSubmit)', function(data){
		$.ajax({
			url:'/role/addOrUpdateRole',
			data:$('.role-form').serialize() ,
			dataType:'json',
			success:function(data){
				  $(".layui-laypage-btn")[0].click(); 
				  layer.closeAll();
				  $('#popUpdateTest').hide();
			},
			error:function(){
				 layer.msg("角色管理异常");
			}
		});
		return false;
	})

	//监听表格头部工具栏事件
	 $('.layui-btn-container>.add').click(function(){
		 toolbarAction.openLayer();
		 var date= new Date();
		 var time=date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate()+' '+date.getHours()+':'+date.getMinutes()+':'+date.getSeconds();
		 $('input[name="last_modify_time"]').val(time)
		 $('input[name="create_time"]').val(time);
		 
	 });
	function setFormVal(el,data){
	    for (var p in data)
	    {
	        el.find(":input[name='" + p + "']").val(data[p]);
	    }
	}
	 $('.layui-btn-container>.update').click(function(){
		 //获取选中数据
		 var checkStatus = table.checkStatus('role')
				,data = checkStatus.data;
		 if (data.length==1){
			 toolbarAction.openLayer();
			 setFormVal($('.role-form'),data[0]);
			 
			 }else if(data.length>1){
				 layer.msg("不能同时编辑多条数据",{icon:5});
			 }else if(data.length<1){
				 layer.msg("请选中一条数据",{icon:5});
			 }
		
	 });
	 $('.layui-btn-container>.delete').click(function(){
		 var checkStatus = table.checkStatus('role')
			,data = checkStatus.data;
		 if(data.length<1){
			 layer.msg("请选中一条数据",{icon:5});
		 }else{
			 layer.confirm('确认删除多条数据?', {icon: 3, title:'提示'}, function(index){
				//后端删除数据
				var ids=[];
				for(var i=0;i<data.length;i++){
					ids[i]=data[i].rolid;
				}
				var ids_string=ids.join(",")
				$.ajax({
					url:'/role/deleteRoles',
					data:{ids:ids_string},
					dataType:'json',
					success:function(ajaxdata){
						
						if(ajaxdata.state==0){
							layer.msg("删除成功");
							 $(".layui-laypage-btn")[0].click(); 
						}
					},
					error:function(){
						layer.msg("删除异常",{icon:5});
					}
				});
				  layer.close(index);
				});
		 }
	 });
	 var zNodes;
	//监听工具条
	table.on('tool(demo)', function(obj) {
		var data = obj.data;
		if (obj.event === 'edit') {
		     var setting = {
			         view: {
			             dblClickExpand: false,
			             showLine: false
			         },
			         data: {
			     		simpleData: {
			    			enable: true,
			    			idKey: "usernum",
			    			pIdKey: "parent_id",
			    			rootPId: null
			    		}
			         },
			    
			         check: {
			             enable: true,
			             chkStyle: "checkbox",
			             chkboxType: {"Y": "ps", "N": "s"}
			         }
			     };
			//获取角色下的所有用户
				    $.ajax({
			     type: "post",
			     url: '/role/queryUsersByRold',
			     data: {'rolid':data.rolid},
			     async: true, 
			     cache: true,
			     dataType: "json",//必须指定，否则根据后端判断				 
			     success: function( jsonData ){
			    	 	zNodes=jsonData.data;
					    zTreeObj = $.fn.zTree.init($("#user_org"), setting, zNodes);
			     },
			     error:function(zNodes){
			    	 layer.msg("")
			     }		       
			});
					layer.open({
						type:1,
						title:'用户组织结构',
						btn: ['确认', '取消'],
						yes: function(index, layero){
							//获取所有选中的数据
							var treeObj = $.fn.zTree.getZTreeObj("user_org");
							var nodes = treeObj.getCheckedNodes(true);
							//过滤掉非用户数据
							var checkNodes=[""];
							for(var i=0;i<nodes.length;i++){
								var temp={};
								if(nodes[i].is_parent==0){
									continue;
								}
								checkNodes.push(nodes[i].usernum);
							};
							//动态的添加用户
							$.ajax({
							     type: "post",
							     url: '/role/addOrUpdateUserRole',
							     data: {"list":checkNodes,"rolid":data.rolid},
							     async: true, 
							     cache: true,
							     dataType: "json",//必须指定，否则根据后端判
							     success:function(){
							    	 
							     }
							});
							  layer.closeAll();
							   $('.orgnation').hide();
						  },
						  end:function(){
							  layer.closeAll();
						      $('#orgnation').hide();
						  },
						content:$('.orgnation'),
						area:['400px','400px'],
						cancel:function(){
							  layer.closeAll();
						      $('#orgnation').hide();
						},
						success:function(layero){
						     var mask = $(".layui-layer-shade");
						     mask.appendTo(layero.parent());
						     //其中：layero是弹层的DOM对象
						     element.init();
						     form.render(); 
						}
					});
		}
	})
});