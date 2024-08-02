const videoCard = document.querySelectorAll('.video-card');

videoCard.forEach(card=> {
	card.addEventListener('click', () => {
		const code = card.getAttributerute("data-code");
		window.location.href = "/" + code;
	});
});