package com.example.anpauthservice.mappers;

import com.example.anpauthservice.DTOs.ReleveDTO;
import com.example.anpauthservice.DTOs.UserDTO;
import com.example.anpauthservice.models.Releve;
import com.example.anpauthservice.models.Utilisateur;
import org.springframework.beans.BeanUtils;

public class UtilisateurMapper {
    public UserDTO fromUtilisateur(Utilisateur utilisateur){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(utilisateur, userDTO);
        return userDTO;
    }


    public Utilisateur fromUtilisateurDTO(UserDTO userDTO){
        Utilisateur utilisateur = new Utilisateur();
        BeanUtils.copyProperties(userDTO, utilisateur);
        return utilisateur;
    }
}
