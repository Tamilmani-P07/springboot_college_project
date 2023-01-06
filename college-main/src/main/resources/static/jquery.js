// admin functionns

function alldisplayItems() {
    document.getElementById("std1").style.display="none";
    document.getElementById("std3").style.display="none";
    document.getElementById("std5").style.display="none";
    document.getElementById("std4").style.display="none";

    document.getElementById("std2").style.display="block";
  
    $('#tablei').DataTable( {
        "ajax": {
            "url": "http://localhost:8080/collage/selected",
            "type":"POST",
            "dataSrc": ""
        },
        "columns": [
            { "data": "s_name" },
            { "data": "allotment_id" },
            { "data": "a_id" },
            { "data": "c_name" },
            { "data": "cour_name" }
        ]
    } );
}
function appdisplayItems() {
    document.getElementById("std3").style.display="none";
    document.getElementById("std2").style.display="none";
    document.getElementById("std4").style.display="none";
    document.getElementById("std5").style.display="none";

    document.getElementById("std1").style.display="block";
    
    $('#tableid').DataTable( {
        "ajax": {
            "url": "http://localhost:8080/collage/applicationlist",
            "type":"POST",
            "dataSrc": ""
            
        },
        "columns": [
            { "data": "a_id" },
            { "data": "s_name" },
            { "data": "s_mark" },
            { "data": "location_name" }
        ]
    } );
}
function accept(n,p,cat){

    let x=[];
    alert("acceptStudent");
    let si={
         u_name:n,
        pass:p,
        category:cat
    }
    console.log(si);
    $.ajax({
        url: "http://localhost:8080/collage/signup",
        type: "PUT",
        data: JSON.stringify(si),
        contentType:"application/JSON",
        success: function (data) {
            alert("login")
            console.log(data);
          
             
                location.href=data.viewName;
        },
        error: function (error) {
            console.log("error");
        }
    });

}
function signup(){
    var x = [];
    
    let n = document.getElementById("uname").value;
    let p=document.getElementById("pass").value;
    let cp=document.getElementById("cpass").value;
    let cat=document.getElementById("cat").value;
    console.log(n);
    if (cp===p) {
        alert();
        accept(n,p,cat);
    }
    else{
        alert("Password and Confirm Password Mismatch");
    }
         
}
function std_approval(){
    document.getElementById("std1").style.display="none";
    document.getElementById("std2").style.display="none";
    document.getElementById("std4").style.display="none";
    document.getElementById("std3").style.display="none";

    document.getElementById("std5").style.display="block";
    let x=[];

    $.ajax({
            type:"GET",
            url:"http://localhost:8080/collage/approval",
        
            success:function(data){
              
               console.log(data);
               displayApproval(data);
    
            },
            error: function (data){
                alert("INVALID ENTRY");
            }
            });

}
function displayApproval(data) {
   
    $(".trc").remove();
  
    console.log(data);
    const tBody = document.getElementById("approvetb");
    const button = document.createElement("button");
    data.forEach(ele => {
        let acceptButton = button.cloneNode(false);
        acceptButton.innerText = "Accept";
        acceptButton.setAttribute("onclick", `acceptItem('${ele.u_name}','Accept','${ele.pass}','${ele.category}')`);
 
        let declineButton = button.cloneNode(false);
        declineButton.innerText = "Decline";
        declineButton.setAttribute("onclick", `acceptItem('${ele.u_name}','Decline')`); 

        let tr = tBody.insertRow();
        tr.className="trc";
        let td1 = tr.insertCell(0);
        let cn = document.createTextNode(ele.u_name);
        td1.appendChild(cn);

        let td2 = tr.insertCell(1);
        let con = document.createTextNode(ele.category);
        td2.appendChild(con);

        let td3 = tr.insertCell(2);
        td3.appendChild(acceptButton);
 
        let td4 = tr.insertCell(3);
        td4.appendChild(declineButton);

    });
    
}
function acceptItem(n,s,x,z){
console.log(n,s,x,z);
let item={
    u_name:n,
    pass:x,
    category:z

   
}
if (s==="Accept") {
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/collage/accept",
        data: JSON.stringify(item),
        contentType:"application/JSON",
        success:function(data){
            // x=JSON.parse(data);
            alert("inserted in login")
           console.log(data);
          
            

        },
        error: function (data){
            alert("INVALID ENTRY");
        }
        });

    
}


 $.ajax({
            type:"DELETE",
            url:"http://localhost:8080/collage/delete",
            data: JSON.stringify(item),
            contentType:"application/JSON",
            success:function(data){
                // x=JSON.parse(data);
                alert("deleted in signup")
               console.log(x);
               window.reload();
              
                
    
            },
            error: function (data){
                alert("INVALID ENTRY");
            }
            });

}
function rjectedStud(){
    document.getElementById("std1").style.display="none";
    document.getElementById("std2").style.display="none";
    document.getElementById("std4").style.display="none";
    document.getElementById("std5").style.display="none";

    document.getElementById("std3").style.display="block";

    

  
    $('#rejected').DataTable( {
        "ajax": {
            "url": "http://localhost:8080/collage/rejected",
            "type": "POST",
            "dataSrc": ""
        },
        "columns": [
            { "data": "a_id" },
            { "data": "s_name" }
          
    ]} );
    console.lo

}
function department(){
    document.getElementById("std1").style.display="none";
    document.getElementById("std2").style.display="none";
    document.getElementById("std3").style.display="none";
    document.getElementById("std5").style.display="none";

    document.getElementById("std4").style.display="block";
    
    $('#depart').DataTable( {
        "ajax": {
            "url": "http://localhost:8080/collage/course",
            "type": "POST",
            "dataSrc": ""
        },
        "columns": [
            { "data": "course_id" },
            { "data": "cour_name" }
          
    ]} );
    
}

