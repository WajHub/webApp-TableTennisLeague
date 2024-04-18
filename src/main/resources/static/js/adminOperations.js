function addMatch(event){
    event.preventDefault(); 
    console.log("addMatch");
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