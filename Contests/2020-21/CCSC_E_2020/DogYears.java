import java.util.Scanner;

public class DogYears {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("quit")) {
            String[] raw = input.split(" ");
            String name = raw[0];
            int age = Integer.parseInt(raw[1]);
            System.out.println(name + ", you are " + (age * 7) + " in dog years");
            input = scanner.nextLine();
        }
    }
}
