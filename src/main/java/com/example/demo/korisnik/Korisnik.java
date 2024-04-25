package com.example.demo.korisnik;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Korisnik {
    @Id
    private String korisnicko_ime;
    private String password;
    private String ime;
    private String email;
    private String rola;
    private String vrstaClanarine;

    public Korisnik(String korisnicko_ime, String password, String ime, String email, String rola, String vrstaClanarine) {
        this.korisnicko_ime = korisnicko_ime;
        this.password = password;
        this.ime = ime;
        this.email = email;
        this.rola = rola;
        this.vrstaClanarine = vrstaClanarine;
    }

    public Korisnik() {

    }

    public String getVrstaClanarine() {
        return vrstaClanarine;
    }

    public void setVrstaClanarine(String vrstaClanarine) {
        this.vrstaClanarine = vrstaClanarine;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setKorisnicko_ime(String korisnickoIme) {
        this.korisnicko_ime = korisnickoIme;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "korisnicko_ime=" + korisnicko_ime +
                ", password='" + password + '\'' +
                ", ime='" + ime + '\'' +
                ", email='" + email + '\'' +
                ", rola='" + rola + '\'' +
                ", vrstaClanarine='" + vrstaClanarine + '\'' +
                '}';
    }
}
