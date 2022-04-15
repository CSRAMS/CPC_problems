import java.util.*;

class QB
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap(); //store radii and # of mascots they hit in HashMap
        int ms = scan.nextInt();
        int mostMs = 0;
        int bestRad = Integer.MAX_VALUE;
        while(ms != 0) { //# mascots = 0 for testset is stopping character
            int qbx = scan.nextInt();
            int qby = scan.nextInt();
            /*for each mascot, find the rope radius that would hit it, and keep track of how
            * many mascots each rope radius hits in a hashmap
            */
            for(int i = 0; i < ms; i++) {
                int xdiff = qbx - scan.nextInt();
                int ydiff = qby - scan.nextInt();
                double rad = Math.sqrt(xdiff*xdiff + ydiff*ydiff);
                double decimal = rad - (int)rad;
                int radius = 0;
                if(decimal>=0.5) { //rope radii must be integers and mascots have radius 0.5
                     radius = (int) Math.ceil(rad);
                }
                else {
                    radius = (int) Math.floor(rad);
                }
                map.put(radius, map.getOrDefault(radius, 0) + 1);
                //update radius hitting most mascots
                if(map.get(radius) > mostMs){
                    bestRad = radius;
                    mostMs = map.get(radius);
                }
                //if two radii hit the same # of mascots, take the smaller one per problem constraints
                else if(map.get(radius) == mostMs && radius < bestRad) {
                    bestRad = (int)radius;
                }
            }
            System.out.println(bestRad);
            ms = scan.nextInt();
            map = new HashMap();
            bestRad = Integer.MAX_VALUE;
            mostMs = 0;
        }
        
    }
}
