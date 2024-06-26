
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Llibres extends JFrame {

    int id_llibre;
    String titol;
    String autor;
    String isbn;
    String editorial;
    int any_publicacio;
    String categoria;
    String estat;

    public Llibres(){

    }

    public Llibres (String titol, String autor, String isbn, String editorial, int any_publicacio, String categoria, String estat){
        this.titol = titol;
        this.autor = autor;
        this.isbn = isbn;
        this.editorial = editorial;
        this.any_publicacio = any_publicacio;
        this.categoria = categoria;
        this.estat = estat;

    }


    public void veureLlibres(){
        ConnectionDB conn = new ConnectionDB();

        try {
            Connection result = conn.getConection();
            Statement stmt = result.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from llibres");

            TablaMostrarLibros taula = new TablaMostrarLibros();


            while (rs.next()) {
                String idDatabase = rs.getString("id_llibre");
                String titolDatabase = rs.getString("titol");
                String autorDatabase = rs.getString("autor");
                String isbnDatabase = rs.getString("isbn");
                String editorialDatabase = rs.getString("editorial");
                String any_publicacioDatabase = rs.getString("any_publicacio");
                String categoriaDatabase = rs.getString("categoria");
                String estatDatabase = rs.getString("estat");

                taula.model.addRow(new Object[]{idDatabase,titolDatabase,autorDatabase,isbnDatabase,editorialDatabase,any_publicacioDatabase,categoriaDatabase,estatDatabase});
            }

        } catch (SQLException e) {
            System.out.println("Error");
        }
    }

    
    public void mostrarUnLlibre(String nomLlibre){
        int contador = 0;
        ConnectionDB conn = new ConnectionDB();
        VentanaMostrarLlibre visor = new VentanaMostrarLlibre();
        visor.setVisible(false);

        try {
            Connection result = conn.getConection();

            Statement stmt = result.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM llibres ");

            while (rs.next()) {
                String titolDatabse = rs.getString("titol");

                if (titolDatabse.equals(nomLlibre)) {
                    String idDatabase = rs.getString("id_llibre");
                    String titolDatabase = rs.getString("titol");
                    String autorDatabase = rs.getString("autor");
                    String isbnDatabase = rs.getString("isbn");
                    String editorialDatabase = rs.getString("editorial");
                    String any_publicacioDatabase = rs.getString("any_publicacio");
                    String categoriaDatabase = rs.getString("categoria");
                    String estatDatabase = rs.getString("estat");

                    visor.id_llibre.setText(idDatabase);
                    visor.titol.setText(titolDatabase);
                    visor.autor.setText(autorDatabase);
                    visor.ISBN.setText(isbnDatabase);
                    visor.editorial.setText(editorialDatabase);
                    visor.any.setText(any_publicacioDatabase);
                    visor.categoria.setText(categoriaDatabase);
                    visor.estat.setText(estatDatabase);

                    contador++;
                }
            }

            if (contador == 0) {
                JOptionPane.showMessageDialog(Llibres.this, "No hem trobat el llibre", "Error", JOptionPane.INFORMATION_MESSAGE);
            }else{
                visor.setVisible(true);

            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Llibres.this, "Error al conectar-se a la base de dades", "Error", JOptionPane.INFORMATION_MESSAGE);

        }
    }



    public void afegirLlibre(String titol,String autor, String isbn, String editorial, int any, String categoria, String estat){
        ConnectionDB conn = new ConnectionDB();
        
        try {
            Connection result = conn.getConection();

            String query = "INSERT INTO llibres (titol, autor, isbn, editorial, any_publicacio, categoria, estat) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = result.prepareStatement(query);
            pstmt.setString(1, titol);
            pstmt.setString(2, autor);
            pstmt.setString(3, isbn);
            pstmt.setString(4, editorial);
            pstmt.setInt(5, any);
            pstmt.setString(6, categoria);
            pstmt.setString(7, estat);
            int canvis = pstmt.executeUpdate();
    
            if (canvis > 0) {
                JOptionPane.showMessageDialog(Llibres.this, "Llibre afegit correctament!");
            }
    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Llibres.this, "Error al conectar-se a la base de dades", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    

    }

    public void editarLlibre(String titol, String camp, String nouValor){
        ConnectionDB conn = new ConnectionDB();
        int contador = 0;
        
        try {
            Connection result = conn.getConection();
            Statement stmt = result.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM llibres");


            while (rs.next()) {
                String titolDatabse = rs.getString("titol");
                
                if (titolDatabse.equals((titol))) {
                    String query = "UPDATE llibres SET " + camp + " = ? WHERE titol = ?";
                    PreparedStatement pstmt = result.prepareStatement(query);
                    contador++;
                    pstmt.setString(1, nouValor);
                    pstmt.setString(2, titol);

                    int canvis = pstmt.executeUpdate();

                    if (canvis > 0) {
                        JOptionPane.showMessageDialog(Llibres.this, "Llibre editat correctament!");
                    }
                }
            }

            if (contador == 0) {
                JOptionPane.showMessageDialog(Llibres.this, "No s'ha trobat el llibre");

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Llibres.this, "Error al conectar-se a la base de dades", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Per als lectors

    public void mostrarLlibresDisponibles(){
        int contador = 0; 
        ConnectionDB conn = new ConnectionDB();

        try {
            Connection result = conn.getConection();
            Statement stmt = result.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from llibres");

            TablaMostrarLibros taula = new TablaMostrarLibros();

            
            while (rs.next()) {
                String estat = rs.getString("estat");
                if (estat.equals("disponible")) {
                    contador++;
                    String idDatabase = rs.getString("id_llibre");
                    String titolDatabase = rs.getString("titol");
                    String autorDatabase = rs.getString("autor");
                    String isbnDatabase = rs.getString("isbn");
                    String editorialDatabase = rs.getString("editorial");
                    String any_publicacioDatabase = rs.getString("any_publicacio");
                    String categoriaDatabase = rs.getString("categoria");
                    String estatDatabase = rs.getString("estat");
    
                    taula.model.addRow(new Object[]{idDatabase,titolDatabase,autorDatabase,isbnDatabase,editorialDatabase,any_publicacioDatabase,categoriaDatabase,estatDatabase}); 
                }
            }
            if (contador == 0) {
                JOptionPane.showMessageDialog(Llibres.this, "No hi ha llibres disponibles, ho sentim.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
    }

    //Per als lectors

    public void mostrarUnLlibreDisponible(String nomLlibre){
        int contador = 0;
        ConnectionDB conn = new ConnectionDB();
        VentanaMostrarLlibre visor = new VentanaMostrarLlibre();
        visor.setVisible(false);

        try {
            Connection result = conn.getConection();

            Statement stmt = result.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM llibres ");

            while (rs.next()) {
                String titolDatabse = rs.getString("titol");
                String estat = rs.getString("estat");

                if (titolDatabse.equals(nomLlibre) && estat.equals("disponible") ) {
                    String idDatabase = rs.getString("id_llibre");
                    String titolDatabase = rs.getString("titol");
                    String autorDatabase = rs.getString("autor");
                    String isbnDatabase = rs.getString("isbn");
                    String editorialDatabase = rs.getString("editorial");
                    String any_publicacioDatabase = rs.getString("any_publicacio");
                    String categoriaDatabase = rs.getString("categoria");
                    String estatDatabase = rs.getString("estat");

                    visor.id_llibre.setText(idDatabase);
                    visor.titol.setText(titolDatabase);
                    visor.autor.setText(autorDatabase);
                    visor.ISBN.setText(isbnDatabase);
                    visor.editorial.setText(editorialDatabase);
                    visor.any.setText(any_publicacioDatabase);
                    visor.categoria.setText(categoriaDatabase);
                    visor.estat.setText(estatDatabase);

                    contador++;
                }
            }

            if (contador == 0) {
                JOptionPane.showMessageDialog(Llibres.this, "El llibre no esta disponible.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }else{
                visor.setVisible(true);

            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Llibres.this, "Error al conectar-se a la base de dades", "Error", JOptionPane.INFORMATION_MESSAGE);

        }
    }



    public void eliminarLlibre(String nomLlibre){
        ConnectionDB conn = new ConnectionDB();
        int contador = 0;

        try {
            Connection result = conn.getConection();

            Statement stmt = result.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM llibres");

            while (rs.next()) {
                String titol = rs.getString("titol");
                if (titol.equals(nomLlibre)) {
                    contador++;
                }
            }

            if (contador == 0) {
                JOptionPane.showMessageDialog(Llibres.this, "No hem trobat el llibre", "Error", JOptionPane.INFORMATION_MESSAGE);
            }else{
                String query = "DELETE FROM llibres WHERE titol = ?";

                PreparedStatement pstmt = result.prepareStatement(query);
                pstmt.setString(1, nomLlibre);

                int rows  = pstmt.executeUpdate();

                if (rows > 0) {
                    JOptionPane.showMessageDialog(Llibres.this, "Llibre esobrrat de la base de dades", "Informatiu", JOptionPane.INFORMATION_MESSAGE);                    
                }
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Llibres.this, "Error al conectar-se a la base de dades", "Error", JOptionPane.INFORMATION_MESSAGE);

        }

    }

   


       
}
    

