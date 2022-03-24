import java.util.Scanner;
public class D {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        //parse input
        String [] rc = sc.nextLine().split(" ");

        int r = Integer.parseInt(rc[0]);
        int c = Integer.parseInt(rc[1]);
        int [][] land = new int [r][c];
        for(int i = 0; i <r; i++) {
            for (int j = 0; j<c; j++){
                land[i][j]=sc.nextInt();
            }
        }
        //count each type of cell
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for(int i = 0; i <r; i++) {
            for (int j = 0; j<c; j++){
                if (land[i][j]==0) zeros++;
                if (land[i][j]==1) ones++;
                if (land[i][j]==2) twos++;
            }
        }
        //we need long if there are >60 2s -- Java integer max value is 2^31-1
        long min_diff = Long.MAX_VALUE;
        //possible cases with more than one row and column
        if(r>1&&c>1) {
            if (zeros==0) {
                if (twos==0) {
                    min_diff = 0;
                } 
                else if (twos==1) {
                    min_diff = 1;
                }
                else {
                    if (twos%2==0) {
                        min_diff=0;
                    }
                    else {
                        min_diff = (long) Math.pow(2,twos/2+1) - (long) Math.pow(2,twos/2);
                    }
                }   
            }  
            else if (zeros == 1) {
                if (ones>0) {
                    min_diff=1;
                }
                else {
                    min_diff=2;
                }
            }
            else {
                min_diff=0;
            }
            
        }
        else {
            //for just one row or column, scan all possible splits (up to 63)
            if (r==1) {
                for(int s = 1; s<land[0].length; s++) {
                   long first_prod =1;
                    for(int i = 0; i<s; i++) {
                        first_prod*=land[0][i];
                    }
                    long second_prod = 1;
                    for(int j = s; j<land[0].length; j++) {
                        second_prod*=land[0][j];
                    }
                    min_diff = Math.min(Math.abs(first_prod-second_prod),min_diff);
                }
            }
            else {
                for(int s = 1; s<land.length; s++) {
                    long first_prod =1;
                    for(int i = 0; i<s; i++) {
                        first_prod*=land[i][0];
                    }
                    long second_prod = 1;
                    for(int j = s; j<land.length; j++) {
                        second_prod*=land[j][0];
                    }
                    min_diff = Math.min(Math.abs(first_prod-second_prod),min_diff);
                }
            }  
        }
        System.out.println(min_diff);    
    }
}
