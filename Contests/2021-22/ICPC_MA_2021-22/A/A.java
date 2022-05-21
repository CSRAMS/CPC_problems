import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //parse input
        int numOrders = sc.nextInt();
        int waterOz = sc.nextInt();
        sc.nextLine(); //not doing nextLine after parsing ints can make Scanner one line off when
        //reading subsequent input
        int currOz = waterOz; // amount remaining in tank
        int numRefills = 0;
        char[] order;
        int cost;
        for(int i = 0; i < numOrders; i++) {
            order = sc.nextLine().toCharArray();
            cost = 0;
            for(int j = 0; j < order.length; j++) {
                if(order[j] == 'L') {
                    cost += 1;
                }
                else {
                    cost += Integer.parseInt("" + order[j]);
                }
            }
            if(currOz < cost) {
                numRefills++;
                currOz = waterOz;
            }
            currOz -= cost;
        }
        System.out.println(numRefills);
    }
}
