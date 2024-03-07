public class SegitigaSikuSiku extends Segitiga {
    public SegitigaSikuSiku(String nama, double tinggi,double sisi,double alas) {
        super(nama,tinggi,sisi, alas);
    }

    @Override
    public double hitungLuas() {
        double luas = 0.5 * getSisi3() * getSisi1(); 
        return luas;
    }
}
