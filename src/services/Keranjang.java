package services;

import java.util.ArrayList;
import abstracts.Barang;

public class Keranjang {
    private ArrayList<Barang> listKeranjang;

    public Keranjang() {
        this.listKeranjang = new ArrayList<>();
    }

    public void tambahBarang(Barang barang) {
        listKeranjang.add(barang);
    }

    public double getTotalHarga() {
        double total = 0;
        for (Barang barang : listKeranjang) {
            total += barang.getHarga();
        }
        return total;
    }

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

    public void bersihkan() {
        listKeranjang.clear();
    }
}
