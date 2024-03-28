package bentuk;

public class SegitigaSembarang extends Segitiga {
    private double sisi1;
    private double sisi2;
    private double tinggi;

    public SegitigaSembarang(double sisi1, double sisi2, double tinggi) {
        super(null);
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuas() {
        double s = (sisi1 + sisi2 + tinggi) / 2;
        return Math.sqrt(s * (s - sisi1) * (s - sisi2) * (s - tinggi));
    }

    @Override
    public double hitungKeliling() {
        double sisi3 = Math.sqrt(Math.pow(sisi1, 2) + Math.pow(sisi2, 2) - 2 * sisi1 * sisi2 * Math.cos(Math.toRadians(180 - Math.acos((Math.pow(sisi1, 2) + Math.pow(sisi2, 2) - Math.pow(sisi1, 2) - Math.pow(sisi2, 2)) / (-2 * sisi1 * sisi2)))));
        return sisi1 + sisi2 + sisi3;
    }
}
