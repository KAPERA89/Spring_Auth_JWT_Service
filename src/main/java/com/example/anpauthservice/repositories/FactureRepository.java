package com.example.anpauthservice.repositories;

import com.example.anpauthservice.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {
}
