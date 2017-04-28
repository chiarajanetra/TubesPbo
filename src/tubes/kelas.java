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
public class kelas {
    private mata_kuliah mk;
    private ArrayList<mahasiswa> anggota = new ArrayList<>();
    private String namaKelas;
    private ArrayList<tugas> Tugas = new ArrayList();
    private int jmlMhs = 0; //jml mhs
    private int jmlTgs = 0; //jml tugas
    
    public kelas(String namaKelas){
        this.namaKelas = namaKelas;
    }
    
   

    public void setMk(mata_kuliah mk) {
        this.mk = mk;
       
    } 
    
public tugas getTugas(String tugas){
    for (tugas t : Tugas){
        if (t.getNt().equals(tugas))
     return t;
    }
    return null;
}

    public mata_kuliah getMk() {
        return mk;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public ArrayList<tugas> getListTugas(){
        return this.Tugas;
    }

public void addMahasiswa(mahasiswa m){
 anggota.add(m);
}

public void addMataKuliah(mata_kuliah mkl){
    mk = mkl;
 }

public void createTugas(String tugas){
    Tugas.add(new tugas(tugas));
}

    public int getJml() {
        return anggota.size();
    }

    public int getJmlT() {
        return Tugas.size();
    }
    
    public void removeTugas(String tugas){
        Tugas.remove( this.getTugas(tugas));
    }
    
public mahasiswa getMhsID(long id){
    for (mahasiswa m : anggota){
        if (m.getNim() == id) {
            return m;
        }
    }    
    return null;
}



   public void showMahasiswa() {
   if (!anggota.isEmpty()){
       for (int i = 1; i <=anggota.size(); i++) {
        anggota.toString();
       }
    
   }
   }
  

   public void showTugas(){
       for (tugas t : Tugas){
            this.Tugas.toString();
                }
   
   }
   
   public String toString(){
       return this.namaKelas + " - " + this.jmlMhs + " Orang. ";
   }
   
   
}
