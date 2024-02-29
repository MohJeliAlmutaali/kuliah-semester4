public class Square {
    private double width;
    private double height;

    public Square(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLebar(){
        return width;
    }

    public double getTinggi(){
        return height;
    }

    public double getLuas() {
        return width * height;
    }

    public double getKeliling() {
        return 2 * (width + height);
    }

    
}
