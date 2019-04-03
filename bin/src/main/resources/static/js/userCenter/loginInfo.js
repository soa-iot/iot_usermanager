/**
 * 全局变量
 */
var findLoginInfoUrl = ipPort + "/user/loginInfo",
	layer = layui.layer,
	dataAxis = [],
	data = [];
 
/**
 * 初始化加载
 */


/**
 * 事件绑定
 */
 
 
/**
 * 页面初始化
 */
/*
 * 图标初始化
 */
$(function(){
	//请求参数
	var state = 0;//0-登录，1-登出
	ajax( 'get', findLoginInfoUrl + "/" + state , {}, findLoginInfoCallBack, false );
	
	console.log( dataAxis );
	console.log( data );
	
	//初始化echarts实例
	var myChart = echarts.init(document.getElementById('loginNum'));
	
	// 指定图表的配置项和数据
	var yMax ;
	var dataShadow = [];
	
	for (var i = 0; i < data.length; i++) {
	    dataShadow.push(yMax);
	}
	
	option = {
	    title: {
	        text: '人员登录次数展示',
	        subtext: '所有时间段',
	        left: 'center'
	    },
	    xAxis: {
	        data: dataAxis,
	        axisLabel: {
	            inside: true,
	            textStyle: {
	                color: '#fff'
	            }
	        },
	        axisTick: {
	            show: false
	        },
	        axisLine: {
	            show: false
	        },
	        z: 10
	    },
	    yAxis: {
	        axisLine: {
	            show: false
	        },
	        axisTick: {
	            show: false
	        },
	        axisLabel: {
	            textStyle: {
	                color: '#999'
	            }
	        }
	    },
	    dataZoom: [
	        {
	            type: 'inside'
	        }
	    ],
	    series: [
	        { // For shadow
	            type: 'bar',
	            itemStyle: {
	                normal: {color: 'rgba(0,0,0,0.05)'}
	            },
	            barGap:'-100%',
	            barCategoryGap:'40%',
	            data: dataShadow,
	            animation: false
	        },
	        {
	            type: 'bar',
	            itemStyle: {
	                normal: {
	                    color: new echarts.graphic.LinearGradient(
	                        0, 0, 0, 1,
	                        [
	                            {offset: 0, color: '#83bff6'},
	                            {offset: 0.5, color: '#188df0'},
	                            {offset: 1, color: '#188df0'}
	                        ]
	                    )
	                },
	                emphasis: {
	                    color: new echarts.graphic.LinearGradient(
	                        0, 0, 0, 1,
	                        [
	                            {offset: 0, color: '#2378f7'},
	                            {offset: 0.7, color: '#2378f7'},
	                            {offset: 1, color: '#83bff6'}
	                        ]
	                    )
	                }
	            },
	            data: data
	        }
	    ]
	};
	
	//图表点击事件
	var zoomSize = 6;
	myChart.on('click', function (params) {
	    console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
	    myChart.dispatchAction({
	        type: 'dataZoom',
	        startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
	        endValue: dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
	    });
	});
	
	//渲染图表
	myChart.setOption(option);	 
})

/**
 * 获取登录信息成功回调函数
 */
function findLoginInfoCallBack( data2 ){
	console.log( '---------获取登录信息成功回调函数----------' );
	console.log( data2 );
	var jsonData= JSON.parse(data2);
	console.log( jsonData );
	dataAxis = jsonData.name,
	data = jsonData.num;
}
