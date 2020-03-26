/**
 * 全局变量
 */
var personalized_index_table;
layui.use(['layer', 'form', 'table'], function() {
	var form = layui.form;
	var layer = layui.layer;
	var table = layui.table;
	// 执行渲染
	personalized_index_table = table.render({
				elem : '#personalized_index_table',
				height : 'full-100',
				url : '/index/getRoleIndexInfo',
				method : 'post',
				contentType : 'application/json',
				where : {

	}			,
				parseData : function(res) { // res 即为原始返回的数据
					return res;
				},
				toolbar : '#toolbar',
				cols : [[{
							type : 'checkbox'
						}, {
							title : '序号',
							type : 'numbers'
						}, {
							field : 'roleName',
							title : '角色名称'
						}, {
							field : 'pageName',
							title : '页面名称',
							templet : function(obj) {
								if (obj.pageName == null || obj.pageName == '') {
									return '<span class="layui-btn layui-btn-sm layui-btn-danger">未配置</span>';
								} else {
									return obj.pageName
								}

							}
						}, {
							field : '',
							title : '操作'
						}]],
				page : true,
				loading : true,
				limits : [30, 60, 90, 120, 150],
				limit : 30

			});

	/**
	 * 监听提交按钮
	 */
	form.on('submit(search_button_search)', function(obj) {
				console.log(obj.field);
				var roleName = obj.field.roleName;
				table.reload('personalized_index_table', {
							where : {
								roleName : roleName
							}
						});
				return false;
			});

	/**
	 * 监听新增按钮
	 */
	$('#add').on('click', function() {

			});

	// 头工具栏事件
	table.on('toolbar(personalized_index_table)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				switch (obj.event) {
					case 'add' :

						break;
					case 'edit' :

						break;
					case 'del' :

						break;

					// 自定义头工具栏右侧图标 - 提示
					case 'LAYTABLE_TIPS' :
						layer.alert('这是工具栏右侧自定义的一个图标按钮');
						break;
				};
			});
});