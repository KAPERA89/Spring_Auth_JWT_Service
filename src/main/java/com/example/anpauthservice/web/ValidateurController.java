package com.example.anpauthservice.web;

import com.example.anpauthservice.DTOs.UserProfileDTO;
import com.example.anpauthservice.services.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validateur")
@CrossOrigin("*")
public class ValidateurController {

    @Autowired
    private AuthentificationService authentificationService;

    @GetMapping("/")
    public String helloValidateurController(){
        return "validateur access level";
    }

    @GetMapping("/profile")
    @ResponseBody
    public UserProfileDTO profile(Authentication authentication){
        return authentificationService.profile(authentication.getName());
    }
}
