public class SegitigaSembarang extends Segitiga {
    public SegitigaSembarang(String nama, double sisi1, double sisi2, double sisi3) {
        super(nama, sisi1, sisi2, sisi3);
    }

    @Override
    public double hitungLuas() {
        double s = (getSisi1() + getSisi2() + getSisi3())/2;
        double luas = Math.sqrt( s * (s-getSisi1()) * (s-getSisi2()) * (s-getSisi3()));
        return luas;
    }
}
