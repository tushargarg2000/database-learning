package com.example.dbDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public String addUser(UserInfo userInfo){

        userRepository.save(userInfo);

        return "User has been added to the db succesfully";

    }




}
