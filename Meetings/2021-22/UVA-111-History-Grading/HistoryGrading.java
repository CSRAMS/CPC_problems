import java.util.Scanner;
import java.lang.Math;

public class HistoryGrading {

  public static void main(String[]args) {
    Scanner sc = new Scanner(System.in);
    //Read initial n and answer key
    int n = Integer.parseInt(sc.nextLine());
    int [] correct = convertToInt(sc.nextLine().split("\\s+"));
    String line = sc.nextLine();
    //read lines
    while(line.strip().length()>0) {
      //reset n, answer key if we find a new "n"
      if (line.strip().split("\\s+").length==1) {
        n = Integer.parseInt(line);
        correct = convertToInt(sc.nextLine().split("\\s+"));
      }
      else {
      int [] response = convertToInt(line.split("\\s+"));
      //call lcs on each case, comparing to "correct"
      System.out.println(lcs(response,correct));
      }
      if (sc.hasNextLine()) line = sc.nextLine();
      else break;
    }
  }
  //tabulated function for finding longest common subsequence b/w answer key and response
  public static int lcs(int [] response, int [] correct) {
    int [][] dparr = new int [correct.length+1][response.length+1];
    for (int i = 1; i< dparr.length; i++) {
      for (int j = 1; j<dparr.length; j++) {
        if (response[i-1]==correct[j-1]) dparr[i][j]=1+dparr[i-1][j-1];
        else dparr[i][j]=Math.max(dparr[i-1][j],dparr[i][j-1]);
      }
    }
    return dparr[dparr.length-1][dparr[0].length-1];
  }
  //convert String array to int array
  public static int [] convertToInt(String [] arr) {
    int [] converted = new int [arr.length];
    for (int i =0; i<arr.length; i++) {
      converted[i]=Integer.parseInt(arr[i]);
      }
      return converted;
  }

}
