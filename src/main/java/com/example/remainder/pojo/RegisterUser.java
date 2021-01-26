package com.example.remainder.pojo;

public class RegisterUser {
   public String number;
   public String password;
   public String repassword;

   public void setNumber(String number){
      this.number = number;
   }

   public void setPassword(String password){
      this.password = password;
   }

   public String getNumber(){
      return number;
   }

   public String getPassword(){
      return  password;
   }

   public void setRepassword(String repassword){
      this.repassword = repassword;
   }

   public String getRepassword(){
      return repassword;
   }
}
