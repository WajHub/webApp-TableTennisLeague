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
            contentAdmin();
        })
        .catch(error => {
            console.error('There has been a problem with your fetch operation:', error);
            document.getElementById('error-message').innerText = 'Invalid username or password';
        });
    });
}



function contentAdmin(){
    if(localStorage.getItem("jwttoken")==null){
        login();
    }
    else{
        fetch('http://localhost:8080/api/admin/content',{
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer " + localStorage.getItem("jwttoken")
            }
        })
        .then(response => {
            if(response.ok){
                document.getElementById('loginForm').style.display = 'none';
                return response.text();
            }
            else{
                return ""
            }
        })
        .then(html => {
            document.getElementById("adminPanel").innerHTML = html;
        })
        .catch(error => console.error('Błąd podczas pobierania pliku:', error));
    }
}
