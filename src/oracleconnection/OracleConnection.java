
package oracleconnection;
import java.sql.*;
public class OracleConnection {
    public static void main(String[] args) {
Connection conn=null;
try{
    String driverName="oracle.jdbc.OracleDriver";
    Class.forName(driverName);
    String serverName="Dell";
    String serverPort="1521";
    String sid="XE";
    String url="jdbc:oracle:thin:@"+serverName+":"+serverPort+":"+sid;
    String username="HR";
    String password="12";
    conn=DriverManager.getConnection(url,username,password);
    System.out.println("Successfully connected to the database ");
}
        catch(ClassNotFoundException e){
             System.out.println("Could not find the database driver"+e.getMessage());
         }        
        catch(SQLException e){
              System.out.println("Could not connected to the databse"+e.getMessage());
      }        
try{
    PreparedStatement st=conn.prepareStatement("Select * From Emp ");
    ResultSet rs=st.executeQuery();
    while(rs.next()){
    
    int no=rs.getInt(1);
    String name=rs.getString(2).toString();
    System.out.println(""+no+" "+name);
    
}
    rs.close();  
}   
catch(Exception e){
        e.printStackTrace();
        
    }     
        

    }
    
}
