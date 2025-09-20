import java.util.ArrayList;
import java.util.HashMap;

public class Directed_Graph_Cycle {
    public static void main(String[] args) {
        int V1 = 4;
        int edges1[][] = {{0, 1}, {1, 2}, {2, 3}, {3, 3}};

        int V2 = 3;
        int edges2[][] = {{0, 1}, {1, 2}};

        // This case will
        int V3 = 3;
        int[][] edges3 = {{0,2}, {1,2}};


        System.out.println(new Directed_Graph_Cycle().isCyclic(V1, edges1));
        System.out.println(new Directed_Graph_Cycle().isCyclic(V2, edges2));
        System.out.println(new Directed_Graph_Cycle().isCyclic(V3, edges3));
    }

    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
        }

        boolean[] v = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!v[i]){
                boolean[] loop = new boolean[V];
                if(helper(adj, i, v, loop)) return true;
            }
        }

        return false;
    }


    static boolean helper(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] v, boolean[] loop){

        if(loop[curr]) return true;
        if(v[curr]) return false;

        loop[curr] = true;
        v[curr] = true;

        for(int n : adj.get(curr)){
            if(helper(adj, n, v, loop)) return true;
        }

        loop[curr] = false;

        return false;
    }
}
