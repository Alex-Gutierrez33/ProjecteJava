import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class VentanaAdminPrestecs extends JFrame {
    JLabel info;
    JLabel txtnomUsuari;
    JTextField nomUsuari;
    JLabel txtcognomUsuari;
    JTextField cognomUsuari;
    JButton veurePrestecs;
    JLabel infoEntregaPrestec;
    JTextField idPrestecEntrega;
    JButton entregaPrestec;


    public VentanaAdminPrestecs(){


        setTitle("Administració Prestecs");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9,1));

        info = new JLabel("Administració de prestecs: ");
        add(info);

        txtnomUsuari = new JLabel("Indica el teu nom: ");
        add(txtnomUsuari);

        nomUsuari = new JTextField();
        add(nomUsuari);

        txtcognomUsuari = new JLabel("Indica el teu cognom: ");
        add(txtcognomUsuari);

        cognomUsuari = new JTextField();
        add(cognomUsuari);

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
                String nomCercar = nomUsuari.getText();
                String cognomCercar = cognomUsuari.getText();

                prestec.veurePrestecsIndividual(nomCercar, cognomCercar);
            }
        });
    }
    
}
