/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.ArrayList;

/**
 *
 * @author march
 */
public class dosen extends orang {
    private String kd;//kode
    private long nip;
    private ArrayList<kelas> daftarkelas = new ArrayList();
    private int listKelas= 0;
   

   public dosen(String nama, String kode, long nip, String user, String pw) {
      super(nama,user,pw);
        this.nip = nip;
        this.kd = kd;
    }

    public ArrayList<kelas> getListKelas() {
        return daftarkelas;
    }
    
    public ArrayList<String> getNamaKelas(){
        ArrayList<String> nama = new ArrayList<>();
        for (kelas k : daftarkelas) {
//            String n = k.getNamaKelas();
//            nama.add(n);
              nama.add(k.getNamaKelas());
        }
        return nama;       
    }
    

    public String getKode() {
        return kd;
    }

    public long getNip() {
        return nip;
    }

    public void addKelas (String namaKelas){
        daftarkelas.add(new kelas(namaKelas));
    }
    
    public kelas getKelas(String kelas){
        for (kelas k : daftarkelas){
            if (k.getNamaKelas().equals(kelas)){
                return k;
            }
        }
        return null;
        
    }
    
    
    public kelas getKelasIdx(int x){
        return this.daftarkelas.get(x);
    }
    
    public void removeKelas(String kelas){
            daftarkelas.remove(this.getKelas(kelas));
    }
    
    public void removeKelasIdx(int x){
        daftarkelas.remove(x);
        
    }
    
//    public String showKelas(){
//        String s = " ";
//        
//        for (int i =1; i <=daftarkelas.size(); i++) {
//            kelas k = daftarkelas.get(i);
//            
//             s +="Kelas "+ i + k + "\n";
//         }
//        return s;
//    }
    
    
    public String toString(){
        return  super.getNama() + " - "
                + this.kd + " - ";
    }

//    public void addTugas(kelas k,String nama){ 
//        k.createTugas(nama);         
//    }
    
//    public void removeTugas(kelas k, String nama){
//       k.removeTugas(nama);
//    }

}


