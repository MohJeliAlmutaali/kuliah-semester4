package geometri;
import bentuk.PersegiPanjang;

public class Balok implements Geometri {
    private PersegiPanjang alas;
    private double tinggi;

    public Balok(double panjang, double lebar, double tinggi) {
        this.alas = new PersegiPanjang(panjang, lebar);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        return alas.hitungLuas() * tinggi;
    }

    @Override
    public double hitungLuasAlas() {
        return alas.hitungLuas();
    }
}
