import java.util.*;
class Contest {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String[] one = sc.nextLine().split(" ");
        int testCases = Integer.parseInt(one[0]);
        double r = Double.parseDouble(one[1]);
        double sphere =  Math.PI*(4)/3*Math.pow(r,3);

        //store each box's dimensions in an array of length three, sort list of these
        ArrayList<double []> boxes = new ArrayList<double []>();
        for(int i = 0; i<testCases; i++) {
            String [] boxDims = sc.nextLine().split(" ");
            double [] box = new double [3];
            for(int j =0; j<3; j++) {
                box[j]= Double.parseDouble(boxDims[j]);
            }
            boxes.add(box);
        }
        sort(boxes);

        //check if our COM is higher than each box's -- expand if it is, if not, we're done
        int count = 0;
        for(double [] box: boxes) {
            if (r> 0.5*box[2]) {
                sphere+=(box[0]*box[1]*box[2]);
                r = Math.pow((3*sphere)/4/Math.PI, 1.0/3.0);
                count++;
            }
            else {
                System.out.println("We need to rebuild this! ");
                break;
            }
        }
        if (count==boxes.size()) {
            System.out.println("It's going to be a good set! ");
        }

    }

    //quicksort algo from textbook
    public static void sort ( List<double []> items) {

        if (items.size()>1) {
            List<double []>smaller= new ArrayList<double []>();
            List<double []>same= new ArrayList<double []>();
            List<double []>larger = new ArrayList<double []>();

            double [] chosenItem = items.get(items.size()/2);

            for (double [] i : items) {
                if (i[2] < chosenItem[2])
                    smaller.add(i);
                else if (i[2]>chosenItem[2])
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
