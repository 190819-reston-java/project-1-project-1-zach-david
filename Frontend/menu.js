'use strict'

//const REIMBURSEMENT_URL = ""
// const EMPLOYEE_URL = ``
let reimbursementtable = document.getElementById("employeereimbursement");
let vr = document.getElementById("viewreimbursement");
let expenselist = document.getElementById("ereimbursementlist");

let olddisplay = reimbursementtable.style.display;
reimbursementtable.style.display = "none";

vr.addEventListener("click", (event) => {
    event.stopPropagation();
    reimbursementtable.style.display = olddisplay;
    /*
    fetch().then().catch();
    */
   expenselist.innerHTML = `
   <tr>
        <td>
            <input type = "radio" name="expense"> Expense Id</input>
        </td>
        <td>
        amount
        </td>
        <td>
        type
        </td>
        <td>
        description
        </td>
        <td>
        date
        </td>
        <td>
        status
        </td>
   </tr> 

    `;
});

