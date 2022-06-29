let baseUrl = "http://localhost:8080"; // /users, /users/1

async function login() {
    console.log("login button pressed")

    // gather input from the user - using our DOM
    let uname = document.getElementById('uname').value;

    let pass = document.getElementById('pass').value;

    // print that to the console
    console.log(uname);
    
    // send a GET request to our backend using the Fetch API
    // fetch method returns a Promise
    let res = await fetch(
                        `${baseUrl}/users/login/${uname}/${pass}`, {
                            method: 'GET', 
                            body: JSON.stringify(login)
                        }
                        
                    );
    console.log("STATUS: " + res.status);
    if (res.status == 200) {
    let resJson = await res.json()
        // .then will execute if the promise is successfully resolved
        // .then() takes a function as an argument
        .then((resp) => {
            
            console.log(resp); // this is where we will eventually put our DOM manipulation if needed

                sessionStorage.setItem("user", JSON.stringify(resp));
                window.location.assign("homePage.html");
            

        })
        // .catch will execute if there's any error
        .catch((error) => {
            console.log(error);
        });
    } else {
        console.log("Wrong Password");
        wrongPass();
    }
}

async function managerLogin() {
    console.log("login button pressed")

    // gather input from the user - using our DOM
    let uname = document.getElementById('uname').value;

    let pass = document.getElementById('pass').value;

    // print that to the console
    console.log(uname);
    
    // send a GET request to our backend using the Fetch API
    // fetch method returns a Promise
    let res = await fetch(
        `${baseUrl}/users/login/${uname}/${pass}`, {
            method: 'GET', 
        }
                    );
    if (res.status == 200) {
        let resJson = await res.json()
            // .then will execute if the promise is successfully resolved
            // .then() takes a function as an argument
            .then((resp) => {
                
                console.log(resp); // this is where we will eventually put our DOM manipulation if needed
    
                if (!resp.manager) {
                    console.log("Not a manager");
                    lackPerm();
                } else {
                    sessionStorage.setItem("user", JSON.stringify(resp));
                    window.location.assign("managerHomePage.html");
                }
                
    
            })
            // .catch will execute if there's any error
            .catch((error) => {
                console.log(error);
            });
        } else {
            console.log("Wrong Password");
            wrongPass();
        }
}

function wrongPass() {
    alert("Invalid Login Credentials");
}
function lackPerm() {
    alert("You do not have Manager permissions. Log in as User or ask admin for help");
}