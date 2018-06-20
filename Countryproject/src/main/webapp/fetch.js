$(document).ready(function(){
    $("#submit").click(function(){
    save(); 
    }); 
    $("#get").click(function(){
    get();
    });
    });
    id=0;
    // function save() {
    // alert("post");
    // var cobj = {
    // "countryid": $('#cid').val(),
    // "countryname": $('#cname').val(),
    // };
    // fetch('http://localhost:9090/country/test',{
    // method:"POST",
    // headers:{
    
    // 'Content-Type':'application/json'
    
    // },
    // body:JSON.stringify(cobj)
    // })
    
    // }
        function fetchall() {
            // function checkStatus(response) {
            //     if (response.status >= 200 && response.status < 300) {
            //       return Promise.resolve(response)
            //     } else {
            //       return Promise.reject(new Error(response.statusText))
            //     }
            //   }
              function parseJson(response) {
                return response.json()
               }
              
              fetch('http://localhost:9090/country')
                // .then(checkStatus)
                .then(parseJson)
                .then(function(data) {
                    var html = "<table border='1|1'>";
                    for (var i = 0; i < data.length; i++)
                    {
                    html += "<tr>";
                    html += "<td>" + data[i].countryid + "</td>";
                    html += "<td>" + data[i].countryname + "</td>";
                    var d = JSON.stringify(data[i]);
                    html += '<td><button onclick="edit(' + d + ')">Edit</button></td>';
                    html += '<td><button onclick="delete1(' + data[i].countryid  + ')">Delete</button></td>';  
                    html += "</tr>"; 
                    }
                    html += "</table>";
                    document.getElementById("box").innerHTML = html;
                  console.log('Request succeeded with JSON response', data);
                }).catch(function(error) {
                  console.log('Request failed', error);
                });
            }  
    function save()
    {
         var cobj = {
            "countryid": $('#cid').val(),
            "countryname": $('#cname').val(),
            };
    var req = new Request('http://localhost:9090/country/test', {
        method: 'post',
        mode: 'cors',
        redirect: 'follow',
        headers: {
          "Content-type": "application/json"
        },
        body: JSON.stringify(cobj)
      });  
    fetch(req)
    .then(function(responseObj) {
        console.log('status: ', responseObj.status)  });
        fetchall();

    }  
    function delete1(data)
    {
    fetch('http://localhost:9090/country/'+data,{
    method:"DELETE",
    headers:{
    'Content-Type':'application/json'
    },
    body:JSON.stringify(data)
    })
    }