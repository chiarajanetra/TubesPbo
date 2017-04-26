/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import tubes.Aplikasi;
import tubes.GUI.LoginGui;
import tubes.GUI.menuMahasiswa;
import tubes.dosen;
import tubes.kelas;
import tubes.mahasiswa;

/**
 *
 * @author IDS CREW
 */
public class mahasiswaHandler implements ActionListener {
   Aplikasi model;
    menuMahasiswa view;
   mahasiswa user;

    public mahasiswaHandler(Aplikasi model) {
        view = new menuMahasiswa();
        view.setVisible(true);
        view.AddActionListener(this);
        this.model = model;
        this.user = (mahasiswa) model.getUser();
    }
   
    public void setList(){
       view.getListDosen().setModel( new DefaultComboBoxModel(model.getListDosen().toArray()));
       
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object click = e.getSource();
        try {
            if (click.equals(view.getMenuLogout())) {
                this.user = null;
                model.logout();
                view.dispose();
            }
            else   if (click.equals(view.getBtnEnroll())) {
                
             dosen d = (dosen)   model.getDosenKD(view.getSelectDosen());
             kelas k = d.getKelas(view.getSelectKelas1());
             k.addMahasiswa(user);
            }
            if (view.getListDosen().isShowing()) {
                view.getListKelas().setModel( new DefaultComboBoxModel());
            }
    
        } catch (Exception ex) {
        }
        
    }
    
}
