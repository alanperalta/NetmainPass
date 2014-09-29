/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelos.Usuario;
import vistas.Login;
import vistas.VentanaPrincipal;

/**
 *
 * @author Alan
 */
public class ControlLogin implements ActionListener{

    private Login login;
    
    public ControlLogin(Login login) {
        this.login = login;
        this.login.setVisible(true);
        actionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("entrar")){
            verificarLogin(login.txtUsuario.getText(), login.txtPassword.getText());
        }
    }
    
    public void actionListener(ActionListener listener){
        login.btnEntrar.addActionListener(listener);
        login.btnEntrar.setActionCommand("Entrar");
        login.txtPassword.addActionListener(listener);
        login.txtPassword.setActionCommand("Entrar");
    }
    
    public void verificarLogin(String usuario, String password){
        Usuario u = new UsuarioDAO().select(usuario, password);
        if(u != null){
            boolean admin = false;
            if(u.getTipoUsuario().getId() == 1){
                admin = true;
            }
            this.login.dispose();
            new ControladorPrincipal(new VentanaPrincipal(), admin);
        } else {
            JOptionPane.showMessageDialog(login, "Usuario o contraseña incorrectos", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

}
