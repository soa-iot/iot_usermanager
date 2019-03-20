/**
 * 全局变量
 * @type 
 */
var element = layui.element,
	layer = layui.layer,
	laydate = layui.laydate,
	tempNoticeUrl = ipPort + "/ststem/notice/temp",
	timeNumber;

/**
 * 初始化加载
 * @type 
 */
$(function(){
	console.log( '---------------计算选择的时间----------------');
	laydate.render({
    	elem: '#tempNoticeTime',
    	type: 'time',
    	value: new Date().getHours() + ":" + new Date().getMinutes() + ":" + "59",
    	change: function(value, date, endDate){
//    		console.log(value); //得到日期生成的值，如：2017-08-18
//    		console.log(date); //得到日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
//    		console.log(endDate); //得结束的日期时间对象，开启范围选择（range: true）才会返回。对象成员同上。
    		var hourNumber,minuteNumber,
    			currHour=new Date().getHours(),choosedateHour=date.hours,
    			chooseMinute=date.minutes;
//    		console.log(currHour);
    		//跨越的小时
    		if( choosedateHour > currHour ){
    			hourNumber = (choosedateHour - currHour) * 3600;
    		}else{
    			hourNumber = (24 - currHour + choosedateHour ) * 3600 ;
    		}
    		//跨越的分钟
    		minuteNumber = chooseMinute * 60;
    		timeNumber = minuteNumber + hourNumber;
    		console.log( timeNumber);
  		}
  	});
	element.init();
})

/**
 * 事件绑定
 * @type 
 */
$(function(){
	//临时通知按钮单击事件
	$('#tempNoticeSend').on('click', tempNoticeCF );
	
	//系统通知按钮单击事件
})

/**
 * 页面初始化
 * @type 
 */
$(function(){

})

/**
 * 临时通知按钮单击事件函数
 * @type 
 */
function tempNoticeCF(){
	console.log( '---------------临时通知按钮单击事件函数----------------');
	//参数获取、验证
	var content = $.trim( $('#tempNotice').val() );
	console.log( content );
	if( !content ){
		layer.msg( '请输入临时通知内容', {icon:4});
		return;
	}
	console.log( timeNumber );
	if( !timeNumber ){
		layer.msg( '临时通知时间选择不对', {icon:4});
		return;
	}
		
	//请求
	var tempNoticeData = {
		"notice" : content,
		"number" : timeNumber
	};
	ajax( 'post', tempNoticeUrl, tempNoticeData, tempNoticeCB );
}

/**
 * 临时通知ajax回调函数
 * @type 
 */
function tempNoticeCB(){
	console.log( '---------------临时通知ajax回调函数----------------');
	layer.msg( '临时通知ajax回调函数', {icon:1} );
}