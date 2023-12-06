import java.util.Scanner;

public class rentalSepeda {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     String namaJenis, namaKonsemen, pilihJenis;
     int pilihUnit, pilihan = 0, waktu;
     double total = 0, harga = 0;
     boolean isValidInput = false;
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
     
    while (true) {
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
                        System.out.println("==== " + sepeda[i][j] + " ====");
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
            System.out.println("Pilih Nomor Sepeda : "); 
            pilihUnit = sc.nextInt();
        }while (pilihUnit == 0 || pilihUnit > unitJenis);
        System.out.print("Tentukan berapa lama waktu peminjaman (JAM) : ");
        waktu = sc.nextInt();
        sepeda[pilihan][pilihUnit] = namaKonsemen + " / " + waktu + " jam";
        harga = waktu * hargaPerJam;
        total += harga;
        System.out.println("Cash IDR" + total );
        
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
    sc.close();}
    }
}