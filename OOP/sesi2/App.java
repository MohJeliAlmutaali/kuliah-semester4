import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu Utama:");
            System.out.println("1. Persegi");
            System.out.println("2. Buku");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    clearDispaly();
                    handlePersegi();
                    break;
                case 2:
                    clearDispaly();
                    handleBuku();
                    break;
                case 3:
                    System.out.println("Menutup program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih lagi.");
            }
        }
    }

    private static void clearDispaly(){
        System.out.print("\u001b[H\u001b[2J");
    }

    private static void handlePersegi() {
        clearDispaly();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan lebar dan tinggi persegi:");
        double lebar = scanner.nextDouble();
        double tinggi = scanner.nextDouble();

        Square persegi = new Square(lebar, tinggi);

        System.out.println("\nDetail Persegi:");
        System.out.println("Lebar: " + persegi.getLebar());
        System.out.println("Tinggi: " + persegi.getTinggi());
        System.out.println("Luas: " + persegi.getLuas());
        System.out.println("Keliling: " + persegi.getKeliling()+"\n\n");
    }

    private static void handleBuku() {
        Book buku1 = new Book("Jeli", "Python", 10.11, 1);

        Book buku2 = new Book("Malik", "Java", 15.11, 2);

        Book buku3 = new Book("Dipta", "C++", 11.11, 3);

        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, Book> daftarBuku = new HashMap<>();
        daftarBuku.put(1, buku1);
        daftarBuku.put(2, buku2);
        daftarBuku.put(3, buku3);

        System.out.println("Daftar Buku:");
        for (int key : daftarBuku.keySet()) {
            Book buku = daftarBuku.get(key);
            System.out.println(key + ". " + buku.getTitle() + " oleh " + buku.getAuthor() + " - $" + buku.getPrice());
        }

        HashMap<Integer, Integer> bukuDibeli = new HashMap<>();
        double totalHarga = 0.0;
        boolean selesai = false;
        while (!selesai) {
            System.out.print("Pilih nomor buku yang ingin dibeli (0 untuk selesai): ");
            int pilihanBuku = scanner.nextInt();
            if (pilihanBuku == 0) {
                selesai = true;
            } else if (daftarBuku.containsKey(pilihanBuku)) {
                System.out.print("Masukkan jumlah buku yang ingin dibeli: ");
                int jumlahBuku = scanner.nextInt();
                bukuDibeli.put(pilihanBuku, jumlahBuku);
                totalHarga += daftarBuku.get(pilihanBuku).getPrice() * jumlahBuku;
            } else {
                System.out.println("Nomor buku tidak valid.");
            }
        }

        System.out.println("Anda akan membeli buku dengan total harga: $" + totalHarga);
        System.out.print("Apakah Anda yakin ingin membeli? (Y/N): ");
        String konfirmasi = scanner.next();

        if (konfirmasi.equalsIgnoreCase("Y")) {
            System.out.print("\u001b[H\u001b[2J");
            System.out.println("Buku berhasil dibeli:");
            for (int bukuId : bukuDibeli.keySet()) {
                Book buku = daftarBuku.get(bukuId);
                int jumlah = bukuDibeli.get(bukuId);
                System.out.println("- " + buku.getTitle() + " oleh " + buku.getAuthor() + " (" + jumlah + " buah) - $" + (buku.getPrice() * jumlah));
            }
            System.out.println("Total Harga: $" + totalHarga + "\n\n");
        } else {
            System.out.print("\u001b[H\u001b[2J");
            System.out.println("Pembelian dibatalkan.");

        }
    }
}
