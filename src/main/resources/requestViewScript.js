let baseUrl = "http://localhost:8080"; // /users, /users/1

async function loadTable() {
    console.log("GO");
    
    let uid = sessionStorage.getItem("request");

    console.log(uid);
    
    let res = await fetch(
        `${baseUrl}/requests/${uid}`
    );
    let resJson = await res.json()
            // .then will execute if the promise is successfully resolved
            // .then() takes a function as an argument
            .then((resp) => {
                
                console.log(resp); // this is where we will eventually put our DOM manipulation if needed

                var request = document.createElement('table');
                let description = request.insertRow();
                let desc = description.insertCell();
                desc.appendChild(document.createTextNode("Description"));
                let val = description.insertCell();
                val.appendChild(document.createTextNode(resp.description));

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
            });
    }