'use strict'

const BASE_URL = "/Dashpay";
const EXPENSE_URL = `${BASE_URL}/expenses`;

let expenseDisplay = document.getElementById("expenseDisplay");
let reimbursementtable = document.getElementById("employeereimbursement");
let vr = document.getElementById("viewreimbursement");
 

let expenselist = document.getElementById("ereimbursementlist");

let olddisplay = reimbursementtable.style.display;
reimbursementtable.style.display = "none";

vr.addEventListener("click", (event) => {
    event.stopPropagation();
    reimbursementtable.style.display = olddisplay;
    
    fetch(EXPENSE_URL, { method: "GET" })
        .then((expenseJson)=>{
        clearDisplay();
        for(let expense in expenseJson) {
            //console.log(expense)
            createLi(expense);
        }
    }).catch((error)=>{ 
        alert("No Expense Found");
    });
    
  
   
});

let clearDisplay = () => {
    expenseDisplay.innerHTML = "";
}

let createLi = (expense) => {
    let li = document.createElement("li");
    li.innerText =  `${expense.expenseid}`;
    expenseDisplay.appendLi();   
}
