import java.util.Scanner;

public class Siakad {

    public static Scanner scan = new Scanner(System.in);
    public static int pilihan = 0;
    public static Mahasiswa[] mahasiswa = new Mahasiswa[1000];
    public static int jumlahData = 0;

    public static void pilihMenu() {
        System.out.println("\n### Menu Siakad ###");
        System.out.println("1. Tambah Data Mahasiswa");
        System.out.println("2. Lihat Data Mahasiswa");
        System.out.println("3. Urutkan Data");
        System.out.println("4. Cari Data");
        System.out.println("5. Edit Data");
        System.out.println("6. Hapus Data");
        System.out.println("7. UAS");
        System.out.println("8. Keluar");
        System.out.print("Silahkan pilih menu: ");
        pilihan = scan.nextInt();
        scan.nextLine();
    }

    public static void tambahData() {
        System.out.println("\n1. Silahkan Tambah Data");

        while (true) {
            mahasiswa[jumlahData] = new Mahasiswa();
            System.out.print("nama: ");
            mahasiswa[jumlahData].setNama(scan.next());
            System.out.print("nim: ");
            mahasiswa[jumlahData].setNim(scan.nextInt());
            jumlahData++;
            System.out.print("\nLanjutkan input (y/n)?");
            char yn = scan.next().charAt(0);
            if (yn != 'y') {
                break;
            }
        }
    }

    public static void lihatData() {
        System.out.println("\n2. Lihat Data ");
        System.out.println("Berikut Data Anda");
        int i = 0;
        while (i < jumlahData) {
            System.out.println("--------------------------------------");
            System.out.println("Data ke-" + (i + 1));
            System.out.println("\nNama:" + mahasiswa[i].getNama());
            System.out.println("NIM:" + mahasiswa[i].getNim());
            System.out.println("--------------------------------------");
            i++;
        }
    }

    public static void editData() {
        long nim;
        String nama;

        System.out.print("\nData Ke Berapa Yang Ingin Diedit? : ");
        int index = scan.nextInt();
        scan.nextLine();

        System.out.println("--------------------------------------");
        System.out.print("Data Yang Akan Diedit : ");
        System.out.println("\nNama : " + mahasiswa[index - 1].getNama());
        System.out.println("NIM : " + mahasiswa[index - 1].getNim());
        System.out.print("\nEdit Data Tersebut? (y/n) : ");
        String opsi = scan.next();
        System.out.println("--------------------------------------");
        scan.nextLine();
        switch (opsi) {
            case "y":
                System.out.print("\nNama : ");
                nama = scan.nextLine();

                System.out.print("NIM : ");
                nim = scan.nextLong();
                scan.nextLine();

                mahasiswa[index - 1].setNim(nim);
                mahasiswa[index - 1].setNama(nama);

                System.out.println();
                break;

            case "n":
                editData();
                break;
        }
    }

    public static void hapusData() {
        System.out.print("\nData Ke Berapa Yang Ingin Dihapus? : ");
        int index = scan.nextInt();
        scan.nextLine();

        System.out.println("--------------------------------------");
        System.out.print("\nData Yang Akan Dihapus : ");
        System.out.println("\nNama : " + mahasiswa[index - 1].getNama());
        System.out.println("NIM : " + mahasiswa[index - 1].getNim());
        System.out.print("\nHapus Data Tersebut? (y/n) : ");
        String opsi = scan.next();
        System.out.println("--------------------------------------");
        scan.nextLine();
        switch (opsi) {
            case "y":
                for (int i = index; i < jumlahData; i++) {
                    mahasiswa[index - 1].setNim(mahasiswa[index].getNim());
                    mahasiswa[index - 1].setNama(mahasiswa[index].getNama());
                }
                break;

            case "n":
                hapusData();
                ;
                break;
        }
        jumlahData -= 1;
        System.out.println();
    }

    public static void cariData() {
        int search;
        System.out.println("--------------------------------------");
        System.out.print("\nNIM yang ingin dicari: ");
        System.out.println("--------------------------------------");
        search = scan.nextInt();
        int pilih;
        System.out.println("\n### Pilih Algoritma Pencarian ###");
        System.out.println("1. Binary Search");
        System.out.println("2. Linear Search");
        System.out.print("Silahkan pilih algoritma: ");
        pilih = scan.nextInt();
        switch (pilih) {
            case 1:
                binarySearch(search);
                break;
            case 2:
                linearSearch(search);
                break;
        }
    }

    public static void linearSearch(int search) {
        int result = algoLinearSearch(mahasiswa, search);
        if (result == -1) {
            System.out.println("Data Tidak Ada");
        } else {
            System.out.println("--------------------------------------");
            System.out.println("\nData Yang Anda Cari :");
            System.out.println("\nnama:" + mahasiswa[result].getNama());
            System.out.println("nim:" + mahasiswa[result].getNim());
            System.out.println("--------------------------------------");
        }
    }

