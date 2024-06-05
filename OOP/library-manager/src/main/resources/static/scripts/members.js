document.addEventListener('DOMContentLoaded', () => {
    fetch('http://localhost:8080/api/members')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            const memberList = document.getElementById('member-list');
            data.forEach(member => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${member.name}</td>
                    <td>${member.email}</td>
                    <td>${member.idnumber}</td>
                    <td>${member.address}</td>
                    <td>${member.phone}</td>
                `;
                memberList.appendChild(row);
            });
        })
        .catch(error => console.error('Error:', error));
});
