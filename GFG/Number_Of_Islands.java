import java.util.ArrayList;
import java.util.List;

public class Number_Of_Islands {
    public static void main(String[] args) {
        Number_Of_Islands obj = new Number_Of_Islands();
        int rows = 3;
        int cols = 5;
        int n = 10;
        int[][] operators = {
            {1, 1},
            {0, 3},
            {2, 3},
            {2, 4},
            {2, 4},
            {2, 1},
            {1, 4},
            {0, 0},
            {1, 2},
            {2, 0}
        };
        List<Integer> res = obj.numOfIslands(rows, cols, operators);
        for (int x : res) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static int parent[];
    static int rank[];
    static int provinces;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b){
        int ra = find(a);
        int rb = find(b);

        if(ra != rb){
            if(rank[ra] > rank[rb]){
                parent[rb] = ra;
            }else if(rank[rb] > rank[ra]){
                parent[ra] = rb;
            }else{
                parent[rb] = ra;
                rank[ra]++;
            }
            provinces--;
        }
    }    

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
        int V = rows*cols;
        
        parent = new int[V];
        rank = new int[V];
        provinces = 0;
        
        for(int i = 0; i < V; i++){
            parent[i] = i;
        }

        int[][] grid = new int[rows][cols];
        List<Integer> ans = new ArrayList<>();
        
        for(int[] o : operators){

            int i = o[0];
            int j = o[1];
            grid[i][j] = 1;

            int node = i*cols + j;
            provinces++;

            for(int[] d : dir){

                int ni = i + d[0];
                int nj = j + d[1];
                
                if(ni < 0 || nj < 0 || ni >= rows || nj >= cols) continue;

                if(grid[ni][nj] == 1){
                    int neigh = ni*cols + nj;
                    union(node, neigh);
                }
            }
            ans.add(provinces);
        }

        return ans;
    }
}