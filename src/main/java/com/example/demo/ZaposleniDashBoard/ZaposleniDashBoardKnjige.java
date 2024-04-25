package com.example.demo.ZaposleniDashBoard;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.sql.*;

import com.example.demo.Login.Login;
import com.example.demo.knjiga.DodajKnjigu;
import com.example.demo.knjiga.KnjigaService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.SpringApplication;
import com.example.demo.korisnik.UnosKorisnikaDashBoard;
import com.example.demo.korisnik.KorisnikService;

public class ZaposleniDashBoardKnjige extends JFrame {
    private JPanel JPanel;
    private JTable table1;
    private JButton kreirKorisnika;
    private JButton kreirKnjigu;
    private JButton nazad;
    private JButton prikaziKorisnike;
    private JTable table2;
    private JButton button4Button;


    public ZaposleniDashBoardKnjige() {
        setContentPane(JPanel);
kreirKnjigu.setEnabled(false);
kreirKorisnika.setEnabled(false);
        setTitle("Zaposleni");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(300, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        initTable();
        setVisible(true);
        kreirKorisnika.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfigurableApplicationContext ctx = SpringApplication.run(ZaposleniDashBoardKnjige.class);
                KorisnikService service = ctx.getBean(KorisnikService.class);
                kreirKorisnika.addActionListener(ee -> new UnosKorisnikaDashBoard(service));

            }
        });
        kreirKnjigu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfigurableApplicationContext ctx = SpringApplication.run(ZaposleniDashBoardKnjige.class);
                KnjigaService service = ctx.getBean(KnjigaService.class);
                kreirKnjigu.addActionListener(ee -> new DodajKnjigu(service));
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

        prikaziKorisnike.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZaposleniDashBoardKorisnik zaposleniDashBoardKorisnik= new ZaposleniDashBoardKorisnik();
                zaposleniDashBoardKorisnik.setVisible(true);
                dispose();
            }
        });

    }


    private void initTable() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"idKnjige", "naziv","broj_dostupnih_knjiga","dostupnost"}, 0);
        table1.setModel(model);
        model.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (column != TableModelEvent.ALL_COLUMNS) {
                Object data = model.getValueAt(row, column);

                updateDatabase(row, column, data);
            }
        });

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibl", "root", "15082003");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM knjiga");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2),rs.getInt(3),rs.getString(4)});
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
            String sql = "UPDATE knjiga SET " + columnName + " = ? WHERE idKnjige = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setObject(1, newData);
            pstmt.setObject(2, idValue);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void table1(){

    }

//    public static void main(String[] args) {
//        new ZaposleniDashBoardKnjige();
//    }
}
