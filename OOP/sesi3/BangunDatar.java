public class BangunDatar {
    protected double luas;
    protected double keliling;
    protected String nama;

    public BangunDatar(String nama) {
        this.nama = nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public double hitungLuas() {
        return 0.0; 
    }

    public double hitungKeliling() {
        return 0.0; 
    }

    public String getNama() {
        return nama;
    }

    public double getKeliling(){
        return keliling;
    }
    public double getLuas(){
        return luas;
    }
}


