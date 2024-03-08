public class App {
    public static void main(String[] args) throws Exception {
        RightTriangle ABC = new RightTriangle("ABC", 3.0, 4.0);
        Triangle BCD = new RightTriangle("BCD", 3.0, 4.0); 
        Triangle CDE = new Triangle("CDE", 3.0, 4.0, 5.0);

        SameFoot sameFoot = new SameFoot("same foot", 5.0,10.0);

        SameSide sameSide = new SameSide("same side", 10.0);

        Rectangle rectangle = new Rectangle("rectangle", 10.0,5.0);

        ABC.getInfo();
        BCD.getInfo();
        CDE.getInfo();

        sameFoot.getInfo();
        sameSide.getInfo();
        rectangle.getInfo();
    }
}
