/**
 * 页面初始化加载
 */

function load_index_page(isEdit) {
	/**
	 * 加载页面数据
	 */
	$.ajax({
				url : '/iot_usermanager/index/getIndexEditData',
				type : 'post',
				dataType : 'json',
				data : {},
				async : false,
				success : function(res) {
					//console.log(res);
					if (res.data != null && res.data.length != 0) {
						/**
						 * 生成页面
						 */
						var items = GridStackUI.Utils.sort(res.data);

						var html = "";
						_.each(items, function(node) {
									html += '<div class="grid-stack-item" data-gs-x="'
											+ node.positionX
											+ '" data-gs-y="'
											+ node.positionY
											+ '" data-gs-width="'
											+ node.width
											+ '" data-gs-height="'
											+ node.height
											+ '"><div class="grid-stack-item-content">'
											+ node.content
											+ '</div></div>';

								}, this);
						//console.log(html);
						$('#grid-stack').html(html);

					}

					if (!isEdit) {
						$('.grid-stack-item').attr("data-gs-no-resize",
								"disable element resizing");
						$('.grid-stack-item').attr("data-gs-no-move",
								"disable element moving");
					} 
					var options = {
						cell_height : 80,
						vertical_margin : 10
					};
					$('.grid-stack').gridstack(options);

					var options = {
						cell_height : 80,
						vertical_margin : 10
					};
					$('.grid-stack').gridstack(options);
					// 请求页面数据
					$.ajax({
								url : '/iot_usermanager/index/getIndexData',
								type : 'get', // GET
								async : true, // 或false,是否异步
								data : {},
								dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
								success : function(res) {
									//console.log(res);
									/**
									 * 填充数据
									 */
									// 设备异常
									$('#total_PROBLEM')
											.text(res.data.total_PROBLEM);

									// 预警
									$('#total_WARN').text(res.data.total_WARN);

									// 隐患问题量
									$('#total_PROBLEM_WARN')
											.text(res.data.total_PROBLEM_WARN);

									// 任务完成率
									$('#total_TASK_RATE')
											.text(res.data.total_TASK_RATE);

									// 待办数量
									$('#total_TODO').text(res.data.total_TODO);

									// 问题整改率
									$('#total_PROBLEMRECTIFYRATE')
											.text(res.data.total_PROBLEMRECTIFYRATE);

									// 加载待办任务提醒
									load_table(res.data.todoListMap);

									// 加载消息提醒
									load_notice(res.data.noticeListMap);

									//console.log('页面初始化完毕');

								},
								error : function(xhr, textStatus) {
									/*
									 * $.messager.show({ title: "提示", msg:
									 * "请求处理失败", showType: 'slide', timeout:
									 * 5000 })
									 */
								}
							});
				},
				error : function() {
				}
			});

	// 请求消息
	/*
	 * $.ajax({ url :
	 * 'http://192.168.18.22:10039/CZ_PIOTMS/getMessageInfoInMain.action', type :
	 * 'get', // GET async : true, // 或false,是否异步 data : { userName : userName },
	 * processData : false, dataType : 'jsonp', //
	 * 返回的数据格式：json/xml/html/script/jsonp/text success : function(data) {
	 * console.log(data); if (data && data != '0') { $.each(data,
	 * function(index, item) { $('marquee') .append(' <p> ' + ' <i class="fa
	 * fa-bell-o"></i> ' + ' <span class="details" onclick="dealMessage(this)"
	 * piid="' + item.PIID + '"> ' + item.PROBLEMDESCRIBE + ' </span>' + ' </p>
	 * '); }) } else { $.messager.show({ title : "提示", msg : "请求数据为空", showType :
	 * 'slide', timeout : 5000 }) } }, error : function(xhr, textStatus) {
	 * 
	 * $.messager.show({ title: "提示", msg: "请求处理失败", showType: 'slide', timeout:
	 * 5000 }) } });
	 */
}

/**
 * 加载待办任务表格
 */
function load_table(data, height) {

	if (data == null || data == '') {
		data = [];
	}

	var height = $('#todo_task').parent().height() * 0.95;

	/*layui.use(['form', 'laypage', 'table', 'laydate', 'layer'], function() {
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
							even : true,
							size : 'sm',
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

			});*/
	
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

	var html = '<marquee  style="margin: 0 0;height: 98%" direction="up" behavior="scroll" scrollamount="3" '
			+ 'scrolldelay="0" loop="-1" hspace="10" vspace="10" direction="up" '
			+ 'onmouseover="this.stop()" onmouseout="this.start()">';

	$.each(notice_list, function(index, item) {
		var notice = item.TASK_CLASS + '--' + item.TASK_NAME + '--已超期'
				+ item.OVERTIME + '!!!';
		html += '<p><i class="fa fa-bell-o"></i><span class="details" onclick="showDetails(this)">'
				+ '问题上报--已超期5天!!!' + '</span></p>';
	});

	html += '</marquee>'
	//console.log(notice_list);
	$('#notice').html(html);

}

/**
 * 获得cookie 的值
 */
function getCookie( name ){    
   var cookieArray=document.cookie.split( "; " ); 
   for ( var i=0; i<cookieArray.length; i++ ){    
      var arr = cookieArray[i].split( "=" );       //将名和值分开    
      if( arr[0] == name ) return decodeURI( arr[1] ); //如果是指定的cookie，则返回它的值    
   } 
   return ""; 

} 
//return decodeURI( arr[1] );
