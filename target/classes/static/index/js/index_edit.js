layui.use(['layer', 'jquery', 'table', 'form'], function() {
	var layer = layui.layer;
	var $ = layui.jquery;
	var form = layui.form;

	$(function() {
				new function() {
					// 初始化加载页面
					load_index_page(true);
					this.serialized_data = [];

					this.grid = $('.grid-stack').data('gridstack');

					this.load_grid = function() {
					}.bind(this);

					this.save_grid = function() {

						var sava_info = layer.msg("数据保存中。。。", {
									time : 10 * 1000
								});

						this.serialized_data = _.map(
								$('.grid-stack > .grid-stack-item:visible'),
								function(el) {
									el = $(el);
									console.log(el);
									var node = el.data('_gridstack_node');
									// console.log();
									// console.log(node);
									return {
										positionX : node.x,
										positionY : node.y,
										width : node.width,
										height : node.height,
										content : el
												.find('.grid-stack-item-content')
												.html()
									};
								}, this);
						console.log(this.serialized_data);

						// 发送请求，保存编辑信息到数据库
						$.ajax({
									url : '/iot_usermanager/index/saveIndexEditData',
									type : 'post',
									contentType : 'application/json;charset=utf-8',
									dataType : 'json',
									data : JSON.stringify(this.serialized_data),
									success : function(res) {
										// console.log(res);
										layer.close(sava_info);
										layer.msg('保存成功');
										/* load_index_page(true); */
										//window.location.reload();
									},
									error : function() {
									}
								});

					}.bind(this);

					/**
					 * 增加
					 */
					this.add_grid = function() {

						$.ajax({
									url : '/iot_usermanager/index/getIndexTempIndfo',
									type : 'post',
									dataType : 'json',
									data : {},
									success : function(res) {
										console.log(res);
										if (res.code != 0) {
											layer.msg('数据请求异常，请联系管理员');
											return;
										}

										var html = '';
										$.each(res.data, function(index, item) {

													// html += '<option value =
													// '+item.tempComtent+'>'+item.tempName+'</option>'
													html += item.tempComtent;

												});
										layer.open({
													type : 1,
													area : ['40%', '60%'],
													title : '添加',
													btn : ['确认', '取消'],
													yes : function(index,
															layero) {

													},
													btn2 : function(index,
															layero) {

														// return
														// false;
													},
													content : html
												});

									},
									error : function() {
										layer.msg('数据请求异常，请联系管理员');
									}
								});

					}.bind(this);

					/**
					 * 清除
					 */
					this.clear_grid = function() {
						this.grid.remove_all();
					}.bind(this);

					$('#save-grid').click(this.save_grid);
					$('#load-grid').click(this.load_grid);
					$('#clear-grid').click(this.clear_grid);
					$('#add-grid').click(this.add_grid);

				};
			});
});
