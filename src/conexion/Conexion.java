/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
import java.sql.*; 

public class Conexion { 
   static String bd = "pass"; 
   static String login = "root"; 
   static String password = ""; 
   static String url = "jdbc:mysql://localhost/"+bd; 
 
   Connection conn = null; 
    
   public Conexion() { 
      try{          
         Class.forName("com.mysql.jdbc.Driver");          
         conn = DriverManager.getConnection(url,login,password); 
         if (conn!=null){ 
            System.out.println("Conexión a base de datos "+bd+". listo"); 
         } 
      }catch( SQLException | ClassNotFoundException e){ 
         System.out.println(e); 
      } 
   } 
    
   public Connection getConnection(){ 
      return conn; 
   } 
 
   public void desconectar(){ 
      conn = null; 
   } 
}
