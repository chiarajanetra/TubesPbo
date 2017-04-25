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
    private orang user;

    
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
          
        
       
        if (model.isAda(view.getName())){
                if(model.getUser().getPw().equals(view.getPw())  ){
                    user = model.getOrang(view.getUsername());
                    view.dispose();
                    new dosenHandler(model, user);
                    //menu mhs/dosen
                }
                else{ JOptionPane.showMessageDialog(view,"Password Salah");
                view.resetPw();}
            }
         else {
            view.resetAll();
            JOptionPane.showMessageDialog(view,"User Tidak Ditemukan");
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
