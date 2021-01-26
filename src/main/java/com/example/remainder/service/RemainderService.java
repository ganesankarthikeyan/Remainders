package com.example.remainder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.remainder.dao.RemainderDao;
import com.example.remainder.pojo.LoginUser;
import com.example.remainder.pojo.RegisterUser;

@Service
public class RemainderService {

   @Autowired
   RemainderDao remainderDao;

   public boolean validateLogin(LoginUser user) {
      return remainderDao.validateLogin(user);
   }

   public boolean isRegistered(RegisterUser user) {
      return remainderDao.isRegistered(user);
   }

   public void registerUser(RegisterUser user) {
      remainderDao.registerUser(user);
   }
}
