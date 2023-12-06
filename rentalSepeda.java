import java.util.Scanner;


public class rentalSepeda {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     String namaJenis, namaKonsemen, pilihJenis, pesanLagi;
     int pilihUnit, pilihan = 0, waktu;
     double  harga = 0, uangPembeli;
     boolean isValidInput = false, mainLoop = true;
     System.out.print("Input Jumlah Jenis Sepeda Yang Mau Direntalkan: ");
     int jumlahJenis = sc.nextInt();
     System.out.print("Input Jumlah Unit Per Jenis : ");
     int unitJenis = sc.nextInt();
     System.out.print("Input Harga Per Jam : ");
     double hargaPerJam = sc.nextInt();
     String sepeda [][] = new String[jumlahJenis][unitJenis + 1];
     
    for (int i = 0; i < sepeda.length; i++) {
            System.out.print("Input Jenis Sepeda " + (i+1) + " : ");
            namaJenis = sc.next();
            sepeda[i][0] = namaJenis;
    }
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
     
    while (mainLoop) {
        System.out.println("============================");
        System.out.print("Masukkan nama anda :");
        namaKonsemen = sc.next();
        System.out.println("============================");
        System.out.println();
    
        do {
        System.out.print("Masukkan jenis sepeda: ");
        pilihJenis = sc.next();

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
        do {
            System.out.println("Pilih Nomor Sepeda Yang Tersedia: "); 
            pilihUnit = sc.nextInt();
        }while (pilihUnit == 0 || pilihUnit > unitJenis || sepeda[pilihan][pilihUnit] != null);
        System.out.print("Tentukan berapa lama waktu peminjaman (JAM) : ");
        waktu = sc.nextInt();
        sepeda[pilihan][pilihUnit] = namaKonsemen + " / " + waktu + " jam";
        harga = waktu * hargaPerJam;
        System.out.println("Cash IDR" + harga );
        System.out.print("Input uang pembeli : ");
        uangPembeli = sc.nextDouble();

        if (uangPembeli >= harga) {
          System.out.println("Kembalian anda : IDR" + (uangPembeli - harga));
          System.out.println("Terimakasih !");
        } else {
          System.out.println("Mohon maaf uang anda tidak cukup, silahkan input kembali");
          break;
        }
       
        for (int i = 0; i < sepeda.length; ++i) {
        for(int j = 0; j < sepeda[i].length; ++j) {
          if (sepeda[i][j] == null) {
            System.out.println("Sepeda Nomor " + j);
          }else {
              System.out.println(sepeda[i][j]);;
          }
        }
        System.out.println();
      }
      System.out.println("Y untuk lanjut || Any key untuk berhenti");
      System.out.print("Ingin pesan lagi? ");
      pesanLagi = sc.next();
      if(pesanLagi.equalsIgnoreCase("y")) {
        continue;
      }  else {
        mainLoop = false;
      }
    }
    }
}