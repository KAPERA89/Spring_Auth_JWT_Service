package com.example.anpauthservice.repositories;
import com.example.anpauthservice.models.Etat_Releve;
import com.example.anpauthservice.models.Releve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface ReleveRepository extends JpaRepository<Releve, Long> {
    List<Releve> findByMoisConsommationContains(String Mois_Consommation);
    Optional<Releve> findById(Long id);
    @Query("SELECT r FROM Releve r WHERE r.date_releve =:date")
    List<Releve> findByDate_releve(@Param("date")Date date);
    List<Releve> findByEtatreleve(Etat_Releve etat_releve);
}
