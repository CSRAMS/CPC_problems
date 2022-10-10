import java.util.*;
public class Coffee {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] vals = sc.nextLine().split(" ");
        int n = Integer.parseInt(vals[0]); //number of groups
        int m = Integer.parseInt(vals[1]); //pots of coffee
        int total= 96*m; //initial total to 96 oz's per pot of coffee * number of pots of coffee
        int remaining = 0;
        for(int i = 0; i<n; i++){
            total -= Integer.parseInt(sc.nextLine()); //decrement total by amount to group drank
            remaining = total; //current total is the remaining value after current group
            int emptypots = (m - (int)Math.ceil((double)total/(double)96)); // this is the number of empty pots we can brew in
            //after storing all the currently remaining coffee in pots
            total += 96*emptypots; //fill available empty pots
            
        }
        //print remaining ozs after last group
        System.out.println(remaining);
    }
}
