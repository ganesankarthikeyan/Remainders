package com.example.remainder.pojo;

import org.springframework.data.annotation.Id;

public class LoginUser {

   @Id
   public String number;
   public String password;

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
      return password;
   }
}
