import bentuk.*;
import geometri.*;

public class App {
    public static void main(String[] args) {
        Bentuk persegiPanjang = new PersegiPanjang(5, 4);
        System.out.println("Keliling Persegi Panjang: " + persegiPanjang.hitungKeliling());
        System.out.println("Luas Persegi Panjang: " + persegiPanjang.hitungLuas());
        System.out.println();

        Bentuk lingkaran = new Lingkaran(7);
        System.out.println("Keliling Lingkaran: " + lingkaran.hitungKeliling());
        System.out.println("Luas Lingkaran: " + lingkaran.hitungLuas());
        System.out.println();

        Geometri kubus = new Kubus(5);
        System.out.println("Volume Kubus: " + kubus.hitungVolume());
        System.out.println("Luas Alas Kubus: " + kubus.hitungLuasAlas());
        System.out.println();

        Bentuk segitigaSamaKaki = new SegitigaSamaKaki(new PersegiPanjang(6, 6), 4);
        Geometri prismaSamaKaki = new Prisma((Segitiga) segitigaSamaKaki, 5);
        System.out.println("Volume Prisma dengan alas segitiga sama kaki: " + prismaSamaKaki.hitungVolume());
        System.out.println("Luas Alas Prisma dengan alas segitiga sama kaki: " + prismaSamaKaki.hitungLuasAlas());
        System.out.println("Keliling Alas Prisma dengan alas segitiga sama kaki: " + segitigaSamaKaki.hitungKeliling());
        System.out.println();

        Bentuk segitigaSamaSisi = new SegitigaSamaSisi(8);
        Geometri prismaSamaSisi = new Prisma((Segitiga) segitigaSamaSisi, 5);
        System.out.println("Volume Prisma dengan alas segitiga sama sisi: " + prismaSamaSisi.hitungVolume());
        System.out.println("Luas Alas Prisma dengan alas segitiga sama sisi: " + prismaSamaSisi.hitungLuasAlas());
        System.out.println("Keliling Alas Prisma dengan alas segitiga sama sisi: " + segitigaSamaSisi.hitungKeliling());
        System.out.println();

        Bentuk segitigaSikuSiku = new SegitigaSikuSiku(new PersegiPanjang(3, 4), 5);
        Geometri prismaSikuSiku = new Prisma((Segitiga) segitigaSikuSiku, 5);
        System.out.println("Volume Prisma dengan alas segitiga siku-siku: " + prismaSikuSiku.hitungVolume());
        System.out.println("Luas Alas Prisma dengan alas segitiga siku-siku: " + prismaSikuSiku.hitungLuasAlas());
        System.out.println("Keliling Alas Prisma dengan alas segitiga siku-siku: " + segitigaSikuSiku.hitungKeliling());
        System.out.println();

        Bentuk segitigaSembarang = new SegitigaSembarang(3, 4, 6);
        Geometri prismaSembarang = new Prisma((Segitiga) segitigaSembarang, 5);
        System.out.println("Volume Prisma dengan alas segitiga sembarang: " + prismaSembarang.hitungVolume());
        System.out.println("Luas Alas Prisma dengan alas segitiga sembarang: " + prismaSembarang.hitungLuasAlas());
        System.out.println("Keliling Segitiga Sembarang: " + segitigaSembarang.hitungKeliling());
        System.out.println("Keliling Alas Prisma dengan alas segitiga sembarang: " + segitigaSembarang.hitungKeliling());
        System.out.println();

        Geometri silinder = new Silinder(7, 10);
        System.out.println("Volume Silinder: " + silinder.hitungVolume());
        System.out.println("Luas Alas Silinder: " + silinder.hitungLuasAlas());
        System.out.println("Keliling Alas Silinder : " + lingkaran.hitungKeliling());
        System.out.println();

        Geometri balok = new Balok(3, 4, 5);
        System.out.println("Volume Balok: " + balok.hitungVolume());
        System.out.println("Luas Alas Balok: " + balok.hitungLuasAlas());
        System.out.println("Keliling Alas Balok : " + persegiPanjang.hitungKeliling());
        System.out.println();
    }
}
