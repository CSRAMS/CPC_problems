class Solution {

    static List<List<String>> solutions; //final list of valid boards

    public List<List<String>> solveNQueens(int n) {

        solutions = new ArrayList<List<String>>();

        int [][] board = new int [n][n];
        for(int i = 0; i<board.length; i++) {
            for(int j =0; j<board[i].length; j++){
                board[i][j]=0;
            }
        }
        placeQueens(board,0,0,0,0);

        return solutions;
    }
    /*
    * @param board - int array of 1's and 0's representing board state
    * @ param prev_i - row coordinate of most recently placed queen
    * @ param i_ind - new row coordinate
    * @ param j_ind - current column coordinate
    * @param numQs - number of queens placed on current board
    */
    public static void placeQueens(int[][]board, int prev_i, int i_ind, int j_ind, int numQs) {
        //implement
    }

    /*
    * Return true if queen @i_ind, j_ind is attacking another queen
    * return false otherwise
    * @param board - int array of 1's and 0's representing board state
    * @param i_ind - row coordinate of queen
    * @param j_ind - column coordinate of queen
    */
    public static boolean legalCheck(int[][]board, int i_ind, int j_ind) {

        int n = board.length;
        //vertical
        int count = 0;
        for(int i =0; i<n;i++){
            if (board[i][j_ind]==1){
                count++;
            }
            if (count>1) {
                return false;
            }
        }
        //horizontal
        count = 0;
        for(int j =0; j<n;j++){
            if (board[i_ind][j]==1){
                count++;
            }
            if (count>1) {
                return false;
            }
        }
        //diagonals:
        //southeast
        if(i_ind!=n-1&&j_ind!=n-1) {
            for(int r=i_ind+1, f= j_ind+1; r<n && f<n; r++, f++){
                if (board[r][f]==1) {
                    return false;
                }
            }
        }
        //northwest
        if(i_ind!=0&&j_ind!=0) {
            for(int r=i_ind-1, f= j_ind-1; r>-1 && f>-1; r--, f--){
                if (board[r][f]==1) {
                    return false;
                }
            }
        }
        //southwest
        if(i_ind!=n-1&&j_ind!=0) {
            for(int r=i_ind+1, f= j_ind-1; r<n && f>-1; r++, f--){
                if (board[r][f]==1) {
                    return false;
                }
            }
        }
        //northeast
        if(i_ind!=0&&j_ind!=n-1) {
            for(int r=i_ind-1, f= j_ind+1; r>-1 && f<n; r--, f++){
                if (board[r][f]==1) {
                    return false;
                }

            }
        }
        return true;
    }

    /*
    * convert an int [] board to proper string output format
    * @param board - int array representing board state
    */
    public static List<String> convert(int [][]board) {
        List<String> ret = new ArrayList<String>();
        for(int i =0; i<board.length; i++) {
            String row = "";
            for(int j =0; j<board.length; j++){
                if (board[i][j]==0) {
                    row+=".";
                }
                else {
                    row+="Q";
                }
            }
            ret.add(row);
        }
        return ret;
    }

    /*
    * Print board for debugging
    * @param board - int array representing board state
    */
    public static void printBoard(int [][] board) {
        for(int i = 0; i<board.length; i++) {
            for(int j =0; j<board[i].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}
