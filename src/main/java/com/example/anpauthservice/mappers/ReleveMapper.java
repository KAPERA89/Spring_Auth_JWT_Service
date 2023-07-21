package com.example.anpauthservice.mappers;

import com.example.anpauthservice.DTOs.ReleveDTO;
import com.example.anpauthservice.models.Releve;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class ReleveMapper {

    public ReleveDTO fromReleve(Releve releve){
        ReleveDTO releveDTO = new ReleveDTO();
        BeanUtils.copyProperties(releve, releveDTO);
        return releveDTO;
    }


    public Releve fromReleveDTO(ReleveDTO releveDTO){
        Releve releve = new Releve();
        BeanUtils.copyProperties(releveDTO, releve);
        return releve;
    }

}
