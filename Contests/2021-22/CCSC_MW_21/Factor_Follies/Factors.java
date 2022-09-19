import java.util.Scanner;
public class Factors {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        //read input
        int n = sc.nextInt();
        int m = sc.nextInt();;
        int [] factors = new int [n];
        int [] multiples = new int [m];
        for(int i = 0; i<n; i++){
            factors[i] = sc.nextInt();
        } 
        for(int i = 0; i<m; i++){
            multiples[i] = sc.nextInt();
        } 
        //check each factor for each multiple
        for(int i = 0; i<multiples.length; i++){
            boolean valid = true;
            for(int j = 0; j<factors.length; j++){
                if (multiples[i]%factors[j] != 0) {
                    valid = false;  
                    break;
                }
            }
            if(valid) System.out.print(multiples[i]+" ");
        }   
    }  
}
