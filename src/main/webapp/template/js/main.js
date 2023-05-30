// XỬ LÍ DROPDOWN NAVBAR
let menu = $(".canvas__open i");
let navbar = $(".header .navbar");

menu.click(function() {
	menu.toggleClass("fa-times");
	navbar.toggleClass("active");
});

$(document).ready(function() {
	//Check to see if the window is top if not then display button
	$(window).scroll(function() {
		menu.removeClass("fa-times");
		navbar.removeClass("active");
		// Show button after 100px
		var showAfter = 100;
		if ($(this).scrollTop() > showAfter) {
			$(".scrool-top").addClass("active");
			console.log("active");
		} else {
			$(".scrool-top").removeClass("active");
		}
	});
});
// xử lí cart
$(".js-show-cart").click(function() {
	$(".wrap-header-cart").addClass("show-header-cart");
});

$(".iconCart").click(function() {
	$(".wrap-header-cart").removeClass("show-header-cart");
});

// xử lí wishlist
$(".js-show-wishlist").click(function() {
	$(".wrap-header-wishlist").addClass("show-header-wishlist");
});

$(".iconWishlist").click(function() {
	$(".wrap-header-wishlist").removeClass("show-header-wishlist");
});



// xử lí ảnh home
let slides = $(".slide-container");
let index = 0;
function next() {
	slides.eq(index).removeClass("active");
	index = (index + 1) % slides.length;
	slides.eq(index).addClass("active");
}
function prev() {
	slides.eq(index).removeClass("active");
	index = (index - 1 + slides.length) % slides.length;
	slides.eq(index).addClass("active");
}

// xử lí tabs
$(function() {
	/* cho box đầu tiên hiển thị */
	$(".tab-pane:eq(0)").show();
	$(".tab-item").click(function() {
		/* loại bỏ class active của tất cả li */
		$(".tab-item").removeClass("active");
		/* add class active của li được click */
		$(this).addClass("active");
		/* Xác định phần tử thứ n được click */
		var n = $(".tab-item").index(this);
		/* Ẩn tất cả .box */
		$(".tab-pane").hide();
		/* Hiển thị .box theo phần tử thứ n */
		$(".tab-pane:eq(" + n + ")").fadeIn(300);
	});
});
