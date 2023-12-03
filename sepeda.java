import java.util.Scanner;

public class sepeda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jumlah;
        int nomorSepeda;
        String next;
        String peminjam;
        String waktu;

        System.out.println("===============================");
        System.out.println("      Input Jumlah Sepeda     ");
        System.out.println("===============================");
        System.out.print("Jumlah: ");
        jumlah = sc.nextInt();
        
        String [] sepeda = new String[jumlah];
        System.out.println("===============================");
        System.out.println("      Sepeda yang tersedia     ");
        System.out.println("===============================");
        for (int i = 0; i < sepeda.length; i++) {
            if (sepeda[i] == null) {
                System.out.println("Sepeda-" + (i+1));
            } 
        }
        while(true) {
        System.out.print("Input nama peminjam    : ");
        peminjam = sc.next();
        System.out.print("Input nomor sepeda     : ");
        nomorSepeda = sc.nextInt();
        System.out.print("Input waktu peminjaman : ");
        waktu = sc.next();

        if(nomorSepeda > sepeda.length) {
            System.out.println("Input salah");
        }

        if (sepeda[nomorSepeda-1] == null) {
            sepeda[nomorSepeda-1] = "Dipinjam oleh " + peminjam + " Selama " + waktu + " jam ";
        } else {
            System.out.println("\nMohon maaf sudah terpakai, silahkan input lagi\n");

            continue;
        }
        System.out.println("===============================");
        for (int i = 0; i < sepeda.length; i++) {
            if (sepeda[i] == null) {
                System.out.println("Sepeda-" + (i+1) + " Tersedia");
            } else {
                System.out.println(sepeda[i]);
            }
        }
        System.out.print("Pinjam lagi? (ya/tidak): ");
        next = sc.next();
        if (next.equalsIgnoreCase("tidak")) {
            break;
        }
    }
    sc.close();    
    }
}