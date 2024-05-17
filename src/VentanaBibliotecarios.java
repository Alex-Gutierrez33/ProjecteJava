
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaBibliotecarios extends JFrame {

    JLabel text;
    JButton observarLlibres;
    JButton observarUnLlibre;
    JButton afegirLlibre;
    JButton editarLlibre;
    JButton eliminarLlibre;
    JLabel textUsu;
    JButton afegirUsuari;
    JButton eliminarUsuari;



    public VentanaBibliotecarios(){
        setTitle("Bibliotecaris");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9,1));


        text = new JLabel("Accions a realitzar: ");
        add(text);

        observarLlibres = new JButton("Veure llibres");
        add(observarLlibres);

        observarUnLlibre = new JButton("Veure un llibre");
        add(observarUnLlibre);

        afegirLlibre = new JButton("Afegix llibre");
        add(afegirLlibre);

        editarLlibre = new JButton("Editar llibre");
        add(editarLlibre);

        eliminarLlibre = new JButton("Eliminar llibre");
        add(eliminarLlibre);

        textUsu = new JLabel("Accions dels usuaris: ");
        add(textUsu);

        afegirUsuari = new JButton("Afegir usuari");
        add(afegirUsuari);

        eliminarUsuari = new JButton("Eliminar usuari");
        add(eliminarUsuari);


        setVisible(true);


    }
    
}
