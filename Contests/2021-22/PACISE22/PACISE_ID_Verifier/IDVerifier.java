import java.util.*;

class IDVerifier {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        String id = sc.nextLine();
        
        int sum = 0;
        for(int i = 0; i <id.length(); i++) {
            int doubled = 0;
            int digit = Character.getNumericValue(id.charAt(id.length()-1-i));
            if(i%2==1) {
                doubled = digit*2;
                sum+=doubled/10;
                sum+=doubled%10;
            }
            else {
                sum+=digit;
            }
        }

        if (sum%10==0) {
            System.out.println("VALID");
        }
        else {
            System.out.println("INVALID");
        }  
    }
}
