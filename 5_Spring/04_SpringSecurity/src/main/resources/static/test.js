const token = localStorage.getItem("token");
		$("#member").click((e) => {
			e.preventDefault();
			$.ajax({
				url: '/member',
				type: 'get',
				beforeSend: function(xhr) {
					xhr.setRequestHeader('Authorization', 'Bearer ' + token);
				},
				success: function(data) {
					console.log(data);
				}
			})
		});