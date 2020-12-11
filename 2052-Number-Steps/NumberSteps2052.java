import java.util.Scanner;

public class NumberSteps2052 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // number of test cases
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = x + y;
            if (Math.abs(x-y) <= 2) {
                if (x % 2 == 0 && y % 2 == 0) { // x and y are both even
                    System.out.println(z);
                } else if (x % 2 == 1 && y % 2 == 1) { // x and y are both odd
                    System.out.println(z-1);
                } else {
                    System.out.println("No Number");
                }
            } else {
                System.out.println("No Number");
            }
        }

        scanner.close();
    }
}
