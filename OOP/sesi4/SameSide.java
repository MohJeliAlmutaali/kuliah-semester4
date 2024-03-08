public class SameSide extends Triangle {

    private Double side;

    public SameSide(String name, Double side) {
        super();
        this.name = name;
        this.side = side;
        this.calculateArea();
        super.side1 = side;
        super.side2 = side;
        super.side3 = side;
    }

    @Override
    public void calculateArea() {
        super.area = (Math.sqrt(3) / 4) * side * side;
    }

    @Override
    public void getInfo() {
        System.out.println("\nSameSide " + name + " info");
        System.out.println("Area: " + super.area);
        System.out.println("Side: " + side);
    }
}