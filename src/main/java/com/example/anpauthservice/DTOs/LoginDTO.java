package com.example.anpauthservice.DTOs;

import com.example.anpauthservice.models.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class LoginDTO {
    private Utilisateur utilisateur;
    private String jwt;

    public LoginDTO(){
        super();
    }

    public LoginDTO(Utilisateur user, String jwt){
        this.utilisateur = user;
        this.jwt = jwt;
    }

    public Utilisateur getUser(){
        return this.utilisateur;
    }

    public void setUser(Utilisateur user){
        this.utilisateur = user;
    }

    public String getJwt(){
        return this.jwt;
    }

    public void setJwt(String jwt){
        this.jwt = jwt;
    }

}
