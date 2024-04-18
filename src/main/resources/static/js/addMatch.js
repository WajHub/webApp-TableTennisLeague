function add_match(){
    const homeTeamId = document.getElementById('teamHomeId').value; 
    const guestTeamId = document.getElementById('teamGuestId').value;
    console.log(homeTeamId);
    console.log(guestTeamId);
    fetch('http://localhost:8080/api/admin/addMatch',{
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer " + localStorage.getItem("jwttoken")
            }
    })
}