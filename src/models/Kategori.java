package models;

import java.util.ArrayList;
import abstracts.Barang;

public class Kategori {
    private String nama;
    private ArrayList<Barang> barangList;

    // setter
    public Kategori(String nama) {
        this.nama = nama;
        this.barangList = new ArrayList<>();
    }

    // getter
    public String getNama() {
        return nama;
    }

    // setter
    public void tambahBarang(Barang barang) {
        barangList.add(barang);
    }

    // getter
    public ArrayList<Barang> getBarangList() {
        return barangList;
    }
}
