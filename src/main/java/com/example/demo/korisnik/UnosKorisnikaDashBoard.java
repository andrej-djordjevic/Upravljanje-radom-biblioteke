package com.example.demo.korisnik;

import com.example.demo.ZaposleniDashBoard.ZaposleniDashBoardKnjige;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UnosKorisnikaDashBoard extends JFrame {

    private JLabel korisnicko_imee;
    private JLabel lozinka;
    private JLabel ime;
    private JLabel email;
    private JLabel vrsta_clanarine;
    private JButton klikniButton;
    private JPanel Panela;
    private JTextField tflozinka;
    private JTextField tfime;
    private JTextField tfemail;
    private JTextField tfvrsta_clanarine;
    private JTextField textkorime;
    private JButton back;

    private KorisnikService korisnikService; // Spring-managed service

    public UnosKorisnikaDashBoard(KorisnikService service) {
        this.korisnikService = service;
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


        klikniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textkorime.getText().isEmpty())JOptionPane.showMessageDialog(UnosKorisnikaDashBoard.this, "Korisnicko ime ne sme da bude prazno.", "Input Error", JOptionPane.ERROR_MESSAGE);

                if(tflozinka.getText().length()<6)JOptionPane.showMessageDialog(UnosKorisnikaDashBoard.this, "Lozinka mora da ima barem 6 karaktera.", "Input Error", JOptionPane.ERROR_MESSAGE);

                if(tfime.getText().length()<3)JOptionPane.showMessageDialog(UnosKorisnikaDashBoard.this, "Ime mora da ima barem 3 slova.", "Input Error", JOptionPane.ERROR_MESSAGE);

                if(tfemail.getText().length()<11)JOptionPane.showMessageDialog(UnosKorisnikaDashBoard.this, "Unesite validnu e-mail adresu.", "Input Error", JOptionPane.ERROR_MESSAGE);

                if(tfvrsta_clanarine.getText()==null)JOptionPane.showMessageDialog(UnosKorisnikaDashBoard.this, "Izaberite vrstu clanarine.", "Input Error", JOptionPane.ERROR_MESSAGE);

                if(textkorime.getText()!=null&&tflozinka.getText().length()>6&&tfime.getText().length()>2&&tfemail.getText().length()>10&&tfvrsta_clanarine.getText()!=null){
                String ukorisnicko_ime = textkorime.getText();
                String upassword = tflozinka.getText();
                String uime = tfime.getText();
                String uemail = tfemail.getText();
                String uvrstaClanarine = tfvrsta_clanarine.getText();

                korisnikService.addKorisnikToDatabase(ukorisnicko_ime, upassword, uime, uemail, "role", uvrstaClanarine);}
                JOptionPane.showMessageDialog(null,"Korisnik je uspesno unet!");
                tflozinka.setText("");
                tfvrsta_clanarine.setText("");
                tfime.setText("");
                tfemail.setText("");
                textkorime.setText("");
            }
        });

        setContentPane(Panela);
        setTitle("Nasolv");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,350);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(UnesiKorisnika.class, args);
        KorisnikService service = ctx.getBean(KorisnikService.class);
        new UnosKorisnikaDashBoard(service);
    }
}
