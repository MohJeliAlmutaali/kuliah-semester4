public class App{
    public static void main(String[] args) throws Exception {
        RightTriangle ABC = new RightTriangle("ABC", 3.0, 4.0);
        ABC.specificMethod();

        Triangle BCD = new RightTriangle("BCD", 3.0, 4.0);
        BCD.hallo();

        Triangle CDE = new Triangle("CDE", 3.0,4.0,5.0);
        CDE.hallo();
    }
}