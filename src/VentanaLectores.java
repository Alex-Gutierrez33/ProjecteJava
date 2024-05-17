import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaLectores extends JFrame {

    JLabel text;
    JButton observarLlibres;
    JButton observarUnLlibre;

    public VentanaLectores(){
        setTitle("Lectors");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4,1));


        text = new JLabel("Accions a realitzar: ");
        add(text);

        observarLlibres = new JButton("Veure llibres");
        add(observarLlibres);

        observarUnLlibre = new JButton("Veure un llibre");
        add(observarUnLlibre);

        setVisible(true);
    }
    
}
