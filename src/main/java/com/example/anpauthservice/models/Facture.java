package com.example.anpauthservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numeroFacture")
    private Long num_facture;
    private double montant_ht;
    private double montant_ttc;
    private String created_By;
    private String updated_By;

    private int delai_Facture = 30;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedAt", nullable = false, updatable = false)
    private Date Created_At;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Updated_At")
    private Date Updated_At;

    @ManyToOne
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "facture")
    private List<LigneFacture> ligneFactureList;

    @OneToOne(mappedBy = "facture")
    private Releve releve;

    //methods
    @PrePersist
    protected void onCreate(){
        this.Created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.Updated_At = new Date();
    }

}
