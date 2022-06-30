let baseUrl = "http://localhost:8080"; // /users, /users/1

let user = JSON.parse(sessionStorage.getItem("user"));
if (user == null || !user.manager){
    alert("Not a Manager. Returning to Login Page");
    window.location.assign("login.html");
} 

let uid = sessionStorage.getItem("request");

async function loadRequest() {
    console.log("GO");
    
    

    console.log(uid);
    
    let res = await fetch(
        `${baseUrl}/requests/${uid}/manager`
    );
    let resJson = await res.json()
            // .then will execute if the promise is successfully resolved
            // .then() takes a function as an argument
            .then((resp) => {
                
                console.log(resp); // this is where we will eventually put our DOM manipulation if needed

                if (resp.approval != 'Pending') {
                    buttons = document.getElementById('buttons');
                    buttons.parentNode.removeChild(buttons);
                }

                var request = document.createElement('table');
                request.classList.add('table-bordered');

                let description = request.insertRow();
                let desc = description.insertCell();
                desc.appendChild(document.createTextNode("Description"));
                let val = description.insertCell();
                val.appendChild(document.createTextNode(resp.description));

                let employee = request.insertRow();
                desc = employee.insertCell();
                desc.appendChild(document.createTextNode("Employee"));
                val = employee.insertCell();
                val.appendChild(document.createTextNode(resp.firstName + " " + resp.lastName)); 

                let type = request.insertRow();
                desc = type.insertCell();
                desc.appendChild(document.createTextNode("Type"));
                val = type.insertCell();
                val.appendChild(document.createTextNode(resp.event_t));

                let money = request.insertRow();
                desc = money.insertCell();
                desc.appendChild(document.createTextNode("Reimbursement Amount"));
                val = money.insertCell();
                val.appendChild(document.createTextNode(resp.money));
                if (resp.money < resp.expected_funds) { 
                    desc = money.insertCell();
                    desc.appendChild(document.createTextNode("They are owed " + resp.expected_funds + ", but are only slated to recieve " + resp.money));
                }
                let buttonSpace = money.insertCell();
                let buttonText = "EDIT";
                let button = document.createElement('button');
                button.type = 'button';
                button.innerHTML = buttonText;
                button.onclick = function() {
                    let newM = prompt("How much should they be paid?");
                    updateMoney(resp,newM);
                }
                buttonSpace.appendChild(button);

                let approval = request.insertRow();
                desc = approval.insertCell();
                desc.appendChild(document.createTextNode("Approval"));
                val = approval.insertCell();
                val.appendChild(document.createTextNode(resp.approval));

                let start = request.insertRow();
                desc = start.insertCell();
                desc.appendChild(document.createTextNode("Start Date"));
                val = start.insertCell();
                val.appendChild(document.createTextNode((new Date(resp.startDate)).toDateString()));

                let end = request.insertRow();
                desc = end.insertCell();
                desc.appendChild(document.createTextNode("End Date"));
                val = end.insertCell();
                val.appendChild(document.createTextNode((new Date(resp.endDate)).toDateString()));

                let total = request.insertRow();
                desc = total.insertCell();
                desc.appendChild(document.createTextNode("Total Value"));
                val = total.insertCell();
                val.appendChild(document.createTextNode(resp.totalValue));

                let grade = request.insertRow();
                desc = grade.insertCell();
                desc.appendChild(document.createTextNode("Grade"));
                val = grade.insertCell();
                val.appendChild(document.createTextNode(resp.grade));


                document.getElementById("request").appendChild(request);


            })
            // .catch will execute if there's any error
            .catch((error) => {
                console.log(error);
                alert("Error: No Such Request");
                window.location.assign("managerViewRequestList.html");
            });
}

async function updateMoney(request, newMoney) {
    request.money = newMoney;

    let res = await fetch(
        `${baseUrl}/requests/${request.id}`, {
            method: 'PUT', 
            headers: {
              'Content-Type': 'application/json'
              // 'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: JSON.stringify(request) // body data type must match "Content-Type" header
          });

    window.location.assign("requestViewManager.html");
}

async function approve(request) {
    let res = await fetch(
        `${baseUrl}/approve/${uid}`, {
            method: 'PUT', 
            headers: {
              'Content-Type': 'application/json'
              // 'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: JSON.stringify(request) // body data type must match "Content-Type" header
          });

    window.location.assign("requestViewManager.html");
}

async function reject(request) {
    let res = await fetch(
        `${baseUrl}/reject/${uid}`, {
            method: 'PUT', 
            headers: {
              'Content-Type': 'application/json'
              // 'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: JSON.stringify(request) // body data type must match "Content-Type" header
          });

    window.location.assign("requestViewManager.html");
}

async function cancel() {
    window.location.assign("managerViewRequestList.html");
}