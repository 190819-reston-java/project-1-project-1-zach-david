'use strict'

let login = getElementById("login");
let EMPLOYEE_URL = menu.html;


login.addEventListener("submit", (event) => {
    event.preventDefault();

    let username = getElementById("usernameInput").value;
    let password = getElementById("passwordInput").value;

    fetch(EMPLOYEE_URL, {method: "POST"})
        .then((response) => {
            return response.json();
        })
        .then((employeeJson) =>{
            clearDisplay();
            createLi(employeeJson);
        })
})