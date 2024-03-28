package bentuk;

public class SegitigaSikuSiku extends Segitiga {
    private double tinggi;

    public SegitigaSikuSiku(Bentuk alas, double tinggi) {
        super(alas);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuas() {
        return 0.5 * alas.hitungLuas() * tinggi;
    }

    @Override
    public double hitungKeliling() {
        double sisiMiring = Math.sqrt(alas.hitungLuas() + tinggi * tinggi);
        return alas.hitungKeliling() + tinggi + sisiMiring;
    }
}
