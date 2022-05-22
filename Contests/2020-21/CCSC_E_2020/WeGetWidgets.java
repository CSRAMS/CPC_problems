import java.util.Scanner;

public class WeGetWidgets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        while (x > 0) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            int maxA = a.length(), maxB = b.length();
            a += a;
            b += b;
            int max = 0;
            int i = maxA;
            int j = maxB;
            for (int sb = 0; sb < maxB; sb++) {
                for (int sa = 0; sa < maxA; sa++) {
                    int ia = sa, ib = sb;
                    int count = 0;
                    while (ia < a.length() && ib < b.length() && a.charAt(ia) == b.charAt(ib)) {
                        if (count > max || (count == max && (i + j < sa + sb))) {
                            i = sa;
                            j = sb;
                            max = count;
                        }
                        count++;
                        ia++;
                        ib++;
                    }
                }
            }
            if (i == maxA && j == maxB) {
                i = -1;
                j = -1;
            }
            System.out.println(i);
            System.out.println(j);
            x--;
        }
    }
}
