package models;

import abstracts.Barang;

//inheritance
public class Tambahan extends Barang {
    // Constructor
    public Tambahan(String nama, double harga) {
        super(nama, harga);
    }

    // Overriding method getDeskripsi
    @Override
    public String getDeskripsi() {
        return "Tambahan: " + getNama() + " | Harga: Rp " + getHarga();
    }
}
