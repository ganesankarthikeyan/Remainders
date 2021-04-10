package com.example.remainder.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.remainder.dao.RemainderDao;
import com.example.remainder.pojo.Errors;
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

   public ArrayList<Errors> getErrors() {
      ArrayList<Errors> errors = new ArrayList<>();
      ArrayList<String> E0424ErrorScenarios = new ArrayList<>();
      E0424ErrorScenarios.add("If it is update of entity, and there is no existing entity in data store to be updated, we will have this error");
      E0424ErrorScenarios.add("If it is delete of entity, and there is no existing entity in data store to be deleted, we will have this error");
      errors.add(new Errors("E0424",E0424ErrorScenarios));

      ArrayList<String> E0006ErrorScenarios = new ArrayList<>();
      E0006ErrorScenarios.add("If the data is not found in data store, to be used in govern part to fetch the existing values for running the business Rules.");
      errors.add(new Errors("E0006", E0006ErrorScenarios));

      ArrayList<String> E0030ErrorScenarios = new ArrayList<>();
      E0030ErrorScenarios.add("If the entity Action is any of these like create, delete, replace, restore, update etc and Error in persistance" +
            " in data store, due to any issue while getting data from store or while putting data into store, related to ES.");
      errors.add(new Errors("E0030", E0030ErrorScenarios));

      ArrayList<String> E0619ErrorScenarios = new ArrayList<>();
      E0619ErrorScenarios.add("If there is any error while creating event, which will be send to request tracking part to create request object.");
      errors.add(new Errors("E0619", E0619ErrorScenarios));

      ArrayList<String> E0310ErrorScenarios = new ArrayList<>();
      E0310ErrorScenarios.add("Failed to create/update/delete any config object into/from data store i.e, from elastic or blob");
      errors.add(new Errors("E0310", E0310ErrorScenarios));

      ArrayList<String> E0004ErrorScenarios = new ArrayList<>();
      E0004ErrorScenarios.add("If the entity Action is any of these like create, delete, replace, restore, update etc and Error in persistance"+
            " in data store, due to any issue while getting data from store or while putting data into store, related to Blob store.");
      errors.add(new Errors("E0004", E0004ErrorScenarios));

      ArrayList<String> W0012ErrorScenarios = new ArrayList<>();
      W0012ErrorScenarios.add("If the post process to manage request chain crosses the recursion limit consider 5 is the recursion limit, then we generate this error");
      errors.add(new Errors("W0012", W0012ErrorScenarios));

      ArrayList<String> E0129ErrorScenarios = new ArrayList<>();
      E0129ErrorScenarios.add("Any programmatic Exception in EntityCompareAndProcessBolt.");
      E0129ErrorScenarios.add("Any programmatic Exception in EntityManageModelBolt.");
      E0129ErrorScenarios.add("Any programmatic Exception in EntityManageProcessBolt.");
      E0129ErrorScenarios.add("Any programmatic Exception in EntityManageObjectOperationBolt.");
      errors.add(new Errors("E0129", E0129ErrorScenarios));

      return  errors;
   }
}
