import java.util.Scanner;
public class B {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        int mod = 1000;
        char[][] res = new char[4][4];
        int digit;
        int bit;
        for(int j = 0; j < 4; j++) {
            digit = time/mod;
            bit = 8;
            for(int i = 0; i < 4; i++) {
                if(digit >= bit) {
                    digit -= bit;
                    res[i][j] = '*';
                }
                else {
                    res[i][j] = '.';
                }
                bit /= 2;
            }
            time %= mod;
            mod /= 10;
        }
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(res[i][j]);
                if(j != 3) {
                    System.out.print(" ");
                }
                if(j == 1) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
