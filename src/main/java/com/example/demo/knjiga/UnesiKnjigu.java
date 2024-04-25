package com.example.demo.knjiga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.*;

@SpringBootApplication
public class UnesiKnjigu extends JFrame{

    private final KnjigaService knjigaService;

    @Autowired
    public UnesiKnjigu(KnjigaService knjigaService) {
        this.knjigaService = knjigaService;
    }

    public static void main(String[] args) {
        SpringApplication.run(UnesiKnjigu.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return (args -> {

        });
    }
}
