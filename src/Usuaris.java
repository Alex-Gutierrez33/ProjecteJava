import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JFrame;




public class Usuaris extends JFrame{

    String nom;
    String cognoms;

    public Usuaris (){

    }

    public Usuaris (String nom, String cognoms){
        this.nom = nom;
        this.cognoms = cognoms;
     
    }

    public String[] validarCredencials(String nomDemant, String cognomDemanat){
        int contador = 0;
        String rol = "";

        ConnectionDB conn = new ConnectionDB();

        try {
            Connection result = conn.getConection();
            Statement stmt = result.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuaris");

            while (rs.next()) {
               String nomDatabase = rs.getString("nom");
               String cognomDatabase = rs.getString("cognoms");
               String rolDatabase = rs.getString("rol");

               if (nomDatabase.equals(nomDemant) && cognomDatabase.equals(cognomDemanat) ) {
                    contador++;
                    rol = rolDatabase;
               }
              
            }

        } catch (SQLException e) {
            System.out.println("Error al conectarse en la base de dades");
        }

        if (contador >= 1) {
            String resultado [] = {"valid",rol};
            return resultado;
        }else{
            String resultado [] = {"no-valid",rol};
            return resultado;

        }

    }

    public void mostrarUsuaris(){
        ConnectionDB conn = new ConnectionDB();

        try {
            Connection result = conn.getConection();
            Statement stmt = result.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from usuaris WHERE rol = 'lector'");

            TablaMostrarUsuarios taula = new TablaMostrarUsuarios();


            while (rs.next()) {
        
                
                String idDatabase = rs.getString("id_usuari");
                String nomDatabase = rs.getString("nom");
                String cognomsDatabase = rs.getString("cognoms");
                String emailDatabase = rs.getString("email");
                String telefonDatabase = rs.getString("telefon");
                String rolDatabase = rs.getString("rol");
                String data_registreDatabase = rs.getString("data_registre");
               

                taula.model.addRow(new Object[]{idDatabase,nomDatabase,cognomsDatabase,emailDatabase,telefonDatabase,rolDatabase,data_registreDatabase});
            }

        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    
}
