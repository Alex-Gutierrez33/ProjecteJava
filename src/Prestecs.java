import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Prestecs extends JFrame {
    
    public Prestecs(){

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
                        JOptionPane.showMessageDialog(Prestecs.this, "S'ha realitzat el prestec", "Informació", JOptionPane.INFORMATION_MESSAGE);
                        
                        String query2 = "UPDATE llibres set estat = ? WHERE id_llibre = ?";
                        PreparedStatement pstmt2 = result.prepareStatement(query2);
                        pstmt2.setString(1, "prestat");
                        pstmt2.setInt(2, id_llibre);
                        
                        pstmt2.executeUpdate();
                }

            }else{
                JOptionPane.showMessageDialog(Prestecs.this, "Usuari no existeix / llibre no trobat / Llibre no disponible", "Error", JOptionPane.INFORMATION_MESSAGE);
            }


            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Prestecs.this, "Error al conectar-se a la base de dades", "Error", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    // es per veure els prestecs que hi ha en total.
    public void veurePrestecs(){
        ConnectionDB conn = new ConnectionDB();
        TablaMostrarPrestecs visor = new TablaMostrarPrestecs();
        try {
            Connection result = conn.getConection();
            Statement stmt = result.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM prestecs");

            while (rs.next()) {
                int id_prestec = rs.getInt("id_prestec");
                int id_llibre = rs.getInt("id_llibre");
                int id_usuari = rs.getInt("id_usuari");
                Date data_prestec = rs.getDate("data_prestec");
                Date data_retorn_prevista = rs.getDate("data_retorn_prevista");
                Date data_retorn_real = rs.getDate("data_retorn_real");
                String estat = rs.getString("estat");

                visor.model.addRow(new Object[]{id_prestec,id_llibre,id_usuari,data_prestec,data_retorn_prevista,data_retorn_real,estat});
                
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    // prestec per usuari
    public void veurePrestecsIndividual(){
       

        String usauriLogin = VentanaLogin.nomUsuari;
        String cognomLogin = VentanaLogin.cognomUsuari;
        int idUsuariTrobat = 0;

    

        ConnectionDB conn = new ConnectionDB();

        try {
            Connection result = conn.getConection();
            Statement stmt = result.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuaris");

            while (rs.next()) {
                String nomUsuari = rs.getString("nom");
                String cognomUsuari = rs.getString("cognoms");
                
                if (nomUsuari.equals(usauriLogin) && cognomUsuari.equals(cognomLogin)) {
                    idUsuariTrobat = rs.getInt("id_usuari");  
                }
            }

            Statement stmt2 = result.createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT * FROM prestecs");
            TablaMostrarPrestecs taula = new TablaMostrarPrestecs();


            while (rs2.next()) {
                if (rs2.getInt("id_usuari") == idUsuariTrobat) {

                    int id_prestec = rs2.getInt("id_prestec");
                    int id_llibre = rs2.getInt("id_llibre");
                    int id_usuari = rs2.getInt("id_usuari");
                    Date data_prestec = rs2.getDate("data_prestec");
                    Date data_retorn_prevista = rs2.getDate("data_retorn_prevista");
                    Date data_retorn_real = rs2.getDate("data_retorn_real");
                    String estat = rs2.getString("estat");
    
                    taula.model.addRow(new Object[]{id_prestec,id_llibre,id_usuari,data_prestec,data_retorn_prevista,data_retorn_real,estat});

                }
            }



        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Prestecs.this, "Error al conectar-se en la base de dades", "Error", JOptionPane.INFORMATION_MESSAGE);

        }


    

    }

    public void tornarPrestec(int idPrestecTornar){

        int id_llibreEntregar = 0;
        int entregat = 0;
        int contador = 0;
        int id_prestec = 0;
        int id_prestecModificar = 0;
        Date dataPrestec = null;
        LocalDate dataEntregaPrestec = null;

        ConnectionDB conn = new ConnectionDB();

        try {
            Connection result = conn.getConection();
            Statement stmt = result.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM prestecs");

            while (rs.next()) {
                id_prestec = rs.getInt("id_prestec");
                dataPrestec = rs.getDate("data_prestec");
               

                if (id_prestec == idPrestecTornar) {
                    String estat = rs.getString("estat");

                    if (estat.equals("completat") || estat.equals("retardat")) {
                        JOptionPane.showMessageDialog(Prestecs.this, "Aquest prestec ja ha estat entregat", "Informatiu", JOptionPane.INFORMATION_MESSAGE);
                        contador++;

                    }else{
                        id_prestecModificar = id_prestec;
                        id_llibreEntregar = rs.getInt("id_llibre");
                        contador++;

                    }
                }

            }

            if (contador == 1) {
                LocalDate dataActual = LocalDate.now();
                dataEntregaPrestec = dataPrestec.toLocalDate();

                Long diferneciaDies = ChronoUnit.DAYS.between(dataEntregaPrestec, dataActual);

                if (diferneciaDies >= 15) {

                    String query = "UPDATE prestecs set data_retorn_real = ?, estat = ? WHERE id_prestec = ?";
                    PreparedStatement pstmt = result.prepareStatement(query);
                    pstmt.setDate(1, Date.valueOf(dataActual));
                    pstmt.setString(2, "retardat");
                    pstmt.setInt(3, id_prestecModificar);

                    
                    int rows = pstmt.executeUpdate();

                    if (rows > 0) {
                        JOptionPane.showMessageDialog(Prestecs.this, "Prestec retornat de forma exitosa, amb retard", "Informatiu", JOptionPane.INFORMATION_MESSAGE);
                        entregat++;
                    }


                }else {

                    String query = "UPDATE prestecs set data_retorn_real = ?, estat = ? WHERE id_prestec = ?";
                    PreparedStatement pstmt = result.prepareStatement(query);
                    pstmt.setDate(1, Date.valueOf(dataActual));
                    pstmt.setString(2, "completat");
                    pstmt.setInt(3, id_prestecModificar);


                    int rows = pstmt.executeUpdate();

                    if (rows > 0) {
                        JOptionPane.showMessageDialog(Prestecs.this, "Prestec retornat de forma exitosa", "Informatiu", JOptionPane.INFORMATION_MESSAGE);
                        entregat++;

                    }
                }

                if (entregat == 1) {

                    String query2 = "UPDATE llibres set estat = ? WHERE id_llibre = ?";
                    PreparedStatement pstmt2 = result.prepareStatement(query2);
                    pstmt2.setString(1, "disponible");
                    pstmt2.setInt(2, id_llibreEntregar);

                    pstmt2.executeUpdate();
                }

               

                                
            }else{
                JOptionPane.showMessageDialog(Prestecs.this, "No existeix aquest prestec", "Error", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Prestecs.this, "Error al conectar-se a la base de dades", "Error", JOptionPane.INFORMATION_MESSAGE);

        }

    }


}
