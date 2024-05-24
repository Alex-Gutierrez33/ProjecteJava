import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;




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

    public void afegirUsuaris(String nom, String cognoms, String email, String telefon, String rol, String data){
        ConnectionDB conn = new ConnectionDB();

        try {
            Connection result = conn.getConection();

            Statement stmt2 = result.createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT * FROM usuaris");

            while (rs2.next()) {
                String nomDatabase = rs2.getString("nom");
                String cognomDatabase = rs2.getString("cognoms");

                if (nomDatabase.equals(nom) && cognomDatabase.equals(cognoms)) {
                    JOptionPane.showMessageDialog(Usuaris.this, "Error aquest usuari ja existeix", "Error", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }


            String query = "INSERT INTO usuaris (nom, cognoms, email, telefon, rol, data_registre) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = result.prepareStatement(query);
            pstmt.setString(1, nom);
            pstmt.setString(2, cognoms);
            pstmt.setString(3, email);
            pstmt.setString(4, telefon);
            pstmt.setString(5, rol);
            pstmt.setString(6, data);
            int canvis = pstmt.executeUpdate();
            if (canvis > 0) {
                JOptionPane.showMessageDialog(Usuaris.this, "Usuari afegit correctament!");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Usuaris.this, "Error al conectar-se a la base de dades", "Error", JOptionPane.INFORMATION_MESSAGE);
        }

        
    }





    public void eliminarUsuari(String nomUsuari, String cognomUsuari){
        ConnectionDB conn = new ConnectionDB();
        int contador = 0;
        int id_usuari = 0;

        try {
            Connection result = conn.getConection();

            Statement stmt = result.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuaris");

            while (rs.next()) {
                String nom = rs.getString("nom");
                String cognom = rs.getString("cognoms");
                if (nom.equals(nomUsuari) && cognom.equals(cognomUsuari)) {
                    contador++;
                    id_usuari = rs.getInt("id_usuari");
                }

            }

            if (contador == 0) {
                JOptionPane.showMessageDialog(Usuaris.this, "No hem trobat l'usuari", "Error", JOptionPane.INFORMATION_MESSAGE);
            }else{

                String query2 = "DELETE FROM prestecs WHERE id_usuari = ?";
                PreparedStatement pstmt2 = result.prepareStatement(query2);
                pstmt2.setInt(1, id_usuari);
                
                int rows2 = pstmt2.executeUpdate();

                if (rows2 > 0) {
                    
                    String query = "DELETE FROM usuaris WHERE id_usuari = ?";

                    PreparedStatement pstmt = result.prepareStatement(query);
                    pstmt.setInt(1, id_usuari);

                    int rows  = pstmt.executeUpdate();

                    if (rows > 0) {
                        JOptionPane.showMessageDialog(Usuaris.this, "Usuari esobrrat de la base de dades", "Informatiu", JOptionPane.INFORMATION_MESSAGE);                    
                    }
                }




            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Usuaris.this, "Error al conectar-se a la base de dades", "Error", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.getMessage());
        }

    }

}

    
