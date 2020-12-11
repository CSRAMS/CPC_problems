import java.util.Scanner;

public class StarshipHakodatemaru2400 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int numFuelBalls = scanner.nextInt();
            if (numFuelBalls == 0) break; // End program is supply is 0.
            int maxBalls = 0;
            for (int i = 0; i*i*i <= numFuelBalls; i++) {
                int cube = i*i*i;
                for (int j = 0; j*(j+1)*(j+2)/6 <= numFuelBalls; j++) {
                    int tetrahedral = j*(j+1)*(j+2)/6;
                    int sum = cube + tetrahedral;
                    if (sum > maxBalls && sum <= numFuelBalls) {
                        maxBalls = sum;
                    }
                    if (sum > numFuelBalls) { // Balls requested exceeeds supply.
                        break;
                    }
                }
            }
            System.out.println(maxBalls); // Print the result.
        }

        scanner.close();
    }
}
