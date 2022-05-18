package com.cebem.ejercicio2.services;

import com.cebem.ejercicio2.models.Translation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TranslationService{
    @Autowired
    RestTemplate restTemplate;

    public Translation getTranslatedWord(String spanishWord){
       String url = "https://api.mymemory.translated.net/get?q="+spanishWord+"&langpair=es|en";
       Translation translation =restTemplate.getForObject(url, Translation.class);
       return translation;
    }
}