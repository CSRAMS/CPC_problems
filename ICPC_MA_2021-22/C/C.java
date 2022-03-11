import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numStuds = sc.nextInt();
        int timePerDay = sc.nextInt();
        int numDays = sc.nextInt();
        int[] perfTime = new int[numStuds];
        for(int i = 0; i < numStuds; i++) {
            perfTime[i] = sc.nextInt();
        }
        int timeLeft;
        int currStud = 0;
        int numPasses = 0;
        for(int i = 0; i < numDays; i++) {
            timeLeft = timePerDay;
            while(timeLeft >= perfTime[currStud]) {
                timeLeft -= perfTime[currStud];
                currStud++;
                if(currStud == numStuds) {
                    currStud = 0;
                    numPasses++;
                }
            }
        }
        System.out.println(numPasses);
    }
}
