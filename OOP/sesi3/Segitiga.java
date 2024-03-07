public class Segitiga extends BangunDatar {
    private double sisi1; // sisi miring 1
    private double sisi2; // sisi miring 2
    private double sisi3; // alas

    public Segitiga(String nama, double sisi1, double sisi2, double sisi3) {
        super(nama);
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
    }

    @Override
    public double hitungLuas() {
        
        double tinggi = Math.sqrt(Math.pow(sisi1,2) - Math.pow(sisi3/2, 2));
        double luas = 0.5 * sisi3 * tinggi;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = sisi1 + sisi2 + sisi3;
        return keliling;
    }

    public double getSisi1(){
        return sisi1;
    }

    public double getSisi2(){
        return sisi2;
    }

    public double getSisi3(){
        return sisi3;
    }
}

