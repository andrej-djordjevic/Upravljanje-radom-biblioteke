package com.example.demo.Login;

import com.example.demo.ZaposleniDashBoard.*;
import com.example.demo.korisnik.KorisnikDashBoard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Login extends JFrame {
    private JButton zaposleni;
    private JButton korisnik;
    private JPanel JPanel; // Renamed for clarity
    private JLabel labela;

    public Login() {
        // Initialize panel and components
        JPanel = new JPanel(); // Instantiate JPanel correctly
        zaposleni = new JButton("Zaposleni");
        korisnik = new JButton("Korisnik");


        // Adding components to panel
        JPanel.add(labela);
        JPanel.add(zaposleni);
        JPanel.add(korisnik);

        // Setting layout manager for JPanel (optional here as FlowLayout is default)
        JPanel.setLayout(new java.awt.FlowLayout());

        // Set panel to frame
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

        // Setup JFrame properties
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocationRelativeTo(null); // Center the window
        setResizable(false);

        // Make frame visible after all components added
        setVisible(true);
    }



    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
    }
}


