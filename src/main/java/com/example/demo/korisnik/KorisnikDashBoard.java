package com.example.demo.korisnik;

import com.example.demo.Login.Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class KorisnikDashBoard extends JFrame {
    private JButton nazad;
    private JButton prikazi_knjige;
    private JTable table1;
    private JLabel labl;
    private JTextField kor_ime;
    private JButton clanarina_dugovi;
    private javax.swing.JPanel JPanel;

    public KorisnikDashBoard() {
        initComponents(); // Call initComponents first
        Connect(); // Then connect to the database

        nazad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });
    }

    private void initComponents() {
        JPanel = new JPanel();
        prikazi_knjige = new JButton("Prikaži knjige");
        table1 = new JTable();
        JScrollPane scrollPane = new JScrollPane(table1);

        // Add components to JPanel with appropriate layout
        JPanel.setLayout(new BoxLayout(JPanel, BoxLayout.Y_AXIS));
        JPanel.add(prikazi_knjige);
        JPanel.add(Box.createVerticalStrut(10)); // Add some spacing between components
        JPanel.add(scrollPane);
        JPanel.add(Box.createVerticalStrut(10)); // Add some spacing between components
        JPanel.add(new JLabel("Korisničko ime: "));
        JPanel.add(kor_ime);
        JPanel.add(clanarina_dugovi);

        // Adjust the alignment of components
        prikazi_knjige.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        scrollPane.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        kor_ime.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        clanarina_dugovi.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        // Add nazad button to JPanel
        nazad = new JButton("Nazad");
        JPanel.add(Box.createVerticalStrut(10)); // Add some spacing between components
        JPanel.add(nazad);

        setContentPane(JPanel);
        setTitle("Korisnik");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);
        setResizable(false);

        prikazi_knjige.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchBooks();
            }
        });

        setVisible(true);
    }

    Connection con;
    PreparedStatement pst;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibl", "root", "15082003");
//            JOptionPane.showMessageDialog(null, "Connected to Database");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Failed to connect to Database");
            ex.printStackTrace();
        }
    }

    private void fetchBooks() {
        try {
            pst = con.prepareStatement("SELECT * FROM bibl.knjiga");  // Use the correct table name
            ResultSet rs = pst.executeQuery();

            // The column names should match the ones in the database
            String[] columnNames = {"idKnjige", "naziv", "broj_dostupnih_knjiga", "dostupnost"};

            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0);  // Clear the model before adding new rows
            model.setColumnIdentifiers(columnNames);

            while (rs.next()) {
                // Use the correct method to fetch the data based on the data type
                model.addRow(new Object[]{
                        rs.getInt("idKnjige"),
                        rs.getString("naziv"),
                        rs.getInt("broj_dostupnih_knjiga"),
                        rs.getString("dostupnost")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fetching books: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

//    public static void main(String[] args) {
//        new KorisnikDashBoard();
//    }
}
