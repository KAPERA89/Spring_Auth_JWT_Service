package com.example.anpauthservice.DTOs.Request;

import com.example.anpauthservice.models.Facture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ReleveRequest {
    private String moisConsommation;
    private Long numFacture;
    private Long userId;
}
