package models;

import abstracts.Barang;

public class Makanan extends Barang {
    public Makanan(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public String getDeskripsi() {
        return "Makanan: " + getNama() + " | Harga: Rp " + getHarga();
    }
}
