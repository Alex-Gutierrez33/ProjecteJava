
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaBibliotecarios extends JFrame {

    JLabel text;
    JButton observarLlibres;
    JButton administrarLlibres;
    JButton afegirLlibre;
    JButton editarLlibre;
    JButton eliminarLlibre;
    JLabel textUsu;
    JButton afegirUsuari;
    JButton eliminarUsuari;
    JLabel textPrestec;
    JButton crearPrestec;
    JButton veurePrestecs;



    public VentanaBibliotecarios(){
        setTitle("Bibliotecaris");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(11,1));


        text = new JLabel("Accions sobre llibres: ");
        add(text);

        observarLlibres = new JButton("Veure llibres");
        add(observarLlibres);

        administrarLlibres = new JButton("Administrar Llibres");
        add(administrarLlibres);

        afegirLlibre = new JButton("Afegix llibre");
        add(afegirLlibre);

        editarLlibre = new JButton("Editar llibre");
        add(editarLlibre);

       
        textUsu = new JLabel("Accions dels usuaris: ");
        add(textUsu);

        afegirUsuari = new JButton("Afegir usuari");
        add(afegirUsuari);

        eliminarUsuari = new JButton("Eliminar usuari");
        add(eliminarUsuari);

        textPrestec = new JLabel("Accions prestecs");
        add(textPrestec);

        crearPrestec = new JButton("Crear un prestec");
        add(crearPrestec);

        veurePrestecs = new JButton("Listar Historial Prestecs");
        add(veurePrestecs);


        setVisible(true);

        observarLlibres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Llibres llibre = new Llibres();
                llibre.veureLlibres();
            }
        });

        administrarLlibres.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaEliminarMostrarLlibre visor = new VentanaEliminarMostrarLlibre();
            }
        });

        afegirLlibre.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaAfegirLlibre visor = new VentanaAfegirLlibre();
            }
        });

        editarLlibre.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaEditarLlibre visor = new VentanaEditarLlibre();
            }
        });




        crearPrestec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPrestecs visor = new VentanaPrestecs();
                
            }
        });

        veurePrestecs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Prestecs prestec = new Prestecs();
                prestec.veurePrestecs();
            }
        });


         afegirUsuari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaAfegirUsuaris visor = new VentanaAfegirUsuaris();
               
            }
        });

        eliminarUsuari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaEliminarUsuari visor = new VentanaEliminarUsuari(); 
               
            }
        });


    }
    
}
