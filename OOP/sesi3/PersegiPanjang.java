public class PersegiPanjang extends BangunDatar{
    
    public PersegiPanjang(String nama, double panjang, double lebar){
        super(nama);
        hitungKeliling(panjang, lebar);
        hitungLuas(panjang, lebar);
    }


    public void hitungKeliling(double panjang, double lebar){
        keliling = 2 * (panjang + lebar);
        
    }

    public void hitungLuas(double panjang, double lebar){
        luas = panjang * lebar;
    }
}
