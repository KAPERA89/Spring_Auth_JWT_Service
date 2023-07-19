package com.example.anpauthservice.web;

import com.example.anpauthservice.DTOs.LoginDTO;
import com.example.anpauthservice.DTOs.RegisterDTO;
import com.example.anpauthservice.DTOs.UserProfileDTO;
import com.example.anpauthservice.models.Utilisateur;
import com.example.anpauthservice.services.AuthentificationService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/auth")
@CrossOrigin("*")
@AllArgsConstructor
public class AuthenticationController {

    private AuthentificationService authentificationService;

    @PostMapping(path = "/register")
    public Utilisateur register(@RequestBody RegisterDTO registerDTO){
        return  authentificationService.register(
                registerDTO.getNom(),
                registerDTO.getPrenom(),
                registerDTO.getAdresse(),
                registerDTO.getUsername(),
                registerDTO.getPassword()
        );
    }

    @PostMapping("/login")
    public LoginDTO loginUser(@RequestBody RegisterDTO body){
        return authentificationService.loginUser(body.getUsername(), body.getPassword());
    }


}
