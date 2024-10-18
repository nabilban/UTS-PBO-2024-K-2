package models;

import java.util.ArrayList;
import abstracts.Barang;

public class Kategori {
    private String nama;
    private ArrayList<Barang> barangList;

    public Kategori(String nama) {
        this.nama = nama;
        this.barangList = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public void tambahBarang(Barang barang) {
        barangList.add(barang);
    }

    public ArrayList<Barang> getBarangList() {
        return barangList;
    }
}
