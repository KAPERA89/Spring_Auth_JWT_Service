package com.example.anpauthservice.DTOs;
import com.example.anpauthservice.models.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDTO {
    private Utilisateur utilisateur;

}
