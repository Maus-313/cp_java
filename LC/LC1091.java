import java.util.Arrays;
import java.util.PriorityQueue;

public class LC1091 {
    public static void main(String[] args) {
        // int[][] grid = {{0,1},{1,0}};
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(new LC1091().shortestPathBinaryMatrix(grid));
    }

    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, {1,1}, {-1,1},{1,-1},{-1,-1} };

    public int shortestPathBinaryMatrix(int[][] grid) {
        // System.out.println("Hllo");
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;

        int[][] dist = new int[n][m];
        for(int[] r : dist){
            Arrays.fill(r, -1);
        }
        dist[0][0] = 1;

        // dist, i, j
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{1, 0, 0});
        // System.out.println("Hllo");

        while(pq.size() != 0){
            // System.out.println("Hllo");
            int temp[] = pq.poll();
            int i = temp[1];
            int j = temp[2];
            int dis = temp[0];
            // System.out.println("Hllo");
            if((i == n-1) && (j == m-1)) return dis;

            // System.out.println("Hllo");
            for (int[] d : dir) {
                int ni = i + d[0];
                int nj = j + d[1];
                // System.out.println("Hllo");
                if (ni < 0 || nj < 0 || ni >= n || nj >= m || grid[ni][nj] == 1) continue;
                if(dist[ni][nj] == -1){
                    dist[ni][nj] = dis+1;
                    pq.add(new int[]{dis+1, ni,nj});
                }else{
                    int ndis = dis+1;
                    if(ndis < dist[ni][nj]){
                        dist[ni][nj] = dis+1;
                        pq.add(new int[]{dis+1, ni,nj});
                    }
                }
            }
        }

        return -1;
    }
}