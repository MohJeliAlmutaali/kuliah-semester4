package geometri;

import bentuk.Persegi;

public class Kubus implements Geometri {
    private double sisi;

    public Kubus(double sisi) {
        this.sisi = sisi;
    }

    @Override
    public double hitungVolume() {
        return sisi * sisi * sisi;
    }

    @Override
    public double hitungLuasAlas() {
        return new Persegi(sisi).hitungLuas();
    }
}