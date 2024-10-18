package models;

import abstracts.Barang;

public class Tambahan extends Barang {
    public Tambahan(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public String getDeskripsi() {
        return "Tambahan: " + getNama() + " | Harga: Rp " + getHarga();
    }
}
