package Home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pras
 */
public class Koneksi {
    private static Connection koneksi;
    
    public static Connection getKoneksi() {
        if (koneksi == null) {
            try{
                String url = "jdbc:mysql://localhost:3306/dblogin";
                String Username = "root";
                String Password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, Username, Password);
                System.out.println("Connection Successfully");
            }catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return koneksi;
    }
    
    public static void closeConnection() {
        if (koneksi != null) {
            try {
                koneksi.close();
                System.out.println("Connection Closed");
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        Connection connection = getKoneksi();
        // Lakukan operasi database di sini
        closeConnection();
    }
}
