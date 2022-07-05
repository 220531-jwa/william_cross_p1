let baseUrl = "http://localhost:8080"; // /users, /users/1

let user = JSON.parse(sessionStorage.getItem("user"));
if (user == null || !user.manager){
    alert("Not a Manager. Returning to Login Page");
    window.location.assign("login.html");
} 
let nameText = "Manager: " + user.firstName + " " + user.lastName;
console.log(nameText);
document.getElementById("Name").innerHTML = nameText; 

async function homePage() {
    window.location.assign("managerHomePage.html");
}

async function logOut() {
    sessionStorage.clear();
    window.location.assign("login.html");
}

async function viewRequests() {
    window.location.assign("managerViewRequestList.html");
}