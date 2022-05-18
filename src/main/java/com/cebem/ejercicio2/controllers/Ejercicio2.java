package com.cebem.ejercicio2.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


import com.cebem.ejercicio2.models.Data;
import com.cebem.ejercicio2.models.Translation;
import com.cebem.ejercicio2.services.DataService;
import com.cebem.ejercicio2.services.TranslationService;
import com.cebem.ejercicio2.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class Ejercicio2 {
    @Autowired
    DataService dataService;

    @Autowired
    TranslationService translationService;    

@GetMapping("/contar/{word}")
public String getNumberOfCharacters(@PathVariable String word) {
    int cVocales=0;
    int cConsonantes=0;

    for (int i=0; i<word.length();i++){
        if (word.charAt(i)=='a'||word.charAt(i)=='e'||word.charAt(i)=='i'||word.charAt(i)=='o'||word.charAt(i)=='u'){
            cVocales++;
        }else{
            cConsonantes++;
        }
    }
    return "La palabra introducida tiene "+cVocales+" vocales y "+cConsonantes+" consonantes.";
}

@GetMapping(value = "/guarda")
public String addData(@RequestParam String name, @RequestParam String surname, @RequestParam String age) {
    Data data = new Data();
    data.setName(name);
    data.setSurname(surname);
    data.setAge(age);
    dataService.saveData(data);
    return "Informacion guardada correctamente";
}

@GetMapping("/listar")
    public String dataList(){
        ArrayList<Data> data = dataService.getAllData();
        String listado = "";
        for(Data d: data){
            listado+= d.getName()+", ";
            listado+= d.getSurname()+", ";
            listado+= d.getAge();
            listado += "<br/>";
        }
        return listado;
    }

@GetMapping("/{word}")
public String transformWord(@PathVariable String word){
    String transformed=Utils.toUpper(word);
    return transformed;
}


@GetMapping("/traduce/{word}")
public String translateWord(@PathVariable String word){ 
    Translation translation= translationService.getTranslatedWord(word);
    return translation.responseData.translatedText;
}

}


