var updateID;
var btnchg;
$(document).ready(function(){
    loadData();
    $("#submit").click(function(){
        save();  
});  
$("#delete").click(function(){
    delete1();  
});  
$("#update").click(function(){
    update1();  
}); 
});
function loadData() {
    alert('validated!');
    $.ajax({
        type: 'GET',
        url: "http://ng4springbootrest.herokuapp.com/employees",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            // alert(JSON.stringify(data));
            //alert(data.length);
            $("#p1").append("<table class='table' ><tr> <th width='50'>Id</th>"
                + "<th width='50'>Name</th>"
                + "<th width='50'>Position</th>"
                + "<th width='50'>Department</th>"
                + "<th width='50'>Salary</th> </tr></table>");
            var tr;
            for (var i = 0; i < data.length; i++) {
                tr = $('<tr/>');
                tr.append("<td >" + data[i].id + "</td>");
                tr.append("<td>" + data[i].name + "</td>");
                tr.append("<td>" + data[i].position + "</td>");
                tr.append("<td>" + data[i].department + "</td>");
                tr.append("<td>" + data[i].salary+ "</td>");
                var d = JSON.stringify(data[i]);
                //alert(d);
                tr.append("<td><button onclick='update(" + d + ")' >Edit</button> <button onclick=delete1(" + data[i].id + ") >Delete</button></td>");
                $('table').append(tr);
            }
        },
        error: function () {
            alert('fail....post');

        }
    });
}

function save() {
    alert("post");
    var markers = {
        "department":  $('#department').val(),
        "name": $('#name').val(),
        "position": $('#position').val(),
        "salary": $('#salary').val()
    };
    $.ajax({
        type: "POST",
        url: "http://ng4springbootrest.herokuapp.com/employees",
        data: JSON.stringify(markers),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) { alert(JSON.stringify(data)); console.log(data); },
        failure: function (errMsg) {
            console.log(errMsg);
            alert(errMsg);
        }
    });
}

function delete1(data) {
    alert("delete.....");
     //var del=$('#id').val();
    $.ajax({
        type: "DELETE",
        url: "http://ng4springbootrest.herokuapp.com/employees/"+data,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        // success: function (data) { alert(JSON.stringify(data)); console.log(data); },
        failure: function (errMsg) {
            console.log(errMsg);
            alert(errMsg);
        }
    });
    loadData();
}

function update(data) {
    alert("Update");
    alert("update....." + JSON.stringify(data));
    $("#id").val(data.id);
    $("#department").val(data.department);
    $("#name").val(data.name);
    $("#position").val(data.position);
    $("#salary").val(data.salary);
};

function update1()
{
    var id=$('#id').val();
    var update1 = {
        "department":  $('#department').val(),
        "name": $('#name').val(),
        "position": $('#position').val(),
        "salary": $('#salary').val()
    };
    $.ajax({
        type: "PUT",
        url: "http://ng4springbootrest.herokuapp.com/employees/"+id,
        data: JSON.stringify(update1),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) { alert(JSON.stringify(data)); console.log(data); },
        failure: function (errMsg) {
            console.log(errMsg);
            alert(errMsg);
        }
    });
}


