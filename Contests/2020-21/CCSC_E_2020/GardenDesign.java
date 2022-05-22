import java.util.Scanner;
import java.util.Arrays;

public class GardenDesign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        while (!line.equals("quit")) {
            int[] input = Arrays.stream(line.split(" "))
                            .mapToInt(x -> Integer.parseInt(x))
                            .toArray();
            int numColors = input[0];
            int gardenDimension = input[1];
            int gnomeDimension = input[2];

            if ((numColors < 1 || gardenDimension < 1 || gnomeDimension < 1)
                || ((gardenDimension % 2) != (gnomeDimension % 2))
                || (gardenDimension < (gnomeDimension + 2))) {
                System.out.println("Invalid");
            } else {
                int numFlowerPots = gardenDimension*gardenDimension
                                    - gnomeDimension*gnomeDimension;
                long numPossibleGardens = (long)Math.pow((numColors-1),numFlowerPots)
                                            + numColors - 1;
                System.out.println(numPossibleGardens);
            }

            line = scan.nextLine();
        }
        scan.close();
    }
}
