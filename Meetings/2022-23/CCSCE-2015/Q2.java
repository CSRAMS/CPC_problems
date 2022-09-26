import java.util.*;
public class Q2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //parse new inputs till we get end of input marker
        while(!input.equals("-1")) {
            String [] vals = input.split(" ");
            int base = Integer.parseInt(vals[0]);
            int numDigits = Integer.parseInt(vals[1]);
            String reading  = vals[2];
            int inc = Integer.parseInt(vals[3]);
            //parse odomoter reading into an array of digits
            int [] result = new int [numDigits];
            for(int i = 0; i<numDigits; i++){
                result[i]=Integer.parseInt(reading.substring(i,i+1));
            }

            int carry = 0;
            int ind = numDigits-1;
            //increment odometer specified number of times
            for(int i = 0; i<inc; i++) {
                result[ind]++;
                carry=result[ind]/base;
                result[ind]%=base;
                //like pencil and paper addition, carry until value at current
                //digit does not exceed base-1
                while(carry>0){
                    ind--;
                    result[ind]+=carry;
                    carry=result[ind]/base;
                    result[ind]%=base;
                    if(ind==0){ //account for wraparound to 0 at max value
                        ind = numDigits-1;
                        carry-=1;
                    } 
                }
                //print result of each increment
                for(int j =0; j<result.length; j++){
                    System.out.print(result[j]);
                }
                System.out.println();
                ind = numDigits-1; //reset digit to start adding at
            }
            input = sc.nextLine();
        }     
    }
}
