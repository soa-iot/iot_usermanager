var add_layer;
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

	// 渲染表格
	layer.load(2);
	loadTable();

	$("#menuIcon").blur(function() {
		$("#preview_icon").html('<i class="' + $("#menuIcon").val() + '"></i>');
	});

	/**
	 * 加载表格
	 */
	function loadTable() {
		treetable.render({
					treeColIndex : 1,
					treeSpid : -1,
					treeIdName : 'modId',
					toolbar : '#toolbar',
					treePidName : 'parentId',
					elem : '#resource_table',
					treeDefaultClose: true,
					url : '/iot_usermanager/resource/getAllResourceInfo',
					page : false,
					cols : [[{
								field : 'modId',
								title : 'id',
								hide : true
							}, {
								field : 'name',
								minWidth : 200,
								title : '资源名称'
							}, {
								field : 'menuIcon',
								width : 60,
								title : '图标',
								templet : function(obj) {
									return '<i style="font-size:18px;" class = "'
											+ obj.menuIcon + '"></i>';

								}
							}, {
								field : 'url',
								title : '资源URL'
							}, {
								field : 'describe',
								title : '资源描述'
							}, {
								field : 'createTime',
								title : '创建时间'
							}, {
								field : 'lastModifyTime',
								title : '最后修改时间'
							}, /*
								 * { field:'', title:'图标', templ:function(d){
								 * return '<i class = "layui-icon '+d.icon+'"><i>'; } },
								 */{
								title : '操作',
								fixed : 'right',
								width : 118,
								align : 'center',
								toolbar : '#barDemo'
							}

					]],
					done : function() {
						layer.closeAll('loading');
					}
				});

	}

	$('#btn-search').click(function() {
		var keyword = $('#edt-search').val();
		var searchCount = 0;
		$('#resource_table').next('.treeTable')
				.find('.layui-table-body tbody tr td').each(function() {
					$(this).css('background-color', 'transparent');
					var text = $(this).text();
					if (keyword != '' && text.indexOf(keyword) >= 0) {
						$(this)
								.css('background-color',
										'rgba(250,230,160,0.5)');
						if (searchCount == 0) {
							treetable.expandAll('#resource_table');
							$('html,body').stop(true);
							$('html,body').animate({
										scrollTop : $(this).offset().top - 150
									}, 500);
						}
						searchCount++;
					}
				});
		if (keyword == '') {
			layer.msg("请输入搜索内容", {
						icon : 5
					});
		} else if (searchCount == 0) {
			layer.msg("没有匹配结果", {
						icon : 5
					});
		}
	});

	// 头工具栏事件
	table.on('toolbar(resource_table)', function(obj) {
		var checkStatus = table.checkStatus(obj.config.id);
		console.log(">>>>>>>>>..");
		switch (obj.event) {
			case 'add' :
				/**
				 * 清除数据
				 */

				$("#parent_resource option").remove();
				$("#resource_name").val(null);
				$("#resource_url").val(null);
				$("#resource_sort").val(null);
				$("#resource_desc").val(null);
				$("#btn_update").css("display", "none");
				$("#btn_commit").css("display", "inline");
				$("#menuIcon").val("fa fa-home");
				$("#preview_icon").html('<i class="fa fa-home"></i>');

				add_layer = layer.open({
							title : '资源新增',
							area : ['30%', '70%'], // 宽高
							type : 1,
							content : $('#resource_add'),
							success : function(layero) {
								var mask = $(".layui-layer-shade");
								mask.appendTo(layero.parent());
								// 其中：layero是弹层的DOM对象
							},
							end : function() {
								hideElement();
							}
						});
				$.ajax({
					url : '/iot_usermanager/resource/getParentResource',
					dataType : 'json',
					success : function(data) {
						// console.log(data);
						var parent_resources = data.data;

						var html = '<option value=""></option><option value="-1">无</option>';
						parent_resources.forEach(function(currentValue, index,
										arr) {
									html += '<option value = "'
											+ currentValue.MODID + '">'
											+ currentValue.NAME + '</option>'

								});
						$("#parent_resource").append(html);
						console.log(html);
						form.render('select');
					},
					error : function() {

					}
				});
				break;
			case 'expand_all' :
				treetable.expandAll('#resource_table');
				break;
			case 'fold_all' :
				treetable.foldAll('#resource_table');
				break;

			// 自定义头工具栏右侧图标 - 提示
			case 'LAYTABLE_TIPS' :
				layer.alert('这是工具栏右侧自定义的一个图标按钮');
				break;
		};
	});

	/*
	 * 隐藏弹出框
	 */
	function hideElement() {
		$('#resource_add').hide();
	}

	// 监听更新数据按钮点击事件
	form.on('submit(btn_update)', function(data) {
				// 获取数据
				var resource_name = $("#resource_name").val();// 资源名称
				var parent_resource = $("#parent_resource").val();// 父级资源id
				var is_parent = $("#is_parent").val();// 是否为父级
				var resource_url = $("#resource_url").val();// 资源url
				var resource_desc = $("#resource_desc").val();// 资源描述
				var mod_id = $("#mod_id").val();
				var resource_sort = $("#resource_sort").val();// 排序字段
				var menuIcon = $("#menuIcon").val();

				var fdata = {
					name : resource_name,
					parentId : parent_resource,
					isParent : is_parent,
					url : resource_url,
					describe : resource_desc,
					modId : mod_id,
					remark1 : resource_sort,
					menuIcon : menuIcon

				};

				layer.close(add_layer);
				$.ajax({
							url : '/iot_usermanager/resource/updateResource',
							data : fdata,
							success : function(data) {

								if (data.state == 0) {
									layer.msg("更新数据成功！！");
									loadTable();
								} else {
									layer.msg("更新数据失败，请联系管理员！");
								}

							},
							error : function() {
								layer.msg("更新数据失败，请联系管理员！");
							}
						});
				return false;

			});
	// 监听提交按钮点击事件
	form.on('submit(btn_commit)', function(data) {

				// 获取数据
				var resource_name = $("#resource_name").val();// 资源名称
				var parent_resource = $("#parent_resource").val();// 父级资源id
				var is_parent = $("#is_parent").val();// 是否为父级
				var resource_url = $("#resource_url").val();// 资源url
				var resource_desc = $("#resource_desc").val();// 资源描述
				var resource_sort = $("#resource_sort").val();// 排序字段
				var menuIcon = $("#menuIcon").val();// 图标

				var fdata = {
					name : resource_name,
					parentId : parent_resource,
					isParent : is_parent,
					url : resource_url,
					describe : resource_desc,
					remark1 : resource_sort,
					menuIcon : menuIcon
				};

				layer.close(add_layer);
				$.ajax({
							url : '/iot_usermanager/resource/addResource',
							data : fdata,
							success : function(data) {

								if (data.state == 0) {
									layer.msg("添加数据成功！！");
									loadTable();
								} else {
									layer.msg("添加数据失败，请联系管理员！");
								}

							},
							error : function() {
								layer.msg("添加数据失败，请联系管理员！");
							}
						});
				return false;
			});

	// 监听取消按钮事件
	$("#btn_cancel").click(function() {
				layer.close(add_layer);
				return false;
			});

	// 监听行工具事件
	table.on('tool(resource_table)', function(obj) {
		var data = obj.data;
		// console.log(obj)
		if (obj.event === 'del') {
			layer.confirm('若为父级数据，其所有子级数据都将被删除！确定删除该数据吗？', function(index) {
				// obj.del();
				console.log(obj);

				/**
				 * 发送请求，删除数据
				 */
				$.ajax({
							method : "get",
							url : "/iot_usermanager/resource/delResourceInfoById",
							data : {
								modId : obj.data.modId,
								parentId : obj.data.parentId
							},
							success : function(data) {
								obj.del();
								if (data.data >= 1) {
									layer.msg("删除数据成功");
									loadTable();
								} else {
									layer.msg("删除数据失败，请联系管理员！");
								}

							},
							error : function() {
								layer.msg("删除数据失败，请联系管理员！");
							}
						});

				layer.close(index);
			});
		} else if (obj.event === 'edit') {

			console.log(obj);

			/**
			 * 清除数据
			 */
			$("#parent_resource option").remove();

			/**
			 * 设置样式
			 */
			$("#btn_update").css("display", "inline");
			$("#btn_commit").css("display", "none");

			/**
			 * 表单赋值
			 * 
			 */

			$("#mod_id").val(obj.data.modId);
			$("#resource_name").val(obj.data.name);
			$("#is_parent").val(obj.data.isParent);
			$("#resource_url").val(obj.data.url);
			$("#resource_desc").val(obj.data.describe);
			$("#resource_sort").val(obj.data.remark1);
			$("#menuIcon").val(obj.data.menuIcon);
			$("#preview_icon")
					.html('<i class="' + obj.data.menuIcon + '"></i>');

			add_layer = layer.open({
						title : '资源编辑',
						area : ['30%', '70%'], // 宽高
						type : 1,
						content : $('#resource_add'),
						success : function(layero) {
							var mask = $(".layui-layer-shade");
							mask.appendTo(layero.parent());
							// 其中：layero是弹层的DOM对象
						},
						end : function() {
							hideElement();
						}
					});
			$.ajax({
				url : '/iot_usermanager/resource/getParentResource',
				dataType : 'json',
				success : function(data) {
					// console.log(data);
					var parent_resources = data.data;

					var html = '<option value=""></option><option value="-1">无</option>';
					parent_resources.forEach(
							function(currentValue, index, arr) {
								html += '<option value = "'
										+ currentValue.MODID + '">'
										+ currentValue.NAME + '</option>'

							});
					$("#parent_resource").append(html);
					console.log(html);
					$("#parent_resource").val(obj.data.parentId);
					form.render('select');

				},
				error : function() {

				}
			});

		}
	});

});