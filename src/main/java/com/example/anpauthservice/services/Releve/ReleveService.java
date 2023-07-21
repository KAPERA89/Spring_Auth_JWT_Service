package com.example.anpauthservice.services.Releve;

import com.example.anpauthservice.DTOs.ReleveDTO;
import com.example.anpauthservice.DTOs.Request.ReleveRequest;
import com.example.anpauthservice.models.Etat_Releve;

import java.util.Date;
import java.util.List;

public interface ReleveService {
        List<ReleveDTO> getAllReleve();

        ReleveDTO saveReleve(ReleveRequest releveRequest);

        List<ReleveDTO> getReleveMois(String mois);

        ReleveDTO getReleveId(Long id);
        List<ReleveDTO> getReleveDate(Date date);

        List<ReleveDTO> getReleveEtat(Etat_Releve etat_releve);

}
