package com.example.anpauthservice.services.Releve;

import com.example.anpauthservice.DTOs.ReleveDTO;
import com.example.anpauthservice.DTOs.UserDTO;
import com.example.anpauthservice.mappers.ReleveMapper;
import com.example.anpauthservice.models.Etat_Releve;
import com.example.anpauthservice.models.Releve;
import com.example.anpauthservice.models.Utilisateur;
import com.example.anpauthservice.repositories.ReleveRepository;
import com.example.anpauthservice.repositories.UtilisateurRepository;
import com.example.anpauthservice.DTOs.Request.ReleveRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class ReleveServiceImpl implements ReleveService{

    private ReleveRepository releveRepository;
    private ReleveMapper releveMapper;
    private UtilisateurRepository utilisateurRepository;


    //Voir la liste des releves
    @Override
    public List<ReleveDTO> getAllReleve() {
        List<Releve> releves = releveRepository.findAll();
        List<ReleveDTO> releveDTOS = releves.stream()
                .map(releve -> releveMapper.fromReleve(releve))
                .collect(Collectors.toList());
        return releveDTOS;
    }

    //permet d'ajouter un releve
    @Override
    public ReleveDTO saveReleve(ReleveRequest releveRequest) {
        Utilisateur utilisateur = utilisateurRepository.findByUserId(releveRequest.getUserId());

        Releve releve = new Releve();
        releve.setMoisConsommation(releveRequest.getMoisConsommation());
        releve.setDate_releve(new Date());

        releve.setNum_facture(releveRequest.getNumFacture());
        releve.setUtilisateur(utilisateur);


        return releveMapper.fromReleve(releveRepository.save(releve));
    }

    //chercher des releve par mois
    @Override
    public List<ReleveDTO> getReleveMois(String mois) {
        List<Releve> releve = releveRepository.findByMoisConsommationContains(mois);
        List<ReleveDTO> releveDTOS = releve.stream().map(r -> releveMapper.fromReleve(r)).collect(Collectors.toList());
        return releveDTOS;
    }


    //consulter un releve
    public ReleveDTO getReleveId(Long id){
        Releve releve = releveRepository.findById(id).orElseThrow();
        return releveMapper.fromReleve(releve);
    }

    @Override
    public List<ReleveDTO> getReleveDate(Date date) {
        List<Releve> releves=  releveRepository.findByDate_releve(date);
        List<ReleveDTO> releveDTOS = releves.stream().map(r -> releveMapper.fromReleve(r)).collect(Collectors.toList());
        return releveDTOS;
    }

    @Override
    public List<ReleveDTO> getReleveEtat(Etat_Releve etat_releve) {
        List<Releve> releves=  releveRepository.findByEtatreleve(etat_releve);
        List<ReleveDTO> releveDTOS = releves.stream().map(r -> releveMapper.fromReleve(r)).collect(Collectors.toList());
        return releveDTOS;
    }

}
