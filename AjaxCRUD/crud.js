$(document).ready(function(){
    $(".btn").click(function(){
        loadData();  
});  
});

function loadData() {
    alert('validated!');
    $.ajax({
        url: "http://ng4springbootrest.herokuapp.com/employees",
        type: 'POST',

        // headers: {
        //     "Accept": "application/json",
        //     "Content-Type": "application/json"
        // },
        success: function (data) {
            alert(data);
           // alert(JSON.parse(data));
            alert(JSON.stringify(data));

        },
        error: function () {
            alert('fail....post');

        }
    });
}