function login() {
    
    
    var x = [];
    
    
    let u = document.getElementById("in").value;
    let p = document.getElementById("out").value;
    console.log(u);
    sessionStorage.setItem("u_name",u);
    sessionStorage.setItem("password",p);
   
    var datas = {
        u_name: u,
        pass: p
    };
    
    console.log(datas);
      $.ajax({
        url: "http://localhost:8080/collage/login",
        type: "POST",
        data: JSON.stringify(datas),
        contentType:"application/JSON",
        success: function (data) {
            
            console.log(data);
          
             
                location.href=data.viewName;
        },
        error: function (error) {
            console.log("error");
        }
    });
}
//seat list for student
 function getCollegeSeatList() {
         document.getElementById("csl").style.display = "block";
         document.getElementById("cslform").style.display = "block";
         document.getElementById("status").style.display = "none";
         document.getElementById("csltable").style.display = "none";
}
 function dataSeatList(){
           var x = [];
           let college_id = document.getElementById("c_name").value;
           let course_id = document.getElementById("co_name").value;
            dataseat = {
               c_id: college_id,
               course_id: course_id
           }
           console.log(dataseat);
           $.ajax({
               url: "http://localhost:8080/collage/seats",
               type: "POST",
               data: JSON.stringify(dataseat),
               contentType:"application/JSON",
               success: function (data) {
                   
                   console.log(data);
                   document.getElementById("cslform").style.display = "none";
                   displaySeatList(data);
               },
               error: function (error) {
                   console.log("error");
               },
           })
}
 function displaySeatList(data) {
        //document.getElementById("cslform").style.display = "none";
        document.getElementById("cslform").style.display = "none";
        document.getElementById("csltable").style.display = "block";
        $(".trc").remove();
        console.log(data);
        const tBody = document.getElementById("sea");
        data.forEach(ele => {
    
            let tr = tBody.insertRow();
            tr.className="trc";
            let td1=tr.insertCell(0);
            let cname=document.createTextNode(ele.c_name);
            td1.appendChild(cname);
            
            let td2 = tr.insertCell(1);
            let con = document.createTextNode(ele.cour_name);
            td2.appendChild(con);
    
            let td3 = tr.insertCell(2);
            let co_id = document.createTextNode(ele.c_id);
            td3.appendChild(co_id);
    
            let td4 = tr.insertCell(3);
            let fs = document.createTextNode(ele.filledseats);
            td4.appendChild(fs);
    
            let td5 = tr.insertCell(4);
            let res = document.createTextNode(ele.remainingseats);
            td5.appendChild(res);
    
            let td6 = tr.insertCell(5);
            let ts = document.createTextNode(ele.total_seats);
            td6.appendChild(ts);
    
        });
}
       //student status 
function getStudentStatusonload(){
        document.getElementById("csl").style.display = "block";
        document.getElementById("cslform").style.display = "none";
        document.getElementById("csltable").style.display = "none";
        var x = [];
        let name=sessionStorage.getItem("u_name")
        let p=sessionStorage.getItem("password");
        console.log(name);
        
        var datas={     
            u_name:name,
            pass:p
        };
    
        $.ajax({
            url: "http://localhost:8080/collage/status",
            type: "POST",
            data:JSON.stringify(datas),
            contentType:"application/JSON",
            success: function (data) {
                
                console.log(data);
                getstatusDisplay(data);
                },
            error: function (error) {
                console.log("error");
            },
        });
        
}
 
    function getstatusDisplay(data) {
        console.log(data);
        document.getElementById("status").style.display = "block";
        $(".trcc").remove();
        const tBody = document.getElementById("sta");
    
        data.forEach(ele => {if (ele.allotment_id!=null) {
            
        
    
            let tr = tBody.insertRow();
            tr.className="trcc";
            let td1 = tr.insertCell(0);
            let cn = document.createTextNode(ele.a_id);
            td1.appendChild(cn);
    
            let td2 = tr.insertCell(1);
            let con = document.createTextNode(ele.s_name);
            td2.appendChild(con);
    
            let td3 = tr.insertCell(2);
            let co_id = document.createTextNode(ele.allotment_id);
            td3.appendChild(co_id);
    
            let td4 = tr.insertCell(3);
            let fs = document.createTextNode("ALLOTTED");
            td4.appendChild(fs);}
            else{
                let tr = tBody.insertRow();
            tr.className="trcc";
            let td1 = tr.insertCell(0);
            let cn = document.createTextNode(ele.a_id);
            td1.appendChild(cn);
    
            let td2 = tr.insertCell(1);
            let con = document.createTextNode(ele.s_name);
            td2.appendChild(con);
    
            let td3 = tr.insertCell(2);
            let co_id = document.createTextNode("NILL");
            td3.appendChild(co_id);
    
            let td4 = tr.insertCell(3);
            let fs = document.createTextNode("NOT ALLOTTED");
            td4.appendChild(fs);

            }
    
    });    
}

 function name(){
     var temp=sessionStorage.getItem("u_name");
        document.getElementById("name").textContent=temp.toUpperCase();
}  
    //log out 
    function logout(){
        location.href="index.html";
}
     // redirect functions
    function redirectStudent() {
        document.getElementById("csl").style.display = "none";
        document.getElementById("status").style.display= "none"; 
}

    function redirectAdmin() {
        location.href="admin.html";
        
}
    function redirectStudent() {
        location.href="student.html";
        
}