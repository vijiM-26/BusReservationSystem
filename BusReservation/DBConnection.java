import java.sql.*;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/busresv";
    private static final String user = "root";
    private static final String password = "viji";

    // this method establishes the connection and returns the connection object
    public static Connection getConnection()  throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }

}
