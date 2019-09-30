'use strict'

//const REIMBURSEMENT_URL = ""
// const EMPLOYEE_URL = ``
let reimbursementtable = document.getElementById("employeereimbursement");
let vr = document.getElementById("viewreimbursement");

let olddisplay = reimbursementtable.style.display;
reimbursementtable.style.display = "none";

vr.addEventListener("click", (event) => {
    event.stopPropagation();
    reimbursementtable.style.display = olddisplay;
    /*
    fetch().then.catch();
    */
});

