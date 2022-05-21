public class aboveaverage {
    //https://open.kattis.com/problems/aboveaverage
    //https://github.com/dakoval/Kattis-Solutions/blob/master/aboveaverage.java
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for(int i=0;i<c-1;i++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            double average=0;
            for(int j=0;j<n;j++){
                //insert logic
            }
            average = average/n;
            int above=0;
            for(int j=0;j<nn;j++)if(arr[j]>average)above++;
            System.out.printf("%.3f%s  \n",(double)above/n*100,"%");
        }
    }
}