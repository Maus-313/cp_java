public class LC130 {
    public static void main(String[] args) {
        // char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        // char[][] board = {{'X'}};    
        char[][] board = {
            {'X','O','X','O','X','O'},
            {'O','X','O','X','O','X'},
            {'X','O','X','O','X','O'},
            {'O','X','O','X','O','X'}
        };    

        new LC130().solve(board);;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public void solve(char[][] board) {
        // securing the border
        int n = board.length;
        int m = board[0].length;

        boolean[][] bordered = new boolean[n][m];

        for (int j = 0; j < m; j++) {
            if(board[0][j] == 'O' && !bordered[0][j]){
                bordered[0][j] = true;
                dfs(0, j, board, bordered);
            }
            if(board[n-1][j] == 'O' && !bordered[n-1][j]){
                bordered[n-1][j] = true;
                dfs(n-1, j, board, bordered);
            }
        }

        for(int i = 0; i<n; i++){
            if(board[i][0] == 'O' && !bordered[i][0]){
                bordered[i][0] = true;
                dfs(i, 0, board, bordered);
            }
            if(board[i][m-1] == 'O' && !bordered[i][m-1]){
                bordered[i][m-1] = true;
                dfs(i, m-1, board, bordered);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 'O' && !bordered[i][j]) board[i][j] = 'X';
            }
        }
        // for(boolean[] r : bordered){
        //     for(boolean b : r){
        //         System.out.print(b +" ");
        //     }
        //     System.out.println();
        // }
    }

    static void dfs(int i, int j, char[][] board, boolean[][] bordered){
        int n = board.length;
        int m = board[0].length;

        for (int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];
        
            if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;
            if(board[ni][nj] == 'O' && !bordered[ni][nj]){
                bordered[ni][nj] = true;
                dfs(ni, nj, board, bordered);
            }
        }
    }
}
