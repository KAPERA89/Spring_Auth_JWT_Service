package com.example.anpauthservice.web;

import com.example.anpauthservice.DTOs.UserProfileDTO;
import com.example.anpauthservice.models.Utilisateur;
import com.example.anpauthservice.repositories.UtilisateurRepository;
import com.example.anpauthservice.services.AuthentificationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
@AllArgsConstructor
public class UserController {

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
