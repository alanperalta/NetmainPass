/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import vistas.*;

/**
 *
 * @author Alan
 */
public class ControladorPrincipal implements ActionListener, InternalFrameListener{

    VentanaPrincipal vp;

    public ControladorPrincipal(VentanaPrincipal vp, boolean admin) {
        this.vp = vp;
        this.vp.setVisible(true);
        this.vp.menuUsuarios.setVisible(admin);
        actionListener(this);
    }
    
    public void actionListener(ActionListener listener){
        vp.itmSalir.addActionListener(listener);
        vp.itmSalir.setActionCommand("Salir");
        vp.itmCerrarSesion.addActionListener(listener);
        vp.itmCerrarSesion.setActionCommand("Logout");
        vp.btnAgregar.addActionListener(listener);
        vp.btnAgregar.setActionCommand("Agregar");
        vp.btnVer.addActionListener(listener);
        vp.btnVer.setActionCommand("Ver");
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Salir")){
            System.exit(0);
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Logout")){
            new ControlLogin(new Login());
            vp.dispose();
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Agregar")){
            NuevoPass np = new NuevoPass();
            np.addInternalFrameListener(this);
            vp.panel.add(np);
            new ControladorNuevoPass(np);
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Ver")){
            VerPass vps = new VerPass();
            vps.addInternalFrameListener(this);
            vp.panel.add(vps);
            new ControladorVerPass(vps);
        }
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        vp.btnAgregar.setVisible(false);
        vp.btnVer.setVisible(false);
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        vp.btnAgregar.setVisible(true);
        vp.btnVer.setVisible(true);
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        
    }
    
}
