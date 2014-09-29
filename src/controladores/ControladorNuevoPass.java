/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.TipoAccesoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import modelos.TipoAcceso;
import vistas.NuevoPass;

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
        cargaTipoAcceso();
    }
    
    private void actionListener(ActionListener a){
        np.cmbTipo.addActionListener(a);
        np.cmbTipo.setActionCommand("Tipo");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Tipo")){
            camposDefecto();
            switch(np.cmbTipo.getSelectedItem().toString()){
                
            }
        }
    }
    
    private void cargaTipoAcceso(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        ArrayList<TipoAcceso> tipos = new TipoAccesoDAO().selectAll();
        for (Iterator<TipoAcceso> iterator = tipos.iterator(); iterator.hasNext();) {
            modelo.addElement(iterator.next());
        }
        np.cmbTipo.setModel(modelo);
        actionPerformed(new ActionEvent(this, 1, "Tipo"));
    }
    
    private void camposDefecto (){
        np.txtUsuario.setEnabled(true);
        np.txtPass.setEnabled(true);
        np.txtServidor.setEnabled(false);
        np.txtPuerto.setEnabled(false);
        np.txtURL.setEnabled(true);
    }
}
