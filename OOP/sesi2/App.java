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
        Scanner scanner = new Scanner(System.in);
        
        HashMap<Integer, Double> daftarBuku = new HashMap<>();
        daftarBuku.put(1, 25.0);
        daftarBuku.put(2, 20.0);
        daftarBuku.put(3, 30.0);
        
        System.out.println("Daftar Buku:");
        for (int key : daftarBuku.keySet()) {
            System.out.println(key + ". Buku " + key + " - $" + daftarBuku.get(key));
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
                totalHarga += daftarBuku.get(pilihanBuku) * jumlahBuku;
            } else {
                System.out.println("Nomor buku tidak valid.");
            }
        }
        
        System.out.println("Anda akan membeli buku dengan total harga: $" + totalHarga);
        System.out.print("Apakah Anda yakin ingin membeli? (Y/N): ");
        String konfirmasi = scanner.next();
        
        if (konfirmasi.equalsIgnoreCase("Y")) {
            clearDispaly();
            System.out.println("Buku berhasil dibeli:");
            for (int buku : bukuDibeli.keySet()) {
                System.out.println("- Buku " + buku + " (" + bukuDibeli.get(buku) + " buah) - $" + (daftarBuku.get(buku) * bukuDibeli.get(buku)));
            }
            System.out.println("Total Harga: $" + totalHarga + "\n\n");
        } else {
            clearDispaly();
            System.out.println("Pembelian dibatalkan.");
            
        }
    }
}   
