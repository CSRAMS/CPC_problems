import java.util.Scanner;

public class M {

    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String bit = parseInput(line);
            int [] board = createBoard(bit.substring(9,18),bit.substring(0,9));
            int state = getState(board);
            switch (state) {
                case 0: System.out.println("O wins");break;
                case 1: System.out.println("X wins");break;
                case 2: System.out.println("In progress");break;
                case 3: System.out.println("Cat's");break;
            }
        }

    }

    public static String parseInput(String oct){
        char [] arr = oct.toCharArray();
        String bit = "";
        for (int i = 1; i <arr.length; i++){
            switch(arr[i]) {
                case '0': bit+="000"; break;
                case '1': bit+="001"; break;
                case '2': bit+="010"; break;
                case '3': bit+="011"; break;
                case '4': bit+="100"; break;
                case '5': bit+="101"; break;
                case '6': bit+="110"; break;
                case '7': bit+="111"; break;
            }
        }
        if (bit.length()==21) {
            bit = bit.substring(3,bit.length());
        }
        else {
            while(bit.length()<18) {
                bit="0"+bit;
            }
        }
        return bit;
    }
    //0 - O wins, 1 - X wins, 2 - in progress, 3 - Cat's
    public static int getState(int [] board) {
        //rows
        for(int i = 0; i< 3; i++) {
            int one = 0;
            int zero = 0;
            for (int j = 0; j<3; j++) {
                if (board[(3*i+j)]==1) {
                    one++;
                }
                else if (board[(3*i+j)]==0)  {
                    zero++;
                }
            }
            if (zero==3) {
                return 0;
            }
            else if (one==3) {
                return 1;
            }
        }

        //columns
        for(int i = 0; i< 3; i++) {
            int one = 0;
            int zero = 0;
            for (int j = 0; j<3; j++) {
                if (board[3*j+i]==1) {
                    one++;
                }
                else if (board[3*j+i]==0)  {
                    zero++;
                }
            }
            if (zero==3) {
                return 0;
            }
            else if (one==3) {
                return 1;
            }
        }
        //diagonals
        if (board[0]==board[4]&&board[0]==board[8]&&board[0]!=2){
            return board[0];
        }
        else if (board[2]==board[4]&&board[2]==board[6]&&board[2]!=2) {
            return board[2];
        }

        //is full
        for(int i = 0; i< 9; i++) {
            if (board[i]==2) return 2;
        }
        return 3;
    }

    public static int[] createBoard(String played, String xoro) {
        // System.out.println("Played: "+played);
        // System.out.println("XorO: "+xoro);
        int [] board = new int [9];
        for (int i = 0; i < played.length(); i++) {
            if (played.substring(i,i+1).equals("1")&&xoro.substring(i,i+1).equals("1")){
                board[i]=1;
            }
            else if (played.substring(i,i+1).equals("0")&&xoro.substring(i,i+1).equals("0")) {
                board[i]=2;
            }
            else {
                board[i]=0;
            }
        }
        return board;
    }

}
