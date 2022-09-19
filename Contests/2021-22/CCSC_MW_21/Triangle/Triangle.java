import java.util.*;
public class Triangle {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt(); //nth triangle number -- construct a triangle with n rows
        int digitsAllowed = rows*(rows+1)/2; //Gaussian summation formula for available digits
        int digitsUsed = 0;

        int n = -1;
        int triangleSum = 0;
        while(digitsUsed<digitsAllowed) {
            n++;
            triangleSum+=n;
            digitsUsed+= String.valueOf(triangleSum).length();
            if(digitsUsed==digitsAllowed) {
                System.out.println(n);
                break;
            }
            else if (digitsUsed>digitsAllowed) System.out.println("NO");   
        }
    }
}
