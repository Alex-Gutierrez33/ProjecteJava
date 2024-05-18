import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicToggleButtonUI;

public class VentanaLectores extends JFrame {

    JLabel text;
    JButton observarLlibres;
    JButton observarUnLlibre;
    JButton listarPrestecs;
    JButton tornarPrestec;

    public VentanaLectores(){
        setTitle("Lectors");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6,1));


        text = new JLabel("Accions a realitzar: ");
        add(text);

        observarLlibres = new JButton("Veure llibres");
        add(observarLlibres);

        observarUnLlibre = new JButton("Veure un llibre");
        add(observarUnLlibre);

        listarPrestecs = new JButton("Listar prestecs");
        add(listarPrestecs);

        tornarPrestec = new JButton("Tornar Prestec");
        add(tornarPrestec);

        setVisible(true);
    }
    
}
