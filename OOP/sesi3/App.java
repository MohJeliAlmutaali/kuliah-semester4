public class App {
    public static void main(String[] args) {
        SegitigaSikuSiku SegitigaSikuSiku = new SegitigaSikuSiku("Segitiga Siku Siku",7,4,2);

        System.out.println("Nama: " + SegitigaSikuSiku.getNama());
        System.out.println("Luas: " + SegitigaSikuSiku.hitungLuas());
        System.out.println("Keliling: " + SegitigaSikuSiku.hitungKeliling());
    }
}