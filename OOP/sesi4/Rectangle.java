public class Rectangle extends Shape {

    private Double length;
    private Double width;

    public Rectangle(String name, Double length, Double width) {
        super();
        this.name = name;
        this.length = length;
        this.width = width;
        this.calculateArea();
    }

    public void calculateArea() {
        super.area = length * width;
    }

    @Override
    public void getInfo() {
        System.out.println("\nRectangle " + name + " info");
        System.out.println("Area: " + super.area);
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
    }
}
