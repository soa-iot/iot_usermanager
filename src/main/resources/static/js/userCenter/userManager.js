var commit_id = null;
var pid;
$(function() {

	/**
	 * 参数定义
	 */
	var table = layui.table, layer = layui.layer, getUsersUrl = "/iot_usermanager/user", getUsersByNumUrl = "/iot_usermanager/user/users", addUserUrl = "/iot_usermanager/user/addUser", initOrganDataUrl = "/iot_usermanager/user/organ", modifyUserParentUrl = "/iot_usermanager/user/organ", modifyUserUrl = "/iot_usermanager/user/user", deleteUserUrl = "/iot_usermanager/user";

	/**
	 * 页面初始化
	 */
	// 表格初始化
	ajax('get', getUsersUrl + "/users", {}, getUsersSF, false);

	/**
	 * 渲染头像上传
	 */
	load_head_sculpture();
	load_head_sculpture_edit();
	/*
	 * 表格初始化请求成功回调函数
	 */
	function getUsersSF(data) {
		console.log('---------表格初始化请求成功回调函数----------');
		// console.log( data );
		generateBTable('user_table', data);
		hideElement();
	}

	/**
	 * 事件绑定
	 */
	var active = {
		search : function() {
			console.log('---------搜索事件执行---------');
			var usernumValue = $('#search_value').val();
			console.log(usernumValue);
			if (!usernumValue) {
				return;
			} else if (usernumValue == '-1') {
				ajax('get', getUsersUrl + "/users", {}, getUsersSF, false);
				return;
			}
			// 查询
			ajax('get', getUsersByNumUrl + "/" + usernumValue, {},
					getUsersByNumSF, false);
			$('#userOrgan').hide();

		},
		list : function() {
			console.log('---------展示全部用户---------');
			ajax('get', getUsersUrl + "/users", {}, getUsersSF, false);
			$('#userOrgan').hide();
		},
		add : function() {
			console.log('---------增加用户事件执行---------');

			commit_id = guid();
			console.log(commit_id);
			layer.open({
						type : 1,
						title : '增加用户',
						area : ['60%', '70%'],
						id : 'layerDemo' + 1 // 防止重复弹出
						,
						content : $('#form_add_user'),
						zIndex : 999,
						btn : ['提交', '取消'],
						btnAlign : 'c' // 按钮居中
						,
						shade : 0 // 不显示遮罩
						,
						yes : function(index, layero) {
							// 验证
							if (!$('#form_add_user').valid()) {
								return;
							}

							// 获取数据，请求增加用户
							/*
							 * var addInfo = $('#form_add_user').serialize();
							 * console.log(addInfo); ajax('post', addUserUrl,
							 * addInfo, addUserSF);
							 */
							var save_data = {
								orgid : commit_id,
								usernum : $('#usernum').val(),
								name : $('#name').val(),
								accountExtends : {
									userOrganId : commit_id,
									accountName : $('#name').val(),
									accountPhone : $('#phoneNumber').val(),
									accountEmail : $('#email').val()
								}
							};
							console.log(save_data);
							$.ajax({
										url : addUserUrl,
										dataType : 'json',
										type : 'post',
										data : JSON.stringify(save_data),
										contentType : 'application/json',
										success : function(res) {
											console.log(res);
											if (res.state == 0) {
												layer.msg('新增用户成功!!!', {
															icon : 1
														});
												pid = res.data.accountExtends.eId;
												$('#img_btn').trigger('click');
												layer.close(index);
											} else {
												layer.msg('新增用户失败!!!', {
															icon : 2
														});
												return;
											}
										},
										error : function() {
											layer.msg('新增用户失败!!!', {
														icon : 2
													});
											return;
										}

									});
						},
						btn2 : function(index, layero) {
							hideElement();
							layer.close(index);
						},
						end : function() {
							hideElement();
						},
						success : function(layero, index) {
							/*
							 * 初始化加载弹出页面
							 */
							console.log('---------增加用户页面初始化---------');
							// 参数验证初始化
							$('#form_add_user').validate({
								rules : {
									usernum : {
										required : true
									},
									name : {
										required : true
									},
									email : {
										email : true
									},
									phoneNumber : {
										minlength : 11,
										maxlength : 11,
										digits : true
									}
								},
								messages : {
									usernum : {
										required : "用户编号不能为空"
									},
									name : {
										required : "用户名不能为空"
									},
									email : {
										email : "请输入正确的邮箱地址"
									},
									phoneNumber : {
										minlength : "请输入正确的手机号或固定号码",
										maxlength : "请输入正确的手机号或固定号码",
										digits : "请输入正确的手机号或固定号码"
									}
								},
								onfocusout : function(element) {
									$(element).valid();
								},
								onsubmit : false,
								focusInvalid : true,
								highlight : function(element) {
									$(element).siblings('label')
											.addClass('has-error');
								},
								errorPlacement : function(error, element) {
									element.siblings('div').append(error);
								}/*
									 * , submitHandler : function( form ) {
									 * console.log( '---准备提交---' );
									 * //form.submit(); } success :
									 * function(label) {
									 * label.closest('.form-group').removeClass('has-error');
									 * label.remove(); }, submitHandler :
									 * function( form ) { //form.submit(); }
									 */
							})
						}
					});
		}
	}

	$('.demoTable .layui-btn').on('click', function() {
				var type = $(this).attr('id');
				active[type] ? active[type].call(this) : '';
			});

	table.on('edit(user_table)', function(obj) {
		console.log(obj);
		console.log(obj.value); // 得到修改后的值
		console.log(obj.field); // 当前编辑的字段名
		console.log(obj.data); // 所在行的所有相关数据
		if (obj.field == 'accountPhone') {
			// 邮箱验证
			if (!(/^1[3456789]\d{9}$/.test(obj.value)) || obj.value == '') {
				layer.msg("手机号码有误，请重填", {
							icon : 2
						});
				return false;
			}

		} else if (obj.field == 'accountEmail') {
			// 手机号验证
			if (!(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/
					.test(obj.value))
					|| obj.value == '') {
				layer.msg("邮箱有误，请重填", {
							icon : 2
						});
				return false;
			}

		}

		if (!obj.data.accountExtends) {
			obj.data.accountExtends = {};
		}
		obj.data.accountExtends[obj.field] = obj.value;

	});
	// 监听事件
	table.on('toolbar(user_table)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				switch (obj.event) {
					case 'add' :
						active['add'].call(this);
						break;
					case 'delete' :
						break;
					case 'update' :
						break;
				};
			});

	// 监听工具条
	table.on('tool(user_table)', function(obj) {
				var data = obj.data;
				if (obj.event === 'detail') {
					detail(data);
				} else if (obj.event === 'del') {
					del(obj);
				} else if (obj.event === 'save') {
					save(obj);
				} else if (obj.event === 'img_check') {

					console.log(data);

					if (data.accountExtends) {
						pid = data.accountExtends.eId;
						// 有头像
						$.ajax({
									url : '/iotapp-admin/image/getImages',
									type : 'post',
									asyn : false,
									dataType : 'json',
									contentType : 'application/json',
									data : JSON.stringify({
												picture : {
													pid : data.accountExtends.eId,
													ptype : '3'
												}
											}),
									success : function(res) {
										if (res.code == 0 && res.data) {
											$('#head_sculpture1')
													.attr(
															'src',
															'http://192.168.18.211:8080'
																	+ res.data[0].ppath);
										} else {
											layer.msg('头像查询失败', {
														icon : 2
													});
										}

									},
									error : function() {
										layer.msg('头像查询失败', {
													icon : 2
												});
									}
								});

					} else {
						// 无头像
						layer.msg('该用户无头像', {
									icon : 2
								});
						return;

					}

					layer.open({
								id : 'img_check_layer',
								type : 1,
								title : '头像查看',
								skin : 'layui-layer-molv',
								area : ['50%', '45%'],
								resize : false,
								btn : ['关闭'],
								yes : function(index, layero) {
									$('#img_check_div').css('display', 'none');
									layer.close(index);
								},
								cancel : function(index, layero) {
									$('#img_check_div').css('display', 'none');
									layer.close(index);
								},
								content : $('#img_check_div')
							});
				}
			})

	/*
	 * 保存按钮单击事件
	 */
	function save(obj) {
		console.log('--------保存按钮单击事件--------');
		// 保存

		var data = obj.data, dataJson = {
			"orgid" : data.orgid,
			"usernum" : data.usernum,
			"name" : data.name || null,
			"password" : data.user_password || "123",
			"eId" : data.accountExtends ? data.accountExtends.eId : null,
			"accountEmail" : data.accountExtends
					? data.accountExtends.accountEmail
					: null,
			"accountPhone" : data.accountExtends
					? data.accountExtends.accountPhone
					: null
		};
		console.log(dataJson);
		ajax('put', modifyUserUrl, dataJson, modifyUserSF);
	}

	/*
	 * 保存按钮单击事件
	 */
	function modifyUserSF(data) {
		console.log('--------保存按钮单击事件|--------');
		// 刷新页面
		ajax('get', getUsersUrl + "/users", {}, getUsersSF, false);
		layer.msg('保存用户成功', {
					icon : 1
				});
	}

	/*
	 * 删除按钮单击事件
	 */
	function del(obj) {
		console.log('--------删除按钮单击事件--------');
		console.log(obj);
		var data = obj.data;
		console.log(data);
		layer.confirm('真的删除行么', function(index) {
					// 后端删除
					var url = deleteUserUrl + "/" + data.usernum, deleteData = {
						"orgid" : data.orgid,
						"usernum" : data.usernum,
						"name" : data.name
					};
					console.log(url);
					ajax('delete', url, deleteData, function(data) {
								console.log('--------请求删除用户成功回调函数--------');
								// 刷新页面
								// 查询
								ajax('get', getUsersUrl + "/users", {},
										getUsersSF, false);
								layer.msg('删除成功', {
											icon : 1
										});
							});
					layer.close(index);
				});
	}

	/*
	 * 生成前台表格
	 */
	function generateBTable(id, data) {
		table.render({
					elem : '#' + id,
					height : 'full-120',
					title : '用户数据表',
					data : data,
					toolbar : '#toolbar',
					page : true,
					even : true,
					autoSort : false,
					count : data.length,
					curr : 0,
					limit : 10,
					limits : [10, 13, 20, 25, 30],
					layout : ['prev', 'page', 'next', 'skip', 'count', 'limit'],
					cols : [[{
								type : 'numbers',
								title : '序号',
								align : 'center',
								minWidth : 120
							}, {
								field : 'orgid',
								title : 'id',
								minWidth : 120,
								fixed : 'left',
								hide : true,
								align : 'center'
							}, {
								field : 'usernum',
								title : '用户编号',
								minWidth : 200,
								edit : 'text',
								align : 'center'
							}, {
								field : 'name',
								title : '姓名',
								minWidth : 200,
								edit : 'text',
								align : 'center'
							}, {
								field : 'user_password',
								minWidth : 150,
								title : '密码',
								edit : 'text',
								align : 'center'
							}, {
								field : 'state',
								title : '状态',
								minWidth : 80,
								sort : true,
								hide : true,
								align : 'center'
							}, {
								title : '联系电话',
								field : 'accountPhone',
								align : 'center',
								edit : 'text',
								templet : function(obj) {
									return obj.accountExtends
											? obj.accountExtends.accountPhone
											: ''
								}
							}, {
								title : '邮箱',
								align : 'center',
								field : 'accountEmail',
								edit : 'text',
								templet : function(obj) {
									return obj.accountExtends
											? obj.accountExtends.accountEmail
											: ''
								}
							}, {
								fixed : 'right',
								title : '头像',
								toolbar : '#img',
								minWidth : 60,
								width : 80,
								align : 'center'
							}, {
								fixed : 'right',
								title : '操作',
								toolbar : '#barDemo',
								minWidth : 300,
								align : 'center'
							}

					]],
					id : 'testReload',
					done : function(res, curr, count) {
					}
				});
	}

	/*
	 * 搜索请求成功回调函数
	 */
	function getUsersByNumSF(data) {
		console.log('--------搜索请求成功回调函数--------');
		// console.log( data );
		var arr = [];
		arr.push(data);
		// 执行重载
		$('#tableDiv')
				.empty()
				.append(' <table class="layui-hide" id="user_table" lay-filter="user_table"></table>');
		generateBTable('user_table', arr);
	}

	/*
	 * 增加用户请求成功回调函数
	 */
	function addUserSF(data) {
		console.log('--------增加用户请求成功回调函数--------');
		// 关闭弹出页面
		layer.close(layer.index);

		// 重载表格
		layer.msg('增加用户成功', {
					icon : 1
				});
		// 查询
		ajax('get', getUsersUrl + "/users", {}, getUsersSF, false);
	}

	/*
	 * 用户组织关系单击事件
	 */
	function detail(data) {
		console.log('--------用户组织关系单击事件--------');
		console.log(data.usernum);
		var usernum = data.usernum, parentId = data.parent_id, currentOrganId = parentId;

		layer.open({
			type : 1,
			title : '用户与组织关系管理',
			area : ['60%', '80%'],
			id : 'layerDemo' + 1 // 防止重复弹出
			,
			content : $('#userOrgan'),
			btn : ['确定', '取消'],
			btnAlign : 'c' // 按钮居中
			,
			shade : 0 // 不显示遮罩
			,
			yes : function(index, layero) {
				// 获取选中值，对比
				console.log(parentId);
				if (parentId && parentId == currentOrganId) {
					layer.close(index);
					hideElement();
					return;
				}

				// 请求改变用户的组织关系
				console.log(currentOrganId);
				ajax('post', modifyUserParentUrl, {
							'usernum' : usernum,
							'parentid' : currentOrganId
						}, function changeParentSF(data) {
							console.log('-------------修改用户父id成功回调函数--------');
							layer.msg('修改组织关系成功', {
										icon : 6
									});
							layer.close(index);
						});
				hideElement();
				// return false;
			},
			btn2 : function(index, layero) {
				layer.close(index);
				hideElement();
			},
			end : function() {
				hideElement();
			},
			success : function(layero, index) {
				console.log('---------打开用户组织管理页面---------');
				var editObj = null, ptable = null, treeGrid = null, tableId = 'treeTable';
				layui.config({
							base : '/iot_usermanager/jsPackage/web/design/extend/'
						}).extend({}).use(['jquery', 'treeGrid', 'layer'],
						function() {
							var $ = layui.jquery;
							treeGrid = layui.treeGrid;// 很重要
							ptable = treeGrid.render({
										id : tableId,
										elem : '#' + tableId,
										url : initOrganDataUrl + "/" + usernum,
										cellMinWidth : 100,
										idField : 'usernum'// 必須字段
										,
										treeId : 'usernum'// 树形id字段名称
										,
										treeUpId : 'parent_id'// 树形父id字段名称
										,
										treeShowName : 'name'// 以树形式显示的字段
										,
										heightRemove : [".dHead", 10]// 不计算的高度,表格设定的是固定高度，此项不生效
										,
										height : '80%',
										isFilter : false,
										iconOpen : true// 是否显示图标【默认显示】
										,
										isOpenDefault : true// 节点默认是展开还是折叠【默认展开】
										,
										loading : true,
										method : 'get',
										isPage : false,
										cols : [[{
													type : 'numbers'
												}, {
													type : 'radio'
												}, {
													field : 'name',
													width : '50%',
													title : '人员组织名称',
													edit : 'text'
												}, {
													field : 'usernum',
													width : -1,
													title : 'id',
													edit : 'text',
													hide : true
												}, {
													field : 'parent_id',
													width : -1,
													title : 'pid',
													hide : true
												}]],
										parseData : function(res) {// 数据加载后回调
											return res;
										},
										onClickRow : function(index, o) {
											// console.log(index,o,"单击！");

										},
										onDblClickRow : function(index, o) {
											// console.log(index,o,"双击");
										},
										onCheck : function(obj, checked, isAll) {// 复选事件
											// console.log(obj,checked,isAll);
										},
										onRadio : function(obj) {// 单选事件
											console.log(obj);
											currentOrganId = obj.usernum;
										}
									});
						});
			}
		})
	}

	/*
	 * 用户组织关系单击事件
	 */
	function hideElement() {
		$('#userOrgan').hide();
		$('#form_add_user').hide();
	}

	function print() {
		console.log(treeGrid.cache[tableId]);
		var loadIndex = layer.msg("对象已打印，按F12，在控制台查看！", {
					time : 3000,
					offset : 'auto'// 顶部
					,
					shade : 0
				});
	}
	var openorclose = function openorclose() {
		var map = treeGrid.getDataMap(tableId);
		var o = map['102'];
		treeGrid.treeNodeOpen(tableId, o, !o[treeGrid.config.cols.isOpen]);
	}
	var openAll = function openAll() {
		var treedata = treeGrid.getDataTreeList(tableId);
		treeGrid
				.treeOpenAll(tableId, !treedata[0][treeGrid.config.cols.isOpen]);
	}

	var getCheckData = function getCheckData() {
		var checkStatus = treeGrid.checkStatus(tableId), data = checkStatus.data;
		layer.alert(JSON.stringify(data));
	}
	var radioStatus = function radioStatus() {
		var data = treeGrid.radioStatus(tableId)
		layer.alert(JSON.stringify(data));
	}
	var getCheckLength = function getCheckLength() {
		var checkStatus = treeGrid.checkStatus(tableId), data = checkStatus.data;
		layer.msg('选中了：' + data.length + ' 个');
	}
	var reload = function reload() {
		treeGrid.reload(tableId, {
					page : {
						curr : 1
					}
				});
	}
	var query = function query() {
		treeGrid.query(tableId, {
					where : {
						name : 'sdfsdfsdf'
					}
				});
	}
});

