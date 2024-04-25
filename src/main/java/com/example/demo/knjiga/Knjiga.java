package com.example.demo.knjiga;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Knjiga {
    @Id
    @GeneratedValue
    private  int id;
    private String naziv;
    private int broj_dostupnih_knjiga;
    private boolean dostupnost;

    public Knjiga(String naziv, int broj_dostupnih_knjiga, boolean dostupnost) {
        this.naziv = naziv;
        this.broj_dostupnih_knjiga = broj_dostupnih_knjiga;
        this.dostupnost = dostupnost;

    }
    public Knjiga(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id =id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBroj_dostupnih_knjiga() {
        return broj_dostupnih_knjiga;
    }

    public void setBroj_dostupnih_knjiga(int broj_dostupnih_knjiga) {
        this.broj_dostupnih_knjiga = broj_dostupnih_knjiga;
    }

    public boolean isDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(boolean dostupnost) {
        this.dostupnost = dostupnost;
    }
}
