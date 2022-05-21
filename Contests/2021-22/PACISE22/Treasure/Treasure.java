import java.util.*;

class Treasure {

    static int [] pascal;
    static int [] treasure;
    static char [][] maze;
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        maze = new char [10][10];
        //parse input
        for (int i = 0; i<10; i++){
            maze[i] = sc.nextLine().toCharArray();
            for (int j = 0; j<maze[i].length; j++) {

                if (maze[i][j]=='P') {
                    pascal = new int []{i,j};
                }
                else if (maze[i][j]=='T'){
                    treasure = new int []{i,j};
                }
            }
        }
    
        String first = bfs(pascal,'T'); //generate Pascal's path to the treasure
        String second = bfs(treasure,'X'); //generate path from treasure to the nearest exit

        System.out.println(first+second);
        
    }
    /*generate neighbors of current maze coordinate that are not already visited
    */
    public static HashMap<Character,int []> getNeighbors(int [] loc,HashMap<String,Character> visited) {

        int r = loc[0];
        int c = loc[1];
        HashMap<Character, int[]> moves = new HashMap<Character, int[]>();
        if(r!=0&&maze[r-1][c]!='W'&&!visited.containsKey(String.valueOf(loc[0]-1)+String.valueOf(loc[1]))) {
            moves.put('N',new int[]{r-1,c});
        }
        if (r!=maze.length-1&&maze[r+1][c]!='W'&&!visited.containsKey(String.valueOf(loc[0]+1)+String.valueOf(loc[1]))) {
            moves.put('S',new int[]{r+1,c});
        }
        if (c!=maze[r].length-1&&maze[r][c+1]!='W'&&!visited.containsKey(String.valueOf(loc[0])+String.valueOf(loc[1]+1))) {
            moves.put('E',new int[]{r,c+1});
        }
        if (c!=0&&maze[r][c-1]!='W'&&!visited.containsKey(String.valueOf(loc[0])+String.valueOf(loc[1]-1))) {
            moves.put('W',new int[]{r,c-1});
        }
        return moves;
    }

    /*
    *standard BFS over maze
    */
    public static String bfs(int [] start, char goal) {
        
        ArrayList<int []> q = new ArrayList<int []>(); //queue of nodes to visit in bfs
        HashMap<String,String> steps = new HashMap<String,String>(); //map of locations and the steps taken to get there
        HashMap<String,Character> visited = new HashMap<String,Character>(); //map keeping track of coordinates we've visited --
        //we don't visit the same place twice -- this could cause infinite cycles

        q.add(start);
        steps.put(asString(start),"");

        while (!q.isEmpty()) {
            int [] cur = q.remove(0);
            visited.put(asString(cur),maze[cur[0]][cur[1]]);

            if(maze[cur[0]][cur[1]]==goal&&!(steps.get(asString(cur)).length()>200)) {
                //return if we arrived at goal and total steps does not exceed 200 (problem constraint)
                return steps.get(asString(cur));
            }
            HashMap<Character,int[]> moves = getNeighbors(cur, visited);
            for(char key: moves.keySet()){
                int [] loc = moves.get(key);
                q.add(loc);
                steps.put(asString(loc),steps.get(asString(cur))+key);
            }
      
        }
        return "";
    }

    /*save some syntax for string conversion -- we encode locations as strings
    * in hashmap because arrays are not primitive -- identical arrays will not map to same address
    * unless they are the same object
    */
    public static String asString(int [] loc) {
        return String.valueOf(loc[0])+String.valueOf(loc[1]);
    }
}
