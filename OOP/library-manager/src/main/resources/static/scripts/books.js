document.addEventListener('DOMContentLoaded', () => {
    fetch('http://localhost:8080/get-books')
        .then(response => response.json())
        .then(data => {
            const bookList = document.getElementById('book-list');
            data.forEach(book => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${book.name}</td>
                    <td>${book.isbn}</td>
                    <td>${book.category}</td>
                    <td>${book.title}</td>
                    <td>${book.description}</td>
                    <td>${book.qty}</td>
                `;
                bookList.appendChild(row);
            });
        })
        .catch(error => console.error('Error:', error));
});
