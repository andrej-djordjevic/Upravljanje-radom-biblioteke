package com.example.demo.ZaposleniDashBoard;

import com.example.demo.Login.Login;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ZaposleniDashBoardKorisnik extends JFrame {
    private JButton kreirajKorisnikaButton;
    private JButton kreirajKnjiguButton;
    private JButton prikaziKnjigeButton;
    private JButton nazad;
    private JTable table1;
    private javax.swing.JPanel JPanel;

    public  ZaposleniDashBoardKorisnik(){
        setContentPane(JPanel);
        kreirajKnjiguButton.setEnabled(false);
        kreirajKorisnikaButton.setEnabled(false);
        setTitle("Zaposleni");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(400, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        initTable();
        setVisible(true);
        prikaziKnjigeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    ZaposleniDashBoardKnjige zaposleniDashBoardKnjige= new ZaposleniDashBoardKnjige();
                    zaposleniDashBoardKnjige.setVisible(true);
                    dispose();
            }
        });
        nazad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });
    }

    private void initTable() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"korisnicko_ime", "email", "ime", "password", "rola", "vrsta_clanarine"}, 0);
        table1.setModel(model);

        model.addTableModelListener(e -> {

            int row = e.getFirstRow();
            int column = e.getColumn();
            if (column != TableModelEvent.ALL_COLUMNS) {
                Object data = model.getValueAt(row, column);
                // Call method to update the database
                updateDatabase(row, column, data);
            }
        });



        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibl", "root", "15082003"); // Replace with your database details
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM korisnik");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void updateDatabase(int row, int column, Object newData) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibl", "root", "15082003");
            String columnName = table1.getColumnName(column);
            Object idValue = table1.getValueAt(row, 0);
            String sql = "UPDATE korisnik SET " + columnName + " = ? WHERE korisnicko_ime = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, newData);
            pstmt.setObject(2, idValue);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } }



//    public static void main(String[] args) {
//        new ZaposleniDashBoardKorisnik();
//    }
}
