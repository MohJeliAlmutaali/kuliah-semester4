package geometri;
import bentuk.Segitiga;

public class Prisma implements Geometri {
    private Segitiga alas;
    private double tinggi;

    public Prisma(Segitiga alas, double tinggi) {
        this.alas = alas;
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
