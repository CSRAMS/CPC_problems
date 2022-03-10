import java.util.Scanner;

public class J {

    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int one = Integer.parseInt(line1[0]);
        int two = Integer.parseInt(line1[1]);
        String line2 = sc.nextLine();

        boolean works = true;
        String out = "";

        outerloop:
        if (line2.charAt(0) == ('B')){
            if (line2.charAt(1) == ('B')){
                if(one!=3){
                    works = false;
                    break outerloop;
                }
                out = "1 2";
            }
            else{
                if(one!=2){
                    works = false;
                    break outerloop;
                }
                if (line2.charAt(2) == ('B')){
                    if(two!= 4){
                        works = false;
                        break outerloop;
                    }
                    out = "1 3";
                }
                if (line2.charAt(2) == ('A')){
                    if(two!= 8){
                        works = false;
                        break outerloop;
                    }
                    out = "1 9";
                }
            }  
        }
        else{
            if (line2.charAt(1) == ('B')){
                if (line2.charAt(2) == ('B')){
                    if(two-one!= 3){  
                        works = false;
                        break outerloop;
                    }
                    out+= one+1;
                    out += " ";
                    out+= two-1;
                }
                else if(two!= 8){
                    works = false;
                    break outerloop;
                }
                else if (one!=6) {
                    works = false;
                    break outerloop;
                    
                }
                else{
                    out = "7 9";
                }
                
            }
            else if(two!= 7){
                works = false;
                break outerloop;
            }
            else{out = "8 9";}
            
        }

        if(works){
            System.out.println(out);
        }
        else{
            System.out.println(-1);
        }
    }
}
