import java.util.Scanner;

import services.*;
import models.*;
import abstracts.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Keranjang keranjang = new Keranjang();
        Kasir kasir = new Kasir();

        // Membuat kategori dan barang
        Kategori kategoriMakanan = new Kategori("Makanan");
        kategoriMakanan.tambahBarang(new Makanan("Nasi Goreng", 20000));
        kategoriMakanan.tambahBarang(new Makanan("Ayam Bakar", 25000));

        Kategori kategoriMinuman = new Kategori("Minuman");
        kategoriMinuman.tambahBarang(new Minuman("Es Teh", 5000));
        kategoriMinuman.tambahBarang(new Minuman("Kopi", 10000));

        Kategori kategoriTambahan = new Kategori("Tambahan");
        kategoriTambahan.tambahBarang(new Tambahan("Sambal", 2000));
        kategoriTambahan.tambahBarang(new Tambahan("Kerupuk", 3000));

        // Loop utama
        boolean jalan = true;
        while (jalan) {
            System.out.println("\n1. Tambah Saldo");
            System.out.println("2. Lihat Kategori dan Barang");
            System.out.println("3. Tambah Barang ke Keranjang");
            System.out.println("4. Lihat Keranjang");
            System.out.println("5. Bayar");
            System.out.println("6. Keluar");
            System.out.print("Pilih: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jumlah saldo: Rp ");
                    double jumlah = scanner.nextDouble();
                    kasir.tambahSaldo(jumlah);
                    break;
                case 2:
                    System.out.println("\nKategori: " + kategoriMakanan.getNama());
                    for (Barang barang : kategoriMakanan.getBarangList()) {
                        System.out.println(barang.getDeskripsi());
                    }
                    System.out.println("\nKategori: " + kategoriMinuman.getNama());
                    for (Barang barang : kategoriMinuman.getBarangList()) {
                        System.out.println(barang.getDeskripsi());
                    }
                    System.out.println("\nKategori: " + kategoriTambahan.getNama());
                    for (Barang barang : kategoriTambahan.getBarangList()) {
                        System.out.println(barang.getDeskripsi());
                    }
                    break;
                case 3:
                    System.out.println("Pilih kategori: ");
                    System.out.println("1. Makanan");
                    System.out.println("2. Minuman");
                    System.out.println("3. Tambahan");
                    int pilihanKategori = scanner.nextInt();

                    Kategori kategoriDipilih = null;
                    switch (pilihanKategori) {
                        case 1:
                            kategoriDipilih = kategoriMakanan;
                            break;
                        case 2:
                            kategoriDipilih = kategoriMinuman;
                            break;
                        case 3:
                            kategoriDipilih = kategoriTambahan;
                            break;
                    }

                    if (kategoriDipilih != null) {
                        System.out.println("Pilih barang: ");
                        for (int i = 0; i < kategoriDipilih.getBarangList().size(); i++) {
                            System.out.println((i +
                                    1) + ". " + kategoriDipilih.getBarangList().get(i).getDeskripsi());
                        }
                        int pilihanBarang = scanner.nextInt();
                        keranjang.tambahBarang(kategoriDipilih.getBarangList().get(pilihanBarang - 1));
                        System.out.println("Barang berhasil ditambahkan ke keranjang.");
                    }
                    break;
                case 4:
                    keranjang.tampilkanKeranjang();
                    break;
                case 5:
                    double total = keranjang.getTotalHarga();
                    System.out.println("Total yang harus dibayar: Rp " + total);
                    if (kasir.prosesPembayaran(total)) {
                        keranjang.bersihkan();
                    }
                    break;
                case 6:
                    jalan = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
