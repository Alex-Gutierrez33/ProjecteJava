import java.awt.GridLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAfegirLlibre extends JFrame{
    JLabel txtTitol;
    JTextField titol;

    JLabel txtAutor;
    JTextField autor;

    JLabel txtISBN;
    JTextField ISBN;

    JLabel txtEditorial;
    JTextField editorial;

    JLabel txtAny;
    JTextField any;

    JLabel txtCategoria;
    JTextField categoria;

    JLabel txtEstat;
    JTextField estat;

    JButton btnAfegir;

    public VentanaAfegirLlibre(){

        setTitle("Llibres");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8,2));

        txtTitol =new JLabel("Titol llibre: ");
        add(txtTitol);

        titol = new JTextField();
        add(titol);

        txtAutor = new JLabel("Nom autor");
        add(txtAutor);

        autor = new JTextField();
        add(autor);

        txtISBN = new JLabel("ISBN llibre: ");
        add(txtISBN);

        ISBN = new JTextField();
        add(ISBN);

        txtEditorial = new JLabel("Editorial llibre: ");
        add(txtEditorial);

        editorial = new JTextField();
        add(editorial);

        txtAny = new JLabel("Any llibre: ");
        add(txtAny);

        any = new JTextField();
        add(any);

        txtCategoria = new JLabel("Categoria llibre: ");
        add(txtCategoria);

        categoria = new JTextField();
        add(categoria);

        txtEstat = new JLabel("Estat llibre: ");
        add(txtEstat);

        estat = new JTextField("disponible");
        estat.setEnabled(false);
        add(estat);


        btnAfegir = new JButton("Afegir Usuari");
        add(btnAfegir);

        setVisible(true);
        
        btnAfegir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titolLlibre = titol.getText();
                String autorLlibre = autor.getText();
                String isbnLlibre = ISBN.getText();
                String editorialLlibre = editorial.getText();
                int anyLlibre = Integer.parseInt(any.getText());
                String categoriaLlibre = categoria.getText();
                String estatLlibre = estat.getText();
            
                Llibres llibre = new Llibres(); 
                llibre.afegirLlibre(titolLlibre,autorLlibre,isbnLlibre,editorialLlibre,anyLlibre,categoriaLlibre,estatLlibre);
                dispose();
            }
        });
    }
}
    
