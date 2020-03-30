layui.config({
			base : '/iot_usermanager/jsPackage/web/design/module/'
		}).extend({
			treetable : 'treetable-lay/treetable'
		}).use(
				[ 'table', 'form', 'layer','layedit', 'laydate' ],
				function() {
					var $ = layui.jquery;
					var table = layui.table, form = layui.form, layedit = layui.layedit, laydate = layui.laydate, layer = layui.layer;
					// 日期
					laydate.render({
						elem : '#date'
					});
					// 加载数据
					indexTable();
					indexViewAsc();
					indexViewDesc();
					var username=null;
					var dateTime=null;
					
					
					 function indexTable() {
							console.log(username)
							console.log(dateTime)
							$.post('/iot_usermanager/userLog/getLogCount', {
								username : username,
								dateTime : dateTime
							}, function(results) {
								console.log(results);
								if (results.code == 0) {
									 setTable(results.data);
								}
							});
						}
					 
					 
					function indexViewAsc() {
						console.log(username)
						console.log(dateTime)
						$.post('/iot_usermanager/userLog/getLogCountAsc', {
							username : username,
							dateTime : dateTime
						}, function(results) {
							console.log(results);
							if (results.code == 0) {
								var ax=[];
								var ser=[];
								var redata=results.data;
								 $.each(redata,function(i,val){
									 ax.push(val.usernum);
									 ser.push(val.num);
								 });
								 view('viewAsc',ax,ser,'登录次最少的30名');
							}
						});
					}

					function indexViewDesc() {
						$.post('/iot_usermanager/userLog/getLogCount', {
							username : username,
							dateTime : dateTime
						}, function(results) {
							console.log(results);
							if (results.code == 0) {
								var ax=[];
								var ser=[];
								var redata=results.data;
								 $.each(redata,function(i,val){
									 ax.push(val.username);
									 ser.push(val.num);
								 });
								view('container',ax,ser,'登录次数多的10名');
							}
						});
					}
					
					
					function setTable(data) {
						table.render({
							elem : '#testdata',
							data : data,
							height: 300,
							cellMinWidth : 80,
							page : true,
							limits : [ 20, 30, 40, 50, 60 ], //显示
							limit : 20,
							cols : [ [ {
								type: 'numbers',
								fixed: 'left', 
								title: '序号'
							},{
								field : 'id',
								title : 'id',
								hide : true
							}, {
								field : 'username',
								minWidth : 200,
								title : '用户名'
							}, {
								field : 'num',
								title : '登录次数'
							}
							,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
							] ]
						});
					}

					//监听行工具事件
					  table.on('tool(testdata)', function(obj){
					    var data = obj.data;
					    console.log(obj)
					    if(obj.event === 'edit'){
					    	layOpenHtml(data.username);
						    }
					  });
					
					
					function view(dress,ax,ser,title) {
						var dom = document.getElementById(dress);
						var myChart = echarts.init(dom);
						var app = {};
						option = null;
						option = {
								title: {
							        text: title
							    },
						    color: ['#3398DB'],
						    tooltip: {
						        trigger: 'axis',
						        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
						            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
						        }
						    },
						    grid: {
						        left: '3%',
						        right: '4%',
						        bottom: '3%',
						        containLabel: true
						    },
						    xAxis: [
						        {
						            type: 'category',
						            data: ax,
						            axisTick: {
						                alignWithLabel: true
						            }
						        }
						    ],
						    yAxis: [
						        {
						            type: 'value'
						        }
						    ],
						    series: [
						        {
						            name: '登录次数',
						            type: 'bar',
						            barWidth: '60%',
						            label: {
						                show: true,
						                position: 'inside'
						            },
						            data:ser
						        }
						    ]
						};
						;
						if (option && typeof option === "object") {
						    myChart.setOption(option, true);
						}
					}
					
					// 监听提交
					form.on('submit(demo1)', function(data) {
						var datas = data.field;
						username = datas.username;
						dateTime = datas.date;
						indexTable();
						return false;
					});

					
					
					function layOpenHtml(name) {
						layer.open({
							  type: 2,
							  skin: 'layui-layer-rim', //加上边框
							  area: ['60%', '50%'], //宽高
							  content: 'logList.html?username='+name+'&datime='+dateTime
							});
					}
					
				});