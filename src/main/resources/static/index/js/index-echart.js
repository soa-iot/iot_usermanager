
//基于准备好的dom，初始化echarts实例
var equRateChart = echarts.init(document.getElementById('equipment-rate'));

option1 = {
	    tooltip: {
	        trigger: 'item',
	        formatter: '{a} <br/>{b}: {c} ({d}%)'
	    },
	  /*  legend: {
	        orient: 'vertical',
	        left: 5,
	        data: ['设备完好', '设备故障']
	    },*/
	    series: [
	        {
	            name: '设备完好率',
	            type: 'pie',
	            radius: ['50%', '80%'],
	            avoidLabelOverlap: false,	
	            label: {
	                normal: {
	                	formatter: '{d}%',
	                    position: 'inside'
	                },
	                emphasis: {
	                    show: true,
	                    textStyle: {
	                        fontSize: '20',
	                        fontWeight: 'bold'
	                    }
	                }
	            },
	            labelLine: {
	                normal: {
	                    show: false
	                }
	            },
	            data: [
	                {value: 10, name: '设备故障'},
	                {value: 90, name: '设备完好'}
	            ]
	        }
	    ]
	};

//使用刚指定的配置项和数据显示图表。
equRateChart.setOption(option1);


//基于准备好的dom，初始化echarts实例
var equCountChart = echarts.init(document.getElementById('equipment-count'));

option2 = {
	    title: {
	        /*text: '设备数量统计',
	        subtext: '按状态',*/
	        left: 'center'
	    },
	    tooltip: {
	        trigger: 'item',
	        formatter: '{a} <br/>{b} : {c} ({d}%)'
	    },
	    series: [
	        {
	            name: '设备数量统计',
	            type: 'pie',
	            radius: '76%',
	            center: ['50%', '50%'],
	            label: {
                    formatter: '{b}: {c}'
                },
	            data: [
	                {value: 335, name: '报废'},
	                {value: 310, name: '闲置'},
	                {value: 234, name: '停用'},
	                {value: 135, name: '备用'},
	                {value: 1548, name: '在用'}
	            ],
	            emphasis: {
	                itemStyle: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};

//使用刚指定的配置项和数据显示图表。
equCountChart.setOption(option2);


//基于准备好的dom，初始化echarts图表
var enegerChart = echarts.init(document.getElementById('eneger-analysis'));
// 为echarts对象加载数据
var option = {
	/*title : {
		text : '能耗趋势'
	},*/
	tooltip : {
		trigger : 'axis'
	},
	legend : {
		data : ['处理气量', '实际用水单耗']
	},
	 dataset: {
         source: [
             ['product', '01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'],
             ['处理气量', 41.1, 30.4, 65.1, 53.3, 83.8, 98.7],
             ['实际用水单耗', 86.5, 92.1, 85.7, 83.1, 73.4, 55.1]
         ]
     },
	grid : {
		left : '3%',
		right : '4%',
		bottom : '3%',
		containLabel : true
	},
	toolbox : {
		feature : {
			saveAsImage : {}
		}
	},
	xAxis : {
		type : 'category',
		boundaryGap : false
	},
	yAxis : {
		type : 'value'
	},
	series : [
        {type: 'line', smooth: true, seriesLayoutBy: 'row'},
        {type: 'line', smooth: true, seriesLayoutBy: 'row'},
        {
            type: 'pie',
            id: 'pie',
            radius: '30%',
            center: ['50%', '25%'],
            label: {
                formatter: '{b}: {@2012} ({d}%)'
            },
            encode: {
                itemName: 'product',
                value: '2012',
                tooltip: '2012'
            }
        }
    ]
};

enegerChart.clear();
enegerChart.setOption(option);


/**
 *  echart柱状图
 */
 // 基于准备好的dom，初始化echarts实例
var problemChart = echarts.init(document.getElementById('problem-finish'));
$.ajax({
	type: 'get',
	url: '/iot_process/report/finish/record',
	data: {},
	dataType: "json",
	success: function(json){
		if(json.state == 0){
			initEchart(json.data);
		}
	},
	error: function(){
		
	}
})

function initEchart(data){
	console.log("-----initEchart-----");
	var yName = [], finished = [], unfinished = [];
	for(var i=0;i<data.length;i++){
		yName[i] = data[i].DEPARTNAME;
		finished[i] = data[i].FINISHED;
		unfinished[i] = data[i].UNFINISHED;
	}
	console.log(yName);
	// 指定图表的配置项和数据
    var option = {
    		tooltip: {
    	        trigger: 'axis',
    	        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
    	            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
    	        }
    	    },
    	    legend: {
    	        data: ['已完成', '整改中']
    	    },
    	    grid: {
    	        left: '0.2%',
    	        right: '2%',
    	        bottom: '3%',
    	        containLabel: true
    	    },
    	    xAxis: {
    	        type: 'value'
    	    },
    	    yAxis: {
    	        type: 'category',
    	        data: yName
    	    },
    	    series: [
    	        {
    	            name: '已完成',
    	            type: 'bar',
    	            stack: '总量',
    	            label: {
    	                show: true,
    	                position: 'inside'
    	            },
    	            data: finished
    	        },
    	        {
    	            name: '整改中',
    	            type: 'bar',
    	            stack: '总量',
    	            label: {
    	                show: true,
    	                position: 'inside'
    	            },
    	            data: unfinished
    	        }
    	    ]
    };

    // 使用刚指定的配置项和数据显示图表。
    problemChart.setOption(option);
}