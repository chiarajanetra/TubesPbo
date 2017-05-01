/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.parser.TokenType;
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
    DefaultListModel kelasTemp = new DefaultListModel<>();
    DefaultListModel kelasTemp1 = new DefaultListModel<>();
    
    public dosenHandler(Aplikasi model){
        this.model = model;
        view = new menuDosen();
        view.setVisible(true);
        view.addActionListener(this);
        this.user = (dosen) model.getUser();
    }
    
    public void setListKelas(){
           view.getListSelected1().setModel(kelasTemp1);
           view.getListSelected().setModel(kelasTemp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object click = e.getSource();



           try {
                if (click.equals(view.getMenuLogout())) {
                    view.dispose();
                }
                else if (click.equals(view.getBtnAddKelas())) {
                   user.addKelas(view.getTfKelas());
                }
                //addTugas

                else if (click.equals(view.getBtnTambahList())) {
                  this.kelasTemp.addElement((String) view.getCbKelas().getSelectedItem());
                                 
                }
                else if (click.equals(view.getBtnHapusList())) {
                 this.kelasTemp.removeElementAt(view.getListSelected1().getSelectedIndex());
                                    
                }
                else if (click.equals(view.getBtnAddTugas())) {
                    String s = view.getTfNamaTugas();
                     for (int i = 1; i < this.kelasTemp.getSize(); i++) {
                       String k = (String) this.kelasTemp.get(i);
                       user.getKelas(k).createTugas(s);
                }
                      JOptionPane.showMessageDialog(view, "Tugas Berhasil Ditambahkan.");
                    }                     
                //remove
                else if (click.equals(view.getBtTambahList1())) {
                this.kelasTemp1.addElement((String) view.getCbKelas2().getSelectedItem());
               } 
                else if (click.equals(view.getBtHapusList1())) {
                    this.kelasTemp1.remove(view.getListSelected().getSelectedIndex());
                 
               
                }
                
                
        } catch (Exception ex) {
            
        }
            
            
            
            
//            try {
//             if (click.equals(view.getMenuLogout())){
//                model.logout();
//                view.dispose();
//                new menuHandler(model);
//            }
//            else if (click.equals(view.getBtnAddTugas())) {
//                String s = view.getTfNamaTugas();
//                kelas k = user.getKelas(view.getSelectKelas1());
//                user.addTugas(k, s);
//                }
//            else if (click.equals(view.getBtnTambahMatkul())) {
//                    kelas k = user.getKelas(view.getSelectKelas2());
//                    mata_kuliah m = model.getMatkul(view.getSelecttMatkul());
//                    k.addMataKuliah(m);
//                }
//            else if (click.equals(view.getBtnRegMatkul())) {
//                    String s = view.getTfMatkul().getText();
//                    model.addMatkul(new mata_kuliah(s, view.getIntSKS()));
//                   
//                }
//            else if (click.equals(view.getBtnRemove())) {
//                    String s = view.getSelectKelas3();
//                    user.removeKelas(s);
//                }
//            else if (click.equals(view.getBtnAddKelas())) {
//                    user.addKelas(view.getTfKelas());
//                }
//             
//        }
//            catch (Exception ex) {
//            
//        }
           
            
                

    }
    
    
    
}
