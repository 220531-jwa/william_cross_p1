let baseUrl = "http://localhost:8080"; // /users, /users/1


let user = JSON.parse(sessionStorage.getItem("user"));
if (user == null){
    alert("Not logged in. Returning to Login Page");
    window.location.assign("login.html");
} 
console.log(user);
let nameText = user.firstName + " " + user.lastName;
let moneyRemaining = 1000 - user.reimburseUsed;
console.log(nameText);
document.getElementById("Hello").innerHTML = "Hello " + nameText + "!"; 
document.getElementById("Name").innerHTML = nameText;
document.getElementById("Message").innerHTML = "You have " + user.notif + " notifications and $" + moneyRemaining + " in reimbursements remaining this year." 

async function homePage() {
    window.location.assign("homePage.html");
}

async function logOut() {
    sessionStorage.clear();
    window.location.assign("login.html");
}



async function viewRequests() {
    window.location.assign("requestList.html");
}

async function createRequest() {
    window.location.assign("requestCreator.html");
}