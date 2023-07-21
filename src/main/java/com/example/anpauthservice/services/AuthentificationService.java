package com.example.anpauthservice.services;

import com.example.anpauthservice.DTOs.LoginDTO;
import com.example.anpauthservice.DTOs.UserDTO;
import com.example.anpauthservice.DTOs.UserProfileDTO;
import com.example.anpauthservice.models.Role;
import com.example.anpauthservice.models.Utilisateur;
import com.example.anpauthservice.repositories.RoleRepository;
import com.example.anpauthservice.repositories.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class AuthentificationService {
    private UtilisateurRepository utilisateurRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private TokenService tokenService;


    public Utilisateur register(String nom, String prenom, String adresse, String username, String password){
         String encodedPassword = passwordEncoder.encode(password);
         Role userRole = roleRepository.findByAuthoriry("USER").get();
         Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);
         return utilisateurRepository.save(new Utilisateur(nom,prenom,adresse,username,encodedPassword, authorities));
    }

    public LoginDTO loginUser(String username, String password){
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            return new LoginDTO(utilisateurRepository.findByUsername(username).get(), token);

        } catch(AuthenticationException e){
            return new LoginDTO(null, "");
        }
    }

    public UserProfileDTO profile(String username){
        return new UserProfileDTO(utilisateurRepository.findByUsername(username).get());
    }

    public UserDTO prfile(String username){
      Utilisateur utilisateur = utilisateurRepository.findByEmail(username);
        return new UserDTO(utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getUsername(),utilisateur.getAdresse());

   }

   public String nomPrenom(String username){
        Utilisateur utilisateur = utilisateurRepository.findByEmail(username);
        String nomPrenom = utilisateur.getNom()+" "+ utilisateur.getPrenom();
        return nomPrenom;
   }
}
