import java.util.Scanner;

 class Percabangan {
    public static void main(String[] args) {
        
    Scanner input = new Scanner(System.in);
    
    String nama;
    int nilai;
    
    System.out.print("Masukkan Nama : ");
    nama = input.nextLine();
    System.out.print("Masukkan Nilai");
    nilai = input.nextInt();
    
    if (nilai >= 60){
        System.out.println("Selamat "+nama+" , Anda Lulus");
    }else{
        System.out.println("Maaf "+nama+" , Anda Tidak Lulus");
    }

  }
}
