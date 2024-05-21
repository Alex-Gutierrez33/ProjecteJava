import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


public class VentanaAfegirUsuaris extends JFrame {
    JLabel text1, text2, text3, text4, text5, text6;
    JTextField nomUsuari, cognomUsuari, emailUsuari, telefonUsuari, dataUsuari;
    JComboBox<String> rolUsuari;
    JButton btnAfegir;

    public VentanaAfegirUsuaris() {
        
        setTitle("Usuari");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2));

        text1 = new JLabel("Nom: ");
        add(text1);

        nomUsuari = new JTextField();
        add(nomUsuari);

        text2 = new JLabel("Cognom: ");
        add(text2);

        cognomUsuari = new JTextField();
        add(cognomUsuari);

        text3 = new JLabel("Email: ");
        add(text3);

        emailUsuari = new JTextField();
        add(emailUsuari);

        text4 = new JLabel("Telefon: ");
        add(text4);

        telefonUsuari = new JTextField();
        add(telefonUsuari);

        text5 = new JLabel("Rol: ");
        add(text5);

        rolUsuari = new JComboBox<>(new String[]{"lector", "bibliotecari"});
        add(rolUsuari);

        text6 = new JLabel("Data d'avui: (YYYY-MM-DD): " );
        add(text6);

        dataUsuari = new JTextField();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        dataUsuari.setText(formatoFecha.format(new Date()));
        add(dataUsuari);

        btnAfegir = new JButton("Afegir Usuari");
        add(btnAfegir);


        setVisible(true);


        btnAfegir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = nomUsuari.getText();
                String cognoms = cognomUsuari.getText();
                String email = emailUsuari.getText();
                String telefon = telefonUsuari.getText();


                if (nom.equals("") && cognoms.equals("") && email.equals("") && telefon.equals("")) {
                    JOptionPane.showMessageDialog(VentanaAfegirUsuaris.this, "Error: Camps buits", "Error", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }


                if (telefon.length() != 9) {
                    JOptionPane.showMessageDialog(VentanaAfegirUsuaris.this, "Telefon incorrecte", "Error", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                if (!email.contains("@")) {
                    JOptionPane.showMessageDialog(VentanaAfegirUsuaris.this, "Correu electronic incorrecte", "Error", JOptionPane.INFORMATION_MESSAGE);
                    return;
                    
                }


                String rol = (String) rolUsuari.getSelectedItem();
                String data = dataUsuari.getText();

                Usuaris usuari = new Usuaris();
                usuari.afegirUsuaris(nom, cognoms, email, telefon, rol, data);
                dispose();
            }
        });
    }
}
