public class LC1020 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(new LC1020().numEnclaves(grid));
    }

    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    
    public int numEnclaves(int[][] board) {
        // securing the border
        int n = board.length;
        int m = board[0].length;

        boolean[][] bordered = new boolean[n][m];

        for (int j = 0; j < m; j++) {
            if(board[0][j] == 1 && !bordered[0][j]){
                bordered[0][j] = true;
                dfs(0, j, board, bordered);
            }
            if(board[n-1][j] == 1 && !bordered[n-1][j]){
                bordered[n-1][j] = true;
                dfs(n-1, j, board, bordered);
            }
        }

        for(int i = 0; i<n; i++){
            if(board[i][0] == 1 && !bordered[i][0]){
                bordered[i][0] = true;
                dfs(i, 0, board, bordered);
            }
            if(board[i][m-1] == 1 && !bordered[i][m-1]){
                bordered[i][m-1] = true;
                dfs(i, m-1, board, bordered);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 1 && !bordered[i][j]) count++;
            }
        }
        return count;
    }

    static void dfs(int i, int j, int[][] board, boolean[][] bordered){
        int n = board.length;
        int m = board[0].length;

        for (int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];
        
            if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;
            if(board[ni][nj] == 1 && !bordered[ni][nj]){
                bordered[ni][nj] = true;
                dfs(ni, nj, board, bordered);
            }
        }
    }
}
