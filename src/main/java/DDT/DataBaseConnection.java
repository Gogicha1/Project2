package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
    public static Connection getConnection() throws SQLException
    {
        Connection conn = null;
        try (FileInputStream f = new FileInputStream("src/main/resources/db.properties")){
            Properties pros = new Properties();
            pros.load(f);

            String url = pros.getProperty("URL");
            String user = pros.getProperty("User");
            String password = pros.getProperty("Password");

            conn = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
