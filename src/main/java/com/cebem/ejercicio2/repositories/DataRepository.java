package com.cebem.ejercicio2.repositories;

import com.cebem.ejercicio2.models.Data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends CrudRepository<Data, Long> {
    
}
