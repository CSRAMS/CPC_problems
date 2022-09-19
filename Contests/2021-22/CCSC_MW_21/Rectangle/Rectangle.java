import java.util.*;
public class Rectangle {
    public static void main(String [] args) {  
        Scanner sc = new Scanner(System.in);

        //represent rectangle coordinates in arrays
        int [] r1 = new int [4];
        int [] r2 = new int [4];
        //parse input
        for(int i = 0; i<4; i++){
            r1[i] = sc.nextInt();
        }
        for(int i = 0; i<4; i++){
            r2[i] = sc.nextInt();
        }

        int xmax1 = Math.max(r1[0],r1[2]); //max x coordinate in r1
        int xmax2 = Math.max(r2[0],r2[2]); //max x coordinate in r2
        int uhbound = Math.min(xmax1,xmax2); //upper bound of intersection area on x axis

        int xmin1 = Math.min(r1[0],r1[2]); //min x coordinate in r1
        int xmin2 = Math.min(r2[0],r2[2]); //min x coordiante in r2
        int lhbound =Math.max(xmin1,xmin2); //lower bound of intersection area on x axis

        int ymax1 = Math.max(r1[1],r1[3]); //max y coordinate in r1
        int ymax2 = Math.max(r2[1],r2[3]); //max y coordinate in r2
        int uvbound = Math.min(ymax1,ymax2); //upper bound of intersection area on y axis

        int ymin1 = Math.min(r1[1],r1[3]); //min y coordinate in r1
        int ymin2 = Math.min(r2[1],r2[3]); //min y coordiante in r2
        int lvbound = Math.max(ymin1,ymin2); //lower bound of intersection area on y axis

        if (uhbound<=lhbound || uvbound<=lvbound) System.out.println(0);
        else System.out.println(Math.abs(uhbound-lhbound)*Math.abs(uvbound-lvbound));
    }
}
