import java.util.ArrayDeque;

public class LC733 {
    public static void main(String[] args) {
// 
        // int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] image = {{0,0,0},{0,0,0},{0,0,0}};
        int sr = 1, sc = 1, color = 2;

        int[][] ans = new LC733().floodFill(image, sr, sc, color);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

        static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int n = image.length;
            int m = image[0].length;

            // int[][] ans = new int[n][m];

            
            int old_color = image[sr][sc];

            if(old_color == color ) return image;

            ArrayDeque<int[]> q = new ArrayDeque<>();

            q.add(new int[]{sr, sc});

            while(q.size() != 0 ){
                int[] temp = q.poll();

                int ci = temp[0];
                int cj = temp[1];

                for(int[] d : dir){
                    int ni = ci + d[0];
                    int nj = cj + d[1];
                    
                    if (ni < 0 || nj < 0 || ni >= n || nj >= m || image[ni][nj] != old_color) continue;

                    image[ni][nj] = color;
                    q.add(new int[]{ni,nj});
                }
            }

            return image;
        }
}
