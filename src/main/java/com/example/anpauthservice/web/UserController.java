package com.example.anpauthservice.web;

import com.example.anpauthservice.DTOs.UserProfileDTO;
import com.example.anpauthservice.services.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private AuthentificationService authentificationService;

    @GetMapping("/")
    public String helloUserController(){
        return "user access level";
    }

    public Object authentication(Authentication authentication){
        return  authentication.getName();
    }

    @GetMapping("/profile")
    @ResponseBody
    public UserProfileDTO profile(Authentication authentication){
        return authentificationService.profile(authentication.getName());
    }
}
