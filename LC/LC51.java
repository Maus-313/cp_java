import java.util.ArrayList;
import java.util.List;

public class LC51 {
    public static void main(String[] args) {
        LC51 solver = new LC51();
        List<List<String>> solutions = solver.solveNQueens(4);
        System.out.println("Result -> "+solutions.size());
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        int[][] board = new int[n][n];

        dfs(board, 0, 0, n, ans);

        // ans.add(new ArrayList<>());
        return ans;

    }

    static void dfs(int[][] board, int i, int j, int N, List<List<String>> ans){
        if(N < 0 || i >= board.length || j >= board[0].length) return;
        
        if(N == 0){
            // for(int[] r : board){
            //     List<String> temp = new ArrayList<>();
            //     for(int n : r){
            //         if(n == 0){
            //             temp.add(".");
            //         }else{
            //             temp.add("Q");
            //         }
            //     }
            // }
            ans.add(new ArrayList());
            return;
        }

        board[i][j] = 1;
        N--;

        if(isSafe(i+1, j, board)) dfs(board, i+1, j, N, ans);
        if(isSafe(i, j+1, board)) dfs(board, i, j+1, N, ans);

        board[i][j] = 0;
        N++;
    }

    static boolean isSafe(int x, int y, int[][] board){

        for(int i = 0; i<board.length; i++){
            if( i!= x && board[i][y] == 1) return false;
        }

        for(int j = 0; j<board[0].length; j++){
            if( j != y && board[x][j] == 1) return false;
        }

        return true;
    }
}
