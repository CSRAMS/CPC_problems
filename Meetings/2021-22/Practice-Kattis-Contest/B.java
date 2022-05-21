import java.util.Scanner;
import java.util.Arrays;

public class B {
    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        //parse input
        String [] vals = sc.nextLine().split(" ");
        int n = Integer.parseInt(vals[0]);
        int p = Integer.parseInt(vals[1]);
        int [] cars = new int [n];
        int i = 0;
        while(i<cars.length) {
            cars[i] = sc.nextInt();
            i++;
        }
        Arrays.sort(cars);
        
        int min_dist = p; //will always be at least p
        for(i = 0; i<cars.length; i++) {
            /* 
            *Take braking distance formula for car i and shift so that it reflects the distance you need
            * to be from the car directly in front of you to fulfill it
            * the greater of this and the current minimum distance becomes the new overall min
            */
            min_dist = Math.max((p*(i+1)-(cars[i]-cars[0])),min_dist);
        }
        System.out.println(min_dist);
    }
}