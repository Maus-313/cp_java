import java.util.ArrayDeque;

public class LC785 {
    public static void main(String[] args) {
        // int[][] graph = {{1,3},{0,2},{1,3},{0,2}}; 
        // int[][] graph = {{1, 2, 3},{0,2},{0, 1,3},{0,2}};
        // int[][] graph = {{0}};

        // case failed for dfs
        int[][] graph = {{3},{2,3},{1,3},{0,2,1}}; // false;
 
        System.out.println(new LC785().isBipartite(graph));

    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] v = new int[V];

        for (int i = 0; i < V; i++) {
            if(v[i] == 0){
                v[i] = 1;
                if(!helper(graph, i, 1, v)) return false;
            }
        }
        return true;
    }

    static boolean helper(int[][] graph, int curr, int color, int[] v){
        

        for(int n : graph[curr]){
            if(v[n] == 0){
                v[n] = (color == 1)? 2:1;
                if(!helper(graph, n, v[n], v)) return false;
            }else{
                if(v[n] == v[curr]) return false;
            }
        }

        return true;
    }
}