package com.example.remainder.pojo;

public class Response {
   public boolean validLogin;
   public boolean alreadyRegistered;

   public Response(boolean validLogin, boolean alreadyRegistered) {
      this.validLogin = validLogin;
      this.alreadyRegistered = alreadyRegistered;
   }

   public void setValidLogin(boolean validLogin) {
      this.validLogin = validLogin;
   }

   public void setAlreadyRegistered(boolean alreadyRegistered) {
      this.alreadyRegistered = alreadyRegistered;
   }
   
   public boolean isValidLogin() {
      return validLogin;
   }

   public boolean isAlreadyRegistered() {
      return alreadyRegistered;
   }
}
