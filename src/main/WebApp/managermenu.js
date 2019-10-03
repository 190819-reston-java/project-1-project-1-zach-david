'use strict';


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

            var tableDataReqDate = document.createElement("td");
            tableDataReqDate.innerText = resp[i].requestDate;

            var tableDataAmount = document.createElement("td");
            tableDataAmount.innerText = resp[i].amount;

            var tableDataDesc = document.createElement("td");
            tableDataDesc.innerText = resp[i].description;

            var tableDataEmployeeId = document.createElement("td");
            tableDataEmployeeId.innerText = resp[i].employeeId;

            var tableDataExpType = document.createElement("td");
            tableDataExpType.innerText = resp[i].type;

            var tableDataStatus = document.createElement("td");
            tableDataStatus.innerText = resp[i].status;

            var tableDataManager = document.createElement("td");
            tableDataManager.innerText = resp[i].status;
            
            tablerow.appendChild(tableDataId);
            tablerow.appendChild(tableDataEmployeeId);
            tablerow.appendChild(tableDataAmount);
            tablerow.appendChild(tableDataExpType);
            tablerow.appendChild(tableDataDesc);
            tablerow.appendChild(tableDataReqDate);
            tablerow.appendChild(tableDataStatus);
            tablerow.appendChild(tableDataManager);

            document.querySelector(".mreimbursementlist").appendChild(tablerow);





        }

    }).catch(console.log);
