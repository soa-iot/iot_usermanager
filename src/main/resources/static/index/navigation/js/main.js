layui.use(['layer', 'form', 'element', 'jquery', 'dialog'], function() {
	var layer = layui.layer;
	element = layui.element;
	var form = layui.form;
	var $ = layui.jquery;
	var dialog = layui.dialog;
	var hideBtn = $('#hideBtn');
	var hideBtn_ico = $('#hideBtn-ico');
	var mainLayout = $('#main-layout');
	var mainMask = $('.main-mask');
	// 导航菜单的间隔像素
	var menuCell = 5;
	var num = 0;
	var mod_id_str = '';
	var usedId = [];
//	var user_name = getCookie('name').replace(/\%22/g, '');
	var user_name = decodeURI(getCookie('name')).replace(/\"/g, '');
	console.log(user_name);
	$('#user-name').html(user_name);

	/**
	 * 生成菜单
	 */
	$.ajax({
		url : '/iot_usermanager/user/auths',
		dataType : 'json',
		type : 'get',
		success : function(res) {

			var data = res.data;
			console.log(res);
			var menuArray = [];
			$.each(data, function(index, item) {

						if (item.parentId != '-1') {
							return true;
						}
						console.log(data);
						var obj = {};
						obj.name = item.name;
						obj.id = item.modId;
						obj.url = item.url;
						// mod_id_str += item.modId + ',';
						obj.childMenus = getChildArray(item.modId, data);
						menuArray.push(obj);

					});
			console.log('>>>>>>>>>>>>>>>>>>>>>>>>>>');
			console.log(menuArray);
			console.log('>>>>>>>>>>>>>>>>>>>>>>>>>>');
			console.log('>>>>>>>>>>>>>>>>>num:' + num);

			var liStr = "";
			// 遍历生成主菜单
			for (var i = 0; i < menuArray.length; i++) {
				// console.log("--> "+JSON.stringify(data[i]));
				// 判断是否存在子菜单
				if (menuArray[i].childMenus != null
						&& menuArray[i].childMenus.length > 0) {
					console.log("--> "
							+ JSON.stringify(menuArray[i].childMenus));
					liStr += "<li class=\"layui-nav-item\"><a class=\"\" href=\"javascript:;\"><i class='layui-icon' >&#xe68e;</i> "
							+ menuArray[i].name
							+ "</a>\n"
							+ "<dl class=\"layui-nav-child\">\n";
					// 遍历获取子菜单
					for (var k = 0; k < menuArray[i].childMenus.length; k++) {
						liStr += getChildMenu(menuArray[i].childMenus[k], 0);
					}
					liStr += "</dl></li>";
				} else {
					liStr += '<li class="layui-nav-item"><a class=""  data-text = "'
							+ menuArray[i].name
							+ '" data-id = "'
							+ menuArray[i].modId
							+ '" data-url = "'
							+ menuArray[i].url
							+ '" href="javascript:;"><i class="layui-icon" >&#xe68e;</i> '
							+ menuArray[i].name + '</a></li>';
				}
			};
			console.log(">>>> " + liStr);
			$("#leftNav").html(liStr);
			element.init();

		},
		error : function() {
			// todo
		}
	});

	// 递归生成子菜单
	function getChildMenu(subMenu, num) {
		console.log("num: " + num);
		num++;
		var subStr = "";
		if (subMenu.childMenus != null && subMenu.childMenus.length > 0) {
			subStr += "<dd><ul><li class=\"layui-nav-item\" ><a style=\"margin-Left:"
					+ num
					* menuCell
					+ "px\" class=\"\" href=\"javascript:;\"><i class='layui-icon'>&#xe68e;</i> "
					+ subMenu.name
					+ "</a>"
					+ "<dl class=\"layui-nav-child\">\n";
			for (var j = 0; j < subMenu.childMenus.length; j++) {
				subStr += getChildMenu(subMenu.childMenus[j], num);
			}
			subStr += "</dl></li></ul></dd>";
		} else {
			subStr += '<dd><a href="javascript:;"  data-url="' + subMenu.url
					+ '" data-id="' + subMenu.id + '" data-text="'
					+ subMenu.name + '"><span class="l-line"></span>'
					+ subMenu.name + '</a></dd>';
		}
		return subStr;
	}

	// 递归获取子级元素数组
	function getChildArray(itemId, data) {
		num++;

		var childArray = [];
		$.each(data, function(index, item) {
					if (item.parentId == itemId) {
						var obj = {};
						obj.name = item.name;
						obj.id = item.modId;
						obj.url = item.url;
						mod_id_str += item.modId + ',';
						obj.childMenus = getChildArray(item.modId, data);
						childArray.push(obj);
					}

				});
		return childArray;
	}

	// 监听导航点击
	element.on('nav(leftNav)', function(elem) {
		console.log(elem);

		var navA = $(elem).find('a');
		console.log(navA);
		console.log();
		var id = navA.context.dataset.id;
		var url = navA.context.dataset.url;
		var text = navA.context.dataset.text;
		console.log('>>>>>>>>>>>>>>>>点击了' + text);
		if (!url) {
			return;
		}
		var isActive = $('.main-layout-tab .layui-tab-title').find("li[lay-id="
				+ id + "]");
		if (isActive.length > 0) {
			// 切换到选项卡
			element.tabChange('tab', id);
		} else {
			element.tabAdd('tab', {
				title : text,
				content : '<iframe src="'
						+ url
						+ '" name="iframe'
						+ id
						+ '" class="iframe" framborder="0" data-id="'
						+ id
						+ '" scrolling="auto" width="100%"  height="100%"></iframe>',
				id : id
			});
			element.tabChange('tab', id);

		}
		mainLayout.removeClass('hide-side');
	});
	// 监听导航点击
	/*
	 * element.on('nav(rightNav)', function(elem) {
	 * 
	 * console.log('>>>>>>>>>>>点击了导航菜单'); var navA = $(elem).find('a'); var id =
	 * navA.attr('data-id'); var url = navA.attr('data-url'); var text =
	 * navA.attr('data-text'); if (!url) { return; } var isActive =
	 * $('.main-layout-tab .layui-tab-title').find("li[lay-id=" + id + "]"); if
	 * (isActive.length > 0) { // 切换到选项卡 element.tabChange('tab', id); } else {
	 * element.tabAdd('tab', { title : text, content : '<iframe src="' + url + '"
	 * name="iframe' + id + '" class="iframe" framborder="0" data-id="' + id + '"
	 * scrolling="auto" width="100%" height="100%"></iframe>', id : id });
	 * element.tabChange('tab', id); } mainLayout.removeClass('hide-side'); });
	 */
	// 菜单隐藏显示
	hideBtn.on('click', function() {
				if (!mainLayout.hasClass('hide-side')) {
					mainLayout.addClass('hide-side');
					hideBtn_ico.removeClass('layui-icon-shrink-right');
					hideBtn_ico.addClass('layui-icon-spread-left');
				} else {
					mainLayout.removeClass('hide-side');
					hideBtn_ico.removeClass('layui-icon-spread-left');
					hideBtn_ico.addClass('layui-icon-shrink-right');
				}
			});
	// 遮罩点击隐藏
	mainMask.on('click', function() {
				mainLayout.removeClass('hide-side');
			})

	// 示范一个公告层
	// layer.open({
	// type: 1
	// ,title: false //不显示标题栏
	// ,closeBtn: false
	// ,area: '300px;'
	// ,shade: 0.8
	// ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
	// ,resize: false
	// ,btn: ['火速围观', '残忍拒绝']
	// ,btnAlign: 'c'
	// ,moveType: 1 //拖拽模式，0或者1
	// ,content: '<div style="padding: 50px; line-height: 22px;
	// background-color: #393D49; color: #fff; font-weight:
	// 300;">后台模版1.1版本今日更新：<br><br><br>数据列表页...<br><br>编辑删除弹出功能<br><br>失去焦点排序功能<br>数据列表页<br>数据列表页<br>数据列表页</div>'
	// ,success: function(layero){
	// var btn = layero.find('.layui-layer-btn');
	// btn.find('.layui-layer-btn0').attr({
	// href: 'http://www.layui.com/'
	// ,target: '_blank'
	// });
	// }
	// });
	/**
	 * 退出登录
	 */
	$('#logout').on('click', function() {

		console.log('----------退出事件绑定回调函数----------');

		// 关闭链接请求
		$.ajax({
			url : '/iot_usermanager/user/logout',
			type : 'post',
			data : {},
			dataType : 'json',
			success : function(jsonData) {
				console.log(jsonData);
				if (jsonData.state == 302) {
					location.href = '/iot_usermanager/html/userCenter/login.html';
				} else {
					layer.msg("登出失败", {
								icon : 2
							});
				}
			}
		});
		return false;
	});

	/**
	 * 查看个人信息
	 */
	$('#user-name').on('click', function(elem) {
		
		var id = $(this).attr('data-id');
		var url = $(this).attr('data-url');
		var text = $(this).attr('data-text');
		console.log('>>>>>>>>>>>>>>>>点击了' + text);
		if (!url) {
			return;
		}
		var isActive = $('.main-layout-tab .layui-tab-title').find("li[lay-id="
				+ id + "]");
		if (isActive.length > 0) {
			// 切换到选项卡
			element.tabChange('tab', id);
		} else {
			element.tabAdd('tab', {
				title : text,
				content : '<iframe src="'
						+ url
						+ '" name="iframe'
						+ id
						+ '" class="iframe" framborder="0" data-id="'
						+ id
						+ '" scrolling="auto" width="100%"  height="100%"></iframe>',
				id : id
			});
			element.tabChange('tab', id);

		}
		mainLayout.removeClass('hide-side');

		return false;
	});
});

/**
 * 获取指定cookie
 * 
 * @param {}
 *            cookieName
 * @return {String}
 */
function getCookie(cookieName) {
	var strCookie = document.cookie;
	var arrCookie = strCookie.split("; ");
	for (var i = 0; i < arrCookie.length; i++) {
		var arr = arrCookie[i].split("=");
		if (cookieName == arr[0]) {
			return arr[1];
		}
	}
	return "";
}
