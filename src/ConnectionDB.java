import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionDB {

    static final String DB_URL =  "jdbc:mysql://localhost:3306/biblioteca";
    static final String USER = "root";
    static final String PASS = "Alex2310";

    public Connection getConection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
