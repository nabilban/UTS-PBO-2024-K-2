package models;

import abstracts.Barang;

public class Minuman extends Barang {
    public Minuman(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public String getDeskripsi() {
        return "Minuman: " + getNama() + " | Harga: Rp " + getHarga();
    }
}
