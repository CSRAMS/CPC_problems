import java.util.*;
public class Juicy {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        //parse input
        int n = sc.nextInt();
        int k = sc.nextInt();
        LinkedList<Integer> juices = new LinkedList<Integer>();
        for(int i = 0; i<n; i++) {
            juices.add(sc.nextInt());
        }

        Collections.sort(juices);
        int count = 0;
        //repeatedly combine juices, count iterations
        while(juices.get(0)<k&&juices.size()>1) {
            count++;
            int least = juices.removeFirst();
            int second = juices.removeFirst();
            int newjuice = least+ 2*second;
            //binary search for logn insertion of new juice into sorted position
            int index = Collections.binarySearch(juices,newjuice);
            if(index<0) index = -index-1; //address quirk of Collections.binarySearch
            juices.add(index,newjuice);
        }
        if(juices.get(0)<k) System.out.print(-1);
        else System.out.print(count);
    }
}
