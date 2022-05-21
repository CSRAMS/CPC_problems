
import java.util.*;

public class abc {
    //https://open.kattis.com/problems/abc
    //https://github.com/dakoval/Kattis-Solutions/blob/master/abc.java

    //any of this problem could be wrong/unfinished

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int[] num = new int[3];
        for (int i = 0; i < 3; i++) {
            num[i] = 0;
        }
        char[] c = sc.next().toCharArray();
        for (int i = 0; i < 3; i++) {
            System.out.print(num[c[i] - 'A'] + " ");
        }
    }
}