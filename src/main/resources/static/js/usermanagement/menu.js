layui.config({
			base : '../../jsPackage/web/design/module/'
		}).extend({
			treetable : 'treetable-lay/treetable'
		}).use(['table', 'laydate', 'treetable', 'form'], function() {
	var $ = layui.jquery;
	var table = layui.table;
	var treetable = layui.treetable;
	var form = layui.form;
	var laydate = layui.laydate;
//加载下拉树表格
				getTreeList();

				function getTreeList() {
					var cols=[[
						{field: 'modId',title: 'id',hide: true}
					  , {field: 'name',minWidth: 200,title: '菜单名称'}
					  , {field: 'menuIcon',width: 60,title: '图标',templet: function(obj) {
										return '<i style="font-size:18px;" class = "' +
											obj.menuIcon + '"></i>';
									}}
					  , {field: 'url',title: '类型'}
					  , {field: 'url',title: '资源URL'}
					  , {field: 'describe',title: '权限标识'}
					  , {field: 'createTime',title: '排序号'}
					  , {title: '操作',fixed: 'right',width: 210,align: 'center',toolbar: '#barDemo'}
							]];
					
					treetable.render({
						treeColIndex: 1,
						treeSpid: -1,
						height : TABLE_H-105,
						treeIdName: 'modId',
						toolbar: '#toolbar',
						treeDefaultClose:true,
						treePidName: 'parentId',
						elem: '#resource_table',
						url: api.resource.getAllResourceInfo,
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
				
				function openHtml(title){
					layer.open({
					  type: 1,
					  title:title,
					  closeBtn: 0,
					  shadeClose: true,
					  skin: 'yourclass',
					  content: $('#openProductBox')
					});
				}
				
				
	});
