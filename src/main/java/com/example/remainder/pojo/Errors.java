package com.example.remainder.pojo;

import java.util.ArrayList;

public class Errors {
   public String errorCode;
   public ArrayList<String> errorScenarios;

   public Errors(String errorCode, ArrayList<String> errorScenarios){
      this.errorCode = errorCode;
      this.errorScenarios = errorScenarios;
   }
}
