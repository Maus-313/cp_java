import java.util.ArrayList;

public class Directed_Graph_Cycle {
    public static void main(String[] args) {
        // int V = 4;
        // int edges[][] = {{0, 1}, {1, 2}, {2, 3}, {3, 3}};

        // int V = 3;
        // int edges[][] = {{0, 1}, {1, 2}};

        // This case will
        int V = 3;
        int[][] edges = {{0,2}, {1,2}};

        System.out.println(new Directed_Graph_Cycle().isCyclic(V, edges));
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
                v[i] = true;
                boolean[] loop = new boolean[V];
                loop[i] = true;
                if(helper(adj, i, v, loop)) return true;
            }
        }

        return false;
    }


    static boolean helper(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] v, boolean[] loop){

        for(int n : adj.get(curr)){
            if(loop[n]){
                return true;
            }else if(!loop[n]){
                v[n] =true;
                loop[n] = true;
                if(helper(adj, n, v, loop)) return true;
                loop[n] = false;
            }
        }

        return false;
    }
}
