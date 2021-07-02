function validate(){
        var number = document.getElementById("number").value;
        var password = document.getElementById("password").value;
        if(!number || !password ){
        alert("Number or password cannot be empty");
        }
        else if(number.length != 10){
        alert("Please enter the valid number");
        }
        else{
$.ajax({
type: "POST",
url: "login/",
data: {
'number': number,
'password': password
},
success: function(result){
      if(result.validLogin){
      window.open("Remainder.html","_self");
      }else{
      alert("user not registered, please register!!!!!!")
      window.open("RemainderRegistration.html","_self");
      }

    }});
        }
        }
