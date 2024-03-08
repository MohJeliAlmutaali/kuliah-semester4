public class Triangle extends Shape {

    protected Double side1;
    protected Double side2;
    protected Double side3;

    public Triangle() {
        this.side1 = 0.0;
        this.side2 = 0.0;
        this.side3 = 0.0;
    }

    public Triangle(String name, Double side1, Double side2, Double side3) {
        this.name = name;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.calculateArea();
    }

    public void calculateArea() {
        double halfPerimeter = (side1 + side2 + side3) / 2;
        super.area = Math.sqrt(
                halfPerimeter
                        * (halfPerimeter - side1)
                        * (halfPerimeter - side2)
                        * (halfPerimeter - side3)
        );
    }

    @Override
    public void getInfo() {
        System.out.println("Triangle " + name + " info");
        System.out.println("Area: " + super.area);
        System.out.println("Sides: " + side1 + ", " + side2 + ", " + side3);
    }
}