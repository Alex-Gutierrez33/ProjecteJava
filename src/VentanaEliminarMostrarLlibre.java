
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaEliminarMostrarLlibre extends JFrame {
    JLabel text;
    JTextField llibre;
    JButton btnEliminar;
    JButton btnMostrar;

    public VentanaEliminarMostrarLlibre(){

        setTitle("Llibres");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2,2));

        text = new JLabel("Indica el nom del llibre");
        add(text);

        llibre = new JTextField();
        add(llibre);

        btnEliminar = new JButton("Borrar");
        add(btnEliminar);

        btnMostrar = new JButton("Mostrar");
        add(btnMostrar);

        setVisible(true);


        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String llibreDemanat = llibre.getText();

                Llibres llibre = new Llibres();
                llibre.mostrarUnLlibre(llibreDemanat);
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String llibreDemanat = llibre.getText();


                Llibres llibre = new Llibres();
                llibre.eliminarLlibre(llibreDemanat);
                dispose();
            }
        });
    }
}
