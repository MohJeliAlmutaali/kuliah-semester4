public class SameFoot extends Triangle {

    private Double base;
    private Double side;

    public SameFoot(String name, Double base, Double side) {
        super();
        this.name = name;
        this.base = base;
        this.side = side;
        this.calculateArea();
        super.side1 = base;
        super.side2 = side;
        super.side3 = side;
    }

    @Override
    public void calculateArea() {
        double height = Math.sqrt(side * side - (base * base) / 4);
        super.area = (base * height) / 2;
    }

    @Override
    public void getInfo() {
        System.out.println("\nSameFoot " + name + " info");
        System.out.println("Area: " + super.area);
        System.out.println("Base: " + base);
        System.out.println("Side: " + side);
    }
}