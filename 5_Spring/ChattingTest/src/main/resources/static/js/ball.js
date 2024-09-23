$(function() {
	const $canvas = $('#can');
	const canvas = $canvas.get(0);
	const ctx = canvas.getContext('2d');

	let isDrawing = false;
	let lastX = 0;
	let lastY = 0;


	let trails = [];


	function resizeCanvas() {
		canvas.width = $(window).width();
		canvas.height = $(window).height();
	}
	$(window).on('resize', resizeCanvas);
	resizeCanvas();


	function startDrawing(e) {
		isDrawing = true;
		[lastX, lastY] = [e.clientX, e.clientY];
	}


	function stopDrawing() {
		isDrawing = false;
	}
	let col = 0;
	let bol = true;
	let r = 0; // 빨강색
	let g = 0; // 초록색
	let b = 0; // 파랑색
	function draw(e) {
		if (bol) {
			col+=3;
		} else {
			col-=3;
		}
		if (col >= 255) bol = false;
		if (col <= 1) bol = true;
		 r = 255; // 빨강색
		 g = col; // 초록색
		 b = 255 - col; // 파랑색
		if (!isDrawing) return;

		const now = Date.now();


		trails.push({
			x1: lastX,
			y1: lastY,
			x2: e.clientX,
			y2: e.clientY,
			time: now,
			alpha: 1
		});


		ctx.beginPath();
		ctx.moveTo(lastX, lastY);
		ctx.lineTo(e.clientX, e.clientY);
		ctx.strokeStyle = `rgba(0, 0, 0, 1)`;
		ctx.lineWidth = 2;
		ctx.stroke();

		[lastX, lastY] = [e.clientX, e.clientY];
	}


	function clearTrails() {
		const now = Date.now();


		trails.forEach(trail => {
			const age = now - trail.time;

			trail.alpha = Math.max(1 - age / 500, 0);
		});


		ctx.clearRect(0, 0, canvas.width, canvas.height);


		trails.forEach(trail => {
			ctx.beginPath();
			ctx.moveTo(trail.x1, trail.y1);
			ctx.lineTo(trail.x2, trail.y2);
			ctx.strokeStyle = `rgba(${r}, ${g}, ${b}, ${trail.alpha})`;
			ctx.lineWidth = 2;
			ctx.stroke();
		});


		trails = trails.filter(trail => trail.alpha > 0);
	}

	function animate() {
		clearTrails();
		requestAnimationFrame(animate);
	}

	$canvas.on('mousemove', draw);
	$canvas.on('mouseleave', stopDrawing);
	$canvas.on('mouseenter', startDrawing);

	animate();
});
