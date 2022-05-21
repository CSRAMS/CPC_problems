import java.util.Scanner;
import java.util.ArrayList;

public class H {

    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int h = sc.nextInt();
        String p = sc.next();
        
        //we will generate primes <=n.  This is enough for the max problem constraint
        int n = 1299709; 
        //initialize list representing primality of each index
        ArrayList<Boolean> isPrime = new ArrayList<Boolean>();
        for (int i = 0; i<=n; i++) {
            isPrime.add(true);
        }
        //generate primes up to n with Sieve of Eratosthenes
        for (int i = 2; i<=Math.sqrt(n); i++) {
            if (isPrime.get(i)) {
                for(int j=(int)Math.pow(i,2); j<n; j+=i) {
                    isPrime.set(j,false);
                }
            }
        }
        int numWithP=0; //number of primes containing p
        int totalPrimes = 0; //total number of primes
        //check if primes between l and h contain p 
        for(int i = 2; i <isPrime.size(); i++) {
            if (isPrime.get(i)) { 
                totalPrimes++;
                if(totalPrimes>=l&&totalPrimes<=h) {
                    if (String.valueOf(i).contains(p)) numWithP++;
                }
            }
        }
        System.out.println(numWithP);
    }
}
