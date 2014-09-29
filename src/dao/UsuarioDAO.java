/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelos.TipoUsuario;
import modelos.Usuario;

/**
 *
 * @author Alan
 */
public class UsuarioDAO {
    Conexion db = new Conexion();
    
    public Usuario select(String usuario, String password){
        Usuario u = null;
        try{
            Statement st = db.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE usuario='"+usuario+"' AND pass='"+password+"'");
            while(rs.next()){
                int id = rs.getInt("id");
                TipoUsuario tipoU = new TipoUsuario(rs.getInt("FK_tipo_usuario"));
                u = new Usuario(id, usuario, password, tipoU);
            }
      }catch( SQLException e){ 
         System.out.println(e); 
      } 
        return u;
    }
}
