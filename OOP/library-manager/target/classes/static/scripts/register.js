document.getElementById('registration-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const member = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        idnumber: document.getElementById('idnumber').value,
        address: document.getElementById('address').value,
        phone: document.getElementById('phone').value
    };

    fetch('http://localhost:8080/api/members', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(member)
    })
    .then(response => response.json())
    .then(data => {
        alert('Member registered successfully!');
        window.location.href = 'index.html';
        document.getElementById('registration-form').reset();
    })
    .catch(error => console.error('Error:', error));
});
