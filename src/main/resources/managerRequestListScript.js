let baseUrl = "http://localhost:8080"; // /users, /users/1

let user = JSON.parse(sessionStorage.getItem("user"));
if (user == null || !user.manager){
    alert("Not a Manager. Returning to Login Page");
    window.location.assign("login.html");
} 

async function loadTable() {
    console.log("GO");
    
    
    let res = await fetch(
        `${baseUrl}/requests`
    );
    let resJson = await res.json()
            // .then will execute if the promise is successfully resolved
            // .then() takes a function as an argument
            .then((resp) => {
                
                console.log(resp); // this is where we will eventually put our DOM manipulation if needed

                var table = document.createElement('table');
                let headers = table.insertRow();
                {
                    let desc = headers.insertCell();
                    desc.appendChild(document.createTextNode("Description"));
                    let emp = headers.insertCell();
                    emp.appendChild(document.createTextNode("Employee"));
                    let type = headers.insertCell();
                    type.appendChild(document.createTextNode("Type"));
                    let amount = headers.insertCell();
                    amount.appendChild(document.createTextNode("Amount Requested"));
                    let approval = headers.insertCell();
                    approval.appendChild(document.createTextNode("Approval"));
                }

                for( let i = 0; i < resp.length; i ++) {
                    let row = table.insertRow();


                    let buttonText = resp[i].description;
                    let button = document.createElement('button');
                    button.type = 'button';
                    button.innerHTML = buttonText;

                    button.onclick = function() {
                        sessionStorage.setItem("request", resp[i].id);
                        window.location.assign("managerRequestView.html");
                    }

                    let desc = row.insertCell();
                    desc.appendChild(button);

                    let emp = row.insertCell();
                    emp.appendChild(document.createTextNode(resp[i].firstName + " " + resp[i].lastName));
                    
                    let type = row.insertCell();
                    type.appendChild(document.createTextNode(resp[i].event_t));
                    let amount = row.insertCell();
                    amount.appendChild(document.createTextNode(resp[i].money));
                    let approval = row.insertCell();
                    approval.appendChild(document.createTextNode(resp[i].approval));
                }

                document.getElementById("tableSpace").appendChild(table);
                

            })
            // .catch will execute if there's any error
            .catch((error) => {
                console.log(error);
            });
    }
