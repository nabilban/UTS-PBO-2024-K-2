package models;

import abstracts.Barang;

//inheritance
public class Makanan extends Barang {
    // Constructor
    public Makanan(String nama, double harga) {
        super(nama, harga);
    }

    // Overriding method getDeskripsi
    @Override
    public String getDeskripsi() {
        return "Makanan: " + getNama() + " | Harga: Rp " + getHarga();
    }
}
