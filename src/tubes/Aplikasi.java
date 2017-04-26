/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;
import java.lang.reflect.Array;
import java.util.*;
/**
 *
 * @author MARCHIO
 */
public class Aplikasi {
 //   private ArrayList<orang> person1;
    private Collection<orang> person = new ArrayList();
    private ArrayList<mata_kuliah> daftarMatakuliah = new ArrayList();
    private Scanner cin = new Scanner(System.in);
    private  int x = 0;
    private dosen call; //caller
    private mahasiswa call1; //caller
    private dosen userD; //caller
    private mahasiswa userM; //caller                                     
    private orang user;

    
    
    public void logout(){
        this.user = null;
    }
    
    //function add
    
    public void addMatkul(mata_kuliah m){
       this.daftarMatakuliah.add(m);
    }
    
       public void addMahasiswa(mahasiswa m){
           this.person.add(m) ;
      }
       
    public void addDosen(dosen d){
        this.person.add(d);        
    }
    
    public void addKelas(String kelas,String kode){
       dosen d = (dosen) getDosenKD(kode);
       
    }
    
    public ArrayList<dosen> getListDosen(){
       ArrayList<dosen> d = new ArrayList();
        
        for (orang o : person) {
            if (o instanceof dosen) {
                d.add( (dosen) o );
            }
        }
        return d;
    }
    
    //end function add
    //getter
    
public orang getOrang(String user, String pw){
    for (orang o : person) {
        if (o.getUser().equals(user) && o.getPw().equals(pw))
            return o;
            }
    return null;
}


public orang getUser(){
    return this.user;
}

public void setUser(orang or){
    if (or instanceof dosen) {
        this.userD = (dosen) or;
        
    }
    else  {
        this.userM = (mahasiswa) or;
    }
}




    public orang getNIMMahasiswa(long nim){//getMahasiswaByNimTerdaftar
        for (orang o : person){
            if (o instanceof mahasiswa){
                this.call1 = (mahasiswa) o;
                    if (this.call1.getNim() == nim){
                       return o;
                    }
    }
        }
        return null;
}
    
    public orang getDosenKD(String kd){
          for (orang o : person){
           if (o instanceof dosen ){
               this.call = (dosen) o;
               if (this.call.getKode().equals(kd)){
               return o;
               }
           }
        }
        return null;
    }    
    public mata_kuliah getMatkul(String nama){//getMatkulByName
        for (mata_kuliah o : daftarMatakuliah){
            if (o.getNamaMatkul().equals(nama)){
                return o;
            } 
        }
        return null;
    }
    public orang getOrang(String nama){
        for (orang o : person) {
            if (o.getNama().equals(nama)) {
             return o;   
            }
        }
        return null;
    }
    
    public kelas getKelas(String nama){
        return userD.getKelas(nama);
    }
    
    
    //end getter
    //delete
    
    
public void deletePersonName(String nama){//deletePersonOnName
       person.remove(this.getOrang(nama));
    }
    public void deleteDosen(String kd){
        person.remove(this.getDosenKD(kd));
    }
    public void deleteMahasiswa(long nim){
        person.remove(this.getNIMMahasiswa(nim));
        
    }
    public void deleteMatkul(String nama){
        person.remove(this.getMatkul(nama));
    }
    //end Delete1
    
public boolean isCorrect(String pw){
    for (orang o : person){
        if (o.getPw().equals(pw))
            return true;
    }
    return false;
}

      
  
  public void ShowlistDosen(){//showListDosen
        for (orang o : person){
            if (o instanceof dosen){
                this.call = (dosen) o;
                 this.call.toString();
            }           
        }
    }
  
  //show list 
      public void listMahasiswa(dosen D,String kelas){
          D.getKelas(kelas).showMahasiswa();
      }
       public void ShowlistMatkul(){//showListMatkulTerdaftar
        for (mata_kuliah o :daftarMatakuliah){
           o.toString();
        }
    }
         
    
    
}
