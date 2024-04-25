package com.example.demo.knjiga;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.demo.ZaposleniDashBoard.ZaposleniDashBoardKnjige;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class DodajKnjigu extends JFrame {



    private JLabel label1;
    private JLabel label2;
    private JTextField tfmbroj_dostupnih;
    private JTextField tfnaziv_knjige;
    private JButton dodaj_knjigu;
    private JPanel Panel;
    private JButton back;


    private KnjigaService knjigaService; // Spring-managed service

        public DodajKnjigu(KnjigaService service) {
            this.knjigaService = service;
            initComponents();
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ZaposleniDashBoardKnjige zaposleniDashBoardKnjige = new ZaposleniDashBoardKnjige();
                    zaposleniDashBoardKnjige.setVisible(true);
                    dispose();
                }
            });
        }

        private void initComponents() {
            // initialize and set up your components

            dodaj_knjigu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String naziv = tfnaziv_knjige.getText();
                    Integer br_dostupnih = Integer.valueOf(tfmbroj_dostupnih.getText());
                    boolean dostupnost = br_dostupnih > 0;

                    knjigaService.addKnjigaToDatabase(naziv, br_dostupnih, dostupnost);

                    JOptionPane.showMessageDialog(null, "Korisnik je uspesno unet!");
                }

            });

            setContentPane(Panel);
            setTitle("Nasolv");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(300,250);
            setLocationRelativeTo(null);
            setResizable(false);
            setVisible(true);
        }

        public static void main(String[] args) {
            ConfigurableApplicationContext ctx = SpringApplication.run(UnesiKnjigu.class, args);
            KnjigaService service = ctx.getBean(KnjigaService.class);
            new com.example.demo.knjiga.DodajKnjigu(service);
        }
    }


