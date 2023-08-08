package com.example.dbDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    UserService userService;

    @GetMapping("/getById")
    public String getUserById(@RequestParam("id")Integer id){


        return "";

    }

    @PostMapping("/add")
    public String addUserInfo(@RequestBody UserInfo userInfo){
        return userService.addUser(userInfo);
    }

}
