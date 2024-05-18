import java.awt.GridLayout;

import javax.swing.*;

public class VentanaMostrarLlibre extends JFrame{
    JLabel txtId_llibre;
    JTextField id_llibre;

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

    public VentanaMostrarLlibre(){

        setTitle("Llibres");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8,2));

        txtId_llibre = new JLabel("Id llibre: ");
        add(txtId_llibre);

        id_llibre = new JTextField();
        add(id_llibre);

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
        editorial = new JTextField();

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

        estat = new JTextField();
        add(estat);

        setVisible(true);
        
    }
}
