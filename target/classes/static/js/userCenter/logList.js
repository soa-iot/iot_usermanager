layui.config({
			base : '/iot_usermanager/jsPackage/web/design/module/'
		}).extend({
			treetable : 'treetable-lay/treetable'
		}).use(
				[ 'table', 'form', 'layedit', 'laydate' ],
				function() {
					var $ = layui.jquery;
					var table = layui.table, form = layui.form, layedit = layui.layedit, laydate = layui.laydate;
					// 加载数据
					
					var username = GetQueryString("username");
					var dateTime = GetQueryString("datime");
					
					indexTable();
					function indexTable() {
						console.log(username)
						console.log(dateTime)
						$.post('/iot_usermanager/userLog/getUserLogList', {
							username : username,
							dateTime : dateTime
						}, function(results) {
							console.log(results);
							if (results.code == 0) {
								setTable(results.data);
							}
						});
					}

					
					function setTable(data) {
						table.render({
							elem : '#test',
							data : data,
							height: 300,
							cellMinWidth : 80,
							page : true,
							limits : [ 20, 30, 40, 50, 60 ], //显示
							limit : 20,
							cols : [ [ {
								type: 'numbers',
								fixed: 'left', 
								title: '序号'
							},{
								field : 'id',
								title : 'id',
								hide : true
							}, {
								field : 'username',
								minWidth : 200,
								title : '用户名'
							}
							, {
								field : 'operation',
								title : '操作'
							}, {
								field : 'ip',
								title : 'IP地址'
							}, {
								field : 'createDate',
								title : '操作时间'
							}
							] ]
						});
					}

					
					function GetQueryString(name) {
						 var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
						    var r = window.location.search.substr(1).match(reg);
						    if (r != null) return decodeURI(r[2]); return null;
			        }
					
				});