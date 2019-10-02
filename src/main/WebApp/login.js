'use strict'

const BASE_URL = "/Dashpay";
const LOGIN_URL = `${BASE_URL}/menu`;

let loggedin = false;

let username = getElementById("username");
let password = getElementById("password");

let loginbutton = getElementByID("login");

loginbutton.addEventListener("submit", (event) => {
    event.preventDefault();
    fetch(LOGIN_URL, { method: "POST" })
    .then((response)=>{
    clearDisplay();
    console.log(response);
    for(let employee in response) {
       /* If  (employee.username ==  username.value) {
            if (employee.password == password.value) {
                loggedIn = true;
            }
       }
       */
    }
}).catch();
   
});





