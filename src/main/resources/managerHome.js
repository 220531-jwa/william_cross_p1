let baseUrl = "http://localhost:8080"; // /users, /users/1

let user = JSON.parse(sessionStorage.getItem("user"));
if (user == null || !user.manager){
    alert("Not a Manager. Returning to Login Page");
    window.location.assign("login.html");
} 

async function viewRequests() {
    window.location.assign("managerViewRequestList.html");
}