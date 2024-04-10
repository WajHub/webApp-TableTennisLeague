function login(){
    document.getElementById('loginForm').addEventListener('submit', function(event) {
        event.preventDefault(); 
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        fetch('http://localhost:8080/api/auth', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username, password })
        })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Network response was not ok');
            }
        })
        .then(data => {
            const token = data.token; 
            localStorage.setItem('jwttoken', token);
            logged();
        })
        .catch(error => {
            console.error('There has been a problem with your fetch operation:', error);
            document.getElementById('error-message').innerText = 'Invalid username or password';
        });
    });
}

function logged(){

    document.getElementById('loginForm').style.display = 'none';

    const adminContent = document.createElement('div');
    adminContent.innerHTML = '<h2>Welcome, Admin!</h2><p>Here is your admin content.</p>';
    document.body.appendChild(adminContent);
}
