package com.example.demo.knjiga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnjigaService {

    private final KnjigaInterfejs repository;

    @Autowired
    public KnjigaService(KnjigaInterfejs repository) {
        this.repository = repository;
    }

    public void addKnjigaToDatabase(String naziv, int brojDostupnihKnjiga, boolean dostupnost) {
        Knjiga newKnjiga = new Knjiga(naziv, brojDostupnihKnjiga, dostupnost);
        repository.save(newKnjiga);
    }
}
