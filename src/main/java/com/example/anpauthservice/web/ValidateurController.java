package com.example.anpauthservice.web;

import com.example.anpauthservice.DTOs.ReleveDTO;
import com.example.anpauthservice.DTOs.Request.ReleveRequest;
import com.example.anpauthservice.DTOs.UserDTO;
import com.example.anpauthservice.models.Etat_Releve;
import com.example.anpauthservice.services.AuthentificationService;
import com.example.anpauthservice.services.Releve.ReleveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/validateur")
@CrossOrigin("*")
public class ValidateurController {

    @Autowired
    private AuthentificationService authentificationService;
    @Autowired
    private ReleveServiceImpl releveService;

    @GetMapping("/")
    public String helloValidateurController(){
        return "validateur access level";
    }

    @GetMapping("/profile")
    @ResponseBody
    public UserDTO profile(Authentication authentication){
        return authentificationService.prfile(authentication.getName());
    }

    //Releve APIs:

    @PostMapping("/addReleve")
    public ReleveDTO saveReleve(@RequestBody ReleveRequest releveRequest){
        return releveService.saveReleve(releveRequest);
    }

    @GetMapping("/all")
    public List<ReleveDTO> getReleve(){
        return releveService.getAllReleve();
    }

    @GetMapping("/mois/{mois}")
    public List<ReleveDTO> getReleveMonth(@PathVariable String mois){
        return releveService.getReleveMois(mois);
    }

    @GetMapping("/releve/{id}")
    public ReleveDTO getReleveId(@PathVariable Long id){
        return releveService.getReleveId(id);
    }

    @GetMapping("/releve")
    public List<ReleveDTO> getReleveDate(@RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy")Date date){
        return releveService.getReleveDate(date);
    }

    @GetMapping("/releve/etat/{etat}")
    public List<ReleveDTO> getReleveEtat(@PathVariable Etat_Releve etat){
        return releveService.getReleveEtat(etat);
    }
}
