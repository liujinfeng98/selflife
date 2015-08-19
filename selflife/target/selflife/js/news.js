	(function ($) {

	$(function ($) {
	var news_timer = setInterval(function () {
				$(".js-next-news").trigger("click");
			}, 3000);
			
		$(document).on("click", ".js-prev-news", function (e) {
			var i = $(".js-news-box > ul").data("i");
			if (!i)
				i = 0;
			if (i <= 0)
				i = $(".js-news-box > ul li").length;
			i--;
//alert($(".js-news-box > ul > li").first().height());
			$(".js-news-box > ul").animate({
				"margin-top" : -i * $(".js-news-box > ul > li").first().height()
			}, 500);
			$(".js-news-box > ul").data("i", i);
			return false;
		})
		.on("click", ".js-next-news", function (e) {
			var i = $(".js-news-box > ul").data("i");
			if (!i)
				i = 0;
			i++;
			if (i >= $(".js-news-box > ul li").length)
				i = 0;
			$(".js-news-box > ul").animate({
				"margin-top" : -i * $(".js-news-box > ul > li").first().height()
			}, 500);
			$(".js-news-box > ul").data("i", i);
			return false;
		})
		

	});

})(jQuery);