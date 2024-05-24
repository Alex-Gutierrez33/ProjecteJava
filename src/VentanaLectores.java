import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaLectores extends JFrame {

    JLabel text;
    JButton observarLlibres;
    JButton observarUnLlibre;
    JButton administrarPrestecs;
  

    public VentanaLectores(){
        setTitle("Lectors");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,1));


        text = new JLabel("Accions a realitzar: ");
        add(text);

        observarLlibres = new JButton("Veure llibres disponibles");
        add(observarLlibres);

        observarUnLlibre = new JButton("Veure un llibre disponible");
        add(observarUnLlibre);

        administrarPrestecs = new JButton("Administrar Prestecs");
        add(administrarPrestecs);

       

        setVisible(true);

        observarLlibres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Llibres llibre = new Llibres();
                llibre.mostrarLlibresDisponibles();
            }
                
            });

        observarUnLlibre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 VentanaAbansMostrarLlibre visor = new VentanaAbansMostrarLlibre();
            }
                    
            });
            


        administrarPrestecs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaAdminPrestecs visor = new VentanaAdminPrestecs();
            }
        });
    }
    
}
