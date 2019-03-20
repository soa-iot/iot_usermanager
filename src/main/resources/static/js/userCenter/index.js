/**
 * 全局变量
 * @type 
 */
var element = layui.element,
	layer = layui.layer,
	logoutUrl = ipPort + "/user/logout",	
	roleAuthUrl = ipPort + "/user/role/auths",
	roleAuthJsonUrl = ipPort + "/user/auths",
	username;
//菜单配置
var menoArr,authArr;

/**
 * 初始化加载
 * @type 
 */
$(function(){	
	/*
	 * 初始化菜单权限
	 */
	ajax( 'get', roleAuthJsonUrl, {}, getAuthsSF, false );
	
	/*
	 * 初始化菜单权限请求成功回调函数
	 */
	function getAuthsSF( data ){
		console.log( '-------初始化菜单权限请求成功回调函数---------');
		console.log( data );		
		menoArr = data;
	}
	
	
	/*
	 * 初始化菜单
	 */
	if( menoArr ){
		//对象
		authArr  = sortForTree( menoArr );
		
		/*
		 * 加载第一级菜单
		 */
		$.each( authArr, function( index, item ){
			$( '#firstMeno' ).append(
				'<li class="layui-nav-item" id=' + item.id + '>' +
					'<a href="javaScript:;">' +
						$.trim(item.name) + 
					'</a>' +
				'</li>'		
			);
		})		
		
		element.init(); 
	}		
	
	
	
	/*
	 * 加载用户名
	 */
	//获取usernum
	username = getCookie1("name");
	username = username.substr( 1, username.length-2);
	$('#userName').find('img').after(username);
})

/**
 * 事件绑定
 * @type 
 */
$(function(){
	//退出事件绑定
	$('#logout').on('click', logoutCallBack );
	
	//基本资料单击事件
	$('#userInfo').on( 'click', userInfoCE);
	
	//菜单栏单击事件
	$('.layui-nav-item').on('click', menoCallBack );
})

/**
 * 基本资料单击事件函数
 * @type 
 */
function userInfoCE(){
	console.log( '----------基本资料单击事件函数----------');
	
	//打开页面
}

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
 * 菜单栏单击事件
 * @type 
 */
function menoCallBack(){
	console.log( '----------菜单栏单击事件----------');	
//	console.log( $(this) );	
	//获取二级子菜单
	var secondMenoId = $(this).attr('id');
	console.log( secondMenoId );	
	
	//获取所有子菜单[]
	var sonMeno;
	$.grep( authArr, function( item, index ){
		if( $.trim(item.id) == $.trim( secondMenoId ) ){
			sonMeno = item.child;
		}
	})
	console.log( sonMeno );	
	
	//加载子菜单
	if( sonMeno ){
		$secondMeno = $('#secondMeno');
		$secondMeno.empty();
		generateF( $secondMeno, sonMeno );
		element.init(); 
	}	
	
	return false;
}

/**
 * 侧边菜单单击事件函数
 * @type 
 */
function navClickBack(obj){
	console.log( '----------侧边导航栏单击事件函数---------');	
	var url = $(obj).attr('url');
	//http://localhost:8001/html/userCenter/userManager.html
	//动态加载页面
	var a = $( '#indexContent' )
		.load( ipPort + url + ' .loadContent', function(returnDom){
			$( returnDom ).find( 'script' ).appendTo( '#indexContent' );
		});
}

/**
 * ws加载
 */
$(function(){
	/*
	 * ws验证
	 */
	if(typeof(WebSocket)=='undefined'){
    	layer.msg( "你的浏览器不支持消息推送" );
    	return;
    };
//    console.log( '-------------WebSocket------------' );
//    console.log(WebSocket);
	
	//ws连接,打开服务
	socket = new WebSocket( "ws://"+ ipPort.substr(6) + "/push/pushVideoListToWeb" );
	socket.onopen = function(){
		console.log("--------------ws服务已打开----------------");  
		socket.send( JSON.stringify({'test':20}) ); 
	}
	
	socket.onmessage = function( msg ){
		console.log("--------------ws接受到消息----------------");		
		wsMessage = msg.data;
		
		//通知
		if(  msg.data ){
			layer.open({
				type: 2,
				title: '消息提示',
			  	shade: false,
			  	anim: 2,
			  	area: ['400px', '250px'],
			  	maxmin: true,
			  	content: ipPort + '/html/userCenter/noticeMessage.html',
			  	offset: 'rb',
			  	zIndex: layer.zIndex, //重点1
			  	success: function(layero){
//			  		console.log(  $(layero[0]).children('div') );
			  		$( $(layero[0]).children('div')[1] ).empty().css(
			  			{"height":"200","width":"250","font-size":"14px",
			  			 "padding-left":"25px","padding-top":"20px"}
			  			)
			  			.text( msg.data );
//			  		console.log( wsMessage );
//			  		$(layero[0]).children('div').text();
//			  		$( $(layero[0]).children('div')[1] ).find('iframe').text('33333333');
//			  		var sonDom = $( $(layero[0]).children('div')[1] ).find('iframe').contents()[0];
//			  		console.log( $( $(layero[0]).children('div')[1] ).find('iframe').contents()[0] );
//			  		var $div = $( sonDom ).find( '#nmessage' ) ;
			    	layer.setTop(layero); //重点2
			  	}
			});    
		}		
	}
	
	socket.onclose=function(){
		console.log("--------------关闭ws服务--------------");
	}	
})


