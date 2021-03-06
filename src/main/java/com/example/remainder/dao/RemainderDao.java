package com.example.remainder.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.remainder.pojo.LoginUser;
import com.example.remainder.pojo.RegisterUser;

@Repository
@Service
public class RemainderDao {

   @Autowired
   UserRepository userRepository;
 public boolean flag=false;
 public String id="";
   public boolean validateLogin(LoginUser user) {
      Optional<LoginUser> optionalLoginUser = userRepository.findById(user.getNumber());
      if (optionalLoginUser.isPresent()) {
         LoginUser dbuser = optionalLoginUser.get();
         if (user.getPassword().equalsIgnoreCase(dbuser.getPassword())) {
        	 flag=true;
        	 id=user.getNumber();
            return true;
         }
      }
      return false;
   }

   public boolean isRegistered(RegisterUser user) {
      Optional<LoginUser> optionalRegisterUser = userRepository.findById(user.getNumber());
      System.out.println("optional register user " + optionalRegisterUser);
      if (optionalRegisterUser.isPresent()) {
         return true;
      }
      return false;
   }

   public void registerUser(RegisterUser user) {
      System.out.println("registered");
      LoginUser loginUser = new LoginUser();
      loginUser.setNumber(user.getNumber());
      loginUser.setPassword(user.getPassword());
      userRepository.save(loginUser);
   }
}
