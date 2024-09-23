$(document).ready(function() {
	const resizable = $(".resizable");
	const resizer = $(".resizer");


	resizer.on('mousedown', function(e) {
		e.preventDefault();
		$(window).on('mousemove', resize);
		$(window).on('mouseup', stopResize);
	});

	function resize(e) {
		const newWidth = e.clientX - resizable.offset().left;
		const newHeight = e.clientY - resizable.offset().top;
		let max = Math.max(newWidth,newHeight);
		if (newWidth > 50 || newHeight > 50) { // 최소 크기 제한
			resizable.css({
				width: `${max}px`,
				height: `${max}px`
			});
		}
	}

	function stopResize() {
		$(window).off('mousemove', resize);
		$(window).off('mouseup', stopResize);
	}
})