package com.example.demo.Login;

import com.example.demo.ZaposleniDashBoard.*;
import com.example.demo.korisnik.KorisnikDashBoard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Login extends JFrame {
    private JButton zaposleni;
    private JButton korisnik;
    private JPanel JPanel;
    private JLabel labela;

    public Login() {

        JPanel = new JPanel();
        zaposleni = new JButton("Zaposleni");
        korisnik = new JButton("Korisnik");



        JPanel.add(labela);
        JPanel.add(zaposleni);
        JPanel.add(korisnik);


        JPanel.setLayout(new java.awt.FlowLayout());


        setContentPane(JPanel);

        // Add action listeners to buttons
        zaposleni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZaposleniDashBoardKnjige zaposleniDashBoardKnjige = new ZaposleniDashBoardKnjige();
                zaposleniDashBoardKnjige.setVisible(true);
                dispose();
            }
        });

        korisnik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                KorisnikDashBoard korisnikDashBoard = new KorisnikDashBoard();
                korisnikDashBoard.setVisible(true);
                dispose();

            }
        });


        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocationRelativeTo(null);
        setResizable(false);


        setVisible(true);
    }



    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
    }
}


