public class Looping {
    public static void main(String[] args) {
        // a. 0, 2, 4, 6, 8
        for (int i = 0; i <= 8; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // b. 1, 3, 5, 7, 9
        for (int i = 1; i <= 9; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // c. 1, 2, 4, 7, 11, 16, 22
        int sum = 1;
        for (int i = 1; i <= 7; i++) {
            System.out.print(sum + " ");
            sum += i;
        }
        System.out.println();

        // d. -3, -1, 2, 6, 11, 17, 24
        int value = -3;
        for (int i = 1; i <= 7; i++) {
            System.out.print(value + " ");
            value += i + 1;
        }
        System.out.println();

        // e. 1 1 2 3 5 8 13 21

        int a = 1, b = 1;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < 8; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
        System.out.println();
    }
}

