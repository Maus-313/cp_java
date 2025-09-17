import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Shortest_path_in_Directed_Acyclic_Graph {
    public static void main(String[] args) {
        Shortest_path_in_Directed_Acyclic_Graph solver = new Shortest_path_in_Directed_Acyclic_Graph();

        int V1 = 4, E1 = 2;
        int[][] edges1 = { {0,1,2}, {0,2,1} };
        System.out.println(Arrays.toString(solver.shortestPath(V1, E1, edges1)));

        int V2 = 6, E2 = 7;
        int[][] edges2 = { {0,1,2}, {0,4,1}, {4,5,4}, {4,2,2}, {1,2,3}, {2,3,6}, {5,3,1} };
        System.out.println(Arrays.toString(solver.shortestPath(V2, E2, edges2)));
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        // node , dist
        ArrayList<ArrayList<int[]>> adj = new ArrayList();
        
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList());
        }
        
        for(int[] e : edges){
            adj.get(e[0]).add(new int[]{e[1], e[2]});
        }
        
        int[] dist = new int[V];
        
        Arrays.fill(dist, -1);
        
        dist[0] = 0;
        
        // dist, node
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[] {dist[0], 0});

        while(q.size() != 0 ){
            int[] temp = q.poll();
            int curr = temp[1];
            int d = temp[0];

            for(int[] n : adj.get(curr)){
                int nd = d + n[1];
                int nn = n[0];
                
                if(dist[nn] == -1 || dist[nn] > nd){
                    dist[nn] = nd;
                    q.add(new int[]{nd, nn});
                }
            }
        }
        
        return dist;
    }
}
