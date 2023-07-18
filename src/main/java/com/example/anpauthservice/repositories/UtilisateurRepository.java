package com.example.anpauthservice.repositories;

import com.example.anpauthservice.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByUsername(String username);

    default Utilisateur saveWithUsername(Utilisateur utilisateur) {
        utilisateur.setEmail(utilisateur.getUsername()); // Set the email from the userName
        return save(utilisateur);
    }
}
