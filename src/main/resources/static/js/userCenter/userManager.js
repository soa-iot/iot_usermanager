$(function(){
	
	/**
	 * 参数定义
	 */
	var table = layui.table,
		layer = layui.layer,
		getUsersUrl = ipPort + "/user",
		getUsersByNumUrl = ipPort + "/user/users",
		addUserUrl = ipPort + "/user/users",
		initOrganDataUrl = ipPort + "/user/organ",
		modifyUserParentUrl = ipPort + "/user/organ",
		modifyUserUrl = ipPort + "/user/user",
		deleteUserUrl = ipPort + "/user";
		

	/**
	 * 页面初始化
	 */
	//表格初始化
	ajax( 'get', getUsersUrl + "/users", {}, getUsersSF, false );
	
	/*
	 * 表格初始化请求成功回调函数
	 */
	function getUsersSF( data ){
		console.log( '---------表格初始化请求成功回调函数----------' );
//		console.log( data );
		generateBTable( 'user_table', data );
		hideElement();
	}

	/**
	 * 事件绑定
	 */
	var active = { 
		search: function(){
			console.log( '---------搜索事件执行---------' );
			var usernumValue = $('#search_value').val();
			console.log( usernumValue );
			if( !usernumValue ){
				return ;
			}else if( usernumValue == '-1'){
				ajax( 'get', getUsersUrl + "/users", {}, getUsersSF, false );
				return ;
			} 
			//查询
			ajax( 'get', getUsersByNumUrl+"/"+usernumValue, {}, getUsersByNumSF, false );
			$('#userOrgan').hide();
			
		},
		list: function(){
			console.log( '---------展示全部用户---------' );
			ajax( 'get', getUsersUrl + "/users", {}, getUsersSF, false );
			$('#userOrgan').hide();
		},
		add: function(){
			console.log( '---------增加用户事件执行---------' );
			layer.open({
		        type: 1,
		        title: '增加用户'
		        ,area: ['40%', '40%']	        	
		        ,id: 'layerDemo'+ 1 //防止重复弹出
		        ,content: $('#form_add_user')
		        ,btn: ['提交', '取消']
		        ,btnAlign: 'c' //按钮居中
		        ,shade: 0 //不显示遮罩
		        ,yes: function( index, layero ){
		        	//验证
		        	if( !$( '#form_add_user' ).valid() ){
		        		return ;
		        	}
		        	
		        	//获取数据，请求增加用户
		        	var addInfo = $( '#form_add_user' ).serialize();
		        	console.log( addInfo );
		        	ajax( 'post', addUserUrl, addInfo, addUserSF );
		        	hideElement();
		        	return false;
		        },
		        btn2:function( index, layero ){
		        	hideElement();
		        	layer.close( index );
		        },
		        end: function(){
		        	hideElement();
		        },
		        success: function( layero, index ){
		        	/*
		        	 * 初始化加载弹出页面
		        	 */
		        	console.log( '---------增加用户页面初始化---------' );
		        	//参数验证初始化
		        	$( '#form_add_user' ).validate({
		        		rules : {
		        			usernum : {
		        				required : true
		        			},
		        			name : {
		        				required : true
		        			}
		        		},
		        		messages : {
		        			usernum : {
		        				required : "用户编号不能为空"
		        			},
		        			name : {
		        				required : "用户名不能为空"
		        			}
		        		},
		        		onfocusout :  function( element ){
		        			$(element).valid();
		        		},
		        		onsubmit : false,
		        		focusInvalid : true,			
		        		highlight : function( element ) {
		        			$(element).siblings('label').addClass('has-error');
		        	    },
		        	    errorPlacement : function(error, element) { 
		                    element.siblings('div').append( error );
		                }/*,
		                submitHandler : function( form ) {
		                	console.log( '---准备提交---' );   	
		                	//form.submit();      	
		                }
		        	    success : function(label) {
		        	    	label.closest('.form-group').removeClass('has-error');
		                    label.remove();
		                },     
		                submitHandler : function( form ) {
		                	//form.submit();      	
		                } */
		        	})
		        }
		    });
		}
	}
	
	$('.demoTable .layui-btn').on('click', function(){
		var type = $(this).attr('id');
		active[type] ? active[type].call(this) : '';
	});
	
	//监听工具条
	table.on('tool(user_table)', function(obj){
	    var data = obj.data;
	    if(obj.event === 'detail'){
	    	detail( data );
	    } else if(obj.event === 'del'){
	    	del( obj );	    	
	    } else if(obj.event === 'save'){
	    	save( obj );	   
	    }
	})
	
	/*
	 * 保存按钮单击事件
	 */
	function save( obj ){
		console.log( '--------保存按钮单击事件--------' );		
		//保存
		
		var data = obj.data,
			dataJson ={
				"orgid": data.orgid,
				"usernum": data.usernum,
				"name": data.name || ""
			};
		console.log( dataJson );
		ajax( 'put', modifyUserUrl, dataJson, modifyUserSF );
	}
	
	/*
	 * 保存按钮单击事件
	 */
	function modifyUserSF( data ){
		console.log( '--------保存按钮单击事件|--------' );
		//刷新页面
		ajax( 'get', getUsersUrl + "/users", {}, getUsersSF, false );
		layer.msg('保存用户成功', {icon:1});
	}
	
	/*
	 * 删除按钮单击事件
	 */
	function del( obj ){
		console.log( '--------删除按钮单击事件--------' );
		console.log( obj );
		var data = obj.data;
		console.log( data );
		layer.confirm( '真的删除行么', function(index){			   		
    		//后端删除
    		var url = deleteUserUrl + "/" + data.usernum,
    			deleteData = {
    				"orgid" : data.orgid,
    				"usernum" : data.usernum,
    				"name" : data.name
    			};
    		console.log( url );
    		ajax( 'delete', url, deleteData, function( data ){
    			console.log( '--------请求删除用户成功回调函数--------' );
    			//刷新页面
    			//查询
    			ajax( 'get', getUsersUrl + "/users", {}, getUsersSF, false );	
    			layer.msg('删除成功', {icon:1});
    		} );
    		layer.close(index);
    	});		
	}

	/*
	 * 生成前台表格
	 */
	function generateBTable( id, data ){
		table.render({
			elem : '#' + id,
//			height : '400ox',
			title: '用户数据表',
			data : data,
//			toolbar: true,
			page : true,
			even : true,			
			autoSort : false,
			count : data.length,
			curr : 0,
			limit : 10,
			limits : [ 10, 13, 20, 25, 30 ],
			layout : [ 'prev', 'page', 'next', 'skip',
					'count', 'limit' ],
			cols : [ [
				{type: 'numbers',title:'序号', align:'center', minWidth:120}
		    	,{field:'orgid', title:'id', minWidth:120, fixed: 'left', hide: true, align:'center'}
		    	,{field:'usernum', title:'用户编号', minWidth:300, edit: 'text', align:'center'}
		    	,{field:'name', title:'姓名', minWidth:250, edit: 'text', align:'center'}
		    	,{field:'state', title:'状态', minWidth:80, sort: true,  hide: true, align:'center'}
		    	,{fixed: 'right', title:'操作', toolbar: '#barDemo',minWidth:300, align:'center'}
			] ],
			id: 'testReload',
			done : function(res, curr, count) {
			}
		});
	}
	
	/*
	 * 搜索请求成功回调函数
	 */
	function getUsersByNumSF( data ){
		console.log( '--------搜索请求成功回调函数--------' );
//		console.log( data );
		var arr = [];
		arr.push(data);
		//执行重载
		$( '#tableDiv' ).empty().append(' <table class="layui-hide" id="user_table" lay-filter="user_table"></table>');
		generateBTable( 'user_table', arr );
	}
	
	/*
	 * 增加用户请求成功回调函数
	 */
	function addUserSF( data ){
		console.log( '--------增加用户请求成功回调函数--------' );	
		//关闭弹出页面
		layer.close(layer.index);
		
		//重载表格
		layer.msg( '增加用户成功', {icon:1});
		//查询
		ajax( 'get', getUsersUrl + "/users", {}, getUsersSF, false );				
	}
	
	/*
	 * 用户组织关系单击事件
	 */
	function detail( data ){
		console.log( '--------用户组织关系单击事件--------' );	  
		console.log( data.usernum );
		var usernum = data.usernum,
			parentId = data.parent_id,
			currentOrganId = parentId ;
		
    	layer.open({
	        type: 1,
	        title: '用户与组织关系管理'
	        ,area: ['60%', '80%']	  
	        ,id: 'layerDemo'+ 1 //防止重复弹出
	        ,content: $( '#userOrgan' )
	        ,btn: ['确定', '取消']
	        ,btnAlign: 'c' //按钮居中
	        ,shade: 0 //不显示遮罩
	        ,yes: function( index, layero){
	        	//获取选中值，对比
	        	console.log( parentId );
	        	if( parentId && parentId == currentOrganId ){
	        		layer.close( index );
	        		hideElement();
	        		return;
	        	}
	        	
	        	//请求改变用户的组织关系
	        	console.log( currentOrganId );
	        	ajax( 'post', modifyUserParentUrl, 
	        			{ 'usernum':usernum, 'parentid':currentOrganId}, 
	        			function changeParentSF( data ){
	        				console.log( '-------------修改用户父id成功回调函数--------' );
	        				layer.msg( '修改组织关系成功', {icon:6});
	        				layer.close( index );         				
	        			}
	        		);
	        	hideElement();
	        	//return false;
	        },
	        btn2: function(index, layero){
	            layer.close(index);
	            hideElement();
	        },
	        end: function(){
	        	hideElement();
	        },
	        success: function( layero, index ){
	        	console.log( '---------打开用户组织管理页面---------' );
	        	var editObj=null,ptable=null,treeGrid=null,tableId='treeTable';
	        	layui.config({
	        	    base: '/jsPackage/web/design/extend/'
	        	}).extend({
	        	}).use(['jquery','treeGrid','layer'], function(){
	        	    var $=layui.jquery;
	        	    treeGrid = layui.treeGrid;//很重要
	        	    ptable=treeGrid.render({
	        	        id:tableId
	        	        ,elem: '#'+tableId
	        	        ,url: initOrganDataUrl+"/"+usernum
	        	        ,cellMinWidth: 100
	        	        ,idField:'usernum'//必須字段
	        	        ,treeId:'usernum'//树形id字段名称
	        	        ,treeUpId:'parent_id'//树形父id字段名称
	        	        ,treeShowName:'name'//以树形式显示的字段
	        	        ,heightRemove:[".dHead",10]//不计算的高度,表格设定的是固定高度，此项不生效
	        	        ,height:'80%'
	        	        ,isFilter:false
	        	        ,iconOpen:true//是否显示图标【默认显示】
	        	        ,isOpenDefault:true//节点默认是展开还是折叠【默认展开】
	        	        ,loading:true
	        	        ,method:'get'
	        	        ,isPage:false
	        	        ,cols: [[
	        	            {type:'numbers'}
	        	            ,{type:'radio'}
	        	            ,{field:'name', width:'80%', title: '人员组织名称',edit:'text'}
	        	            ,{field:'usernum',width:0, title: 'id',edit:'text',hide:true}
	        	            ,{field:'parent_id',width:0, title: 'pid',hide:true}
	        	        ]]
	        	        ,parseData:function (res) {//数据加载后回调
	        	            return res;
	        	        }
	        	        ,onClickRow:function (index, o) {
//	        	            console.log(index,o,"单击！");

	        	        }
	        	        ,onDblClickRow:function (index, o) {
//	        	            console.log(index,o,"双击");
	        	        }
	        	        ,onCheck:function (obj,checked,isAll) {//复选事件
//	        	            console.log(obj,checked,isAll);
	        	        }
	        	        ,onRadio:function (obj) {//单选事件
	        	            console.log(obj);
	        	            currentOrganId = obj.usernum;
	        	        }
	        	    });
	        	});        	
	        }
    	}) 
	}
	
	/*
	 * 用户组织关系单击事件
	 */
	function hideElement(){
		$( '#userOrgan' ).hide();
		$( '#form_add_user' ).hide();
	}
	
	
	function print() {
	    console.log(treeGrid.cache[tableId]);
	    var loadIndex=layer.msg("对象已打印，按F12，在控制台查看！", {
	        time:3000
	        ,offset: 'auto'//顶部
	        ,shade: 0
	    });
	}	
	var openorclose = function openorclose() {
	    var map=treeGrid.getDataMap(tableId);
	    var o= map['102'];
	    treeGrid.treeNodeOpen(tableId,o,!o[treeGrid.config.cols.isOpen]);
	}	
	var openAll = function openAll() {
	    var treedata=treeGrid.getDataTreeList(tableId);
	    treeGrid.treeOpenAll(tableId,!treedata[0][treeGrid.config.cols.isOpen]);
	}

	var getCheckData = function getCheckData() {
	    var checkStatus = treeGrid.checkStatus(tableId)
	        ,data = checkStatus.data;
	    layer.alert(JSON.stringify(data));
	}
	var radioStatus = function radioStatus() {
	    var data = treeGrid.radioStatus(tableId)
	    layer.alert(JSON.stringify(data));
	}
	var getCheckLength = function getCheckLength() {
	    var checkStatus = treeGrid.checkStatus(tableId)
	        ,data = checkStatus.data;
	    layer.msg('选中了：'+ data.length + ' 个');
	}
	var reload = function reload() {
	    treeGrid.reload(tableId,{
	        page:{
	            curr:1
	        }
	    });
	}
	var query = function query() {
	    treeGrid.query(tableId,{
	        where:{
	            name:'sdfsdfsdf'
	        }
	    });
	}
})