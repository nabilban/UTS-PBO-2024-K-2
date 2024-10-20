package services;

public class Kasir {
    // Atribut
    private double saldo;

    // Constructor
    public Kasir() {
        this.saldo = 0;
    }

    // Method untuk menambahkan saldo
    public void tambahSaldo(double jumlah) {
        this.saldo += jumlah;
        System.out.println("Saldo berhasil ditambahkan. Saldo saat ini: Rp " + this.saldo);
    }

    // Method untuk proses pembayaran
    public boolean prosesPembayaran(double totalHarga) {
        if (this.saldo >= totalHarga) {
            // Saldo mencukupi untuk membayar
            this.saldo -= totalHarga;
            System.out.println("Pembayaran berhasil. Sisa saldo: Rp " + this.saldo);
            return true;
        } else {
            System.out.println("Saldo tidak cukup. Silakan isi saldo.");
            return false;
        }
    }

    // Getter
    public double getSaldo() {
        return this.saldo;
    }
}