/*
 * 生成无限极layui-Nav第一步
 * $obj为ul标签对应的jquery对象, data为无限极的tree数据结构
 */
function generateF( $obj, data ){
	$.each( data, function(index,item){
	  	var html ='<li class="layui-nav-item "' + 
	  					' url=' + item.url + ' onclick="navClickBack(this);">' + 
					'<a href="javascript:;">'+ item.name + '</a>'
				'</li>';
		$this = $(html);
		$obj.append($this);
		if(item.child){
			$this.append('<dl class="layui-nav-child"></dl>' );
			$this =  $this.find('dl');
			$.each( item.child, function(index1,item1){				
				if(item1.child){
					$this.append('<dd></dd>');
					generateT( $this.find('dd:last'), item1.child, item1.name);
				}else{
					$this.append('<dd><a href="javascript:;">'+item1.name+'</a></dd>');
				}
			})
		}
	})
}

/*
 * 生成无限极layui-Nav第二步
 */
function generateT( $obj, data, name ){
	var html ='<li class="layui-nav-item">' + 
				'<a href="javascript:;">'+ name + '</a>' +
			    '<dl class="layui-nav-child">' +
			    '</dl>' +
			'</li>';
	$this = $(html);
	$obj.append($this);
	$.each( data, function(index,item){
		if(item.child){
			generateT( $this.find('dd:last'), item.child, item.name);
		}else{
			$this.find('dl').append('<dd><a href="javascript:;">'+item.name+'</a></dd>');
		}
	} )
}

/*
 * 根据json数组，生成无限极tree结构
 */
function sortForTree( jsonObj ){
	/*
	 * 找顶级
	 */
	var suthSet = jsonObj.filter( distinct );
	//console.log(suthSet);
	
	/*
	 * 生成指定结构	 
	 */			
	var arr = generateTree( jsonObj, suthSet);
	
	/* 
	 * 加载 
	 */
	console.log( arr );
	return arr;
}


/*
 * 根据json数组，生成无限极tree结构核心算法
 * jsonObj为原json数组，suthSet为去重pid后的json数组
 */
function generateTree( jsonObj, unsortResult ){	
	var suthSet = [];
	//排序
	for( var i = 0; i < unsortResult.length; i++ ){
		if( i == 0 ){
			suthSet.push( unsortResult[i] );
			continue;
		}
		console.log(suthSet.length);
		for( var j = 0; j < suthSet.length; j++ ){
			if( suthSet[j].remark1 > unsortResult[i].remark1  ){
				suthSet.splice( j, 0, unsortResult[i] );
				break;
			}
			if( j == suthSet.length - 1){
				suthSet.push( unsortResult[i] );
				break;
			}
		}
	}
	
	//构造无限极tree
	var result = [];
	for( var i = 0; i < suthSet.length; i++ ){	
		var tempSet = [];//放pid			
		var json = { "name":suthSet[i].name, "child":"", 
					 "remark1":suthSet[i].remark1, "url":suthSet[i].url,
					 "id": suthSet[i].modId
				};			
		for( var j = 0; j < jsonObj.length; j++ ){
			if( jsonObj[j].parentId == suthSet[i].modId ){
				tempSet.push( jsonObj[j] );			
			}					
		}
		if( tempSet.length > 0){
			var tempArr = generateTree( jsonObj, tempSet );
			json.child = tempArr;
		}
		result.push( json );			
	}
	return result;
}

/*
 * 数组去重回调函数
 */
function distinct( elem ){
	for(var i= 0; i< menoArr.length; i++){
		if( menoArr[i].modId == elem.parentId ){
			return false;
		}		
	}
	return true;
}	
