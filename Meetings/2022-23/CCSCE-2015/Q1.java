import java.util.*;
import java.util.regex.*;
public class Q1 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int doris = 0;
        int boris = 0;
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        for(int i = 0; i< n; i++) {

            String first = sc.nextLine();
            Matcher matcher = pattern.matcher(first);
            if(!matcher.find()) { //if first line contains no letters, it is the number of 
                //entries in a set for Doris
                int count = Integer.parseInt(first);
                for(int j = 0; j<count; j++) {
                    String line = sc.nextLine();
                    doris++;
                }
            }
            else {
                while(!first.equals("0")) {
                    boris++;
                    first=sc.nextLine();
                }
            }   
        }
        System.out.println("Doris: "+doris);
        System.out.println("Boris: "+boris);
    }
    
}
