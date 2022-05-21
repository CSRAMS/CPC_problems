import java.util.*;
public class unfinishedPizza {
    //https://open.kattis.com/problems/pizza2
    //note: this is a very straight forward problem, just fix my errors.

    //this one is written by me to be debugged so mess with it as much as you want
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int  r = s.nextInt();
        int c = s.nextInt();
        int radius = r-c;
        double c_area = Math.PI * Math.pow(radius,2);
        double t_area = Math.PI * Math.pow(r,2);
        System.out.println(c_area/t_area*100);
    }
}