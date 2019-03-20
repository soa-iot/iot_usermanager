/**
 * 全局变量
 */
var saveUrl = ipPort + '/user',
	deleteUrl = ipPort + '/user/organ',
	putUrl = ipPort + '/userInfo/state',
	registerUrl = ipPort + '/register/list',
	saveUserInfoUrl = ipPort + '/user/userInfo',
	modifyRegStateUrl = ipPort + '/register/state';
 
/**
 * 初始化加载
 */
$( function(){
//	var _hmt = _hmt || [];
//    (function() {
//        var hm = document.createElement("script");
//        hm.src = "https://hm.baidu.com/hm.js?e2af8415b6ffbaeb52de4d080cb4ba85";
//        var s = document.getElementsByTagName("script")[0];
//        s.parentNode.insertBefore(hm, s);
//    })();
	//加载注册信息
	$.ajax({
		 type : "GET",
	     url : registerUrl,
	     data : {},
	     async : false, 
	     cache : true,
	     contentType : "application/x-www-form-urlencoded",
	     dataType : "json",
	     success : registerListCB,
	     error:function(){
	    	 layer.msg('请求失败：');
	     }		       
	});
	
	/*
	 * 注册信息请求成功回调函数
	 */
	function registerListCB( jsonData ){
		console.log( '-----------注册信息请求成功回调函数------------' );
		if( jsonData ){
			if( jsonData.data.length != 0 ){
				console.log( jsonData.data );
				//初始化表格
				$('#messageTip').append(
					'<table class="layui-table" lay-skin="line" style="margin:0px;">  ' + 
						'<colgroup>  ' +
				    		'<col width="80">  ' +
				    		'<col width="80">  ' +
				    		'<col width="250">  ' +
				    		'<col width="100">  ' +
			  			'</colgroup>  ' +
			  			'<thead>  ' +
							'<tr>  ' +
						   		'<th>注册用户编号</th>  ' +
						      	'<th>注册用户名称</th>  ' +
						      	'<th>注册用户备注</th>  ' +
						      	'<th>操作</th>  ' +
						    '</tr>  ' + 
						'</thead>  ' +
						'<tbody>  ' +	
						'</tbody>  ' +
  					'</table>  ' 
				);
				
				//动态生成数据
				$.map( jsonData.data, function( item, index ){
					console.log( $('#messageTip tbody') );
					$('#messageTip tbody').append(
						'<tr>  ' +
					    	'<td flag="num">' + item.num + '</td>  ' +
					      	'<td flag="name">' + item.name + '</td>  ' +
					      	'<td flag="note">' + item.note + '</td>  ' +
					      	'<td style="padding:0px"><button class="layui-btn layui-btn-normal layui-btn-radius" id="handRegistInfo" onclick="handRegistCE(this)">已阅</button></td>  ' +
					    '</tr>  ' 
					);
				})				
			}	
		}	
	}		
})

/**
 * 注册处理按钮单击事件
 */
var currHandBut,$currTable;
function handRegistCE( obj ){
	currHandBut = null;
	console.log( '-----------注册处理按钮单击事件------------' );
	var $this = $(obj);	
	currHandBut = obj;
	
	//获取行数据
	var tdData = {};
	$.each( $this.parent('td').siblings('td'), function( index, item ){
		console.log( item );
		console.log( $(item).text() );
		tdData[$(item).attr('flag')] = $.trim( $(item).text() );
	})
	console.log( tdData );
	
	//请求处理
	ajax( 'put', modifyRegStateUrl, {num:tdData.num}, modifyRegStateCB );
	
}

/**
 * 修改注册信息回调函数
 */
function modifyRegStateCB( jsonData ){
	console.log( '-----------修改注册信息成功回调函数------------' );
	console.log( currHandBut );
	console.log( $(currHandBut) );
	$currTable = $(currHandBut).closest('table');
	console.log( $currTable );
	
	//前端删除数据
	if( currHandBut ){
		$(currHandBut).closest('tr').remove();
	}
	
	//没有注册信息时，清空
	console.log( '-----------没有注册信息时，清空------------' );
	console.log( currHandBut );
	console.log(  $currTable.find('tbody tr')[0] );
	console.log(  $currTable.find('tbody tr').length );
	if( $currTable.find('tbody tr').length == 0 ){
		$currTable.remove();
	}
}



/**
 * 表格初始化
 */
