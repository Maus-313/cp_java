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
        boolean[] v = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }


        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i<V; i++){
            if(!v[i]){
                v[i] = true;
                q.add(i);

                while(q.size() != 0){
                    int cur = q.poll();

                    for(int n : adj.get(cur)){
                        if(!v[n])
                    }
                }

            }
        }
    }
}
