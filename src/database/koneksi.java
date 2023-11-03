
package database;
import java.sql.*;


public class koneksi {
    private static Connection mysqlconfig;
    public static Connection configDB() {
        try {
            String url = "jdbc:mysql://localhost:3306/fasilitas_olahraga";
            String user = "root";
            String password = "";
            mysqlconfig = DriverManager.getConnection(url, user, password);
        } catch (Exception x) {
            System.err.println("Koneksi gagal"+x.getMessage());
        }
        return mysqlconfig;
    }
}