/**
 * 渲染头像上传
 */
function load_head_sculpture() {
	layui.use('upload', function() {
				var $ = layui.jquery, upload = layui.upload;
				upload.render({
							elem : '#avatar-view',
							url : '/iotapp-admin/image/uploadImages',
							accept : 'images',
							auto : false,
							bindAction : '#img_btn',
							field : 'files',
							data : {
								pid : commit_id,
								uploadType : 0,
								pType : 3
							},
							before : function(obj) {

								this.data.pid = pid;
							},
							choose : function(obj) {
								// 预读本地文件示例，不支持ie8
								obj.preview(function(index, file, result) {
											$('#head_sculpture').attr('src',
													result);
										});
							},
							done : function(res) {
								// 如果上传失败
								if (res.code < 0) {
									return layer.msg('上传失败');
								}
								// 上传成功
								return layer.msg('上传成功');
							},
							error : function() {

							}
						});
			});
}

/**
 * 渲染头像更换
 */
function load_head_sculpture_edit() {
	layui.use('upload', function() {
				var $ = layui.jquery, upload = layui.upload;
				upload.render({
							elem : '#avatar-view1',
							url : '/iotapp-admin/image/uploadImages',
							accept : 'images',
							field : 'files',
							data : {
								pid : commit_id,
								uploadType : 0,
								pType : 3
							},
							before : function(obj) {

								this.data.pid = pid;
							},
							choose : function(obj) {
								// 预读本地文件示例，不支持ie8
								obj.preview(function(index, file, result) {
											$('#head_sculpture1').attr('src',
													result);
										});
							},
							done : function(res) {
								// 如果上传失败
								if (res.code != 0) {
									return layer.msg('头像修改失败');
								}
								// 上传成功
								return layer.msg('头像修改成功');
							},
							error : function() {
								return layer.msg('头像修改失败');
							}
						});
			});
}
