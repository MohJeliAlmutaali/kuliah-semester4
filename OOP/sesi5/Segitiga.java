public class Segitiga {
    public static void calculateArea(double a, double t){
        double luas = 0.5 * a * t;
        System.out.println("Luas segitiga: " + luas);
    }

    public static void calculateArea(Integer a, double t){
        double luas = 0.5 * a * t;
        System.out.println("Luas segitiga: " + luas );
    }

    public static void calculateArea(Integer base, Integer height){
        double luas = 0.5 * base * height;
        System.out.println("Luas segitiga: " + luas);
    }

    public static void calculateArea(double a, double b, double c){
        double s = 0.5 * (a + b + c);
        double luas = Math.sqrt(s * (s-a) * (s-b) * (s - c));
        System.out.println("Luas segitiga: " + luas);
    }
}
