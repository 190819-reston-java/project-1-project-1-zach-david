'use strict'

const BASE_URL = "/Dashpay";
const EMPLOYEE_URL = `${BASE_URL}/register`;

let firstname = document.getElementById("firstname");
let lastname = document.getElementById("lastname");
let username = document.getElementById("username");
let password = document.getElementById("inputpassword1");
let email = document.getElementById("useremail");
let employeerole = document.getElementById("employeerole");
let managercodefield = document.getElementById("managercode");
let isManager = false;

let submitbutton = document.getElementById("register");

submitbutton.addEventListener("click", (event)=>{
    event.preventDefault();
    if (employeerole.value === "Manager"){
        isManager = true;
    }
    if (isManager){
        if (managercodefield.value != "555"){
            alert("Invalid Manager Code");
        }
        else {
            createEmployee();
        }
    }
    else{
        createEmployee();
    }
});


    let employee = {
    rfirstname : firstname.value,
    rlastname : lastname.value,
    rusername : username.value,
    rpassword : password.value,
    remail : email.value,
    risManager : isManager,
    
    };


let createEmployee = () => {
    fetch(EMPLOYEE_URL,
        {method: "POST", 
        body:
    JSON.stringify(employee)}).then((response) => {
        console.log(response);
    }).catch(console.error);
        

};