var editObj=null,ptable=null,treeGrid=null,tableId='treeTable',layer=null;
layui.config({
    base: '/jsPackage/web/design/extend/'
}).use(['jquery','treeGrid','layer'], function(){
    var $=layui.jquery;
    treeGrid = layui.treeGrid;//很重要
    layer=layui.layer;
    ptable=treeGrid.render({
        id:tableId
        ,elem: '#'+tableId
        ,url:ipPort +'/user/list'
        ,cellMinWidth: 100
        ,idField:'usernum'//必須字段
        ,treeId:'usernum'//树形id字段名称
        ,treeUpId:'parent_id'//树形父id字段名称
        ,treeShowName:'name'//以树形式显示的字段
        ,heightRemove:[".dHead",10]//不计算的高度,表格设定的是固定高度，此项不生效
        ,height:'80%'
        ,isFilter:false
        ,iconOpen:true//是否显示图标【默认显示】
        ,isOpenDefault:false//节点默认是展开还是折叠【默认展开】
        ,loading:true
        ,method:'post'
        ,isPage:false
        ,cols: [[
            {type:'numbers'}
            ,{type:'radio'}
            ,{type:'checkbox'}
            ,{field:'name', width:300, title: '人员组织名称',edit:'text'}
            ,{field:'usernum',width:180, title: 'id',edit:'text'}
            ,{field:'parent_id',width:150, title: 'pid'}
            ,{field:'remark1',width:100, title: '状态',templet: '#userState'}
            ,{width:300,title: '操作', align:'center'/*toolbar: '#barDemo'*/
                ,templet: function(d){
                    var html='';
                    var addBtn='<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="add">添加</a>';
                    var delBtn='<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>';
                    var saveBtn='<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="save">保存</a>';
                    var openBtn='<a class="layui-btn layui-btn-xs" lay-event="open">启禁用</a>';
                    return addBtn+delBtn+saveBtn+openBtn;
                }
            }
        ]]
        ,parseData:function (res) {//数据加载后回调
            return res;
        }
        ,onClickRow:function (index, o) {
//            console.log(index,o,"单击！");

        }
        ,onDblClickRow:function (index, o) {
//            console.log(index,o,"双击");
        }
        ,onCheck:function (obj,checked,isAll) {//复选事件
//            console.log(obj,checked,isAll);
        }
        ,onRadio:function (obj) {//单选事件
            console.log(obj);
        }
    });
	//操作按钮监听
    treeGrid.on('tool('+tableId+')',function (obj) {
        if(obj.event === 'del'){//删除行
            del(obj);
        }else if(obj.event==="add"){//添加行
            add(obj);
        }else if(obj.event==="save"){//保存
        	save(obj);
        }else if(obj.event==="open"){//启用
        	open(obj);
        }
    });
});

/**
 * 启用用户
 * @param {} obj
 */
function open( rowWholeData ){
	console.log( rowWholeData );	
	console.log( rowWholeData.tr[0] );	
	
	/*
	 * 前后端异步启禁用
	 */
	var trObj = rowWholeData.tr[0],
		$tdObj = $(trObj).find('td[data-field="remark1"]'),
		stateName = $tdObj.find('p').text(),
		usernum = $.trim( rowWholeData.data.usernum ),
		state = $.trim( rowWholeData.data.remark1 );
		if( !usernum ){
			layer.msg( '获取用户唯一标示失败,启用或禁用失败', {icon:4} );
			return;
		}
	if( $.trim(stateName) == '启用'){
		//后端禁用		
		//ajax( 'put', putUrl + "/" + usernum, {"state":state}, putCallBack );		
		//前端禁用
		$tdObj.find('p').text('禁用').css({'color':'#666666','font-weight':'bold'});
					
	}else if( $.trim(stateName) == '禁用'){
		//后端启用	
		//ajax( 'put', putUrl + "/" + usernum, {"state":state}, putCallBack );
		//前端启用
		$tdObj.find('p').text('启用').css({'color':'#F581B1','font-weight':'bold'});
	}else{
		console.log( '点错了' );
	}
}

/**
 * 修改状态成功回调函数
 * @param {} obj
 */
function putCallBack( jsonData ){
	console.log( '修改状态成功回调函数' );
	layer.msg( jsonData.data.message, {icon:3} );
	
}

/**
 * 删除用户
 * @param {} obj
 */
