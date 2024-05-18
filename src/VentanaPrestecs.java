import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaPrestecs extends JFrame{

    JLabel txtUsuari;
    JLabel txtCognoms;
    JLabel txtLlibre;

    JTextField nomUsuari;
    JTextField cognomUsuari;
    JTextField titolLibre;
    JButton veureUsuaris;
    JButton veureLlibres;
    JButton crearPresetec;

    public VentanaPrestecs(){
        setTitle("Bibliotecaris");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,2));

        txtUsuari = new JLabel("Indica el nom del usuari: ");
        add(txtUsuari);

        txtCognoms = new JLabel("Indica els cognoms del usuari: ");
        add(txtCognoms);

        nomUsuari = new JTextField();
        add(nomUsuari);

        cognomUsuari = new JTextField();
        add(cognomUsuari);

        txtLlibre = new JLabel("Indica el nom del llibre: ");
        add(txtLlibre);

        titolLibre = new JTextField();
        add(titolLibre);

        veureLlibres = new JButton("Observar llibres");
        add(veureLlibres);

        veureUsuaris = new JButton("Observar usuaris");
        add(veureUsuaris);

        crearPresetec = new JButton("Crear prestec");
        add(crearPresetec);

        setVisible(true);

        veureLlibres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Llibres llibre = new Llibres();
                llibre.veureLlibres();
            }
        });

        veureUsuaris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuaris usu = new Usuaris();
                usu.mostrarUsuaris();
            }
        });

        crearPresetec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nomPrestec = nomUsuari.getText();
                String cognomsPrestec = cognomUsuari.getText();
                String llibreDemanat = titolLibre.getText();

                Usuaris usu = new Usuaris();
                usu.crearPresetec(nomPrestec, cognomsPrestec, llibreDemanat);
                
            }
        });

    }
    
}