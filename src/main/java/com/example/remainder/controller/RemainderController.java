package com.example.remainder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.remainder.pojo.LoginUser;
import com.example.remainder.pojo.RegisterUser;
import com.example.remainder.pojo.Response;
import com.example.remainder.service.RemainderService;

@Controller
public class RemainderController {

   @Autowired
   RemainderService remainderService;

   @RequestMapping("/")
   public String login() {
      System.out.println("home");
      return "RemainderLogin.html";
   }

   @PostMapping("/login")
   @ResponseBody
   public ResponseEntity<Response> loginValidate(LoginUser user){
      System.out.println("login controller "+user.getNumber()+" "+user.getPassword());
      Boolean isValid = remainderService.validateLogin(user);
      System.out.println("isvalid "+isValid);
      return new ResponseEntity<Response>(new Response(isValid, false), HttpStatus.OK);
   }

   @PostMapping("/register")
   @ResponseBody
   public ResponseEntity<Response> registerValidate(RegisterUser user){
      System.out.println("register user "+user.getNumber()+" "+user.getPassword()+" "+user.getRepassword());
      boolean isRegistered = remainderService.isRegistered(user);
      if(!isRegistered){
         System.out.println("not registered, so registering");
         remainderService.registerUser(user);
      }else{
         System.out.println("already registered");
      }
      return new ResponseEntity<Response>(new Response(false, isRegistered), HttpStatus.OK);
   }

}