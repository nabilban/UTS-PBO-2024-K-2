package abstracts;

// Abstract class
public abstract class Barang {
    // Encapsulation
    private String nama;
    private double harga;

    // Constructor
    public Barang(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    // Getter
    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    // Abstract method
    public abstract String getDeskripsi();
}
