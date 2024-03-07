public class Lingkaran extends BangunDatar{
    public Lingkaran(String nama, double radius){
        super(nama);
        hitungKeliling(radius);
        hitungLuas(radius);
    }


    public void hitungKeliling(double radius){
        keliling = 2 * Math.PI * radius;
        
    }

    public void hitungLuas(double radius){
        luas = Math.PI * radius * radius;

    }
}
