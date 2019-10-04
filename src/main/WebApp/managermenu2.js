'use strict';

//Used for debugging

let viewbutton = document.getElementById("managerview");
viewbutton.addEventListener("click", (event)=>{
fetch("http://localhost:8080/DashPay/ViewExpenses/All")
    .then((response)=>{
        return response.json();

    })
    .then((responsejson)=>{
        var resp = responsejson;
        
        var i;
        for(i=0; i<resp.length; i++) {

            var tablerow = document.createElement("tr");

            var tableDataId = document.createElement("td");
            tableDataId.innerText = resp[i].expenseId;


            
            tablerow.appendChild(tableDataId);

            document.querySelector(".mreimbursementlist").appendChild(tablerow);





        }

    }).catch(console.log);
});