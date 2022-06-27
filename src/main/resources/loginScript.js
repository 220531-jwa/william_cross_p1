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
                        `${baseUrl}/users/${uname}`
                    );
    let resJson = await res.json()
        // .then will execute if the promise is successfully resolved
        // .then() takes a function as an argument
        .then((resp) => {
            
            

            console.log(resp); // this is where we will eventually put our DOM manipulation if needed
            
            
            //window.location.assign("homePage.html");

        })
        // .catch will execute if there's any error
        .catch((error) => {
            console.log(error);
        });


    
}