'use strict';

fetch("http://localhost:8080/DashPay/ViewExpenses/Employee")
.then((response)=>{
    return response.json();

})
.then((responsejson)=>{
    var resp = responsejson;
    resp.split("]")[0] + "]";
    console.log(JSON.parse(resp.split("]")[0] + "]"));
    console.log(JSON.parse(resp.split("]")[1]));

    var firstname = document.createElement("div");
    firstname.innerText = resp.employeeFirstName;
    document.querySelector(".firstname").appendChild(firstname);

    var lastname = document.createElement("div")
    lastname.innerText = resp.employeeLastName;
    document.querySelector(".lastname").appendChild(lastname);

    var username = document.createElement("div")
    username.innerText = resp.employee.username;
    document.querySelector(".username").appendChild(username);

    var password = document.createElement("div")
    password.innerText = resp.password;
    document.querySelector(".password").appendChild(password);

    var email = document.createElement("div")
    email.innerText = resp.email;
    document.querySelector(".email").appendChild(email);
      

}).catch(console.log);
