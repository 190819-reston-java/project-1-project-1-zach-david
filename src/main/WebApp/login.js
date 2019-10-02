'use strict'

const BASE_URL = "/Dashpay";
const LOGIN_URL = `${BASE_URL}/loggedin`;

let loggedin = false;

let username = getElementById("username");
let password = getElementById("password");

let loginbutton = getElementByID("login");

loginbutton.addEventListener("click", (event) => {
    event.stopPropagation();
    fetch(EXPENSE_URL, { method: "GET" })
    .then((employeeJson)=>{
    clearDisplay();
    for(let employee in employeeJson) {
       /* If  (employee.username ==  username.value) {
            if (employee.password == password.value) {
                loggedIn = true;
            }
       }
       */
    }
}).catch();

    

  
   
});