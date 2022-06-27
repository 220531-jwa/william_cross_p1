let baseUrl = "http://localhost:8080"; // /users, /users/1

async function viewRequests() {
    window.location.assign("requestList.html");
}

async function createRequest() {
    window.location.assign("requestCreator.html");
}