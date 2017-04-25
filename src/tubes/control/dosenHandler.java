/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tubes.Aplikasi;
import tubes.GUI.menuDosen;
import tubes.dosen;
import tubes.orang;

/**
 *
 * @author IDS CREW
 */
public class dosenHandler implements ActionListener{
    Aplikasi model;
    menuDosen view;
    dosen user;
    
    public dosenHandler(Aplikasi model){
        this.model = model;
        view = new menuDosen();
        view.setVisible(true);
        view.addActionListener(this);
        this.user = (dosen) model.getUser();
    }
    
    public void setListKelas(){
        
        
      }

    @Override
    public void actionPerformed(ActionEvent e) {
            Object click = e.getSource();
            
            if (click.equals(view.getMenuLogout())){
                model.logout();
                view.dispose();
                new menuHandler(model);
            }
            
                

    }
    
    
    
}
