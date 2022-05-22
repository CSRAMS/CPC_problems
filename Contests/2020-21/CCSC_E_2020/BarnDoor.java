import java.util.Scanner;
import java.util.ArrayList;


public class BarnDoor {

public static void main(String [] args) {

Scanner sc = new Scanner(System.in);

while(sc.hasNextInt()) {
  int n = sc.nextInt();
  if(n>-1&&n%2!=0&&n!=1){

    char [][] arr = new char [n][n];
    for(int i = 0; i< arr.length; i++){
      for(int j = 0; j< arr.length; j++) {
          arr[i][j]=' ';
        }
      }
    arr[0][0] = '+';
    arr[0][n-1]='+';
    arr[n-1][0]='+';
    arr[n-1][n-1]='+';
    for(int i =1; i<n-1; i++){
      arr[0][i] = '-';
      arr[n-1][i]='-';
    }
    for(int i =1; i<n-1; i++){
      arr[i][0] = '|';
      arr[i][n-1]='|';
    }
    for(int i = 1; i<n-1; i++){
      for(int j = 1; j<n-1; j++) {
        if(i==j){
        arr[i][j] = '\\';
      }
      if(j==n-i-1){
        arr[i][j] = '/';
      }
      if(i==(n/2)&&j==(n/2)){
        arr[i][j] = 'X';
      }
      }
    }
    for(int i = 0; i< arr.length; i++){
      for(int j = 0; j< arr.length; j++) {
          System.out.print(arr[i][j]);
  }
  System.out.println();
    }
  }
  else if (n==1){
    System.out.println("Too small");
  }
  else if (n%2==0) {
    System.out.println(n+" is even");
  }
  else if(n<0) {
    break;
  }



}
}
}
