import java.util.*;
public class Polynomial {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> polys = new HashMap<Integer,Integer>();
        int n = sc.nextInt(); //number of nodes in first poly
        //first polynomial
        System.out.print("Displaying Polynomial 1: ");
        for(int i =0; i<n; i++){
            int coef = 0;
            int deg = 0;
            for(int j = 0; j<2; j++){
                int term = sc.nextInt();
                if(j==0) coef = term;
                else deg = term;
            }
            System.out.print(coef+"X^"+deg+"-->");
            polys.put(deg,coef);
        }
        System.out.print("END");
        System.out.println();

        int m = sc.nextInt(); //number of nodes in second poly
        //second polynomial
        System.out.print("Displaying Polynomial 2: ");
        for(int i =0; i<m; i++){
            int coef = 0;
            int deg = 0;
            for(int j = 0; j<2; j++){
                int term = sc.nextInt();
                if(j==0) coef = term;
                else deg = term;
            }
            System.out.print(coef+"X^"+deg+"-->");
            polys.put(deg,polys.getOrDefault(deg,0)+coef);
        }
        System.out.print("END");
        System.out.println();

        // Resultant Polynomial
        ArrayList<Integer> sortedKeys = new ArrayList<Integer>();

        for(int key:polys.keySet()){
            sortedKeys.add(key);
        }
        Collections.sort(sortedKeys,Collections.reverseOrder());

        System.out.print("Resultant Polynomial: ");
        for(int deg: sortedKeys){
            int coef = polys.getOrDefault(deg,0);
            System.out.print(coef+"X^"+deg+"-->");
        }
        System.out.print("END");
        System.out.println(); 
    }
}
