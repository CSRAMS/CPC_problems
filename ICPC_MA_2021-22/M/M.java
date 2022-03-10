import java.util.Scanner;

import java.util.*;

public class M {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<int[]> input = new ArrayList<int []>();
        //parse input into 
        for(int i=0;i<n;i++){
            String[] line = sc.nextLine().split(" ");
            int [] packet = new int [2];
            packet[0] = Integer.parseInt(line[0]);
            packet[1] = Integer.parseInt(line[1]);
            input.add(packet);
        }

        sort(input);

        //iterate through sorted packets -- if the next packet arrives later than the current time,
        //add the lag time
        int curTime = 1;
        int lag = 0;
        for (int [] i: input){
            if (i[0]>curTime) {
                lag+=(i[0]-curTime);  
                curTime+=((i[0]-curTime)+1);
            } 
            else {
                curTime+=1;
            }
        }
        System.out.println(lag);
    }

    //quicksort algo from textbook
    public static void sort ( List<int []> items) {

        if (items.size()>1) {
            List<int []>smaller= new ArrayList<int []>();
            List<int []>same= new ArrayList<int []>();
            List<int []>larger = new ArrayList<int []>();

            int [] chosenItem = items.get(items.size()/2);

            for (int [] i : items) {
                if (i[1] < chosenItem[1])
                    smaller.add(i);
                else if (i[1]>chosenItem[1])
                    larger.add(i);
                else 
                    same.add(i);
            }
            sort(smaller);
            sort(larger);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }
    }
}
