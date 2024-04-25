package com.example.demo.korisnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.*;

@SpringBootApplication
public class UnesiKorisnika extends JFrame {

   private final KorisnikService korisnikService;

    @Autowired
    public UnesiKorisnika(KorisnikService korisnikService) {
       this.korisnikService = korisnikService;
    }

    public static void main(String[] args) {
        SpringApplication.run(UnesiKorisnika.class, args);
    }

    @Bean
    public CommandLineRunner run(){
        return (args->{
          //  korisnikService.addKorisnikToDatabase("KorIme7", "Sifra3", "Ime3", "Email3", "Rola3", "Vrsta3");
            //korisnikService.addKorisnikToDatabase("KorIme4", "Sifra4", "Ime4", "Email4", "Rola4", "Vrsta4");
            // etc...
        });
    }
}
