layui.config({
//			base : '../../module/'
			base : '/jsPackage/web/design/module/'
		}).extend({
			treetable : 'treetable-lay/treetable'
		}).use(['table', 'layer', 'treetable', 'form', 'tree', 'upload'],
		function() {
			var $ = layui.jquery;
			var table = layui.table;
			var treetable = layui.treetable;
			var layer = layui.layer;
			var form = layui.form;
			var tree = layui.tree;

			// 渲染表格
			layer.load(2);
			loadTable();

			/** *******************************************加载数据表格****************************************************** */
			function loadTable() {
				treetable.render({
					treeColIndex : 0,
					treeSpid : -1,
					treeIdName : 'modId',
					treePidName : 'parentId',
					elem : '#auth-table',
					url : '/roleAuthority/getAuthotityInfo',
					page : false,
					cols : [[/*
								 * { type : 'numbers' },
								 */{
								field : 'name',
								minWidth : 200,
								title : '权限名称'
							}, {
								field : 'resourceName',
								title : '资源名称'
							}, {
								field : 'url',
								title : '资源URL'
							}, {
								field : 'describe',
								title : '资源描述'
							}, {
								field : 'note',
								title : '权限备注'
							}, {
								field : 'type',
								width : 80,
								align : 'center',
								templet : function(d) {
									// console.log(d);
									if (d.type == 0) {
										return '<span class="layui-badge layui-bg-gray">模块</span>';
									} else if (d.type == 1) {
										return '<span class="layui-badge layui-bg-blue">菜单</span>';
									} else {
										return '<span class="layui-badge-rim">其他</span>';
									}
								},
								title : '类型'
							}, {
								field : 'role',
								title : '角色',
								align : 'center',
								toolbar : '#role_view'
							}, {
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
			/** *******************************************加载数据表格****************************************************** */

			$('#btn-expand').click(function() {
						treetable.expandAll('#auth-table');
					});

			$('#btn-fold').click(function() {
						treetable.foldAll('#auth-table');
					});

			$('#btn-search').click(function() {
				var keyword = $('#edt-search').val();
				var searchCount = 0;
				$('#auth-table').next('.treeTable')
						.find('.layui-table-body tbody tr td').each(function() {
							$(this).css('background-color', 'transparent');
							var text = $(this).text();
							if (keyword != '' && text.indexOf(keyword) >= 0) {
								$(this).css('background-color',
										'rgba(250,230,160,0.5)');
								if (searchCount == 0) {
									treetable.expandAll('#auth-table');
									$('html,body').stop(true);
									$('html,body').animate({
												scrollTop : $(this).offset().top
														- 150
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

			// 监听新增按钮点击事件
			var add_layer;
			$("#btn-add").click(function() {
				/**
				 * 清除数据
				 */
				$("#classtree").find('*').remove();
				$("#treeclass").html("请选择");
				$("#resource_id").val(null);
				$("#authority_id").val(null);
				$("#authority_name").val(null);
				$("#authority_type").val(null);
				$("#authority_note").val(null);

				/**
				 * 更改按钮的显示效果
				 */
				$("#btn_update").css("display", "none");
				$("#btn_commit").css("display", "inline");

				add_layer = layer.open({
							title : '资源新增',
							area : ['30%', '60%'], // 宽高
							type : 1,
							content : $('#authority_add'),
							success:function(layero){
							     var mask = $(".layui-layer-shade");
							     mask.appendTo(layero.parent());
							     //其中：layero是弹层的DOM对象
							}
						});

				$.ajax({
					url : '/resource/getResourceInfoOfNode',
					dataType : 'json',
					success : function(data) {
						// console.log(data.data);
						tree({
									elem : "#classtree",
									nodes : data.data,
									click : function(node) {
										var $select = $($(this)[0].elem)
												.parents(".layui-form-select");
										$select
												.removeClass("layui-form-selected")
												.find(".layui-select-title span")
												.html(node.name)
												.end()
												.find("input:hidden[name='selectID']")
												.val(node.id);
									}
								});

					},
					error : function() {

					}

				});
				form.render();
			});

			$(".downpanel").on("click", ".layui-select-title", function(e) {
				$(".layui-form-select").not($(this)
						.parents(".layui-form-select"))
						.removeClass("layui-form-selected");
				$(this).parents(".downpanel")
						.toggleClass("layui-form-selected");
				layui.stope(e);
			}).on("click", "dl i", function(e) {
						layui.stope(e);
					});
			/*
			 * $(document).on("click", function(e) { $(".layui-form-select")
			 * .removeClass("layui-form-selected"); });
			 */

			// 监听提交按钮点击事件
			form.on('submit(btn_commit)', function(data) {

						// 获取数据
						var authority_name = $("#authority_name").val();// 权限名称
						var authority_type = data.field.authority_type// 权限类型
						var resource_id = $("#resource_id").val();// 权限对应资源
						var authority_note = $("#authority_note").val();// 权限备注

						var authority = {
							resourceid : resource_id,
							type : authority_type,
							name : authority_name,
							note : authority_note
						};

						layer.close(add_layer);
						$.ajax({
									url : '/roleAuthority/addAuthority',
									type : 'post',
									dataType : 'json',
									data : authority,
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

			// 监听更改按钮点击事件
			form.on('submit(btn_update)', function(data) {

						// 获取数据
						var authority_id = $("#authority_id").val();// 权限id
						var authority_name = $("#authority_name").val();// 权限名称
						var authority_type = data.field.authority_type// 权限类型
						var resource_id = $("#resource_id").val();// 权限对应资源
						var authority_note = $("#authority_note").val();// 权限备注

						var authority = {
							autid : authority_id,
							resourceid : resource_id,
							type : authority_type,
							name : authority_name,
							note : authority_note
						};

						layer.close(add_layer);
						$.ajax({
									url : '/roleAuthority/updateAuthority',
									type : 'post',
									dataType : 'json',
									data : authority,
									success : function(data) {

										if (data.state == 0) {
											layer.msg("更改数据成功！！");
											loadTable();
										} else {
											layer.msg("更改数据失败，请联系管理员！");
										}

									},
									error : function() {
										layer.msg("更改数据失败，请联系管理员！");
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
			var add_role_layer;
			table.on('tool(auth-table)', function(obj) {
				// var data = obj.data;
				// console.log(obj)
				if (obj.event === 'del') {
					layer.confirm('若为父级数据，其所有子级数据都将被删除！确定删除该数据吗？', function(
									index) {
								/**
								 * 发送请求，删除数据
								 */
								$.ajax({
											method : "get",
											url : "/roleAuthority/delAuthority",
											data : {
												autid : obj.data.autid
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
					// console.log(">>>>>>>>>>>>");

					/**
					 * 清除数据
					 */
					$("#classtree").find('*').remove();
					$("#treeclass").html("请选择");

					/**
					 * 设置样式
					 */
					$("#btn_update").css("display", "inline");
					$("#btn_commit").css("display", "none");

					/**
					 * 表单赋值
					 * 
					 */
					$("#authority_id").val(obj.data.autid);// 权限id
					$("#authority_name").val(obj.data.name);// 权限名称
					$("#authority_type").val(obj.data.type);// 权限类型
					$("#treeclass").html(obj.data.resourceName);// 对应资源名称
					$("#resource_id").val(obj.data.modId);// 资源id
					$("#authority_note").val(obj.data.note);// 权限备注
					form.render();

					add_layer = layer.open({
								title : '资源编辑',
								area : ['30%', '60%'], // 宽高
								type : 1,
								content : $('#authority_add'),	
								success:function(layero){
								     var mask = $(".layui-layer-shade");
								     mask.appendTo(layero.parent());
								     //其中：layero是弹层的DOM对象
								}
							});
					$.ajax({
						url : '/resource/getResourceInfoOfNode',
						dataType : 'json',
						success : function(data) {
							// console.log(data.data);
							tree({
								elem : "#classtree",
								nodes : data.data,
								click : function(node) {
									var $select = $($(this)[0].elem)
											.parents(".layui-form-select");
									$select
											.removeClass("layui-form-selected")
											.find(".layui-select-title span")
											.html(node.name)
											.end()
											.find("input:hidden[name='selectID']")
											.val(node.id);
								}
							});

						},
						error : function() {

						}

					});

				} else if (obj.event == 'detail') {
					// 查看角色按钮
					add_role_layer = layer.open({
						title : '资源编辑',
						area : ['40%', '60%'], // 宽高
						type : 1,
						btn : ['提交', '取消'],
						yes : function(index, layero) {
							var selectInfo = table
									.checkStatus('auth_add_table').data;
							var select_roleIds = [];
							$.each(selectInfo, function(index, element) {
										select_roleIds.push(element.rolid);
									});

							// 发送请求插入权限数据
							$.ajax({
										url : '/roleAuthority/changeToAuthority',
										dataType : 'json',
										type : 'post',
										data : {
											rolids : select_roleIds,
											authorityId : obj.data.autid
										},
										success : function(data) {
											if (data.state == 0) {
												layer.msg("角色权限修改成功！！！");
											} else {
												layer.msg("角色权限修改失败，请联系管理员！！！");
											}
										},
										error : function() {
											layer.msg("角色权限修改失败，请联系管理员！！！");
										}

									});

							layer.close(add_role_layer);
						},
						btn2 : function(index, layero) {
							// 按钮【取消】的回调
						},
						content : $('#add_authority_role'),
						success:function(layero){
						     var mask = $(".layui-layer-shade");
						     mask.appendTo(layero.parent());
						     //其中：layero是弹层的DOM对象
						}
					});

					var roleIds;
					// 发送请求获取已有权限
					$.ajax({
								url : '/roleAuthority/getRoleIdByAuthorityId',
								dataType : 'json',
								data : {
									authorityId : obj.data.autid

								},
								success : function(data) {
									roleIds = data.data
								},
								error : function() {

								}

							});

					// 发送请求获取角色列表
					$.ajax({
						url : '/role/roles',
						dataType : 'json',
						success : function(data) {
							console.log(data.data);
							$.each(data.data, function(index, element) {
										if ($.inArray(element.rolid, roleIds) != -1) {
											element.LAY_CHECKED = true;
										}

									});

							table.render({
										elem : '#auth_add_table',
										// url : '/role/roles',
										data : data.data,
										page : false,
										cols : [[{
													type : 'checkbox'
												}, {
													field : 'rolid',
													title : '角色id',
													hide : true
												}, {
													field : 'name',
													title : '角色名称'
												}

										]],
										done : function() {
											console.log(table);
											layer.closeAll('loading');

										}
									});
						},
						error : function() {

						}

					});

				}
			});
		});