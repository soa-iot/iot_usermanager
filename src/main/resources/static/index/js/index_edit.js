layui.use(['layer', 'jquery', 'table'], function() {
	var layer = layui.layer;
	var $ = layui.jquery;
	$(function() {
				new function() {
					// 初始化加载页面
					load_index_page(true);
					this.serialized_data = [];

					this.grid = $('.grid-stack').data('gridstack');

					this.load_grid = function() {
					}.bind(this);

					this.save_grid = function() {

						this.serialized_data = _.map(
								$('.grid-stack > .grid-stack-item:visible'),
								function(el) {
									el = $(el);
									console.log(el);
									var node = el.data('_gridstack_node');
									//console.log();
									// console.log(node);
									return {
										positionX : node.x,
										positionY : node.y,
										width : node.width,
										height : node.height,
										content : el.find('.grid-stack-item-content').html()
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
										layer.msg('保存成功');
										/*load_index_page(true);*/
										window.location.reload();
									},
									error : function() {
									}
								});
						
					}.bind(this);

					this.clear_grid = function() {
						this.grid.remove_all();
					}.bind(this);

					$('#save-grid').click(this.save_grid);
					$('#load-grid').click(this.load_grid);
					$('#clear-grid').click(this.clear_grid);

				};
			});
});
