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

        });
    }
}
