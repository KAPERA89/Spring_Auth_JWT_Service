package com.example.anpauthservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Releve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String moisConsommation;

    @Temporal(TemporalType.DATE)
    private Date date_releve;

    @Enumerated(EnumType.STRING)
    private Etat_Releve etatreleve = Etat_Releve.EMIS;

    private Long num_facture;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "utilisateur_id")
    @JsonIgnore
    private Utilisateur utilisateur;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facture_id", referencedColumnName = "id")
    private Facture facture;


    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedAt", nullable = false, updatable = false)
    private Date Created_At;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Updated_At")
    private Date Updated_At;


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
