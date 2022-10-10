import java.util.*;
public class Creatures {
    //t0 = current timestep
    //t1-3 are prior time steps
    static char [][] t3;
    static char [][] t1;
    static char [][] t2;
    static char [][] t0;
    //store attack data in hashmap with timestamp as keys
    static HashMap<Integer, int[]> attacks;
    static int N;
    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String [] vals = line.split(" ");
        N = Integer.parseInt(vals[0]);
        int TT = Integer.parseInt(vals[1]);
        int AA = Integer.parseInt(vals[2]);

        char [][] grid = new char [N][N];
        for(int i = 0; i <N; i++) {
            for(int j =0; j<N; j++){
                grid[i][j]='O';
            }
        }
        t3 = null;
        t2 = null;
        t1 = grid;
        t0 = null;
        attacks = new HashMap<Integer, int[]>();
        for(int a = 0; a <AA; a++){
            line = sc.nextLine();
            String [] vals1 = line.split(" ");
            int ti = Integer.parseInt(vals1[0]); 
            int x = Integer.parseInt(vals1[1]); 
            int y = Integer.parseInt(vals1[2]); 
            attacks.put(ti,new int []{x,y});
        }
        //run sumulation
        for(int t = 1; t<=TT; t++){
            updateGrid(t);
        }
        int closed = 0;
        int open = 0;
        int eaten = 0;
        //count each type of creature at the end
        for(int i = 0; i <N; i++) {
            for(int j =0; j<N; j++){
                if(t0[i][j]=='O') open++;
                if(t0[i][j]=='c') closed++;
                if(t0[i][j]=='E') eaten++;
            }
        }
        System.out.println(open+" "+closed+" "+eaten);
    }

    //main method for updating grids in simulation
    public static void updateGrid(int t){
        t0 = new char [N][N];
        for(int i = 0; i <N; i++) {
            for(int j =0; j<N; j++){
                t0[i][j]=t1[i][j];
            }
        }
        boolean cascade = false;
        //update current grid with attack
        if(attacks.containsKey(t)){
            int [] attack = attacks.get(t);
            int x = attack[0];
            int y = attack[1];
            // System.out.println(x+" "+y);
            if (t1[x][y]=='O'||t1[x][y]=='E') t0[x][y] = 'E';
        }

        //cascade neighbors
        if(t>=2){
            for(int i = 0; i <N; i++) {
                for(int j =0; j<N; j++){
                    ArrayList<int []> nes = neighbors(i,j,N);
                    for(int []ne: nes){
                        int x = ne[0];
                        int y = ne[1];
                        if(t2[x][y]=='O'&&t1[x][y]!='O'){
                            if(t0[i][j]!='E') t0[i][j]='c';
                        }
                    }
                }
            }
        }
        if(t>=3){
            //reopen closed
            for(int i = 0; i <N; i++) {
                for(int j =0; j<N; j++){
                    if(t1[i][j]=='c'&&t3[i][j]=='O'&&t2[i][j]=='c') t0[i][j]='O';
                }
            }
        }
        t3 = t2;
        t2 = t1;
        t1 = t0; 
    }

    //get neighbors in both horiz/vert and diag directions
    public static ArrayList<int []> neighbors(int x, int y, int N){
        ArrayList<int []> neighbors1 = new ArrayList<int []>();
        if(x>0){
            neighbors1.add(new int []{x-1,y});

            if(y>0) neighbors1.add(new int []{x-1,y-1});
            if(y<N-1) neighbors1.add(new int []{x-1,y+1});
        }
        if(x<N-1){
            neighbors1.add(new int []{x+1,y});
            if(y>0)neighbors1.add(new int []{x+1,y-1});
            if(y<N-1)neighbors1.add(new int []{x+1,y+1});
        }
        if(y>0)neighbors1.add(new int []{x,y-1});
        if(y<N-1)neighbors1.add(new int []{x,y+1});
        return neighbors1;
    }
}
