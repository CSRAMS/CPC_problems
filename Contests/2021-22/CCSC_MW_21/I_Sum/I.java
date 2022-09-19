import java.util.Scanner;
public class I {

    static int [][] arr;
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        arr = new int [6][6];
        //read input
        for(int i= 0; i<6; i++){
            for(int j =0; j<6; j++){
             arr[i][j] = sc.nextInt();
            }
        }
        int maxI = Integer.MIN_VALUE;
        //iterate through all I's in array and find max
        for(int r = 1; r<5; r++){
            for(int c = 1; c<5; c++){
                maxI = Math.max(maxI, getSum(r,c));
            }
        }
        System.out.print(maxI);
    } 
    
    //get sum of a given I
    public static int getSum(int r, int c){
        return arr[r][c]+arr[r-1][c-1]+arr[r-1][c]+arr[r-1][c+1]+arr[r+1][c-1]+arr[r+1][c]+arr[r+1][c+1];
    }
}
