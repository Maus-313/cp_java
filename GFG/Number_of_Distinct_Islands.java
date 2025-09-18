import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

public class Number_of_Distinct_Islands {
    public static void main(String[] args) {
        int grid[][] = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}
        };

        int grid1[][] = {
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}
        };

        // this is conceptual testcase
        int grid2[][] = {
            {1, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 0, 1, 1},
        };
        System.out.println(new Number_of_Distinct_Islands().countDistinctIslands(grid2));

        // ArrayList<int[]> a = new ArrayList<>();
        // a.add(new int[] {0,0});
        // a.add(new int[] {1,0});
        // a.add(new int[] {0,1});

        // ArrayList<int[]> b = new ArrayList<>();
        // b.add(new int[] {0,0});
        // b.add(new int[] {1,0});
        // b.add(new int[] {0,1});

        // HashSet<ArrayList<int[]>> set = new HashSet<>();
        // set.add(a);
        // System.out.println(set.contains(b));
    }

    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    int countDistinctIslands(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] v = new boolean[n][m];

        HashSet<ArrayList<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !v[i][j]){
                    v[i][j] = true;
                    ArrayList<Integer> path = new ArrayList<>();
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    // path.add(0);
                    q.add(new int[]{i, j});
                    while(q.size() != 0){
                        int temp[] =q.poll();
                        int ci = temp[0];
                        int cj = temp[1];

                        for (int[] d : dir) {
                            int ni = ci + d[0];
                            int nj = cj + d[1];
                        
                            if (ni < 0 || nj < 0 || ni >= n || nj >= m || grid[ni][nj] == 0 || v[ni][nj]) continue;
                            v[ni][nj] = true;
                            path.add(ni-i);
                            path.add(nj-j);
                            // path.add(d[0]);
                            // path.add(d[1]);
                            q.add(new int[] {ni,nj});
                        }
                    }

                    set.add(path);

                }
            }
        }

        return set.size();
    }

}