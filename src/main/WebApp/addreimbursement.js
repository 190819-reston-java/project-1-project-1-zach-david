'use strict'

const BASE_URL = "/Dashpay";
const EXPENSE_URL = `${BASE_URL}/NewExpense`;

let createExpense = document.getElementById("submit-expense");

createExpense.addEventListener("submit", (event) => {
    preventDefault();
    fetch(EXPENSE_URL,  { method: "POST", body: JSON.stringify(expenseFromForm(createExpense)) }
    )
    .then((response) => {
        if(response.status >= 200 && response.status <300) {
        	
            alert("Expense Created")
        } else {
            alert("Failed to create expense")
        }
    })
    .catch(console.error);
});

let expenseFromForm = (form) => {
    let expense = {};
    expense.amount = form.amount.value;
    expense.date = form.requestdate.value;
    expense.type = form.expensetype.value;
    expense.status = "pending";
    expense.description = form.expensedescription.value;

}