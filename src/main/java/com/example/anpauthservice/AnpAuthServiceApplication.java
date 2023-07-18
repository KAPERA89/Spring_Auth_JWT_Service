package com.example.anpauthservice;

import com.example.anpauthservice.models.Role;
import com.example.anpauthservice.models.Utilisateur;
import com.example.anpauthservice.repositories.RoleRepository;
import com.example.anpauthservice.repositories.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AnpAuthServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(AnpAuthServiceApplication.class, args);
    }

    //@Bean
    CommandLineRunner run(
                          RoleRepository roleRepository,
                          UtilisateurRepository utilisateurRepository,
                          PasswordEncoder passwordEncoder){
        return args -> {
            //if(roleRepository.findByAuthoriry("VALIDATEUR").isPresent()) return;
            //Role validateurRole = roleRepository.save(new Role("VALIDATEUR"));
            Role validateurRole = roleRepository.findByAuthoriry("VALIDATEUR").get();
            Set<Role> roles = new HashSet<>();
            roles.add(validateurRole);

            Utilisateur validateur = new Utilisateur("othmaneVAL3", "darhoniVal3", "adresseVal3", "othmaneVal3@gmail.com", passwordEncoder.encode("password123"), roles);
            utilisateurRepository.saveWithUsername(validateur);
        };
    }



}
