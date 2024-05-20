import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class VentanaAdminPrestecs extends JFrame {
    JLabel info;
    JButton veurePrestecs;
    JLabel infoEntregaPrestec;
    JTextField idPrestecEntrega;
    JButton entregaPrestec;


    public VentanaAdminPrestecs(){


        setTitle("Administració Prestecs");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,1));

        info = new JLabel("Administració de prestecs: ");
        add(info);

        
        veurePrestecs = new JButton("Observa els teus prestecs");
        add(veurePrestecs);

       

        infoEntregaPrestec = new JLabel("Indica el id del prestec a entregar: ");
        add(infoEntregaPrestec);

        idPrestecEntrega = new JTextField();
        add(idPrestecEntrega);
        
        entregaPrestec = new JButton("Entregar Prestec");
        add(entregaPrestec);

        setVisible(true);

        veurePrestecs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Prestecs prestec = new Prestecs();
                prestec.veurePrestecsIndividual();
            }
        });

        entregaPrestec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String StringidPrestecTornar = idPrestecEntrega.getText();
                int idPrestecTornar = Integer.parseInt(StringidPrestecTornar);

                Prestecs prestec = new Prestecs();
                prestec.tornarPrestec(idPrestecTornar);
            }
        });
    }
    
}
