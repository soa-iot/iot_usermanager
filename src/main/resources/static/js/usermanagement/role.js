layui.config({
			base : '../../jsPackage/web/design/module/'
		}).extend({
			treetable : 'treetable-lay/treetable'
		}).use(['table', 'laydate', 'treetable', 'form','tree', 'util'], function() {
	var table = layui.table,treetable = layui.treetable,form = layui.form,laydate = layui.laydate,tree  = layui.tree ,util = layui.util;

var data=[{
    title: '一级1'
    ,id: 1
    ,field: 'name1'
    ,checked: true
    ,spread: true
    ,children: [{
      title: '二级1-1 可允许跳转'
      ,id: 3
      ,field: 'name11'
      ,href: 'https://www.layui.com/'
      ,children: [{
        title: '三级1-1-3'
        ,id: 23
        ,field: ''
        ,children: [{
          title: '四级1-1-3-1'
          ,id: 24
          ,field: ''
          ,children: [{
            title: '五级1-1-3-1-1'
            ,id: 30
            ,field: ''
          },{
            title: '五级1-1-3-1-2'
            ,id: 31
            ,field: ''
          }]
        }]
      },{
        title: '三级1-1-1'
        ,id: 7
        ,field: ''
        ,children: [{
          title: '四级1-1-1-1 可允许跳转'
          ,id: 15
          ,field: ''
          ,href: 'https://www.layui.com/doc/'
        }]
      },{
        title: '三级1-1-2'
        ,id: 8
        ,field: ''
        ,children: [{
          title: '四级1-1-2-1'
          ,id: 32
          ,field: ''
        }]
      }]
    },{
      title: '二级1-2'
      ,id: 4
      ,spread: true
      ,children: [{
        title: '三级1-2-1'
        ,id: 9
        ,field: ''
        ,disabled: true
      },{
        title: '三级1-2-2'
        ,id: 10
        ,field: ''
      }]
    },{
      title: '二级1-3'
      ,id: 20
      ,field: ''
      ,children: [{
        title: '三级1-3-1'
        ,id: 21
        ,field: ''
      },{
        title: '三级1-3-2'
        ,id: 22
        ,field: ''
      }]
    }]
  },{
    title: '一级2'
    ,id: 2
    ,field: ''
    ,spread: true
    ,children: [{
      title: '二级2-1'
      ,id: 5
      ,field: ''
      ,spread: true
      ,children: [{
        title: '三级2-1-1'
        ,id: 11
        ,field: ''
      },{
        title: '三级2-1-2'
        ,id: 12
        ,field: ''
      }]
    },{
      title: '二级2-2'
      ,id: 6
      ,field: ''
      ,children: [{
        title: '三级2-2-1'
        ,id: 13
        ,field: ''
      },{
        title: '三级2-2-2'
        ,id: 14
        ,field: ''
        ,disabled: true
      }]
    }]
  },{
    title: '一级3'
    ,id: 16
    ,field: ''
    ,children: [{
      title: '二级3-1'
      ,id: 17
      ,field: ''
      ,fixed: true
      ,children: [{
        title: '三级3-1-1'
        ,id: 18
        ,field: ''
      },{
        title: '三级3-1-2'
        ,id: 19
        ,field: ''
      }]
    },{
      title: '二级3-2'
      ,id: 27
      ,field: ''
      ,children: [{
        title: '三级3-2-1'
        ,id: 28
        ,field: ''
      },{
        title: '三级3-2-2'
        ,id: 29
        ,field: ''
      }]
    }]
  }];

				getTableList();//加载角色列表
				menuTree();//菜单树列表
				
				function getTableList() {
					var cols=[[
					      {type: 'checkbox', fixed: 'left'}
					      ,{field:'name', title:'角色名称', fixed: 'left'}
					      ,{field:'state', title:'状态'}
						  ,{fixed : 'right', width : 165,align : 'center',toolbar : '#table_role'}
					    ]];
					table.render({
								elem : '#role_list',
								toolbar : '#toolbar_role',
								height:'full-80',
								url : api.role.roles,
								loading : true,
								page : true,
								cols : cols
							});
				}
				
				function menuTree(){
				var cols=[[
					{type: 'numbers'}
				  ,{type: 'checkbox'}
				  ,{field: 'modId',title: 'id',hide: true}
				  , {field: 'name',minWidth: 200,title: '菜单名称'}
				  , {field: 'url',title: '类型'}
				  , {field: 'url',title: '资源URL'}
				  , {field: 'createTime',title: '排序号'}
						]];
					
					treetable.render({
						treeColIndex: 1,
						treeSpid: -1,
						height : TABLE_H-105,
						treeIdName: 'modId',
						toolbar: '#toolbar',
						treeDefaultClose:false,
						treePidName: 'parentId',
						elem: '#menu_tree',
						url: api.resource.getAllResourceInfo,
						page: false,
						cols:cols ,
						done: function() {
							layer.closeAll('loading');
						}
					});
				}
				
				function userTree(){
					tree.render({
					  elem: '#user_tree'
					  ,data: data
					  ,showCheckbox: true  //是否显示复选框
					  ,id: 'demoId1'
					  ,isJump: true //是否允许点击节点时弹出新窗口跳转
					  ,click: function(obj){
					    var data = obj.data;  //获取当前点击的节点数据
					    layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(data));
					  }
					});
				}
				
				//头工具栏事件
				 table.on('toolbar(resource_table)', function(obj){
				   var checkStatus = table.checkStatus(obj.config.id);
				   switch(obj.event){
				     case 'add':
					openHtml('目录新增');
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
				
				
				  //监听行工具事件
				  table.on('tool(role_list)', function(obj){
					  setColor(obj);
				    var data = obj.data;
				    //console.log(obj)
				    if(obj.event === 'userSel'){
					  userTree();
					  layer.open({
					        type    : 1,
					        offset  : 'r',
					        area    : ['600px', '100%'],
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
				    } 
				  });
				
				
				var tmpobj=null;
				  //监听行单击事件（双击事件为：rowDouble）
				  table.on('row(role_list)', function(obj){
				setColor(obj);
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
				
				
	});
