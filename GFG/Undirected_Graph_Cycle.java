import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Undirected_Graph_Cycle {
    public static void main(String[] args) {
        int V = 4, E = 4; 
        int edges[][] = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        int edges2[][] = {{0, 1}, {1, 2}, {2, 3}};

        System.out.println(new Undirected_Graph_Cycle().isCycle(V, edges2));
    }

    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        for(int i = 0; i<V; i++){
            if(parent[i] == -1){
                parent[i] = 0;
                if(dfs(adj, i, parent)) return true;
            }
        }

        return false;
    }

    static boolean dfs(ArrayList<ArrayList<Integer>> adj, int par, int[] parent){

        for(int n : adj.get(par)){
            if(parent[n] == -1){
                parent[n] = par;
                if(dfs(adj, n, parent)) return true;
            }else if(parent[n] != -1 && parent[par] != n){
                return true;
            }
        }

        return false;
    }
}
