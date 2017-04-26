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
import tubes.kelas;
import tubes.mata_kuliah;
import tubes.orang;

/**
 *
 * @author IDS CREW
 */
public class dosenHandler implements ActionListener{
    public Aplikasi model;
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
            try {
             if (click.equals(view.getMenuLogout())){
                model.logout();
                view.dispose();
                new menuHandler(model);
            }
            else if (click.equals(view.getBtnAddTugas())) {
                String s = view.getTfNamaTugas();
                kelas k = user.getKelas(view.getSelectKelas1());
                user.addTugas(k, s);
                }
            else if (click.equals(view.getBtnTambahMatkul())) {
                    kelas k = user.getKelas(view.getSelectKelas2());
                    mata_kuliah m = model.getMatkul(view.getSelecttMatkul());
                    k.addMataKuliah(m);
                }
            else if (click.equals(view.getBtnRegMatkul())) {
                    String s = view.getTfMatkul().getText();
                    model.addMatkul(new mata_kuliah(s, view.getIntSKS()));
                   
                }
            else if (click.equals(view.getBtnRemove())) {
                    String s = view.getSelectKelas3();
                    user.removeKelas(s);
                }
            else if (click.equals(view.getBtnAddKelas())) {
                    user.addKelas(view.getTfKelas());
                }
             
        }
            catch (Exception ex) {
            
        }
           
            
                

    }
    
    
    
}
