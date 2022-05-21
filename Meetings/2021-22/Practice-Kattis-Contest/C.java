import java.util.*;

public class C {
    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int num = Integer.parseInt(sc.nextLine());
            System.out.println(num+" "+neighbor(num));
        }
    }

    public static int neighbor(int num) {
        int neighbor = 1;
        //test 2 first because every other prime is odd so we can increment by 2 after
        int count = 0;
        while(num%2==0) {
            num/=2;
            count+=1;    
        }
        if(count>0) {
            neighbor*=Math.pow(count,2);
        }
        for(int i =3; i<=Math.sqrt(num); i+=2) {
            /*
            * if num is evenly divisible by i, we keep dividing by i until it is not, incrementing
            * the number of occurences of i in the prime factorization hashmap each time.
            * non-prime factors will never be reached because their prime factors will already have 
            * been divided out of num.
            */
            count = 0;
            while(num%i==0) {
                num/=i;
                count+=1; 
            }
            if(count>0) {
                neighbor*=Math.pow(count,i);
            }
        }
        return neighbor;
    }
}