import java.util.Scanner;

public class E {

    public static void main (String [] args) {

    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    int paren = line.indexOf("(");
    String first = line.substring(0,paren);
    if (paren+2>line.length()-1) {
        System.out.println("fix");
    }
    else {
        String last = line.substring(paren+2,line.length());
        if (last.length()==first.length()) {
            System.out.println("correct");
        }
        else {
            System.out.println("fix");
        }
    }

    }

}
