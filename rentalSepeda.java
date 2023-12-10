import java.util.Scanner;


public class rentalSepeda {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
      double hargaPerJam = 0;
      int opsiKonsumen, waktu;
      String nama;
      boolean quit = true, programLuar = true;
      int jumlahJenis = 0, unitJenis = 0;
      
      String[][] sepeda = null;

      do {
        System.out.println("=============== Menu Program ===============");
        System.out.println("= 1. Penyedia jasa rental                  =");
        System.out.println("= 2. Konsumen                              =");
        System.out.println("= 3. Keluar                                =");
        System.out.println("============================================");
        System.out.print("> Pilih opsi program (1/2/3) : ");
        int opsiProgram = sc.nextInt();

        switch(opsiProgram) {
          case 1:
          System.out.println("=== Penyedia Jasa Rental ===");
          jumlahJenis = jumlahJenis();

          unitJenis = unitJenis();

          hargaPerJam = harga();
          sepeda = new String[jumlahJenis][unitJenis + 1];
          inputJenis(sepeda);
          tampilanSepeda(sepeda);

                break;
          case 2 :
          do {
            if (sepeda == null) {
              System.out.println("Mohon maaf, jasa rental tidak tersedia");
              break;
            }
            System.out.println("============ Menu (Konsumen) ===============");
            System.out.println("= 1. Merental                              =");
            System.out.println("= 2. Mengembalikan                         =");
            System.out.println("= 3. Kembali                               =");
            System.out.println("============================================");
            System.out.print("> Pilih opsi program (1/2/3) : ");
                    opsiKonsumen = sc.nextInt();
                    switch (opsiKonsumen) {
                    case 1:
                    boolean lanjutRental = true;
                    while(lanjutRental) {
    
                      tampilanSepeda(sepeda);
                      
                      nama = namaPerental();
                      
                      waktu = lamaPinjam();
    
                      rentalUnit(sepeda, nama, waktu, unitJenis, waktu, hargaPerJam);
                                       
                      System.out.println("Y untuk lanjut || Any key untuk berhenti");
                      System.out.print("> Ingin pesan lagi? ");
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
          break;
          case 3 :
          programLuar = false;
          break;
        }
      }while(programLuar);

    sc.close();    
  }
  static void inputJenis(String [][] sepeda) {
    Scanner sc = new Scanner(System.in);
    String namaJenis;
    for (int i = 0; i < sepeda.length; i++) {
              System.out.print("> Input Jenis Sepeda " + (i+1) + " : ");
              namaJenis = sc.next();
              sepeda[i][0] = namaJenis;
      }
  }
  static void tampilanSepeda(String [][] sepeda) {
    Scanner sc = new Scanner(System.in);
      System.out.println("============================");
      System.out.println("=    Sepeda yang tersedia  =");
      System.out.println("============================");
      System.out.println();
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
    System.out.print("Input lama peminjaman (Jam) : ");
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
                break;
              } 
              }
            }
          }
        }
      if(!found) {
        System.out.println(" Nama tidak ditemukan ");
      } 
      tampilanSepeda(sepeda);
    }while(!namaValid);
  }

  static int jumlahJenis() {
    Scanner sc = new Scanner(System.in);
    System.out.print("> Berapa jenis yang direntalkan : ");
    int jumlah = sc.nextInt();
    return jumlah;
  }
  static int unitJenis() {
    Scanner sc = new Scanner(System.in);
    System.out.print("> Jumlah per Jenis : ");
    int jumlah = sc.nextInt();
    return jumlah;
  }
}