package com.example.anunturi.repository;

import com.example.anunturi.model.Ad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
//Repozitoriul se extinde de la CrudRepository
public interface AdsRepository extends CrudRepository<Ad, Long> {
    //Lista cu toate anunturile
    List<Ad> findAll();
    //Cautarea dupa Id
    Ad findById(long id);
}
