import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Shortest_Path_in_Weighted_undirected_graph {
    public static void main(String[] args) {
        int n = 5, m= 6;
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};

        List<Integer> ans = new Shortest_Path_in_Weighted_undirected_graph().shortestPath(n, m, edges);

        System.out.println(ans.size());

    }

    public List<Integer> shortestPath(int V, int E, int edges[][]) {
        //  Code Here.

        // edges: int[][] {u,v,w}, directed weighted graph
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges){
            adj.get(e[0]-1).add(new int[]{(e[1]-1), e[2]});
            adj.get(e[1]-1).add(new int[]{(e[0]-1), e[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] dist = new int[V];

        Arrays.fill(dist, -1);

        dist[0] = 0;

        pq.add(new int[]{0, 0});

        // System.out.println(adj.get(1).size());

        // for (int i = 0; i < adj.size(); i++) {
        //     for (int j = 0; j < adj.get(i).size(); j++) {
        //         System.out.print(adj.get(i).get(j));
        //     }
        //     System.out.println();
        // }

        while(pq.size() != 0){
            int[] temp1 = pq.poll();
            int curr = temp1[1];
            int path = temp1[0];
            

            for(int[] temp2 : adj.get(curr)){

                int n = temp2[0]; 
                int d = temp2[1];
                int np = path+d;
                
                
                if(dist[n] == -1){
                    dist[n] = np;
                    pq.add(new int[]{np, n});
                }else{
                    if(dist[n] > np){
                        dist[n] = np;
                        pq.add(new int[]{np, n});
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(dist[V-1]);

        return ans;
    }
}