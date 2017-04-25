
package tubes.control;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import tubes.Aplikasi;
import tubes.GUI.daftarGUI;


public class daftarHandler implements ActionListener{

    private Aplikasi model;
    private daftarGUI view;

        
    public daftarHandler(Aplikasi model) {
        view = new daftarGUI();
        view.setVisible(true);
        view.addActionListener(this);
        this.model = model;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       Object click = e.getSource();
       view.rbcekStatus();
       
       if (click.equals(view.getBtnDaftar())){
          if (view.getRbDosen().isEnabled()) {
           String nama = view.getName();
           String pw = view.getPw();
           String user = view.getUsername();
           String kode = view.getKode();
           long nip = view.getNIP();
           model.addDosen(nama, kode, nip, user, pw);
           view.reset();
          // view.setMahasiswa();
            JOptionPane.showMessageDialog(view, "Terdaftar");
            view.reset();
             }
          else if (view.getRbMahasiswa().isEnabled()) {
           String nama = view.getName();
           String pw = view.getPw();
           String user = view.getUsername();
           long nim = view.getNIP();  
           model.addMahasiswa(nama, nim, user, pw);
           JOptionPane.showMessageDialog(view, "Terdaftar");
           view.reset();
           }
          else {
              JOptionPane.showMessageDialog(view, "Silahkan pilih status.");
          } 
           
            }
              else if (click.equals(view.getBtnBatal())) {
            view.dispose();
            new menuHandler(model);
        }
}
}
