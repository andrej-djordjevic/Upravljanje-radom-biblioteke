package com.example.demo.korisnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService {

    private final KorisnikInterfejs repository;

    @Autowired
    public KorisnikService(KorisnikInterfejs repository) {
        this.repository = repository;
    }

    public void addKorisnikToDatabase(String korisnickoIme, String sifra, String ime, String email, String rola, String vrsta) {
        Korisnik newKorisnik = new Korisnik(korisnickoIme, sifra, ime, email, rola, vrsta);
        repository.save(newKorisnik);
    }
}
