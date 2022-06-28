let baseUrl = "http://localhost:8080"; // /users, /users/1

//function hello() {
    let user = JSON.parse(sessionStorage.getItem("user"));
    console.log(user);
    let nameText = user.firstName + " " + user.lastName;
    console.log(nameText);
    document.getElementById("Hello").innerHTML = "Hello " + nameText + "!"; 
//}


async function viewRequests() {
    window.location.assign("requestList.html");
}

async function createRequest() {
    window.location.assign("requestCreator.html");
}