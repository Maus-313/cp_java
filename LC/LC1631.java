import java.util.Arrays;
import java.util.PriorityQueue;

public class LC1631 {
    public static void main(String[] args) {
        // int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        // int[][] heights = {{1,2,3},{3,8,4},{5,3,5}};
        int[][] heights = {{1,10,6,7,9,10,4,9}};

        System.out.println(new LC1631().minimumEffortPath(heights));

    }

    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;
        int INF = Integer.MAX_VALUE;

        // effort, i, j, max
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[]{0, 0, 0});

        int[][] effort = new int[n][m];
        
        for(int[] r : effort){
            Arrays.fill(r, INF);
        }

        effort[0][0] = 0;
        // System.out.println("Path -> " + 0+ " - "+0);
        while(pq.size() != 0){

            int[] temp = pq.poll();
            int i = temp[1];
            int j = temp[2];
            // System.out.println("Path -> " + i+ " - "+j + " Effort -> " + temp[0]);

            if(i == n-1 && j == m-1) return temp[0];

            for (int[] d : dir) {
                int ni = i + d[0];
                int nj = j + d[1];
                if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;
                // if (ni < 0 || nj < 0 || ni >= n || nj >= m || v[ni][nj]) continue;
                int eff = Math.abs(heights[i][j] - heights[ni][nj]);
                if(effort[ni][nj] > eff){
                    effort[ni][nj] = eff;
                    // System.out.println(Math.max(eff, temp[0]));
                    pq.add(new int[]{Math.max(eff, temp[0]), ni,nj});
                }
            }
        }

        return -1;
    }
}