import java.util.Scanner;

public class SecretMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String search = scanner.nextLine().toLowerCase();
            if (search.equals("quit")) {
                return;
            }
            String key = scanner.nextLine().toLowerCase().replaceAll("[^a-z0-9]", "");
            int is = 0, ik = 0;
            while(is < search.length() && ik < key.length()) {
                if (search.charAt(is) == key.charAt(ik)) {
                    ik++;
                }
                is++;
            }
            System.out.println(ik == key.length() ? "yes" : "no");
        }
    }
}
