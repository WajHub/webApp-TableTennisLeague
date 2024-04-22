// Operations are unlock after atuhorization as admin
function unlockOperations(){
    document.getElementById('addMatch').addEventListener('submit', addMatch);
    document.querySelectorAll('.addSingleMatch').forEach(element => {
        element.addEventListener('submit', addSingleMatch)
    });
}

function deleteMatch(id){
    event.preventDefault(); 
    fetch('http://localhost:8080/api/admin/deleteMatch/'+id, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + localStorage.getItem("jwttoken")
        }
    })
}

function addMatch(event){
    event.preventDefault(); 
    var homeTeamId = document.getElementById('homeId').value; 
    var guestTeamId = document.getElementById('guestId').value;
    var date = document.getElementById('date').value;
    var round = document.getElementById('round').value;
    const data = {
        'homeTeamId': homeTeamId,
        'guestTeamId': guestTeamId,
        'date': date,
        'round': round
    };
    // console.log(data);


    fetch('http://localhost:8080/api/admin/addMatch',{
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer " + localStorage.getItem("jwttoken")
            },
            body: JSON.stringify(data)
    })
}

function addSingleMatch(event){
    event.preventDefault(); 
    var formId = event.target.id; // Pobierz ID formularza, który został wysłany
    var idGame = formId.slice(5); // Nazwa formularza: form_Id (usuwamy czesc 'form_')
    
    var form = document.getElementById(formId);
    var playerHomeId = form.querySelector('[name="playerHome"]').value;
    var playerGuestId = form.querySelector('[name="playerGuest"]').value;
    var homeResult = form.querySelector('[name="resultPlayerHome"]').value;
    var guestResult = form.querySelector('[name="resultPlayerGuest"]').value;

    const data = {
        'resultPlayerHome': homeResult,
        'resultPlayerGuest': guestResult,
        'idGame': idGame,
        'playerHome': playerHomeId,
        'playerGuest': playerGuestId
    };
    // console.log(data);

    fetch('http://localhost:8080/api/admin/addSingleMatch',{
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer " + localStorage.getItem("jwttoken")
            },
            body: JSON.stringify(data)
    })
}