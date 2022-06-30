let baseUrl = "http://localhost:8080"; // /users, /users/1

let user = JSON.parse(sessionStorage.getItem("user"));
if (user == null){
    alert("Not logged in. Returning to Login Page");
    window.location.assign("login.html");
} 

async function submit() {
    let user = JSON.parse(sessionStorage.getItem("user"));

    console.log(user);

    let request = {
        id: 1,
        employee_id: user.id,
        event_t: document.getElementById('Event_Type').value, 
        description: document.getElementById('description').value,
        grade: "Unknown", 
        approval: "Pending", 
        startDate: document.getElementById('start').value,
        endDate: document.getElementById('end').value,
        totalValue: document.getElementById('total_value').value,
        money: 0
    }


    const response = await fetch(`${baseUrl}/requests`, {
        method: 'POST', 
        headers: {
          'Content-Type': 'application/json'
          // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: JSON.stringify(request) // body data type must match "Content-Type" header
      });

    console.log("STATUS: " + response.status);

    if (response.status == 202) {
        alert("Insufficient Remaining Reimbursement. Request submitted with maximum reimbursement.");
    }



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