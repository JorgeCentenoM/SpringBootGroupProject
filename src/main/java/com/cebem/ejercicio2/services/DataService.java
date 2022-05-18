package com.cebem.ejercicio2.services;

import java.util.ArrayList;

import com.cebem.ejercicio2.models.Data;
import com.cebem.ejercicio2.repositories.DataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    @Autowired
    DataRepository dataRepository;

    public Data saveData(Data data){
        return dataRepository.save(data);
    }
    
    public ArrayList<Data> getAllData(){
        ArrayList<Data> data = (ArrayList<Data>) dataRepository.findAll();
        return data;
    }
}
