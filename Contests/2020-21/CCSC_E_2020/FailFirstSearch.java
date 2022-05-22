import java.util.Scanner;
/*
Rules:
1. Only travels to houses that take even number of minutes
2. Only travels to furthest house away
3. Never visits same house twice
4. If nowhere else to go, turns off
5. No two sidewalks take the same time to travel
*/
public class FailFirstSearch {

    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int numhoods = Integer.parseInt(sc.nextLine());

        for(int i = 0; i<numhoods; i++){

            int sidewalks = Integer.parseInt(sc.nextLine());
            //adjacency matrix mapping houses to their edges:
            /*
            Horizontal: House numbers (0-14)
            Vertical: House numbers (0-14)
            Elements: length of edge connecting them - mostly N/A = 0
            */
            int [][] adjmat = new int [15][15];
            for(int j = 0; j<sidewalks; j++){
                String [] line = sc.nextLine().split(" ");

                int [] input = new int[3];
                for (int k = 0; k<3; k++) {
                    input[k] = Integer.parseInt(line[k]);
                }
                adjmat[input[0]][input[1]] = input[2];
                adjmat[input[1]][input[0]] = input[2];
            }
            //array of visited houses
            int [] visited = new int [15];
            visited[0]=1;
            //total time
            int time = 0;
            //length of last connection to prevent repeats
            int last = 0;
            //house number that max connects to
            int maxmap = 0;
            for(int l = 0; l<adjmat.length; l++) {
                l = maxmap;
                //max length connection for this house
                int max = 0;

                for(int m = 0; m<adjmat[l].length; m++) {
                    if(adjmat[l][m]!=0&&adjmat[l][m]%2==0&&adjmat[l][m]!=last&&adjmat[l][m]>max&&visited[m]==0) {
                        max = adjmat[l][m];
                        //set us to the node we connected to
                        maxmap = m;
                    }
                }
                if(max == 0) {
                    break;
                }
                else {
                    last = max;
                    time += max;
                    visited[maxmap]=1;
                }
            }
            System.out.println(time);
        }
    }
}
