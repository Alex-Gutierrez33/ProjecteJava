import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablaMostrarLibros extends JFrame{
    JTable taula;
    DefaultTableModel model;

    public  TablaMostrarLibros(){
        setTitle("Llibres trobats");
        setSize(1000, 300);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();

        model.addColumn("Id Llibre");
        model.addColumn("Títol");
        model.addColumn("Autor");
        model.addColumn("ISBN");
        model.addColumn("Editorial");
        model.addColumn("Any publicacio");
        model.addColumn("Categoria");
        model.addColumn("Estat");





        taula = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(taula);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true);





    }
}