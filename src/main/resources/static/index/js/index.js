/**
 * 页面初始化加载
 */
$(function() {
	// 获取当前登录人
	/*
	 * var userName =
	 * unescape(document.cookie.split("userLogin=")[1].split(";")[0]);
	 * console.log('username:' + userName);
	 */

	var userName = 'admin';
	// 请求页面数据
	$.ajax({
				url : '/iot_usermanager/index/getIndexData',
				type : 'get', // GET
				async : true, // 或false,是否异步
				data : {
				},
				dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
				success : function(res) {
					console.log(res);
					/**
					 * 填充数据
					 */
					// 设备异常
					$('#total_PROBLEM').text(res.data.total_PROBLEM);

					// 预警
					$('#total_WARN').text(res.data.total_WARN);

					// 隐患问题量
					$('#total_PROBLEM_WARN').text(res.data.total_PROBLEM_WARN);

					// 任务完成率
					$('#total_TASK_RATE').text(res.data.total_TASK_RATE);

					// 待办数量
					$('#total_TODO').text(res.data.total_TODO);

					// 问题整改率
					$('#total_PROBLEMRECTIFYRATE')
							.text(res.data.total_PROBLEMRECTIFYRATE);

					// 加载待办任务提醒
					load_table(res.data.todoListMap);

					// 加载消息提醒
					load_notice(res.data.noticeListMap);

					console.log('页面初始化完毕');

				},
				error : function(xhr, textStatus) {
					/*
					 * $.messager.show({ title: "提示", msg: "请求处理失败", showType:
					 * 'slide', timeout: 5000 })
					 */
				}
			});

	// 请求消息
	$.ajax({
		url : 'http://192.168.18.22:10039/CZ_PIOTMS/getMessageInfoInMain.action',
		type : 'get', // GET
		async : true, // 或false,是否异步
		data : {
			userName : userName
		},
		processData : false,
		dataType : 'jsonp', // 返回的数据格式：json/xml/html/script/jsonp/text
		success : function(data) {
			console.log(data);
			if (data && data != '0') {
				$.each(data, function(index, item) {
					$('marquee')
							.append(' <p> '
											+ ' 	<i class="fa fa-bell-o"></i> '
											+ ' 	<span class="details" onclick="dealMessage(this)" piid="'
											+ item.PIID + '"> '
											+ item.PROBLEMDESCRIBE
											+ ' 	</span>' + ' </p> ');
				})
			} else {
				$.messager.show({
							title : "提示",
							msg : "请求数据为空",
							showType : 'slide',
							timeout : 5000
						})
			}
		},
		error : function(xhr, textStatus) {
			/*
			 * $.messager.show({ title: "提示", msg: "请求处理失败", showType: 'slide',
			 * timeout: 5000 })
			 */
		}
	});
	var options = {
		cell_height : 80,
		vertical_margin : 10
	};
	$('.grid-stack').gridstack(options);

	this.save_grid = function() {
		console.log('111111111111');
		this.serialized_data = _.map(
				$('.grid-stack > .grid-stack-item:visible'), function(el) {
					el = $(el);
					var node = el.data('_gridstack_node');
					return {
						x : node.x,
						y : node.y,
						width : node.width,
						height : node.height
					};
				}, this);
		$('#saved-data')
				.val(JSON.stringify(this.serialized_data, null, '    '));
	}.bind(this);
	$('#save-grid').click(this.save_grid);
});

/**
 * 加载待办任务表格
 */
function load_table(data, height) {

	if (data == null || data == '') {
		data = [];
	}
	
	var height = $('#todo_task').parent().height()*0.95;

	layui.use(['form', 'laypage', 'table', 'laydate', 'layer'], function() {
				var table = layui.table;
				var laydate = layui.laydate;
				var layer = layui.layer;
				var form = layui.form;
				var $ = layui.jquery;
				// 执行渲染
				table.render({
							elem : '#todo_task',
							data : data,
							skin : 'line',
							align : 'center',
							height : height,
							even: true,
							size: 'sm',
							cols : [[ // 表头
							{
										type : 'numbers',
										title : '序号',
										align : 'center'
									}, {
										field : 'taskInstName',
										title : '任务名',
										align : 'center'
									}, {
										field : 'starter',
										title : '发起者',
										align : 'center'
									}, {
										field : 'arriveDate',
										title : '任务到达时间',
										align : 'center',
										minWidth : 180
									}, {
										field : 'taskState',
										title : '紧急度',
										align : 'center'
									}, {
										field : '',
										title : '处理',
										align : 'center',
										toolbar : '#deal'
									}]]
						});

			});
}

/**
 * 加载消息提醒
 * 
 * @param notice_list
 *            消息
 * @returns
 */
function load_notice(notice_list) {

	if (notice_list == null || notice_list == '') {
		notice_list = [];
	}
	
	
							
							
						
	var html = '<marquee  style="margin: 0 0;height: 98%" direction="up" behavior="scroll" scrollamount="3" ' +
			'scrolldelay="0" loop="-1" hspace="10" vspace="10" direction="up" ' +
			'onmouseover="this.stop()" onmouseout="this.start()">';

	$.each(notice_list, function(index, item) {
		var notice = item.TASK_CLASS + '--' + item.TASK_NAME + '--已超期'
				+ item.OVERTIME + '!!!';
		html += '<p><i class="fa fa-bell-o"></i><span class="details" onclick="showDetails(this)">'
				+ '问题上报--已超期5天!!!' + '</span></p>';
	});
	
	html += '</marquee>'
	console.log(notice_list);
	$('#notice').html(html);
	

}
