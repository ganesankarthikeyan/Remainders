function validate(){
        var number = document.getElementById("number").value;
        var password = document.getElementById("password").value;
        var repassword = document.getElementById("repassword").value;
        if(!number || !password || !repassword){
        alert("None of the fields can be empty");
        }
        else if(number.length != 10){
        alert("Please enter the valid number");
        }
        else if(!(password == repassword)){
        alert("passwords must be same");
        }
        else{
$.ajax({
type: "POST",
url: "register/",
data: {
'number': number,
'password': password,
'repassword': repassword
},
success: function(result){
      console.log("success"+result);
      if(result.alreadyRegistered){
      alert("user is already registered with the system, please login");
      window.open("RemainderLogin.html", "_self");
      }else{
      window.open("Remainder.html", "_self");
      }

    }});
        }
        }
