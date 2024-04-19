// Operations are unlock after atuhorization as admin
function unlockOperations(){
    document.getElementById('addMatch').addEventListener('submit', addMatch);
    document.getElementById;
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
    const data = {
        'homeTeamId': homeTeamId,
        'guestTeamId': guestTeamId,
        'date': date
    };
    console.log(data);


    fetch('http://localhost:8080/api/admin/addMatch',{
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer " + localStorage.getItem("jwttoken")
            },
            body: JSON.stringify(data)
    })
}