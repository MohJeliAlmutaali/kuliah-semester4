package bentuk;

public class SegitigaSamaSisi extends Segitiga {
    private double sisi;

    public SegitigaSamaSisi(double sisi) {
        super(null);
        this.sisi = sisi;
    }

    @Override
    public double hitungLuas() {
        return (Math.sqrt(3) / 4) * sisi * sisi;
    }

    @Override
    public double hitungKeliling() {
        return 3 * sisi;
    }
}
