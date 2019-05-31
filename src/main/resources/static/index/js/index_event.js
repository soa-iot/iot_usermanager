$('body').on('click', '.link_block', function(data) {
	
	
		var hideBtn = $('#hideBtn', parent.document);
		var mainLayout = $('#main-layout', parent.document);
		var mainMask = $('.main-mask', parent.document);

		var id = $(this).attr('data-id');
		var url = $(this).attr('data-url');
		var text = $(this).attr('data-text');
		var isActive = $('.main-layout-tab .layui-tab-title',parent.document).find("li[lay-id="
				+ id + "]");
		if (isActive.length > 0) {
			// 切换到选项卡
			parent.element.tabChange('tab', id);
		} else {
			parent.element.tabAdd('tab', {
				title : text,
				content : '<iframe src="'
						+ url
						+ '" name="iframe'
						+ id
						+ '" class="iframe" framborder="0" data-id="'
						+ id
						+ '" scrolling="auto" width="100%"  height="100%"></iframe>',
				id : id
			});
			parent.element.tabChange('tab', id);
		}
		mainLayout.removeClass('hide-side');

});