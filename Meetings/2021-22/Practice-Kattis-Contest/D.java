import java.util.Scanner;

public class D {

    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        //parse input
        while(sc.hasNextLine()) {
            String [] vals = sc.nextLine().split(" ");
            double r = Double.parseDouble(vals[0]);
            int m = Integer.parseInt(vals[1]);
            int c = Integer.parseInt(vals[2]);
            //signal for last line
            if(r==0&&m==0&&c==0) {
                break;
            }

            double true_area = Math.pow(r,2)*Math.PI; //true area from real radius
            double square_area = Math.pow(2*r,2); //get area of square from real radius
            double frac = (double)c/(double)m; //fraction of dots in square that are in circle
            double estimate = frac*square_area; //fraction * the area of the square

            System.out.println(true_area+" "+estimate);
        }

    }

}