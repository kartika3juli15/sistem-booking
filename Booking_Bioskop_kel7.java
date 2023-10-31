import java.util.Scanner;
import java.util.Random;

public class Booking_Bioskop_kel7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] judulFilm = {"", "Yowis Ben", "Joker", "Inception", "Pamali", "The Counjuring 2"};
        String[] menu = { "", "Popcorn", "Churros", "Kentang Goreng", "Orange Juice", "Jasmine Tea", "Mineral Water",
                "Lemon Tea" };
        String lagi = "";
        int poin = 0, gratisMinum, nomorKursi = 0, pilih;
        int jumlahKursi = 40, numMenu = 0;
        int[] hargaTiket = { 0, 40000, 40000, 40000, 40000, 40000 };
        int[] hargaMenu = { 0, 20000, 15000, 14000, 13000, 10000, 5000, 12000 };
        double Prosentase_Diskon = 0.20, Harga_Akhir, Pembayaran;
        double totalHarga = 0.0, harga = 0.0;
        boolean[] kursiTerisi = new boolean[jumlahKursi];

        // tempat bioskop
        Scanner input = new Scanner(System.in);
        String[] tempat = { "", "CGV", "XXI", "Movimax" };
        int[] kodeTempat = { 0, 1, 2, 3 };
        int key = 0;

        System.out.println("---Lokasi Yang Tersedia Saat Ini---");
        for (int i = 1; i < tempat.length; i++) {
            System.out.println(i + ". " + tempat[i]);
        }

        System.out.print("Masukan tempat: ");
        key = input.nextInt();

        for (int i = 0; i < kodeTempat.length; i++) {
            if (key == kodeTempat[i]) {
                if (i == 1 || i == 2 || i == 3) {
                    System.out.println("Bioskop Tersedia " + tempat[i]);
                    break;
                } else {
                    System.out.println("bioskop tidak ditemukan");
                    break;
                }
            }
        }
        System.out.println("--------------------------------");

        // umur
        System.out.println("    -masukkan umur anda-   ");
        System.out.println("===========================");
        int umur = sc.nextInt();
        if (umur < 13) {
            System.out.println("umur " + umur + " belum cukup umur");
        } else {
            System.out.println("umur " + umur + " sudah cukup umur");
            System.out.println("--------------------------");

            // pemilihan film
            System.out.println("");
            System.out.println("==========================");
            System.out.println("       Daftar Film        ");
            System.out.println("==========================");
            for (int i = 1; i < judulFilm.length; i++) {
                System.out.println(i + ". " + judulFilm[i] + " - Tersedia : " + hargaTiket[i]);
            }
            System.out.println("--------------------------");
            System.out.print("Pilih nomor film : ");
            int pilihanFilm = sc.nextInt();

            // jumlah tiket
            System.out.print("Masukkan jumlah tiket yang diinginkan : ");
            int numTickets = sc.nextInt();

            totalHarga += (hargaTiket[pilihanFilm] * numTickets);

            // pemilihan waktu
            // pemilihan waktu agak ambigu karena seharusnya milih waktu untuk menentukan
            // film di hari/waktu yang dipilih, bukan milih film dulu baru waktunya
            System.out.println("-----------------------------");
            System.out.print("masukkan hari : ");
            String hari = sc.next();
            sc.nextLine();
            System.out.print("masukkan tanggal tayang : ");
            int tanggal = sc.nextInt();
            System.out.print("masukkan bulan : ");
            int bulan = sc.nextInt();
            System.out.print("masukkan tahun : ");
            int tahun = sc.nextInt();
            System.out.print("Masukkan jam tayang : ");
            double jam_tayang = sc.nextDouble();
            System.out.println("-----------------------------");

            // pemilihan seat
            while (true) {
                System.out.println("====================");
                System.out.println("        Pilih       ");
                System.out.println("====================");
                System.out.println("1. booking seat");
                System.out.println("2. Lihat Ketersediaan seat");
                System.out.println("3. Keluar");
                System.out.println("--------------------");
                pilih = sc.nextInt();

                if (pilih == 3 && nomorKursi == 0) {
                    while (nomorKursi == 0) {
                        System.out.println("====================");
                        System.out.println("        Pilih       ");
                        System.out.println("====================");
                        System.out.println("1. booking seat");
                        System.out.println("2. Lihat Ketersediaan seat");
                        System.out.println("3. Keluar");
                        System.out.println("--------------------");
                        pilih = sc.nextInt();

                        if (pilih < 3) {
                            break;
                        }
                    }
                }

                if (pilih == 1) {
                    System.out.print("Nomor kursi yang ingin Anda pesan (1 - " + jumlahKursi + "): ");
                    nomorKursi = sc.nextInt();

                    if (nomorKursi >= 1 && nomorKursi <= jumlahKursi) {
                        if (!kursiTerisi[nomorKursi - 1]) {
                            kursiTerisi[nomorKursi - 1] = true;
                            System.out.println("Pemesanan berhasil. Nomor kursi " + nomorKursi);

                        } else {
                            System.out.println("Kursi sudah dipesan. Pilih kursi lain.");
                        }
                    } else {
                        System.out.println("Nomor kursi tidak valid.");
                    }

                } else if (pilih == 2) {
                    System.out.println("Ketersediaan kursi:");
                    for (int i = 0; i < jumlahKursi; i++) {
                        if (!kursiTerisi[i]) {
                            System.out.println("Kursi " + (i + 1) + ": Tersedia");
                        } else {
                            System.out.println("Kursi " + (i + 1) + ": Terisi");
                        }
                    }

                } else if (pilih == 3) {
                    System.out.println("pemilihan seat selesai.");
                    break;
                } else {
                    System.out.println("pemilihan seat tidak valid.");
                }
            }

            // pemilihan studio
            // int[] studio = { 0, 1, 2, 3, 4, 5, 6 };
            Random rand = new Random();
            // key = 2;
            // int hasil = 0;
            // for (int i = 0; i < studio.length; i++) {
            //     if (studio[i] == key) {

            //         hasil = i;
            //         break;
            //     }
            // }

            System.out.println("------------------------------");
            System.out.println("Silahkan masuk ke studio " + rand.nextInt(4));
            System.out.println("------------------------------");

            // pilih makanan dan minuman
            System.out.println("apakah anda ingin membeli makanan/minuman? (y/t)");
            String pilihan = sc.next();
            sc.nextLine();

            if (pilihan.equalsIgnoreCase("y")) {
                do {
                    int i;
                    System.out.println("==========================");
                    System.out.println("       Daftar Menu        ");
                    System.out.println("==========================");
                    for (i = 1; i < menu.length; i++) {
                        System.out.println(i + ". " + menu[i] + " - Tersedia : " + hargaMenu[i]);
                    }
                    System.out.println("--------------------------");
                    System.out.print("pilih : ");
                    int pilihanMenu = sc.nextInt();

                    if (pilihanMenu > 0 && pilihanMenu < menu.length) {

                        System.out.println("Anda memilih " + menu[pilihanMenu]);
                        System.out.println("--------------------------");
                        System.out.print("Masukkan jumlah menu yang diinginkan : ");
                        numMenu = sc.nextInt();
                        sc.nextLine();
                        System.out.println("--------------------------");

                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }

                    totalHarga += (hargaMenu[pilihanMenu] * numMenu);

                    System.out.print("Apakah anda ingin memesan lagi? (y/t) : ");
                    lagi = sc.nextLine();

                    if (lagi.equalsIgnoreCase("t")) {
                        break;
                    }
                } while (true);

            } else {
                System.out.println();
            }

            // total keseluruhan
            System.out.println("Total harga : Rp " + totalHarga);
            System.out.println("===Terima kasih telah memesan di Bioskop kami!===");

        }
    }
}
