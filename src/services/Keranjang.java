package services;

import java.util.ArrayList;
import abstracts.Barang;

public class Keranjang {
    // Atribut
    private ArrayList<Barang> listKeranjang;

    // Constructor
    public Keranjang() {
        this.listKeranjang = new ArrayList<Barang>();
    }

    // Method
    public void tambahBarang(Barang barang) {
        listKeranjang.add(barang);
    }

    // Getter
    public double getTotalHarga() {
        double total = 0;
        for (Barang barang : listKeranjang) {
            total += barang.getHarga();
        }
        return total;
    }

    // Method untuk menampilkan keranjang
    public void tampilkanKeranjang() {
        System.out.println("Keranjang Belanja:");
        if (listKeranjang.isEmpty()) {
            System.out.println(" - Keranjang masih kosong - ");
            return;
        }
        for (Barang barang : listKeranjang) {
            System.out.println(barang.getDeskripsi());
        }
        System.out.println("Total Harga: Rp " + getTotalHarga());
    }

    // method untuk mengosongkan keranjang
    public void bersihkan() {
        listKeranjang.clear();
    }
}
