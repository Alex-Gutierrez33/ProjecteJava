import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaEliminarUsuari extends JFrame{
    JLabel text, text2;
    JTextField nomUsuari, cognomUsuari;
    JButton btnEliminar;
    JButton btnMostrar;

    public VentanaEliminarUsuari(){

        setTitle("Usuari");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6,1));

        text = new JLabel("Indica el nom de l'usuari");
        add(text);

        nomUsuari = new JTextField();
        add(nomUsuari);

        text2 = new JLabel("Indica el cognom de l'usuari");
        add(text2);

        cognomUsuari = new JTextField();
        add(cognomUsuari);

        btnEliminar = new JButton("Esborrar");
        add(btnEliminar);

        setVisible(true);

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = nomUsuari.getText();
                String cognoms = cognomUsuari.getText(); 

                Usuaris usuari = new Usuaris();
                usuari.eliminarUsuari(nom, cognoms);
                dispose();
            }
        });
}
}
