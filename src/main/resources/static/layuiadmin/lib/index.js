// 导航菜单的间隔像素
var menuCell = 10;
var num = 0;
var mod_id_str = '';
var usedId = [];
// var user_name = getCookie('name').replace(/\%22/g, '');
var user_name = decodeURI(getCookie('name')).replace(/\"/g, '');
$('#user-name').html(user_name);
/**
 * 判断用户是否登录
 */
if (user_name == null || user_name == '') {
	window.location.href="/html/userCenter/login.html";
}

/** layuiAdmin.std-v1.0.0 LPPL License By http://www.layui.com/admin/ */
layui.use(['element'], function() {
	var element = layui.element;
	/**
	 * 生成菜单
	 */
	$.ajax({
		url : '/iot_usermanager/user/auths',
		dataType : 'json',
		type : 'get',
		success : function(res) {

			var data = res.data;
			// console.log(res);
			var menuArray = [];
			$.each(data, function(index, item) {
						if (item.parentId != '-1') {
							return true;
						}
						// console.log(data);
						var obj = {};
						obj.name = item.name;
						obj.id = item.modId;
						obj.url = item.url;
						obj.menuIcon = item.menuIcon;
						// mod_id_str += item.modId + ',';
						obj.childMenus = getChildArray(item.modId, data);
						menuArray.push(obj);

					});
			// console.log('>>>>>>>>>>>>>>>>>>>>>>>>>>');
			console.log(menuArray);
			// console.log('>>>>>>>>>>>>>>>>>>>>>>>>>>');
			// console.log('>>>>>>>>>>>>>>>>>num:' + num);

			var liStr = "";
			// 遍历生成主菜单
			for (var i = 0; i < menuArray.length; i++) {
				// //console.log("--> "+JSON.stringify(data[i]));
				// 判断是否存在子菜单
				if (menuArray[i].childMenus != null
						&& menuArray[i].childMenus.length > 0) {

					liStr += '	<li data-name="home" class="layui-nav-item"><a '
							+ 'href="javascript:;" lay-tips="'
							+ menuArray[i].name
							+ '" lay-direction="2"><i class="'
							+ (menuArray[i].menuIcon
									? menuArray[i].menuIcon
									: "layui-icon fa far-bars")
							+ '"></i> <cite>' + menuArray[i].name + '</cite>'
							+ '</a><dl class="layui-nav-child">';

					console.log(menuArray[i].menuIcon);
					/*
					 * liStr += "<li class=\"layui-nav-item\"><a class=\"\"
					 * href=\"javascript:;\"><i class='" +
					 * (menuArray[i].menuIcon ? menuArray[i].menuIcon : "fa
					 * far-bars") + "'></i> " + menuArray[i].name + "</a>\n" + "<dl class=\"layui-nav-child\">\n";
					 */
					// 遍历获取子菜单
					for (var k = 0; k < menuArray[i].childMenus.length; k++) {
						liStr += getChildMenu(menuArray[i].childMenus[k], 0);
					}
					liStr += "</dl></li>";
				} else {

					liStr += ' <li data-name="get" class="layui-nav-item">'
							+ '<a href="javascript:;" lay-href="'
							+ menuArray[i].url
							+ '" lay-tips="'
							+ menuArray[i].name
							+ '" lay-direction="2">'
							+ '<i class="'
							+ (menuArray[i].menuIcon
									? menuArray[i].menuIcon
									: "layui-icon fa far-bars") + '"></i>'
							+ '<cite>' + menuArray[i].name + '</cite></a></li>';

					/*
					 * liStr += '<li class="layui-nav-item"><a class=""
					 * data-text = "' + menuArray[i].name + '" data-id = "' +
					 * menuArray[i].id + '" data-url = "' + menuArray[i].url + '"
					 * href="javascript:;"><i class="' + (menuArray[i].menuIcon ?
					 * menuArray[i].menuIcon : 'fa far-bars') + '" ></i> ' +
					 * menuArray[i].name + '</a></li>';
					 */
				}
			};
			// console.log(">>>> " + liStr);
			$("#leftNav").html(liStr);
			element.init();

		},
		error : function() {
			// todo
		}
	});
	// console.log(user_name);
	layui.extend({
				setter : "config",
				admin : "lib/admin",
				view : "lib/view"
			}).define(["setter", "admin"], function(a) {
		var e = layui.setter, i = layui.element, n = layui.admin, t = n.tabsPage, d = layui.view, l = function(
				a, d) {
			var l, b = r("#LAY_app_tabsheader>li"), y = a.replace(
					/(^http(s*):)|(\?[\s\S]*$)/g, "");
			if (b.each(function(e) {
						var i = r(this), n = i.attr("lay-id");
						n === a && (l = !0, t.index = e)
					}), d = d || "新标签页", e.pageTabs)
				l
						|| (r(s)
								.append([
										'<div class="layadmin-tabsbody-item layui-show">',
										'<iframe src="'
												+ a
												+ '" frameborder="0" class="layadmin-iframe"></iframe>',
										"</div>"].join("")), t.index = b.length, i
								.tabAdd(o, {
											title : "<span>" + d + "</span>",
											id : a,
											attr : y
										}));
			else {
				var u = n.tabsBody(n.tabsPage.index).find(".layadmin-iframe");
				u[0].contentWindow.location.href = a
			}
			i.tabChange(o, a), n.tabsBodyChange(t.index, {
						url : a,
						text : d
					})
		}, s = "#LAY_app_body", o = "layadmin-layout-tabs", r = layui.$;
		r(window);
		n.screen() < 2 && n.sideFlexible(), layui.config({
					base : e.base + "modules/"
				}), layui.each(e.extend, function(a, i) {
					var n = {};
					n[i] = "{/}" + e.base + "lib/extend/" + i, layui.extend(n)
				}), d().autoRender(), layui.use("common"), a("index", {
					openTabsPage : l
				})
	});
});

// 递归生成子菜单
function getChildMenu(subMenu, num) {
	// console.log("num: " + num);
	num++;
	var subStr = "";
	if (subMenu.childMenus != null && subMenu.childMenus.length > 0) {
		subStr += '	<dd><ul><li data-name="home" class="layui-nav-item"><a style="margin-Left:'
				+ num
				* menuCell
				+ 'px" '
				+ 'href="javascript:;" lay-tips="'
				+ subMenu.name
				+ '" lay-direction="2"><i class="'
				+ (subMenu.menuIcon
						? subMenu.menuIcon
						: "layui-icon fa far-bars")
				+ '"></i> <cite>'
				+ subMenu.name + '</cite>' + '</a><dl class="layui-nav-child">';

		/*
		 * subStr += "<dd><ul><li class=\"layui-nav-item\" ><a
		 * style=\"margin-Left:" + num menuCell + "px\" class=\"\"
		 * href=\"javascript:;\"><i class='" + (subMenu.menuIcon ?
		 * subMenu.menuIcon : "fa far-bars") + "'></i> " + subMenu.name + "</a>" + "<dl class=\"layui-nav-child\">\n";
		 */
		for (var j = 0; j < subMenu.childMenus.length; j++) {
			subStr += getChildMenu(subMenu.childMenus[j], num);
		}
		subStr += "</dl></li></ul></dd>";
	} else {

		subStr += '<dd data-name="'
				+ subMenu.id
				+ '" class="">'
				+ '<a style="margin-Left:'
				+ num
				* menuCell
				+ 'px" lay-href="'
				+ subMenu.url
				+ '"><i class="'
				+ (subMenu.menuIcon
						? subMenu.menuIcon
						: "layui-icon fa far-bars") + '"></i>' + subMenu.name
				+ '</a>' + '</dd>';
		/*
		 * subStr += '<dd><a href="javascript:;" data-url="' + subMenu.url + '"
		 * data-id="' + subMenu.id + '" data-text="' + subMenu.name + '">' + '<i
		 * class="l-line ' + (subMenu.menuIcon ? subMenu.menuIcon : 'fa
		 * far-bars') + '" ></i> ' + subMenu.name + '</a></dd>';
		 */
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
					obj.menuIcon = item.menuIcon;
					mod_id_str += item.modId + ',';
					obj.childMenus = getChildArray(item.modId, data);
					childArray.push(obj);
				}

			});
	return childArray;
}

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
