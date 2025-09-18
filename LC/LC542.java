import java.util.ArrayDeque;

public class LC542 {
    public static void main(String[] args) {

        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        int[][] mat2 = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

        // int[][] ans = mat;
        int[][] ans = new LC542().updateMatrix(mat);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    static int INF = Integer.MAX_VALUE;

    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];

        // i, j, dist
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j, 0 });
                }else{
                    dist[i][j] = INF;
                }
            }
        }

        while (q.size() != 0) {
            int[] curr = q.poll();

            int ci = curr[0];
            int cj = curr[1];
            int dis = curr[2];

            for (int[] d : dir) {
                int ni = ci + d[0];
                int nj = cj + d[1];

                if (ni < 0 || nj < 0 || ni >= n || nj >= m || mat[ni][nj] == 0)
                    continue;

                if (dist[ni][nj] > (dis + 1)) {
                    dist[ni][nj] = dis+1;
                    q.add(new int[] { ni, nj, dis + 1 });
                }

            }

        }

        return dist;
    }

}