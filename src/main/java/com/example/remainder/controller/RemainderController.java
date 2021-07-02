package com.example.remainder.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.remainder.dao.UserTaskRepository;
import com.example.remainder.pojo.Errors;
import com.example.remainder.pojo.LoginUser;
import com.example.remainder.pojo.RegisterUser;
import com.example.remainder.pojo.Remainder;
import com.example.remainder.pojo.Response;
import com.example.remainder.pojo.UserTasks;
import com.example.remainder.service.Action;
import com.example.remainder.service.RemainderService;

@RestController
public class RemainderController {
public String globaluserid="";
   @Autowired
   RemainderService remainderService;
   @Autowired
	Action ac;
	@Autowired
	UserTaskRepository utr;


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
      if(isValid==true)
    	  globaluserid=user.getNumber();
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

   @GetMapping("/errors")
   @ResponseBody
   public ArrayList<Errors> getErros(){
      return remainderService.getErrors();
   }
   @PostMapping("/putValues/{specialId}")
	public UserTasks putValues(@RequestBody Remainder remain,@PathVariable String specialId)
	{
		
		UserTasks usertasks=ac.adder1(remain,specialId);
		return usertasks;
		
	}
	
	@GetMapping("/getValues/{specialId}")
	@ResponseBody
	public Optional<UserTasks> getValues(@PathVariable String specialId)
	{
		return utr.findById(specialId);
	}
	@GetMapping("/getAllValues")
	@ResponseBody
	public List<UserTasks> getAllValues()
	{
		ac.test();
		return utr.findAll();
	}
	@GetMapping("/deletetask/{specialId}/{taskname}")
	public UserTasks deletetaskUpcoming(@PathVariable String specialId,@PathVariable String taskname)
	{
	         UserTasks usertasks=ac.delete(specialId, taskname);
	         return usertasks;
	}
	@GetMapping("/showUpcomingTasks/{specialId}")
	public HashMap<String,Remainder> showUpcomingTasks(@PathVariable String specialId)
	{ 
		ac.testMail();
		return  ac.taskviewer(specialId,0);
	}
	@GetMapping("/showOngoingTasks/{specialId}")
	public HashMap<String,Remainder> showOngoingTasks(@PathVariable String specialId)
	{
		return  ac.taskviewer(specialId,1);
	}
	@GetMapping("/showCompletedTasks/{specialId}")
	public HashMap<String,Remainder> showCompletedTasks(@PathVariable String specialId)
	{
		return  ac.taskviewer(specialId,2);
	}
    @PostMapping("/initialize/{specialId}")
    public void initialze(@PathVariable String specialId)
    {
    	ac.initialize(specialId);
    }
	
	
}