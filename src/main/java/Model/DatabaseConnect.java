package Model;
import java.sql.* ;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect {
    static final String DB_URL = "jdbc:postgresql://db.vfanjifsjvgthigoppsc.supabase.co:5432/postgres?user=postgres&password=29xkz2N5!!?";
    static final String USER = "postgres";
    static final String PASS = "29xkz2N5!!?";
    
    
    public static void main(String args[]) {
        Connection conn = null;
        try {
           Class.forName("org.postgresql.Driver");
           conn = DriverManager
              .getConnection(DB_URL,
              USER, PASS);

            //print the users table
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM USERS;";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Users table:");
            while(rs.next()){
                System.out.print("username: " + rs.getString("USERNAME") + ", ");
                System.out.println("password: " + rs.getString("PASSWORD"));
            }

            System.out.println("Opened database successfully");

        
        } catch (Exception e) {
           e.printStackTrace();
           System.err.println(e.getClass().getName()+": "+e.getMessage());
           System.exit(0);
        }
     }
    
    public static void addUser(String username, String password){
      Connection conn = null;
        try {
           Class.forName("org.postgresql.Driver");
           conn = DriverManager
              .getConnection(DB_URL,
              USER, PASS);

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO USERS (USERNAME,PASSWORD) VALUES ('"+username+"','"+password+"');";
            stmt.executeUpdate(sql);
            

            System.out.println("Opened database successfully");

        
        } catch (Exception e) {
           e.printStackTrace();
           System.err.println(e.getClass().getName()+": "+e.getMessage());
           System.exit(0);
        }

   }

     
    
}
