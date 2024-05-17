import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Usuaris {

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

        } catch (Exception e) {
            System.out.println("Error");
        }

        if (contador >= 1) {
            String resultado [] = {"valid",rol};
            return resultado;
        }else{
            String resultado [] = {"no-valid",rol};
            return resultado;

        }

    }
}
