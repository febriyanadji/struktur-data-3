import java.util.Scanner;

class Mahasiswa {
  String nama;
  String nim;
  String jurusan;
  char jekel;
  String alamat;
  String telepon;
}

public class Tugas1 {
  public static Mahasiswa[] semuamahasiswa = new Mahasiswa[100];
  public static int jumlahData = 0;

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    for (int i = 0; i < 100; i++)
      semuamahasiswa[i] = new Mahasiswa();
    boolean loop = true;
    do {
      System.out.println("+++++++++++");
      System.out.println("1. Input");
      System.out.println("2. View");
      System.out.println("3. Tambah");
      System.out.println("4. Hapus");
      System.out.println("5. Exit");
      System.out.print("Masukkan pilihan : ");
      switch (in.nextInt()) {
        case 1:
          inputData();
          break;
        case 2:
          viewData();
          break;
        case 3:
          insertData();
          break;
        case 4:
          deleteData();
          break;
        case 5:
          System.out.println("Selamat tinggal");
          loop = false;
          break;
        default:
          System.out.println("Pilihan salah");
          break;
      }
    } while (loop);
  }

  public static void viewData() {
    System.out.println("No\tNama\tNIM\tJurusan\tJenis Kelamin\tAlamat\tTelepon");
    for (int i = 0; i < jumlahData; i++) {
      Mahasiswa mahasiswa = semuamahasiswa[i];
      System.out.println(i + "\t" + mahasiswa.nama + "\t" + mahasiswa.nim + "\t" + mahasiswa.jurusan + "\t\t"
          + mahasiswa.jekel + "\t" + mahasiswa.alamat + "\t" + mahasiswa.telepon);
    }

  }

  public static void inputData() {
    Scanner in = new Scanner(System.in);
    System.out.print(":: Jumlah data yang ingin dimasukkan (min 10) : ");
    int jml = in.nextInt();
    if (jml < 10) {
      System.out.println("Minimal 10 data !!");
      return;
    }

    for (int i = 0; i < jml; i++) {
      System.out.println(":: Data ke-" + i);
      Mahasiswa dataMahasiswaBaru = inputMahasiswa();
      semuamahasiswa[i] = dataMahasiswaBaru;
      jumlahData++;
    }

  }

  public static void insertData() {
    Scanner in = new Scanner(System.in);
    boolean loop = true;
    do {
      System.out.println("+++++++++++");
      System.out.println("1. Tambah data depan");
      System.out.println("2. Tambah data tengah");
      System.out.println("3. Tambah data belakang");
      System.out.println("4. Kembali");
      System.out.print("Masukkan pilihan : ");
      switch (in.nextInt()) {
        case 1:
          insertFirst();
          break;
        case 2:
          insertMiddle();
          break;
        case 3:
          insertEnd();
          break;
        case 4:
          loop = false;
          break;
        default:
          break;
      }
    } while (loop);
  }

  public static void insertFirst() {
    System.out.println(":: Menambah mahasiswa baru ...");
    Mahasiswa dataMahasiswaBaru = inputMahasiswa();
    for (int i = jumlahData - 1; i >= 0; i--)
      semuamahasiswa[i + 1] = semuamahasiswa[i];
    semuamahasiswa[0] = dataMahasiswaBaru;
    jumlahData++;
  }

  public static void insertMiddle() {
    Scanner in = new Scanner(System.in);
    System.out.print(":: Masukkan posisi data : ");
    int posisi = in.nextInt();
    Mahasiswa dataMahasiswaBaru = inputMahasiswa();
    for (int i = jumlahData - 1; i >= posisi; i--)
      semuamahasiswa[i + 1] = semuamahasiswa[i];
    semuamahasiswa[posisi] = dataMahasiswaBaru;
    jumlahData++;
  }

  public static void insertEnd() {
    System.out.println(":: Menambah data diakhir ...");
    Mahasiswa dataMahasiswaBaru = inputMahasiswa();
    semuamahasiswa[jumlahData] = dataMahasiswaBaru;
    jumlahData++;
  }

  public static Mahasiswa inputMahasiswa() {
    Scanner in = new Scanner(System.in);
    Mahasiswa dataMahasiswaBaru = new Mahasiswa();
    System.out.print("::: Nama mahasiswa : ");
    dataMahasiswaBaru.nama = in.nextLine();
    System.out.print("::: NIM mahasiswa : ");
    dataMahasiswaBaru.nim = in.nextLine();
    System.out.print("::: Jurusan : ");
    dataMahasiswaBaru.jurusan = in.nextLine();
    System.out.print("::: Jenis kelamin (L/P) : ");
    dataMahasiswaBaru.jekel = in.nextLine().charAt(0);
    System.out.print("::: Alamat : ");
    dataMahasiswaBaru.alamat = in.nextLine();
    System.out.print("::: Nomor Telepon : ");
    dataMahasiswaBaru.telepon = in.nextLine();
    return dataMahasiswaBaru;
  }

  public static void deleteData() {
    Scanner in = new Scanner(System.in);
    boolean loop = true;

    do {
      System.out.println("+++++++++++");
      System.out.println("1. Hapus data depan");
      System.out.println("2. Hapus data tengah");
      System.out.println("3. Hapus data belakang");
      System.out.println("4. Kembali");
      System.out.print("Masukkan pilihan : ");
      switch (in.nextInt()) {
        case 1:
          deleteFirst();
          break;
        case 2:
          deleteMiddle();
          break;
        case 3:
          deleteEnd();
          break;
        case 4:
          loop = false;
          break;
        default:
          break;
      }
    } while (loop);

  }

  public static void deleteFirst() {
    System.out.println(":: Menghapus mahasiswa paling awal ...");
    for (int i = 0; i <= jumlahData - 2; i++)
      semuamahasiswa[i] = semuamahasiswa[i + 1];
    jumlahData--;
  }

  public static void deleteMiddle() {
    Scanner in = new Scanner(System.in);
    System.out.print(":: Masukkan nomor data yang ingin dihapus : ");
    int t = in.nextInt();
    System.out.println("::: Menghapus mahasiswa atas nama " + semuamahasiswa[t].nama + " ...");
    for (int i = t; i <= jumlahData - 2; i++)
      semuamahasiswa[i] = semuamahasiswa[i + 1];
    jumlahData--;
  }

  public static void deleteEnd() {
    System.out.println(":: Menghapus data paling akhir ...");
    jumlahData--;
  }
}