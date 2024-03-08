public class RightTriangle extends Triangle {

    private Double base;
    private Double height;

    public RightTriangle(String name, Double base, Double height) {
        super();
        this.name = name;
        this.base = base;
        this.height = height;
        this.calculateArea();
        super.side1 = base;
        super.side2 = height;
        super.side3 = this.getHypotenuse();
    }

    public double getHypotenuse() {
        return Math.sqrt((base * base) + (height * height));
    }

    @Override
    public void calculateArea() {
        super.area = (base * height) / 2;
    }

    @Override
    public void getInfo() {
        System.out.println("\nRightTriangle " + name + " info");
        System.out.println("Area: " + super.area);
        System.out.println("Base: " + base);
        System.out.println("Height: " + height);
        System.out.println("Hypotenuse: " + this.getHypotenuse());
    }
}