/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.NuevoPass;
import vistas.VentanaPrincipal;

/**
 *
 * @author Alan
 */
public class ControladorNuevoPass implements ActionListener{

    NuevoPass np;

    public ControladorNuevoPass(NuevoPass np) {
        this.np = np;
        this.np.setVisible(true);
        actionListener(this);
    }
    
    public void actionListener(ActionListener a){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void internalFrameClosing(){
        
    }
}
