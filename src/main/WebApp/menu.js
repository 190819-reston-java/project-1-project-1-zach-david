'use strict';

let viewbutton = document.getElementById("viewreimbursement");
viewbutton.addEventListener("click", (event)=>{
fetch("http://localhost:8080/DashPay/ViewExpenses/Employee")
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

            var tableDataReqDate = document.createElement("td");
            tableDataReqDate.innerText = resp[i].requestDate;

            var tableDataAmount = document.createElement("td");
            tableDataAmount.innerText = resp[i].amount;

            var tableDataDesc = document.createElement("td");
            tableDataDesc.innerText = resp[i].description;

            var tableDataEmployeeId = document.createElement("td");
            tableDataEmployeeId.innerText = resp[i].employeeId;

            var tableDataExpType = document.createElement("td");
            
            var type;
            if (resp[i].type == 1){
                type = "Travel";
            }
            if (resp[i].type == 2){
                type = "Medical";
            }
            if (resp[i].type == 3){
                type = "Certification";
            }

            if (resp[i].type == 4){
                type = "Other";
            }
            
            tableDataExpType.innerText = type;

            var tableDataStatus = document.createElement("td");
            var status;
            if (resp[i].status == 1){
                status = "Pending";
            }
            if (resp[i].status == 2){
                status = "Approved";
            }
            if (resp[i].status == 3){
                status = "Rejected";
            }
            
            tableDataStatus.innerText = status;

            var tableDataManager = document.createElement("td");
            tableDataManager.innerText = resp[i].status;
            
            tablerow.appendChild(tableDataId);
            tablerow.appendChild(tableDataAmount);
            tablerow.appendChild(tableDataExpType);
            tablerow.appendChild(tableDataDesc)
            
            tablerow.appendChild(tableDataReqDate);
            tablerow.appendChild(tableDataStatus);
            tablerow.appendChild(tableDataManager);

            document.querySelector(".ereimbursementlist").appendChild(tablerow);





        }

    }).catch(console.log);
});