import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra_Algorithm {
    public static void main(String[] args) {

        int V = 3;
        int edges[][] = {{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};
        int src = 2;

        int[] ans = new Dijkstra_Algorithm().dijkstra(V, edges, src);

        for(int i : ans){
            System.out.print(i+" ");
        }

        System.out.println();

    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        int INF = 10000;
        int[] dist = new int[V];

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(new int[]{v, e[2]});
            adj.get(v).add(new int[]{u, e[2]}); // remove if directed
        }

        // dist, node
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        Arrays.fill(dist, INF);
        
        dist[src] = 0;
        pq.add(new int[]{0, src});

        while(pq.size() != 0){
            int[] temp = pq.poll();
            int curr = temp[1];
            for(int[] nei : adj.get(curr)){
                int new_neigh = nei[0];
                int new_dist = temp[0]+nei[1];
                if(new_dist < dist[new_neigh]){
                    dist[new_neigh] = new_dist;
                    pq.add(new int[]{new_dist, new_neigh});
                }
            }
        }

        return dist;
    }
}