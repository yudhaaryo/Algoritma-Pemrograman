import java.util.Scanner;
public class Siakad {
    static Mahasiswa[] mahasiswa = new Mahasiswa[1000];
    static int jumlahData = 0;

    public static void tambahData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Silahkan tambah data");
        System.out.print("NIM = ");
        String nim = scan.nextLine();
        System.out.print("Nama = ");
        String nama = scan.nextLine();
        mahasiswa[jumlahData] = new Mahasiswa();
        mahasiswa[jumlahData].setNim(nim);
        mahasiswa[jumlahData].setNama(nama);
        jumlahData++;

    }

    public static void tampilData() {
        System.out.println("Berikut data Anda");
        int i = 0;
        while (i<jumlahData) {
            System.out.println(mahasiswa[i].getNim()+" "+mahasiswa[i].getNama());
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;
        do {
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu = ");
            menu = scan.nextInt();
            if (menu==1) {
                tambahData();
            } else if (menu==2) {
                tampilData();
            }
        } while (menu!=3);
    }
}