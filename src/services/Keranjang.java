package services;

import java.util.ArrayList;
import abstracts.Barang;

public class Keranjang {
    private ArrayList<Barang> barangList;

    public Keranjang() {
        this.barangList = new ArrayList<>();
    }

    public void tambahBarang(Barang barang) {
        barangList.add(barang);
    }

    public double getTotalHarga() {
        double total = 0;
        for (Barang barang : barangList) {
            total += barang.getHarga();
        }
        return total;
    }

    public void tampilkanKeranjang() {
        for (Barang barang : barangList) {
            System.out.println(barang.getDeskripsi());
        }
        System.out.println("Total Harga: Rp " + getTotalHarga());
    }

    public void bersihkan() {
        barangList.clear();
    }
}
