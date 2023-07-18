package com.example.anpauthservice.services;

import com.example.anpauthservice.models.Role;
import com.example.anpauthservice.models.Utilisateur;
import com.example.anpauthservice.repositories.RoleRepository;
import com.example.anpauthservice.repositories.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class AuthentificationService {
//    private UtilisateurRepository utilisateurRepository;
//    private RoleRepository roleRepository;
//    private PasswordEncoder passwordEncoder;
//
//    public Utilisateur register(String nom, String prenom, String adresse, String username, String password){
//         String encodedPassword = passwordEncoder.encode(password);
//         Role role = roleRepository.findByAuthoriry("USER").get();
//    }

}