    public static int algoLinearSearch(Mahasiswa[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getNim() == x) {
                return i;
            }
        }
        return -1;
    }

    public static void binarySearch(int search) {
        int result = algoBinarySearch(mahasiswa, jumlahData - 1, 0, search);
        if (result == -1) {
            System.out.println("Data Tidak Ada");
        } else {
            System.out.println("--------------------------------------");
            System.out.println("\nData Yang Anda Cari :");
            System.out.println("\nnama:" + mahasiswa[result].getNama());
            System.out.println("nim:" + mahasiswa[result].getNim());
            System.out.println("--------------------------------------");
        }
    }

    public static int algoBinarySearch(Mahasiswa[] arr, int r, int l, int x) {
        if (r >= l) {
            int mid = (l + r) / 2;
            if (arr[mid].getNim() == x) {
                return mid;
            }
            if (arr[mid].getNim() > x) {
                return algoBinarySearch(arr, mid - 1, l, x);
            }
            return algoBinarySearch(arr, r, mid + 1, x);
        }
        return -1;
    }

    public static void urutkanData() {
        int pilih;
        System.out.println("\n### Pilih Algoritma Pengurutan ###");
        System.out.println("1. Exchange Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Quick Sort");
        System.out.println("4. Bubble Sort");
        System.out.println("5. Shell Sort");
        System.out.print("Silahkan pilih algoritma: ");
        pilih = scan.nextInt();
        switch (pilih) {
            case 1:
                exchangeSort();
                break;
            case 2:
                selectionSort();
                break;
            case 3:
                quickSort(mahasiswa, 0, jumlahData - 1);
                break;
            case 4:
                bubbleSort(mahasiswa);
                break;
            case 5:
                shellSort(mahasiswa);
                break;
        }
    }

    public static void exchangeSort() {
        // mahasiswa[jumlahData] = new Mahasiswa();
        for (int x = 0; x < jumlahData; x++) {
            for (int y = x + 1; y < jumlahData; y++) {
                if (mahasiswa[x].getNim() > mahasiswa[y].getNim()) {
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;
                }
            }
        }
    }

    public static void selectionSort() {
        int i, j;
        int n = mahasiswa.length;
        for (i = 0; i < n - 1; i++) {
            // Find the current min item
            int currMin = i;
            for (j = i + 1; j < n; j++) {
                if (mahasiswa[j] == null) {
                    continue;
                }
                if (mahasiswa[j].getNim() < mahasiswa[currMin].getNim()) {
                    currMin = j;
                }
                // swap the found current min with the first item
                Mahasiswa temp = mahasiswa[currMin];
                mahasiswa[currMin] = mahasiswa[i];
                mahasiswa[i] = temp;
            }
        }
    }

    public static void bubbleSort(Mahasiswa[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i; j++) {
                if (arr[j] == null) {
                    continue;
                }
                if (arr[j + 1] == null) {
                    continue;
                }
                if (arr[j].getNim() > arr[j + 1].getNim()) {
                    Mahasiswa temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void shellSort(Mahasiswa[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                Mahasiswa temp = arr[i];
                int j = i;
                if (arr[j] == null) {
                    continue;
                }
                for (j = i; j >= gap && arr[j - gap].getNim() > temp.getNim(); j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void quickSort(Mahasiswa[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(Mahasiswa[] arr, int low, int high) {
        int p = low, j;
        for (j = low + 1; j <= high; j++)
            if (arr[j].getNim() < arr[low].getNim())
                swap(arr, ++p, j);

        swap(arr, low, p);
        return p;
    }

    static void swap(Mahasiswa[] arr, int low, int pivot) {
        Mahasiswa tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }

    public static String uas() {
        int jarak = jumlahData;
        int susut = 13;
        int urut = 0;
        Mahasiswa temp;

        if (jumlahData != 0) {
            do {
                jarak = (jarak * 10) / susut;

                if (jarak <= 1) {
                    jarak = 1;
                    urut = 1;
                }

                for (int i = 0; (i + jarak) < jumlahData; i++) {
                    if (mahasiswa[i].getNim() > mahasiswa[i + jarak].getNim()) {
                        temp = mahasiswa[i];
                        mahasiswa[i] = mahasiswa[i + jarak];
                        mahasiswa[i + jarak] = temp;
                        urut = 0;
                    }
                }
            } while (urut == 0);
        } else {
            return "Tidak Ada Data";
        }

        return "Data telah diurutkan, silakan tampilkan data!";

    }

    public static void main(String[] args) {
        while (true) {
            pilihMenu();
            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    lihatData();
                    break;
                case 3:
                    urutkanData();
                    break;
                case 4:
                    cariData();
                    break;
                case 5:
                    editData();
                    break;
                case 6:
                    hapusData();
                    break;
                case 7:
                    String pesan = uas();
                    System.out.println("\n" + pesan);
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Maaf,pilihan tidak valid!." +
                            "\nSilahkan ulangi masukkan pilihan!");
                    break;
            }
        }
    }
}