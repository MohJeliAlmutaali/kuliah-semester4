package geometri;

import bentuk.Lingkaran;

public class Silinder implements Geometri {
    private double jariJari;
    private double tinggi;

    public Silinder(double jariJari, double tinggi) {
        this.jariJari = jariJari;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        return new Lingkaran(jariJari).hitungLuas() * tinggi;
    }

    @Override
    public double hitungLuasAlas() {
        return new Lingkaran(jariJari).hitungLuas();
    }
}