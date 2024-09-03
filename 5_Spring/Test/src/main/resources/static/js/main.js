$(document).ready(function() {
    const socket = new WebSocket("ws://localhost:8080/move");
    let myId = null;

    // Handle incoming WebSocket messages
    socket.onmessage = function(event) {
        const data = JSON.parse(event.data);

        if (data.type === 'initialize') {
            myId = data.id;

            // Create a new div for the client with their unique ID
            const $newDiv = $('<div>')
                .attr('id', data.id)
                .addClass('ch')
                .text(data.id)
                .css({
                    position: 'absolute',
                    top: data.top + 'px',
                    left: data.left + 'px'
                });

            $('.field').append($newDiv);

            // Hide other clients' divs
            data.clients.forEach(client => {
                if (client.id !== data.id) {
                    $('#' + client.id).css('visibility', 'visible'); // Make other divs visible
                }
            });

        } else if (data.type === 'newClient') {
            // Create a new div for a newly connected client
            const $newDiv = $('<div>')
                .attr('id', data.id)
                .addClass('ch')
                .text(data.id)
                .css({
                    position: 'absolute',
                    top: '0px',
                    left: '0px'
                });

            $('.field').append($newDiv);

        } else if (data.type === 'clientLeft') {
            // Remove the div for a client that has disconnected
            $('#' + data.id).remove();
        } else {
            // Update the position of existing divs
            const $element = $('#' + data.id);
            if ($element.length) {
                $element.css({
                    top: data.top + 'px',
                    left: data.left + 'px'
                });
            }
        }
    };

    $(document).keydown(function(event) {
        if (myId === null) return; // Wait until the client ID is assigned

        const field = $('.field');
        const chs = $('.ch');
        let a = 5;

        // Only move the current client's div
        const $this = $('#' + myId);
        if ($this.length) {
            let position = $this.position();
            let newTop = position.top;
            let newLeft = position.left;

            switch (event.key) {
                case 'ArrowUp':
                    newTop -= a;
                    break;
                case 'ArrowDown':
                    newTop += a;
                    break;
                case 'ArrowLeft':
                    newLeft -= a;
                    break;
                case 'ArrowRight':
                    newLeft += a;
                    break;
                default:
                    return;
            }

            newTop = Math.max(0, Math.min(field.height() - $this.outerHeight(), newTop));
            newLeft = Math.max(0, Math.min(field.width() - $this.outerWidth(), newLeft));

            $this.css({ top: newTop + 'px', left: newLeft + 'px' });

            // Send the updated position to the server
            socket.send(JSON.stringify({
                id: myId,
                top: newTop,
                left: newLeft
            }));
        }
    });
});
