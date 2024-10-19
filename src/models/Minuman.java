package models;

import abstracts.Barang;

//inheritance
public class Minuman extends Barang {
    // Constructor
    public Minuman(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public String getDeskripsi() {
        return "Minuman: " + getNama() + " | Harga: Rp " + getHarga();
    }
}
