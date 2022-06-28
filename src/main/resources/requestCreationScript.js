let baseUrl = "http://localhost:8080"; // /users, /users/1


async function submit() {
    window.location.assign("homePage.html");
}

async function cancel() {
    window.location.assign("homePage.html");
}

async function calculate() {
    let eventName = document.getElementById('Event_Type').value;
    console.log(eventName);

    let value = document.getElementById('total_value').value;
    console.log(value);
    
    let res = await fetch(
        `${baseUrl}/events/${eventName}`
    );
    let resJson = await res.json()
    // .then will execute if the promise is successfully resolved
    // .then() takes a function as an argument
    .then((resp) => {

    console.log(resp); // this is where we will eventually put our DOM manipulation if needed

    console.log("Percent: " + resp.pct);
    console.log("Value: " + value);
    console.log((resp.pct * value)/100)
    document.getElementById("calculated").innerHTML = ((resp.pct * value)/100); 

    })
    // .catch will execute if there's any error
    .catch((error) => {
    console.log(error);
    });
}