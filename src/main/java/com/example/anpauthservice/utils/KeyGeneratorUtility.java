package com.example.anpauthservice.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

//permet de generer des cles RSA
//pour coder et decoder Jwts

public class KeyGeneratorUtility {
    public static KeyPair generateRsaKey(){
        KeyPair keyPair;

        try{
            //permet de cree une instance pour utiliser l'algorith RSA
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();

        }catch(Exception e){
            throw new IllegalStateException();
        }

        return  keyPair;
    }
}
