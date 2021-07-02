package com.example.remainder.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.remainder.pojo.LoginUser;

public interface UserRepository extends MongoRepository<LoginUser,String> 
{

}
