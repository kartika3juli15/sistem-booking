import java.util.Scanner;

public class bookingKel7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] menu = { "", "Popcorn", "Churros", "Kentang Goreng", "Orange Juice", "Jasmine Tea", "Mineral Water", "Lemon Tea" };
        String lagi = "", movie;
        int counter = 0, numMenu = 0, hargaTiket = 30000, bioskop;
        int[] hargaMenu = { 0, 20000, 15000, 14000, 13000, 10000, 5000, 12000 };
        double totalHarga = 0.0;
        String[][] dataFilmBioskop = new String[5][4]; 
        String[][] dataBioskop = new String[1][3];
        int i = 0;


        System.out.println("===============================");
        System.out.println("SELAMAT DATANG DI BIOSKOP KAMI!");
         System.out.println("==============================");
    // umur
        System.out.print("masukkan umur anda : ");
        int umur = sc.nextInt();
        if (umur < 13) {
            System.out.println("umur " + umur + " belum cukup umur");
        } else {
            System.out.println("umur " + umur + " sudah cukup umur");
            System.out.println("--------------------------");

    //bioskop pilihan
        dataBioskop[0][0] = "1. CGV";
        dataBioskop[0][1] = "2. XXI";
        dataBioskop[0][2] = "3. Movimax";

        // Menambahkan data film dan studio 
        dataFilmBioskop[0][0] = "Yowis ben";
        dataFilmBioskop[0][1] = "studio 1";
        dataFilmBioskop[0][2] = "13.00, 15.30, 18.00";
        dataFilmBioskop[0][3] = "Rp.30.000,00";

        dataFilmBioskop[1][0] = "Joker";
        dataFilmBioskop[1][1] = "studio 4";
        dataFilmBioskop[1][2] = "14.00, 16.30, 19.00";
        dataFilmBioskop[1][3] = "Rp.30.000,00";

        dataFilmBioskop[2][0] = "Pamali";
        dataFilmBioskop[2][1] = "studio 3";
        dataFilmBioskop[2][2] = "13.30, 16.00, 18.30";
        dataFilmBioskop[2][3] = "Rp.30.000,00";

        dataFilmBioskop[3][0] = "Inception";
        dataFilmBioskop[3][1] = "studio 5";
        dataFilmBioskop[3][2] = "14.00, 16.00, 18.00";
        dataFilmBioskop[3][3] = "Rp.30.000,00";

        dataFilmBioskop[4][0] = "Barbie";
        dataFilmBioskop[4][1] = "studio 2";
        dataFilmBioskop[4][2] = "14.30, 16.30, 18.30";
        dataFilmBioskop[4][3] = "Rp.30.000,00";

    //pilih bioskop
        System.out.println("---------Daftar Bioskop---------");
        for (i = 0; i < dataBioskop.length; i++) {
            System.out.println(dataBioskop[i][0]);
            System.out.println(dataBioskop[i][1]);
            System.out.println(dataBioskop[i][2]);
            System.out.println("-------------------------------------");
            System.out.print("silahkan pilih bioskop yang tersedia : ");
            bioskop = sc.nextInt();
            sc.nextLine();
            System.out.println("-------------------------------------");
        
        if (bioskop == 1) {
            System.out.println("film yang tersedia : ");
            System.out.println("1. " + dataFilmBioskop[0][0]);
            System.out.println("2. " + dataFilmBioskop[2][0]);

        } else if (bioskop == 2) {
            System.out.println("film yang tersedia : ");
            System.out.println("1. " + dataFilmBioskop[3][0]);
            System.out.println("2. " + dataFilmBioskop[4][0]);

        } else if (bioskop == 3) {
            System.out.println("film yang tersedia : ");
            System.out.println("1. " + dataFilmBioskop[1][0]);
            System.out.println("2. " + dataFilmBioskop[4][0]);
        }
        }
        System.out.println("-------------------------------------");
        System.out.print("Masukkan nama film yang ingin dicari (ketik film) : ");
        movie = sc.nextLine();
        System.out.println("-------------------------------------");
    
        boolean filmTersedia = false;

        for (i = 0; i < dataFilmBioskop.length; i++) {
            if (movie.equalsIgnoreCase(dataFilmBioskop[i][0])) {
                System.out.println("---------Film Tersedia!---------");
                System.out.println("studio      : " + dataFilmBioskop[i][1]);
                System.out.println("Jam Tayang  : " + dataFilmBioskop[i][2]);
                System.out.println("Harga       : " + dataFilmBioskop[i][3]);
                filmTersedia = true;
                System.out.println("---------------------------------");
                break;
            }
        }
        if (!filmTersedia) { 
            System.out.println("Film tidak ditemukan di dalam daftar."); 
    }

    // jumlah tiket
            System.out.println("----------------------------------------");
            System.out.print("Masukkan jumlah tiket yang diinginkan : ");
            int numTickets = sc.nextInt();

            totalHarga += (hargaTiket * numTickets);

            //display
            //int[] displaySeat = new int[numTickets];
            //displaySeat[0] = 0;

    // pemilihan seat
            int baris = 5;
            int kolom = 8;
            int pilihBaris, kursi;
            boolean[][] tersedia = new boolean[baris][kolom];

        // bagian nested loop untuk ketersediaan seat
        for (i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                tersedia[i][j] = true;
            }
        }

    // Menampilkan peta seat
        while (true) {
            System.out.println("====PETA SEAT====");
            for (i = 0; i < baris; i++) {
                System.out.print("Baris " + (i + 1) + ": ");
                for (int j = 0; j < kolom; j++) {
                    if (tersedia[i][j]) {
                        System.out.print("O ");
                    } else {
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }

            System.out.println("---------------------");
            System.out.print("Nomor kursi yang ingin Anda pesan (baris 1 - " + baris + "): ");
                pilihBaris = sc.nextInt();
            System.out.print("pilih kursi (kolom 1 - " + kolom + "): ");
                kursi = sc.nextInt();

                if (pilihBaris >= 1 && pilihBaris <= baris && kursi >= 1 && kursi <= kolom) {
                    if (tersedia[pilihBaris - 1][kursi - 1]) {
                        tersedia[pilihBaris - 1][kursi - 1] = false;
                    System.out.println("seat berhasil dipilih!");
                    } else {
                    System.out.println("Maaf, seat tersebut sudah dipesan. Silakan pilih seat lain.");
                }
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            
            System.out.println("---------------------------");
            System.out.println("=========PETA SEAT=========");
            for (i = 0; i < baris; i++) {
                System.out.print("Baris " + (i + 1) + ": ");
                for (int j = 0; j < kolom; j++) {
                    if (tersedia[i][j]) {
                        System.out.print("O ");
                    } else {
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
                System.out.println("-------------------------");
                System.out.print("Ingin melanjutkan memilih seat? (y/t): ");
                String milih = sc.next();
                System.out.println();

                if (milih.equalsIgnoreCase("t")) {
                    break;
                }
            }
    // pilih makanan dan minuman
            System.out.println("===========================");
            System.out.println("apakah anda ingin membeli makanan/minuman? (y/t)");
            String pilihan = sc.next();
            sc.nextLine();

            int pilihanMenu = 0;

            //display
            int[] displayMenu = new int[10];
            displayMenu[0] = 0;

            int[] displayJumlahMenu = new int[10];
            displayJumlahMenu[0] = 0;

            if (pilihan.equalsIgnoreCase("y")) {

                do {
                    
                    System.out.println("==========================");
                    System.out.println("       Daftar Menu        ");
                    System.out.println("==========================");
                    for (i = 1; i < menu.length; i++) {
                        System.out.println(i + ". " + menu[i] + " - Tersedia : " + hargaMenu[i]);
                    }
                    System.out.println("--------------------------");
                    System.out.print("pilih : ");
                    pilihanMenu = sc.nextInt();

                    if (pilihanMenu > 0 && pilihanMenu < menu.length) {

                        System.out.println("Anda memilih " + menu[pilihanMenu]);
                        System.out.println("--------------------------");
                        System.out.print("Masukkan jumlah menu yang diinginkan : ");
                        numMenu = sc.nextInt();
                        sc.nextLine();
                        System.out.println("--------------------------");

                        //display
                        displayMenu[counter] = pilihanMenu;
                        displayJumlahMenu[counter] = numMenu;

                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }

                    totalHarga += (hargaMenu[pilihanMenu] * numMenu);

                    //display
                    counter++;
                    

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
            System.out.println();
            System.out.println("=======================================");
            System.out.println("||           STRUK BIOSKOP           ||");
            System.out.println("=======================================");
            System.out.println("||NAMA FILM : " + movie + "                 ||");
            System.out.println("---------------------------------------");
            for (i = 0; i < dataFilmBioskop.length; i++) {
                if (movie.equalsIgnoreCase(dataFilmBioskop[i][0])) {
             System.out.println("||jumlah tiket  : " + numTickets + "                    ||");
            System.out.println("||studio        : " + dataFilmBioskop[i][1] + "             ||");
            System.out.println("||Jam Tayang    : " + dataFilmBioskop[i][2] + "  ||");
            System.out.println("||Harga         : " + dataFilmBioskop[i][3] + "         ||");
            filmTersedia = true;
            System.out.println("----------------------------------------");
            break;
            }
        }
            //System.out.println("---------------------------------");
            //for (int i = 0; i < tersedia.length; i++) {
                //System.out.print("Seat " + (i + 1) + " : No. " + tersedia[i]);
                //System.out.println();
       

            //}
            if (pilihan.equalsIgnoreCase("y")) {
                System.out.println("=========================================");
                System.out.println("|| Makanan & Minuman");
                for (i = 0; i < counter; i++) {
                    System.out.println("|| " + menu[displayMenu[i]] + " : " + displayJumlahMenu[i] + "   Rp. " + hargaMenu[displayMenu[i]] * displayJumlahMenu[i]);
                }
            } else {
                
            }

            System.out.println("=========================================");
            System.out.println("||Total harga : Rp " + totalHarga);
            System.out.println("===Terima kasih telah memesan di Bioskop kami!===");
             

        }
    }
}

