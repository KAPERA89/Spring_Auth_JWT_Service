package com.example.anpauthservice.DTOs;

import com.example.anpauthservice.models.Etat_Releve;
import com.example.anpauthservice.models.Facture;
import com.example.anpauthservice.models.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.Date;

@Data
public class ReleveDTO{
    public Long id;
    private String moisConsommation;
    private Date date_releve;
    private Etat_Releve etatreleve;
    private Long num_facture;
    private Utilisateur utilisateur;
    private Facture facture;
    private String createdBy;
    private String lastModifiedBy;
    private Date Created_At;
    private Date Updated_At;
}
