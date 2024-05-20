import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEditarLlibre extends JFrame{
    JLabel txtTitol;
    JTextField titol;
    
    JLabel txtCamp;
    JComboBox<String> camp;

    JLabel txtNouValor;
    JTextField nouValor;
    
    JButton btnEditar;
    
    public VentanaEditarLlibre() {
        setTitle("Editar Llibre");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        txtTitol = new JLabel("Nom del llibre a editar:");
        add(txtTitol);

        titol = new JTextField();
        add(titol);

        txtCamp = new JLabel("Camp a modificar: ");
        add(txtCamp);

        camp = new JComboBox<>(new String[]{"Titol", "Autor", "ISBN", "Editorial", "Any", "Categoria", "Estat"});
        add(camp);

        txtNouValor = new JLabel("Nou valor: ");
        add(txtNouValor);

        nouValor = new JTextField();
        add(nouValor);

        btnEditar = new JButton("Editar");
        add(btnEditar);

        setVisible(true);

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titolLlibre = titol.getText();
                String campLlibre = (String) camp.getSelectedItem();
                String nouValorLlibre = nouValor.getText();

                Llibres llibre = new Llibres();
                llibre.editarLlibre(titolLlibre,campLlibre,nouValorLlibre);
                dispose();
            }
        });
    }
}
