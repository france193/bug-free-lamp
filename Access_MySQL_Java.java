import java.sql.*;

/*
 * Created by Francesco Longo ©
 *
 * 1. Download JDBC Driver from https://dev.mysql.com/downloads/connector/j/
 * 2. Unzip package
 * 3. Copy jar file into a folder on your IDE
 * 4. Add jar as a Library
 * 5. Try the code to see how it works!
 *
 */

public class Main {

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "URL";
    private static final String DB = "DBNAME";
    private static final String COMPLETE_URL = "jdbc:mysql://" + URL + "/" + DB;

    //  Database credentials
    static final String USER = "USER";
    static final String PASS = "PASSWORD";

    public static void main(String[] args) {
        try {
            Class.forName(JDBC_DRIVER);
            Connection con = DriverManager.getConnection(COMPLETE_URL, USER, PASS);
            Statement st = con.createStatement();

            String sql = "SELECT * FROM BPUsers";
            ResultSet rs = st.executeQuery(sql);

            if (rs == null) {
                System.out.println("no corrispondances");
            } else {
                while (rs.next()) {
                    //Display values
                    System.out.println("COLUMN_1: " + rs.getString(1));
                    System.out.println("COLUMN_2: " + rs.getString(2));
                }
            }
        } catch (SQLException e) {
            System.out.println("sql exception:" + "\n" + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
