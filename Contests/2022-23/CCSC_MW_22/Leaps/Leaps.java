import java.util.*;
public class Leaps {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        //parse input
        int D = Integer.parseInt(sc.nextLine());
        int N = Integer.parseInt(sc.nextLine());

        
        int [] nums = new int [N];
        for(int i = 0; i<N; i++){
            nums[i] = sc.nextInt();
        }

        //keep track of max number of leaps that can be taken to reach each point in the array
        int [] dp = new int [N];
        dp[0] = 0;
        int global_max = 0;
        for(int i = 1; i<N; i++){
            int curmax = 0; //current max jumps to point i
            //look at every prior spot in the array and see if a jump can be made from there to the current spot
            for(int j = 0; j<i; j++){
                if(nums[i]-nums[j]>=D){
                    //if a jump is possible, see if it yields a higher max than the current max to this point
                    curmax = Math.max(curmax,dp[j]+1);
                }
            }
            dp[i] = curmax;
            global_max = Math.max(global_max,curmax);
        }
        System.out.println(global_max+1); //+1 because they count a jump off the end as well
    }
}
