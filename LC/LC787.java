import java.util.*;

public class LC787{
    public static void main(String[] args) {
        int n = 5;
        int[][] flights = {
            {0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}
        };
        int src = 0;
        int dst = 2;
        int k = 2;
        System.out.println(new LC787().findCheapestPrice(n, flights, src, dst, k));

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k += 1;
        // cost, k, node

        int[][] edges = flights;

        // node, cost
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(new int[] {v, e[2]}); // remove if directed
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        int[] dist = new int[n];

        Arrays.fill(dist, -1);
        dist[src] = 0;

        pq.add(new int[]{0, k, src});

        while(pq.size() != 0){
            int[] temp = pq.poll();
            int curr = temp[2];
            int cost = temp[0];
            if(curr == dst) return cost;

            for(int[] temp_n: adj.get(curr)){
                
            }
        }
    }
}