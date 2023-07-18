package com.example.anpauthservice.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDTO {

    private String nom;
    private String prenom;
    private String adresse;
    private String username;
    private String password;
}
