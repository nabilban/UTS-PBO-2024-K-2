import java.util.InputMismatchException;
import java.util.Scanner;

import services.*;
import utils.ClearScreen;
import utils.HeaderName;
import models.*;
import abstracts.Barang;

public class Main {
    public static void main(String[] args) {

        // Clear Terminal
        ClearScreen.clear();
        HeaderName.nama();

        Scanner scanner = new Scanner(System.in);
        Keranjang keranjang = new Keranjang();
        Kasir kasir = new Kasir();

        // Membuat kategori dan barang
        Kategori kategoriMakanan = new Kategori("Makanan");
        kategoriMakanan.tambahBarang(new Makanan("Nasi Goreng", 20000));
        kategoriMakanan.tambahBarang(new Makanan("Ayam Bakar", 25000));
        kategoriMakanan.tambahBarang(new Makanan("Mie Ayam", 15000));
        kategoriMakanan.tambahBarang(new Makanan("Sate Ayam", 30000));

        Kategori kategoriMinuman = new Kategori("Minuman");
        kategoriMinuman.tambahBarang(new Minuman("Es Teh", 5000));
        kategoriMinuman.tambahBarang(new Minuman("Kopi", 10000));

        Kategori kategoriTambahan = new Kategori("Tambahan");
        kategoriTambahan.tambahBarang(new Tambahan("Sambal", 2000));
        kategoriTambahan.tambahBarang(new Tambahan("Kerupuk", 3000));

        // PREDIFINED VALUE FOR TESTING
        kasir.tambahSaldo(10000);
        keranjang.tambahBarang(new Makanan("Nasi Goreng", 20000));

        // Loop utama
        boolean jalan = true;
        while (jalan) {
            System.out.println("\nSaldo: Rp " + kasir.getSaldo());
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
                    ClearScreen.clear();
                    HeaderName.nama();
                    System.out.println(
                            "Masukkan jumlah saldo yang ingin ditambahkan: (kelipatan 5.000, maksimal input 100.000)");
                    System.out.println('\n');
                    System.out.print("Jumlah saldo yang ingin ditambahkan (Tanpa Titik): Rp ");
                    try {
                        double jumlah = scanner.nextDouble();
                        if (jumlah < 0) {
                            System.out.println("!! Jumlah saldo tidak valid.");
                        } else if (jumlah % 5000 != 0) {
                            System.out.println(" !! Jumlah saldo harus kelipatan 50000.");
                        } else {
                            kasir.tambahSaldo(jumlah);
                        }
                    } catch (InputMismatchException e) {
                        ClearScreen.clear();
                        HeaderName.nama();
                        System.out.println("!! Input tidak valid, harap masukkan angka.");
                        scanner.next();
                    }
                    break;

                case 2:
                    ClearScreen.clear();
                    HeaderName.nama();
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
                    ClearScreen.clear();
                    HeaderName.nama();
                    keranjang.tampilkanKeranjang();
                    System.out.println("\n");
                    System.out.println("Pilih kategori (1-3) : ");
                    System.out.println("1. Makanan");
                    System.out.println("2. Minuman");
                    System.out.println("3. Tambahan");
                    System.out.print("Pilih: ");
                    try {
                        int pilihanKategori = scanner.nextInt();
                        if (pilihanKategori < 1 || pilihanKategori > 3) {
                            ClearScreen.clear();
                            HeaderName.nama();
                            System.out.println("!! Pilihan kategori tidak valid.");
                            break;

                        }
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
                            ClearScreen.clear();
                            HeaderName.nama();
                            System.out.println("Kategori: " + kategoriDipilih.getNama());
                            System.out.println("Pilih barang: ");
                            for (int i = 0; i < kategoriDipilih.getBarangList().size(); i++) {
                                System.out.println(
                                        (i + 1) + ". " + kategoriDipilih.getBarangList().get(i).getDeskripsi());
                            }
                            System.out.print("Pilih (nomor): ");
                            int pilihanBarang = scanner.nextInt();
                            try {
                                if (pilihanBarang < 1 || pilihanBarang > kategoriDipilih.getBarangList().size()) {
                                    ClearScreen.clear();
                                    HeaderName.nama();
                                    System.out.println("!! Pilihan barang tidak valid.");
                                    break;
                                }
                            } catch (InputMismatchException e) {
                                ClearScreen.clear();
                                HeaderName.nama();
                                System.out.println("!! Input tidak valid, harap masukkan angka.");
                                scanner.next();
                                break;
                            }
                            ClearScreen.clear();
                            HeaderName.nama();
                            keranjang.tambahBarang(kategoriDipilih.getBarangList().get(pilihanBarang - 1));
                            System.out.println("Barang berhasil ditambahkan ke keranjang.");
                        }
                        break;
                    } catch (InputMismatchException e) {
                        ClearScreen.clear();
                        HeaderName.nama();
                        System.out.println("!! Input tidak valid, harap masukkan angka.");
                        scanner.next(); // Clear the invalid input
                        break;
                    }

                case 4:
                    ClearScreen.clear();
                    HeaderName.nama();
                    keranjang.tampilkanKeranjang();
                    break;
                case 5:
                    ClearScreen.clear();
                    HeaderName.nama();
                    if (keranjang.getTotalHarga() == 0) {
                        System.out.println("!! Keranjang masih kosong.");
                        break;
                    }
                    double total = keranjang.getTotalHarga();
                    System.out.println("\n");
                    System.out.println("Total yang harus dibayar: Rp " + total);
                    if (kasir.prosesPembayaran(total)) {
                        keranjang.bersihkan();
                    }
                    break;
                case 6:
                    ClearScreen.clear();
                    HeaderName.nama();
                    jalan = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
