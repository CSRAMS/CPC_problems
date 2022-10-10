import java.util.*;
public class Password {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int testCases = Integer.parseInt(s.nextLine());
        for(int a = 0; a < testCases; a++){
            String[] line = s.nextLine().split(" ");
            int lowercase = 0;
            int uppercase = 0;
            int digits = 0;
            int special = 0;
            int temp = 0;
            
            //if line.length = 1 then the password automatically passes
            if(line.length>1){

                //this stores how many of each type of rule is needed in the variables above
                for(int b = 0; b < line[0].length(); b++ ){
                    char c = line[0].charAt(b);
                    if((c>64)&&(c<123)){
                        if (c=='L') lowercase+=temp;
                        else if (c=='U') uppercase+=temp;
                        else if (c=='D') digits+=temp;
                        else special+=temp;
                        temp=0;
                    }
                    else {
                        if (temp>0) temp = temp*10;
                        temp+= Character.getNumericValue(c);;
                    }
                }

                //every char in the password is checked based on its ascii value for which condition it satisfies
                for (int d = 0; d < line[1].length(); d++){
                    int ascii = line[1].charAt(d);
                    if ((ascii>47)&&(ascii<58)) digits--;
                    else if ((ascii>64)&&(ascii<91)) uppercase--;
                    else if ((ascii>96)&&(ascii<123)) lowercase--;
                    else special --;
                }

                //checks if all of the conditions have been met enough times
                if((digits>0) || (uppercase>0) || (lowercase>0) || (special>0)){
                    System.out.println("NO");
                }
                else System.out.println("YES");


            }
            else System.out.println("YES");
        }
    }
}
