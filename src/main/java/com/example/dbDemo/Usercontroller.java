package com.example.dbDemo;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class Usercontroller {

    @Autowired
    UserService userService;

    @GetMapping("/getById")
    public ResponseEntity getUserById(@RequestParam("id")Integer id){

        try {
            UserInfo userInfo = userService.getUserById(id);
            return new ResponseEntity(userInfo, HttpStatus.OK);
        }catch (Exception e){
            log.error("This is an error and "+e.getMessage());
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/add")
    public String addUserInfo(@RequestBody UserInfo userInfo){
        return userService.addUser(userInfo);
    }


    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam("id")Integer id){
        return userService.deleteUserById(id);
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestParam("id")Integer id,@RequestParam("email")String email){

        return userService.updateEmail(id,email);
    }

    @GetMapping("/findUserAboveAge")
    public List<UserInfo> getUserInfoList(@RequestParam("age")Integer age){


    }
}
