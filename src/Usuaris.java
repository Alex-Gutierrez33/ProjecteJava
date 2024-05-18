import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.Date;



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

    public void crearPresetec(String nomUsuari, String cognomsUsuari, String llibreDemant){

        int contador = 0;
        int idUsuari = 0;
        int id_llibre = 0;

        ConnectionDB conn = new ConnectionDB();

        try {
            Connection result = conn.getConection();

            Statement stmt = result.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuaris");

    
            while (rs.next()) {
                String usuari = rs.getString("nom");
                String cognoms = rs.getString("cognoms");

                if (usuari.equals(nomUsuari) && cognoms.equals(cognomsUsuari)) {
                    contador++;
                    idUsuari = rs.getInt("id_usuari");
                }
            }

            Statement stmt2 = result.createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT * FROM llibres");


            while (rs2.next()) {

                String titol = rs2.getString("titol");
                String estat = rs2.getString("estat");

               
                if (titol.equals(llibreDemant) && !estat.equals("prestat")) {
                    contador++;
                    id_llibre = rs2.getInt("id_llibre");
                }else{
                    JOptionPane.showMessageDialog(Usuaris.this, "Aquest llibre ja està reservat", "Error", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                }

            if (contador == 2) {

                LocalDate dataActual = LocalDate.now();
                LocalDate dataPrevista = dataActual.plusDays(15);

                String query = "INSERT INTO prestecs (id_llibre, id_usuari, data_prestec, data_retorn_prevista, estat) values (?,?,?,?,?)";
                PreparedStatement pstmt = result.prepareStatement(query);

                pstmt.setInt(1, id_llibre);
                pstmt.setInt(2, idUsuari);
                pstmt.setDate(3, Date.valueOf(dataActual)); 
                pstmt.setDate(4, Date.valueOf(dataPrevista));
                pstmt.setString(5, "actiu");
                
                int rows = pstmt.executeUpdate();

                if (rows > 0) {
                        JOptionPane.showMessageDialog(Usuaris.this, "S'ha realitzat el prestec", "Informació", JOptionPane.INFORMATION_MESSAGE);
                        
                        String query2 = "UPDATE llibres set estat = ? WHERE id_llibre = ?";
                        PreparedStatement pstmt2 = result.prepareStatement(query2);
                        pstmt2.setString(1, "prestat");
                        pstmt2.setInt(2, id_llibre);
                        
                        pstmt2.executeUpdate();
                }

            }else{
                JOptionPane.showMessageDialog(Usuaris.this, "Usuari o llibre no trobat", "Error", JOptionPane.INFORMATION_MESSAGE);
            }


            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Usuaris.this, "Error al conectar-se a la base de dades", "Error", JOptionPane.INFORMATION_MESSAGE);

        }

    }
}
