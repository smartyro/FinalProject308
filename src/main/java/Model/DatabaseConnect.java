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
    

    public static void addUser(String username, String password, String role){
      Connection conn = null;
        try {
           Class.forName("org.postgresql.Driver");
           conn = DriverManager
              .getConnection(DB_URL,
              USER, PASS);

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO USERS (USERNAME, PASSWORD, PROBLEM_NUM, ROLE) VALUES ('"+username+"', '"+password+"', 1, '"+role+"');";
            stmt.executeUpdate(sql);
            

            System.out.println("Opened database successfully");

        
        } catch (Exception e) {
           e.printStackTrace();
           System.err.println(e.getClass().getName()+": "+e.getMessage());
           System.exit(0);
        }

   }



   public static String checkUserExists(String username, String password){
      Connection conn = null;
      try {
         Class.forName("org.postgresql.Driver");
         conn = DriverManager
            .getConnection(DB_URL,
            USER, PASS);

            String sql = "SELECT 1 FROM users WHERE username = '"+username+"'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            //stmt.setString(1, usernameToCheck);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                sql = "SELECT 1 FROM users WHERE username = '"+username+"' AND password = '"+password+"'";
                stmt = conn.prepareStatement(sql);
                //stmt.setString(1, usernameToCheck);
                rs = stmt.executeQuery();
                if (rs.next()){

                  sql = "SELECT problem_num FROM USERS WHERE username = '"+username+"'";
                  stmt = conn.prepareStatement(sql);
                  //stmt.setInt(1, primaryKeyValue);
                  rs = stmt.executeQuery();
      
                  if (rs.next()) {
                      String columnValue = rs.getString("problem_num");
                      return columnValue;
                  } else {
                     //throw an error
                      System.out.println("No row found with the specified primary key value.");
                  }
                }
                else{
                  return "unmatched";
                }
                
               }
         return "no exist";
          
      
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      return password;
   }

     
    
}
