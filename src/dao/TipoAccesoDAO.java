/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.*;

/**
 *
 * @author Alan
 */
public class TipoAccesoDAO {
    Conexion db = new Conexion();
    
    public ArrayList<TipoAcceso> selectAll(){
        ArrayList<TipoAcceso> tipos = new ArrayList<>();
        TipoAcceso tipo;
        try{
            Statement st = db.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tipo_accesos");
            while(rs.next()){
                String nombre = rs.getString("nombre");
                tipo = new TipoAcceso(nombre);
                tipos.add(tipo);
            }
      }catch( SQLException e){ 
         System.out.println(e); 
      } 
        return tipos;
    }
}
