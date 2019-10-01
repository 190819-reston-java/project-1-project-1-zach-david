//const REIMBURSEMENT_URL = ""
// const EMPLOYEE_URL = ``
let table = document.getElementById("managerreimbursement");
let srbutton = document.getElementById("managerview");
let expenselist = document.getElementById("mreimbursementlist");

let olddisplay = table.style.display;
table.style.display = "none";

srbutton.addEventListener("click", (event) => {
    event.stopPropagation();
    table.style.display = olddisplay;
    /*
    fetch().then().catch();
    */
   expenselist.innerHTML = `
   <tr>
        <td>
            <input type = "radio" name="expense"> Expense Id</input>
        </td>
        <td>
            employee id
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
        <td>
            manager name
        </td>
   </tr> 

    `;
});