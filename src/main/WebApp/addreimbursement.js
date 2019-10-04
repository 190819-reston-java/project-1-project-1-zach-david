'use strict';

fetch("http://localhost:8080/DashPay/ViewExpenses/Employee")
    .then((response)=>{
        return response.text();

    })
    .then((responsejson)=>{
        var resp = responsejson;

        console.log(JSON.parse(resp.split("]")[0] + "]"));
        console.log(JSON.parse(resp.split("]")[1]));
        
        var i;
        for(i=0; i<resp.length; i++) {

            var employeeID = document.createElement("p");
            employeeID.innerText = resp[i].employeeId;
            document.querySelector(".employid").appendChild(employeeID);





        }

    }).catch(console.log);