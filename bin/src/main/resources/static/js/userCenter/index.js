/**
 * 全局变量
 * @type 
 */
var element = layui.element,
	layer = layui.layer,
	logoutUrl = ipPort + "/user/logout",
	username;
//菜单配置
var menoSon = {
	"userControl" : "用户管理,角色管理,权限管理,系统通知",
	"equipControl" : ""
};
//侧边菜单配置
var navMenoSon = {
	"用户管理" : "userManager" ,
	"角色管理" : "roleManager" ,
	"权限管理" : "authManager" ,
	"系统通知" : "systemNotice"
};
//侧边菜单Url配置
var navMenoSon = {
	"userManager" : ipPort + "/static/userManager",
	"roleManager" : ipPort + "/static/roleManager",
	"authManager" : ipPort + "/static/authManager",
	"systemNotice" : ipPort + "/static/systemNotice"
};

var menoArr = [
	{
		"id" : "1", 
		"first" : "控制台", 
		"second" : "控制台1,控制台2,控制台3",
		"url":""		 
	},
	{
		"id" : "2", 
		"first" : "设备管理", 
		"second" : "设备管理1,设备管理2,设备管理3,设备管理4",
		"url":""		 
	},
	{
		"id" : "3", 
		"first" : "用户模块", 
		"second" : "用户管理,角色管理,权限管理,系统通知",
		"url":"/static/userManager,/static/roleManager,/static/authManager,/static/systemNotice"		 
	},
	{
		"id" : "4", 
		"first" : "其他", 
		"second" : "其他1,其他2",
		"url":""		 
	}
]
	
/**
 * 初始化加载
 * @type 
 */
$(function(){	
	//初始化加载一级菜单
	$.grep( menoArr, function( item, index ){
		$('#firstMeno').append(
			'<li class="layui-nav-item" id=' + item.id + '>' +
				'<a href="">' +
				  + $.trim(item.first) + 
				 '</a>'+
			'</li>'		
		);
	})	
	
	//初始化加载二级菜单
	
	//获取usernum
	username = getCookie1("name");
	//console.log( 'username:' + username );
	
	//ws验证
	if(typeof(WebSocket)=='undefined'){
    	layer.msg( "你的浏览器不支持消息推送" );
    	return;
    };
    console.log( '-------------WebSocket------------' );
    console.log(WebSocket);
	
	//ws连接,打开服务
	socket = new WebSocket("ws://localhost:8001/push/pushVideoListToWeb");
	socket.onopen = function(){
		console.log("--------------ws服务已打开----------------");  
		socket.send( JSON.stringify({'test':20}) ); 
	}
	
	socket.onmessage = function(msg){
		console.log( msg.data );
	}
	
	socket.onclose=function(){
		console.log("--------------关闭ws服务--------------");
	}
})

/**
 * 事件绑定
 * @type 
 */
$(function(){
	//退出事件绑定
	$('#logout').on('click', logoutCallBack );
	
	//菜单栏单击事件
	$('.layui-nav-item').on('click', menoCallBack );
})

/**
 * 页面初始化
 * @type 
 */
$(function(){
	
})

/**
 * 退出事件绑定回调函数
 * @type 
 */
function logoutCallBack(){
	console.log( '----------退出事件绑定回调函数----------');
	//关闭链接请求
	$.ajax({
	    url: logoutUrl,
	    type: 'post',
	    data: {},
	    dataType: 'json',
	    success: function (jsonData) {
	    	console.log( jsonData );
	        if (jsonData.state == 302) {
	            location.href = ipPort +  jsonData.data;
	        }else{
	        	layer.msg("登出失败", {icon:2});
	        }
	    }
	});      
	return false;
}

/**
 * 退出请求成功回调函数
 * @type 
 */
function logoutSucc(){
	console.log( '----------退出请求成功回调函数----------');
	//跳转登录页
}

/**
 * 菜单单击事件回调函数
 * @type 
 */
function menoCallBack( obj ){
	console.log( '----------退出请求成功回调函数----------');	
	//获取二级子菜单
	var secondMeno = $(obj).attr('id');
	console.log( 'secondMeno' );	
	$secondMeno = $('#secondMeno');
	$secondMeno.empty();
	$.grep( menoArr, function( item, index ){
		if( $.trim(item.id) == $.trim(secondMeno) ){
			var secondMenoArr = menoArr.second.split(',');
			var secondMenoUrl = menoArr.url.split(',');
			$secondMeno.map( secondMenoArr, function( item, index ){
				$secondMeno.append(
					'<li class="layui-nav-item layui-nav-itemed" '+ 
							' url=' + secondMenoUrl[index] + ' onclick="navClickBack(obj);">' + 
				     	'<a class="" href="javascript:;">' + secondMenoArr[index] + '</a>' +
			        '</li>');
			})	
		}
	})	
}

/**
 * 侧边菜单单击事件函数
 * @type 
 */
function navClickBack( obj ){
	console.log( '----------侧边导航栏单击事件函数---------');	
	console.log( obj );	
	var url = $(obj).atrr('url');
	//请求
	ajax();
}