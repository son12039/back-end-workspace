let dragging = false;
let shiftX, shiftY, startPageX, startPageY;

let ball = $("#ball")[0];
ball.onmousedown = function(event) {
	event.preventDefault(); // 기본 드래그 동작 방지
	dragging = true;

	// 드래그 시작 시 오프셋 및 시작 위치 설정
	shiftX = event.clientX - ball.getBoundingClientRect().left;
	shiftY = event.clientY - ball.getBoundingClientRect().top;
	startPageX = event.pageX;
	startPageY = event.pageY;

	// 마우스 이동 및 스크롤 이벤트 리스너 등록
	document.addEventListener('mousemove', onMouseMove);
	document.addEventListener('mouseup', onMouseUp);
};

function moveAt(clientX, clientY) {
	// 현재 요소의 크기 가져오기
	const ballRect = ball.getBoundingClientRect();

	// 화면 크기 및 뷰포트 위치 가져오기
	const viewportWidth = window.innerWidth;
	const viewportHeight = document.body.offsetHeight;

	// 새로운 위치 계산 (뷰포트 기준)
	let newLeft = clientX - shiftX;
	let newTop = clientY - shiftY + window.scrollY;

	// 경계 검사 및 조정
	if (newLeft < 0) newLeft = 0;
	if (newTop < 0) newTop = 0;
	if (newLeft + ballRect.width > viewportWidth) newLeft = viewportWidth - ballRect.width;
	if (newTop + ballRect.height > viewportHeight) newTop = viewportHeight - ballRect.height;

	// 요소의 위치 설정
	ball.style.left = newLeft + 'px';
	ball.style.top = newTop + 'px';
}

function onMouseMove(event) {
	if (!dragging) return;

	// 현재 페이지 위치를 기준으로 이동
	moveAt(event.clientX, event.clientY);
}

function onMouseUp() {
	// 드래그 종료 시 이벤트 리스너 제거
	dragging = false;
	document.removeEventListener('mousemove', onMouseMove);
	document.removeEventListener('mouseup', onMouseUp);
}

// 드래그 시작 시 기본 동작 방지
ball.ondragstart = function() {
	return false;
};