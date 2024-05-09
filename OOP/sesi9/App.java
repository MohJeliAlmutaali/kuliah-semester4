public class App {
    public static void main(String[] args) throws Exception {
        String nama = "NUGRAHA";
        int panjang = nama.length();

        System.out.println();

        for (int i = 0; i < panjang; i++) {
            for (int j = 0; j < panjang - i; j++) {
                System.out.print(nama.charAt(j) + " ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();System.out.println();

        for (int i = 0; i < panjang; i++) {
            for (int j = 0; j < panjang; j++) {
                if (j == i) {
                    System.out.print(nama.charAt(j) + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        int lebar = panjang;

        for (int i = 0; i < lebar; i++) {
            for (int j = 0; j < lebar; j++) {
                if (i == lebar / 2 && j >= (lebar - panjang) / 2 && j < (lebar + panjang) / 2) {
                    System.out.print(nama.charAt(j - (lebar - panjang) / 2) + " ");
                } else if (j == lebar / 2 && i >= (lebar - panjang) / 2 && i < (lebar + panjang) / 2) {
                    System.out.print(nama.charAt(i - (lebar - panjang) / 2) + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }

    }

}
