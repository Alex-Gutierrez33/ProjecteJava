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

        camp = new JComboBox<>(new String[]{"Titol", "Autor", "Editorial", "Any_publicacio", "Categoria"});
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


                if (campLlibre.equals("Any_publicacio") ) {
                    if (nouValorLlibre.length() != 4 || !nouValorLlibre.matches("\\d+")) {
                        JOptionPane.showMessageDialog(VentanaEditarLlibre.this, "Error, has de posar un any vàlid");
                        return;
                    }                    
                }

                
                if (titolLlibre.equals("") || nouValorLlibre.equals("") ) {
                    JOptionPane.showMessageDialog(VentanaEditarLlibre.this, "Error: camps buits.", "Error", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }


                Llibres llibre = new Llibres();
                llibre.editarLlibre(titolLlibre,campLlibre,nouValorLlibre);
                dispose();
            }
        });
    }
}
