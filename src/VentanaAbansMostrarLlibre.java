    
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaAbansMostrarLlibre extends JFrame {

    JLabel text;
    JTextField llibre;
    JButton btnMostrar;

    public VentanaAbansMostrarLlibre(){

        setTitle("Llibres");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        text = new JLabel("Indica el nom del llibre");
        add(text);

        llibre = new JTextField();
        add(llibre);

        btnMostrar = new JButton("Mostrar");
        add(btnMostrar);

        setVisible(true);


        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String llibreDemanat = llibre.getText();

                Llibres llibre = new Llibres();
                llibre.mostrarUnLlibreDisponible(llibreDemanat);
            }
        });

    }
}
