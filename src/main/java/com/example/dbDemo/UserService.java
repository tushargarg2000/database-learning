package com.example.dbDemo;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public String addUser(UserInfo userInfo){

        userRepository.save(userInfo);

        return "User has been added to the db succesfully";

    }

    public UserInfo getUserById(Integer userId)throws Exception{

        Optional<UserInfo> optionalUserInfo = userRepository.findById(userId);

        if(!optionalUserInfo.isPresent()){
             throw new Exception("User with Id is not present");
        }

        UserInfo userInfo = optionalUserInfo.get();

        return userInfo;

    }

    public String deleteUserById(Integer id){
        if(userRepository.existsById(id)==true){
            userRepository.deleteById(id);
            return "User with Id is deleted";
        }else {
            return "UserId was invalid";
        }
    }

    public String updateEmail(Integer userId,String newEmail){

        Optional<UserInfo> optionalUserInfo = userRepository.findById(userId);

        //Handle that not present case : Exception handling should be there

        UserInfo userInfo = optionalUserInfo.get();
        userInfo.setEmail(newEmail);
        userRepository.save(userInfo);
        return "Email updated successfully";
    }


    public List<UserInfo> getUsersAboveAge(Integer age)
    {
        List<UserInfo> allUsers = userRepository.findAll();
        List<UserInfo> ansList = new ArrayList<>();

        for(UserInfo userInfo : allUsers){
            if(userInfo.getAge()>age){
                ansList.add(userInfo);
            }
        }
        return ansList;
    }
}
