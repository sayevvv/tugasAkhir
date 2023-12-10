import java.util.Scanner;


public class rentalSepeda {
  static void inputJenis(String [][] sepeda) {
    Scanner sc = new Scanner(System.in);
    String namaJenis;
    for (int i = 0; i < sepeda.length; i++) {
              System.out.print("Input Jenis Sepeda " + (i+1) + " : ");
              namaJenis = sc.next();
              sepeda[i][0] = namaJenis;
      }
  }
  static void tampilanSepeda(String [][] sepeda) {
    Scanner sc = new Scanner(System.in);
    System.out.println("============================");
      System.out.println("    Sepeda yang tersedia    ");
      System.out.println("============================");
      for (int i = 0; i < sepeda.length; ++i) {
          for(int j = 0; j < sepeda[i].length; ++j) {
            if (sepeda[i][j] == null) {
              System.out.println("Sepeda Nomor " + j);
            }else {
                System.out.println(sepeda[i][j]);
            }
          }
          System.out.println();
        }
  }
  static double harga() {
    Scanner sc = new Scanner(System.in);
          System.out.print("Input harga rental per jam : ");
          double harga = sc.nextDouble();
          return harga;
  }
  static String namaPerental() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nama perental : ");
    String nama = sc.nextLine();
    return nama;
  }
  static void rentalUnit(String [][] sepeda, String nama, int waktu, int unitJenis, int lama, double harga) {
    Scanner sc = new Scanner(System.in);
    int pilihan = 0, pilihUnit = 0;
    boolean isValidInput = false, uangCukup = true;
    while(uangCukup) {
      do {
            System.out.print("Masukkan jenis sepeda: ");
            String pilihJenis = sc.next();
    
            for (int i = 0; i < sepeda.length; i++) {
                if (pilihJenis.equalsIgnoreCase(sepeda[i][0])) {
                    pilihan = i;
                    for (int j = 1; j < sepeda[i].length; j++) {
                        if (sepeda[i][j] == null) {
                            System.out.println("Sepeda Nomor " + j + " Tersedia");
                        } else {
                            System.out.println(sepeda[i][j]);
                        }
                    }
                    isValidInput = true;
                    break;
                }
            }
            if (!isValidInput) {
                System.out.println("Jenis sepeda tidak valid. Silahkan input lagi.");
            }
        } while (!isValidInput);
     while(true) {
            System.out.print("Pilih nomor sepeda yang tersedia : ");
            pilihUnit = sc.nextInt();
            if (pilihUnit == 0 || pilihUnit > unitJenis || sepeda[pilihan][pilihUnit] != null) {
              System.out.println("Invalid, silahkan input lagi");
              continue;
            } else {
              sepeda[pilihan][pilihUnit] = nama + " / " + waktu + " jam";
              break;
            }
          }
        double total = waktu * harga; 
        System.out.println("Harga untuk " + waktu + " jam Rental : " + total);
        System.out.print("Input uang konsumen : ");
        double uang = sc.nextDouble();
        if (uang >= total) {
          System.out.println("Kembalian : IDR " + (uang - total));
          uangCukup = false;
        } else {
          System.out.println("Uang tidak cukup, silahkan input lagi");
          sepeda[pilihan][pilihUnit] = null;
        }
    }
  }
  static int lamaPinjam() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Input lama peminjaman : ");
    int lama = sc.nextInt();
    return lama;
  }
  
  static void mengembalikan(String [][] sepeda) {
    Scanner sc = new Scanner(System.in);
    boolean found = false;
    boolean namaValid = false;
    
  
    do {
      System.out.print("Input nama peminjam : ");
      String nama = sc.nextLine();
      
      for(int i = 0; i < sepeda.length; i++) {
        for (int j = 0; j < sepeda[i].length; j++) {
          if(sepeda[i][j] != null) {
            String [] kata = sepeda[i][j].split(" / "); // memisahkan string yang panjang
            for (String cari : kata) {
              if(cari.equalsIgnoreCase(nama)) {
                found = true;
                namaValid = true;
                System.out.println("peminjam atas nama " + nama + " telah mengembalikan sepeda");
                sepeda[i][j] = null;
              }
            }
          }
        }
      }
      if(found) {
        tampilanSepeda(sepeda);
      }
    }while(!namaValid);
  
  }
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      double hargaPerJam;
      int opsiProgram, waktu;
      String nama;
      boolean quit = true, mainLoop = true;
      System.out.println("Selamat datang di program RENTAL SEPEDA");
      System.out.println("Set Rental Sepeda");
      System.out.print("Input Jumlah Jenis Sepeda Yang Mau Direntalkan: ");
                int jumlahJenis = sc.nextInt();
                System.out.print("Input Jumlah Unit Per Jenis : ");
                int unitJenis = sc.nextInt();
                String sepeda [][] = new String[jumlahJenis][unitJenis + 1];
                    
                inputJenis(sepeda);
                    
                  
                hargaPerJam = harga();
              
                tampilanSepeda(sepeda);
                System.out.println("Dengan harga/jam : " + hargaPerJam);
      do {
        System.out.println("=== Menu ===");
        System.out.println("1. Merental");
        System.out.println("2. Mengembalikan");
        System.out.println("3. Keluar");
                System.out.print("Pilih opsi program : ");
                opsiProgram = sc.nextInt();
                switch (opsiProgram) {
                case 1:
                boolean lanjutRental = true;
                while(lanjutRental) {
                  tampilanSepeda(sepeda);

                  nama = namaPerental();
                  
                  waktu = lamaPinjam();

                  rentalUnit(sepeda, nama, waktu, unitJenis, waktu, hargaPerJam);
                                   
                  System.out.println("Y untuk lanjut || Any key untuk berhenti");
                  System.out.print("Ingin pesan lagi? ");
                  String pesanLagi = sc.next();
                  if(pesanLagi.equalsIgnoreCase("y")) {
                  continue;
                  }  else {
                    lanjutRental = false;
                  }
                  }
                  break;

                case 2:

                tampilanSepeda(sepeda);
                mengembalikan(sepeda);
                
                break;

                case 3 :
                quit = false;
                break;
      }
    }while (quit);

   
sc.close();    
}
}