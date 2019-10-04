'use strict';

let firstname = document.getElementById("firstname");
let lastname = document.getElementById("lastname");
let username = document.getElementById("username");
let password = document.getElementById("password");
let email = document.getElementById("email");

fetch("http://localhost:8080/DashPay/ViewExpenses/Employee")

.then((response)=>{
    return response.json();

})
.then((responsejson)=>{
    var resp = responsejson;
    firstname.value = resp.employeeFirstName;
    lastname.value = resp.employeeLastName;
    username.value = resp.username;
    password.value = resp.password;
    email.value = resp.email;
      

}).catch(console.log);
