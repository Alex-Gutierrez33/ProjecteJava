import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablaMostrarUsuarios extends JFrame{
    JTable taula;
    DefaultTableModel model;

    public  TablaMostrarUsuarios(){
        setTitle("Llibres trobats");
        setSize(1000, 300);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();

        model.addColumn("Id Usuari");
        model.addColumn("Nom");
        model.addColumn("Cognoms");
        model.addColumn("Email");
        model.addColumn("Teléfon");
        model.addColumn("Rol");
        model.addColumn("Data_registre");

        taula = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(taula);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true);





    }
}