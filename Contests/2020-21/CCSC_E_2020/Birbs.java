import java.util.Scanner;
import java.util.ArrayList;


public class Birbs {

public static void main(String [] args) {

Scanner sc = new Scanner(System.in);

while(sc.hasNext()) {
String next1 = sc.nextLine();
  if(!next1.equals("quit")){
    String [] sArr1 = next1.split(" ");
    int [] val1 = new int [sArr1.length];
    for(int i = 0; i<sArr1.length; i++) {
      val1[i]=Integer.parseInt(sArr1[i]);
    }

    String next2 = sc.nextLine();
      if(!next2.equals("quit")){
        String [] sArr2 = next2.split(" ");
        int [] val2 = new int [sArr2.length];
        for(int i = 0; i<sArr2.length; i++) {
          val2[i]=Integer.parseInt(sArr2[i]);
        }
        int sum = 0;
        for(int i = 0; i<Math.min(val1.length, val2.length); i++) {
          sum+= Math.max(val1[i], val2[i]);
        }
        if(sum%7==0){
          System.out.println(sum+" Eels!");
        }
        else {
          System.out.println(sum+" No eels :(");
        }
      }
      else {
        break;
      }
  }
  else {
    break;
  }
}
}
}
