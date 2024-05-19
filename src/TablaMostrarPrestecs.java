import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablaMostrarPrestecs extends JFrame{
    JTable taula;
    DefaultTableModel model;

    public  TablaMostrarPrestecs(){
        setTitle("Prestecs trobats");
        setSize(1000, 300);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();

        model.addColumn("Id Prestec");
        model.addColumn("Id Llibre");
        model.addColumn("Id Usuari");
        model.addColumn("Data Prestec");
        model.addColumn("Data Retorn Prevista");
        model.addColumn("Data Retorn Real");
        model.addColumn("Estat");





        taula = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(taula);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true);





    }
}