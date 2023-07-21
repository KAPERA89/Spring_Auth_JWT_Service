package com.example.anpauthservice.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String nom;
    private String prenom;
    private String username;
    private String adresse;
}
