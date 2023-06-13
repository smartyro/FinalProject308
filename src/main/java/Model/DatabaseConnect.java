package Model;
import java.sql.* ;
import java.util.Stack;

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

   /*public void updateUserProblem(int problemnum, String username){

   }*/

   public static void saveChart(String username, String key, Stack<Shape> shapes){
      Connection conn = null;
      String shape_array = "";
      for (Shape i : shapes){
         shape_array+=i.toString();
      }
        try {
           Class.forName("org.postgresql.Driver");
           conn = DriverManager
              .getConnection(DB_URL,
              USER, PASS);


            System.out.println("Opened database successfully");

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO saved_charts_test (key, username, chart_array_string) VALUES ('"+key+"', '"+username+"','"+shape_array+"');";
            stmt.executeUpdate(sql);
            

        
        } catch (Exception e) {
           e.printStackTrace();
           System.err.println(e.getClass().getName()+": "+e.getMessage());
           System.exit(0);
        }
   }

   public static Stack<Shape> loadChart(String username, String key){
      Connection conn = null;
      Stack<Shape> retStack = new Stack<Shape>();
        try {
           Class.forName("org.postgresql.Driver");
           conn = DriverManager
              .getConnection(DB_URL,
              USER, PASS);


            String sql = "SELECT 1 FROM saved_charts_test WHERE key = '"+key+"' AND username = '"+username+"'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            //stmt.setString(1, usernameToCheck);
            ResultSet rs = stmt.executeQuery();

                if (rs.next()){

                  sql = "SELECT chart_array_string FROM saved_charts_test WHERE key = '"+key+"'";
                  stmt = conn.prepareStatement(sql);
                  //stmt.setInt(1, primaryKeyValue);
                  rs = stmt.executeQuery();
      
                  if (rs.next()) {
                     String chart_array = rs.getString("chart_array_string");
                     String[] splitted = chart_array.split("\\s+");

                     for (int x = 0; x < splitted.length; x+=3){
                        switch(splitted[x]){
                           case "BEGIN": retStack.add(new BeginShape(Integer.parseInt(splitted[x+1]), 
                           Integer.parseInt(splitted[x+2]), "BEGIN"));
                              break;
                           case "END":
                              retStack.add(new EndShape(Integer.parseInt(splitted[x+1]), 
                              Integer.parseInt(splitted[x+2]), "END"));
                              break;
                           case "IO": if (!isShape(splitted[x+3])){
                              retStack.add(new InputOutputShape(Integer.parseInt(splitted[x+1]), 
                              Integer.parseInt(splitted[x+2]), splitted[x+3]));
                              
                           }
                           else{
                                 retStack.add(new InputOutputShape(Integer.parseInt(splitted[x+1]), 
                           Integer.parseInt(splitted[x+2]),""));
                              }
                              x+=1;
                              break;
                           case "INSTRUCTION": if (!isShape(splitted[x+3])){
                              retStack.add(new InstructionShape(Integer.parseInt(splitted[x+1]), 
                              Integer.parseInt(splitted[x+2]), splitted[x+3]));
                              }
                              else{
                                 retStack.add(new InstructionShape(Integer.parseInt(splitted[x+1]), 
                           Integer.parseInt(splitted[x+2]),""));
                              }
                              x+=1;
                              break;
                           case "VARIABLE": if (!isShape(splitted[x+3])){retStack.add(new VariableShape(Integer.parseInt(splitted[x+1]), 
                           Integer.parseInt(splitted[x+2]), splitted[x+3]));
                              }
                              else{
                                 retStack.add(new VariableShape(Integer.parseInt(splitted[x+1]), 
                           Integer.parseInt(splitted[x+2]),""));
                              }
                              x+=1;
                              break;
                           case "CALL": if (!isShape(splitted[x+3]))
                           {retStack.add(new MethodShape(Integer.parseInt(splitted[x+1]), 
                           Integer.parseInt(splitted[x+2]), splitted[x+3]));
                              }
                              else{
                                 retStack.add(new MethodShape(Integer.parseInt(splitted[x+1]), 
                           Integer.parseInt(splitted[x+2]),""));
                              }
                              x+=1;
                              break;
                           case "CONDITION": if (!isShape(splitted[x+3]))
                           {retStack.add(new ConditionShape(Integer.parseInt(splitted[x+1]), 
                           Integer.parseInt(splitted[x+2]), splitted[x+3]));
                              }
                              else{
                                 retStack.add(new ConditionShape(Integer.parseInt(splitted[x+1]), 
                           Integer.parseInt(splitted[x+2]),""));
                              }
                              x+=1;
                              break;
                           default: System.out.println("something went wrong");
                           break;
                        }
                     }
                  }

                }
                //else { return error that no chart was found}
                
        
        } catch (Exception e) {
           e.printStackTrace();
           System.err.println(e.getClass().getName()+": "+e.getMessage());
           System.exit(0);
        }
        return retStack;
   }

   public static boolean isShape(String shape){
      switch(shape){
         case "BEGIN": return true;
         case "END": return true;
         case "IO": return true;
         case "INSTRUCTION": return true;
         case "VARIABLE": return true;
         case "CALL": return true;
         case "CONDITION": return true;
         default: return false;
      }
      }

   public static int checkUser(String username, String password){
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
                      return Integer.parseInt(columnValue);
                  } else {
                     //throw an error
                      System.out.println("No row found with the specified primary key value.");
                  }
                }
                else{
                  return -1;
                  // unmatched
                }
                
               }
         return -2;
         // no exist
          
      
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      return -3;
   }

     
    
}