function del( obj ) {
	console.log( obj );
    layer.confirm( "你确定删除数据吗？如果存在下级节点则一并删除，此操作不能撤销！", {icon: 3, title:'提示'},
        function( index ){//确定回调
        	//删除前端
            obj.del();
            layer.close( index );
            console.log( obj.data );
            
            //检查是否存DB
            if( !obj.data.orgid ){
            	layer.msg( '删除用户成功', {icon:1} );
            	return;
            }
            
            //删除后端
            if( obj.data ){
            	var usernum = obj.data.usernum;
            	if( usernum ){
            		ajax( 'delete', deleteUrl + "/" + usernum, {}, deleteCallBack );
            	}else{
            		layer.msg( '删除失败，获取用户唯一标示失败', {icon:4} );
           	 	}
            }else{
            	layer.msg( '删除失败，获取用户信息失败', {icon:4} );
            }
        },function ( index ) {//取消回调
			layer.close( index );
        }
    );
}

/**
 * 删除用户成功回调函数
 * @type Number
 */
function deleteCallBack( jsonData ){
	console.log( '------------删除户成功回调函数-------------' );
	layer.msg( '删除用户成功', {icon:1} );
}

/**
 * 前端操作新增数据
 * @type Number
 */
var i=1000;
function add(pObj) {    
    var pdata=pObj?pObj.data:null;
    var param = {};
//    param.orgid = Math.random()+'';
    param.name = Math.random()*1000000000;
    param.usernum = '请输入用户唯一编号';
    param.parent_id = pdata?pdata.usernum:null;
    param.remark1 = 0;
    treeGrid.addRow(tableId,pdata?pdata[treeGrid.config.indexName]+1:0,param);
}

/**
 * 请求后端保存增加用户
 */
function save( rowWholeData ){
	console.log( '----请求后端保存增加用户-----------' );
//	console.log( this );
	var rowData = rowWholeData?rowWholeData:null,
	data = {};
	data.name = $.trim( rowData.data.name );
	//验证名字
	console.log( '后端保存增加名字:name-' + data.name);
	if( !data.name && !/[\u4e00-\u9fa5]+/g.test(data.name) ){
		layer.msg( '新增失败,数据不合法', {icon:2} );
		return;
	}
	data.parent_id = $.trim( rowData.data.parent_id );	
	data.usernum = $.trim( rowData.data.usernum );
	console.log( '后端保存增加用户:usernum-' + data.usernum);
	//验证标识
	if( ! data.parent_id ){
		layer.msg( '新增失败,用户唯一标示不正确', {icon:2} );
		return;
	}	
	//设置默认密码
	data.user_password = '123';
	ajaxByJson( 'post', saveUrl, JSON.stringify(data), function( jsonData ){
		console.log( '------------新增用户成功回调函数1-------------------' );
		console.log( jsonData );		
		ajaxByJson( 'post', saveUserInfoUrl+"/"+jsonData,{}, function( jsonData ){
			console.log( '------------新增用户成功回调函数2-------------------' );
			console.log( rowWholeData.data );		
			rowWholeData.data.orgid = jsonData;
			layer.msg( '新增用户成功', {icon:1} );
		});
	});	
}

function print() {
    console.log(treeGrid.cache[tableId]);
    var loadIndex=layer.msg("对象已打印，按F12，在控制台查看！", {
        time:3000
        ,offset: 'auto'//顶部
        ,shade: 0
    });
}

function openorclose() {
    var map=treeGrid.getDataMap(tableId);
    var o= map['102'];
    treeGrid.treeNodeOpen(tableId,o,!o[treeGrid.config.cols.isOpen]);
}


function openAll() {
    var treedata=treeGrid.getDataTreeList(tableId);
    treeGrid.treeOpenAll(tableId,!treedata[0][treeGrid.config.cols.isOpen]);
}

function getCheckData() {
    var checkStatus = treeGrid.checkStatus(tableId)
        ,data = checkStatus.data;
    layer.alert(JSON.stringify(data));
}
function radioStatus() {
    var data = treeGrid.radioStatus(tableId)
    layer.alert(JSON.stringify(data));
}
function getCheckLength() {
    var checkStatus = treeGrid.checkStatus(tableId)
        ,data = checkStatus.data;
    layer.msg('选中了：'+ data.length + ' 个');
}

function reload() {
    treeGrid.reload(tableId,{
        page:{
            curr:1
        }
    });
}
function query() {
    treeGrid.query(tableId,{
        where:{
            name:'sdfsdfsdf'
        }
    });
}

function test() {
    console.log(treeGrid.cache[tableId],treeGrid.getClass(tableId));


    /*var map=treeGrid.getDataMap(tableId);
    var o= map['102'];
    o.name="更新";
    treeGrid.updateRow(tableId,o);*/
}



