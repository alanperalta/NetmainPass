/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Alan
 */
public class Usuario {
    private int id;
    private String usuario;
    private String pass;
    private TipoUsuario tipoUsuario;

    public Usuario() {
    }

    public Usuario(int id, String usuario, String pass, TipoUsuario tipoUsuario) {
        this.id = id;
        this.usuario = usuario;
        this.pass = pass;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String usuario, String pass, TipoUsuario tipoUsuario) {
        this.usuario = usuario;
        this.pass = pass;
        this.tipoUsuario = tipoUsuario;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
