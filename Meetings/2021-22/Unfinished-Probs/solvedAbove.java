import java.util.*;
public class unfinishedAbove {
    //https://open.kattis.com/problems/aboveaverage
    //https://github.com/dakoval/Kattis-Solutions/blob/master/aboveaverage.java
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for(int i=0;i<c;i++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            double average=0;
            int sum = 0;
            for(int j=0;j<n;j++){
                arr[j]=sc.nextInt();
                sum+=arr[j];
            }
            average = sum/n;
            int above=0;
            for(int j=0;j<n;j++) {
                if(arr[j]>average)above++;
            }
            System.out.printf("%.3f%s  \n",(double)above/n*100,"%");
        }
    }
}