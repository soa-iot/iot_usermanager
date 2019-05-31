
// 总控
$(document).ready(function()
{
	// 处理表格 title 标题
	$('.content table th,.content table td,.content p').each(function()
	{
		$(this).attr('title', $(this).text());
	});

	// 处理表报点击切换
	$('.task-operation').click(function()
	{
		var iframe = $(this).parent('.more').parent('.head').next('.content').find('iframe');
		var obj = $(this).find('span');
		var text = obj.text();
		if (text == '月')
		{
			// 月
			obj.css('background-color', '#e3e5ea');
			iframe.attr('src', $(this).attr('data-week'));
			obj.html("周");
		} else
		{
			// 周
			obj.css('background-color', '#fff');
			iframe.attr('src', $(this).attr('data-month'));
			obj.html("月");
		}
	});

	// 主页点击顶部统计模块
	$('.cz-icon').click(function()
	{
		// 当前url
		var url = $(this).attr('data-url');
		if (!$.isEmptyObject(url))
		{
			window.location.href = url;
		}
	});

	// 处理任务点击事件
	$('.content a').click(function()
	{
		// 当前url
		var url = $(this).attr('data-click-href');
		if (!$.isEmptyObject(url))
		{
			$.get(url, function(result)
			{
				// alert(result);
			});
		}
	});
	
	
	
});






