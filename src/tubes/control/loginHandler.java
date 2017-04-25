/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import tubes.Aplikasi;
import tubes.GUI.LoginGui;
import tubes.orang;

/**
 *
 * @author MARCHIO
 */
public class loginHandler implements ActionListener {
    private Aplikasi model;
    private LoginGui view;
   

    
    public loginHandler (Aplikasi model) {
        view = new LoginGui();
        view.setVisible(true);
        view.addActionListener(this);
        this.model = model;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    Object click = e.getSource();
    if (click.equals(view.getBtnLogin())){
        orang o = model.getOrang(view.getUsername(),view.getPw());
       if (o!= null){
           model.setUser(o);
       }
       else {
           view.resetAll();
           JOptionPane.showMessageDialog(view,"User Belum Terdaftar");
       }
    }    
       else if (click.equals(view.getBtnBatal())) {
            view.dispose();
            new menuHandler(model);
        }
    else if (click.equals(view.getBtnDaftar())) {
            view.dispose();
            new daftarHandler(model);
        }
}
}
